# Agenda eletrônica

Para o BD local foi utilizado o postgresql versão 9.4 - usuário e senha: postgres 

Adicionar o .jar da pasta /lib as dependências

* DDL SQL:
```
-- Sequence: contato_key

-- DROP SEQUENCE contato_key;

CREATE SEQUENCE contato_key
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE contato_key
  OWNER TO postgres;


-- Table: contato

-- DROP TABLE contato;

CREATE TABLE contato
(
  id integer NOT NULL DEFAULT nextval('contato_key'::regclass),
  nome character varying(255),
  telefone character varying(255),
  email character varying(255),
  CONSTRAINT contato_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE contato
  OWNER TO postgres;
```