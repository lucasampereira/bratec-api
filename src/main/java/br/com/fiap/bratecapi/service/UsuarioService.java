package br.com.fiap.bratecapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.bratecapi.model.Usuario;
import br.com.fiap.bratecapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Page<Usuario> listAll(Pageable pageable){
        
       return repository.findAll(pageable);
    }

    public void save(Usuario usuario) {
        repository.save(usuario);
    }

    public Optional<Usuario> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
