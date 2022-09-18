package br.com.fiap.bratecapi.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bratecapi.model.Local;
import br.com.fiap.bratecapi.service.LocalService;

@RestController
@RequestMapping("/api/local")
public class LocalController {
    
    @Autowired
    private LocalService service;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    @Cacheable("local")
    public Page<Local> index(@PageableDefault(size = 5) Pageable pageable){
        
        return service.listAll(pageable);
    }

    @PostMapping
    public ResponseEntity<Local> create(@RequestBody @Valid Local local){
        String password = passwordEncoder.encode(local.getSenha());
        local.setSenha(password);
        service.save(local);
        return ResponseEntity.status(HttpStatus.CREATED).body(local);
    }

    @GetMapping("{id}")
    public ResponseEntity<Local> show(@PathVariable Long id){
        return ResponseEntity.of(service.getById(id));
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "local", allEntries = true)
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        Optional<Local> optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }    

    @PutMapping("{id}")
    public ResponseEntity<Local> update(@PathVariable Long id, @RequestBody @Valid Local newLocal){
        Optional<Local> optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        var local = optional.get();
        var password = local.getSenha();

        BeanUtils.copyProperties(newLocal, local);

        local.setCodigoLocal(id);
        local.setSenha(passwordEncoder.encode(password));

        service.save(local);

        return ResponseEntity.ok(local);
    }

}
