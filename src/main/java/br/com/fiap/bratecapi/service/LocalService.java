package br.com.fiap.bratecapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.bratecapi.model.Local;
import br.com.fiap.bratecapi.repository.LocaisRepository;

@Service
public class LocalService {

    @Autowired
    LocaisRepository repository;

    public Page<Local> listAll(Pageable pageable){
        
       return repository.findAll(pageable);
    }

    public void save(Local local) {
        repository.save(local);
    }

    public Optional<Local> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
