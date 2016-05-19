# Agenda eletrônica

Para o BD local foi utilizado o postgresql versão 9.4 - usuário e senha: postgres 

Adicionar o .jar da pasta /lib as dependências

* DDL SQL:
```
CREATE TABLE contato
(
  id integer NOT NULL,
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