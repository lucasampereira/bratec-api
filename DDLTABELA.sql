CREATE TABLE tb_m_usuario (
 cd_usuario NUMBER(6) NOT NULL,
 nm_usuario VARCHAR2(50) NOT NULL,
 ds_email VARCHAR2(50) NOT NULL,
 ds_senha VARCHAR2(16) NOT NULL
);
ALTER TABLE tb_m_usuario ADD CONSTRAINT PK_M_USUARIO PRIMARY
KEY (cd_usuario);
ALTER TABLE tb_m_usuario ADD CONSTRAINT UN_M_USUARIO_EMAIL
UNIQUE (ds_email);
CREATE SEQUENCE id_usuario_m
 START WITH 1 INCREMENT BY 1 MAXVALUE 999999
 NOCACHE NOCYCLE;
 
CREATE TABLE tb_m_local (
 cd_local NUMBER(6) NOT NULL,
 nm_local VARCHAR2(50) NOT NULL,
 ds_coordenada_local VARCHAR2(10) NOT NULL
);
ALTER TABLE tb_m_local ADD CONSTRAINT pk_m_local PRIMARY KEY (
cd_local );
CREATE SEQUENCE id_local_m
 START WITH 100 INCREMENT BY 1 MAXVALUE 999999
 NOCACHE NOCYCLE;
 
CREATE TABLE tb_m_login_local (
 ds_email VARCHAR2(50) NOT NULL,
 ds_senha VARCHAR2(16) NOT NULL,
 ds_saldo NUMBER(10, 2) NOT NULL,
 ds_cnpj VARCHAR2(18) NOT NULL,
 cd_local NUMBER(6) NOT NULL
);
ALTER TABLE tb_m_login_local ADD CONSTRAINT pk_m_login_local
PRIMARY KEY ( ds_cnpj );
ALTER TABLE tb_m_login_local
 ADD CONSTRAINT fk_local_login FOREIGN KEY ( cd_local )
 REFERENCES tb_m_local ( cd_local );

CREATE TABLE tb_m_anuncio (
 cd_anuncio NUMBER(6) NOT NULL,
 ds_titulo VARCHAR2(60) NOT NULL,
 ds_texto VARCHAR2(140) NOT NULL,
 ds_imagem VARCHAR2(140) NOT NULL,
 cd_local NUMBER(6) NOT NULL
);
ALTER TABLE tb_m_anuncio ADD CONSTRAINT PK_M_ANUNCIO PRIMARY
KEY (cd_anuncio);
ALTER TABLE tb_m_anuncio ADD CONSTRAINT FK_M_LOCAL FOREIGN KEY
(cd_local) REFERENCES tb_m_local (cd_local);
CREATE SEQUENCE id_anuncio_m
 START WITH 1000 INCREMENT BY 1 MAXVALUE 999999
 NOCACHE NOCYCLE;
 
CREATE TABLE tb_m_visitas_usuario (
 cd_historico NUMBER(6) NOT NULL,
 dt_visita DATE NOT NULL,
 st_favorito NUMBER(1) NOT NULL,
 cd_usuario NUMBER(6) NOT NULL,
 cd_local NUMBER(6) NOT NULL
);
ALTER TABLE tb_m_visitas_usuario ADD CONSTRAINT
PK_M_VISITAS_USUARIO PRIMARY KEY (cd_historico);
ALTER TABLE tb_m_visitas_usuario ADD CONSTRAINT
FK_M_VISITAS_LOCAL FOREIGN KEY (cd_usuario) REFERENCES
tb_m_usuario (cd_usuario);
ALTER TABLE tb_m_visitas_usuario ADD CONSTRAINT FK_M_USUARIO
FOREIGN KEY (cd_local) REFERENCES tb_m_local (cd_local);
CREATE SEQUENCE id_visitas_m
 START WITH 10 INCREMENT BY 1 MAXVALUE 999999
 NOCACHE NOCYCLE;


