package br.com.fiap.bratecapi.dto;

import java.math.BigDecimal;

public record LocalDto (

     Long CodigoLocal,
     String Nome,
     String Email,
     String Senha,
     String CoordenadaLocal,
     BigDecimal SaldoCarteira,
     String Cnpj
) {

     public LocalDto(String Nome, String Email, String Senha, String CoordenadaLocal, String Cnpj){
          this(0l, Nome, Email, Senha, CoordenadaLocal, null, Cnpj);
     }

}
