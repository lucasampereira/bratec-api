package br.com.fiap.bratecapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.bratecapi.model.Local;
import br.com.fiap.bratecapi.model.Usuario;
import br.com.fiap.bratecapi.repository.LocaisRepository;
import br.com.fiap.bratecapi.repository.UsuarioRepository;

@Configuration
@Profile("dev")
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    LocaisRepository locaisRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        usuarioRepository.saveAll(List.of(
            new Usuario("Chris", "chrissytirocerto@gmail.com", passwordEncoder.encode("senha")),
            new Usuario("Julius", "juliusrock@gmail.com", passwordEncoder.encode("1a2b3c")),
            new Usuario("Greg", "chrisegreg@gmail.com", passwordEncoder.encode("123456asd")),
            new Usuario("Isabela", "isabela@fiap.com.br", passwordEncoder.encode("123"))
        ));

        locaisRepository.saveAll(List.of(
            new Local("Lojas Renner", "renner@renner.com", passwordEncoder.encode("renner123"), "4,21", "27.789.456/0001-91"),
            new Local("Lojas Americanas", "contato@americanas.com", passwordEncoder.encode("ame789"), "1,5", "24.597.845/0002-98"),
            new Local("Cacau Show", "cacau@show.com", passwordEncoder.encode("chocolate10"), "1,10", "12.567.545/0001-97")
            
        ));

    }
    
}
