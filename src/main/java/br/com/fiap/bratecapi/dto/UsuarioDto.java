package br.com.fiap.bratecapi.dto;

public record UsuarioDto (

     Long CodigoUsuario,
     String NomeUsuario,
     String Email,
     String Senha

) {

     public UsuarioDto(String NomeUsuario, String Email, String Senha){
          this(0l, NomeUsuario, Email, Senha);
     }

}
