package br.com.fiap.bratecapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bratecapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
 
    Optional<Usuario> findByEmail(String email);

}
