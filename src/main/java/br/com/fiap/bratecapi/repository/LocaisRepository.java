package br.com.fiap.bratecapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bratecapi.model.Local;

public interface LocaisRepository extends JpaRepository<Local, Long> {
 

}
