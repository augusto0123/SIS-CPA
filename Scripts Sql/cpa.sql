drop database if exists cpa ;


create database cpa;

begin;

\c cpa;


CREATE TABLE instituicao (id SERIAL PRIMARY KEY,
                                            email VARCHAR(100) NOT NULL,
                                                               cnpj VARCHAR(19) NOT NULL,
                                                                                razao_social VARCHAR(100) NOT NULL,
                                                                                                          nome_fantasia VARCHAR(100) NOT NULL,
                                                                                                                                     telefone VARCHAR(20) NOT NULL,
                                                                                                                                                          email_responsavel VARCHAR(100) NOT NULL,
                                                                                                                                                                                         telefone_responsavel VARCHAR(20) NOT NULL,
                                                                                                                                                                                                                          nome_responsavel VARCHAR(100) NOT NULL,
                                                                                                                                                                                                                                                        situacao VARCHAR(20) NOT NULL);


CREATE TABLE usuario
    (id SERIAL PRIMARY KEY,
                       id_instituicao INTEGER NOT NULL,
                                              nome VARCHAR(100) NOT NULL,
                                                                email VARCHAR(100) NOT NULL,
                                                                                   senha VARCHAR(100) NOT NULL,
                                                                                                      telefone VARCHAR(100) NOT NULL,
                                                                                                                            situacao VARCHAR(20) NOT NULL,
                                                                                                                                                 data_cadastro DATE NOT NULL,
                                                                                                                                                                    tipo VARCHAR(20) NOT NULL,
     FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE);


CREATE TABLE membro_cpa
    (id SERIAL PRIMARY KEY,
                       id_instituicao INTEGER NOT NULL,
                                              cargo VARCHAR(100) NOT NULL,
                                                                 id_usuario INTEGER NOT NULL,
     FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE,
     FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE
     SET NULL);


CREATE TABLE reuniao_cpa
    (id SERIAL PRIMARY KEY,
                       id_membro_cpa INTEGER NOT NULL,
                                             data_reuniao DATE NOT NULL,
                                                               horario TIMESTAMP NOT NULL,
                                                                                 pauta VARCHAR(250) NOT NULL,
     FOREIGN KEY (id_membro_cpa) REFERENCES Membro_CPA(id) ON DELETE CASCADE);


CREATE TABLE Endereco
    (id SERIAL PRIMARY KEY,
                       id_instituicao INTEGER NOT NULL,
                                              logradouro VARCHAR(100) NOT NULL,
                                                                      numero VARCHAR(100) NOT NULL,
                                                                                          bairro VARCHAR(100) NOT NULL,
                                                                                                              cep VARCHAR(100) NOT NULL,
                                                                                                                               complemento VARCHAR(100), -- Campo opcional

     FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE);


CREATE TABLE edicao_autoavaliacao
    (id SERIAL PRIMARY KEY,
                       id_instituicao INTEGER NOT NULL,
                                              edicao VARCHAR(100) NOT NULL,
                                                                  ano_avaliacao VARCHAR(4) NOT NULL,
                                                                                           descricao VARCHAR(300) NOT NULL,
                                                                                                                  data_inicio TIMESTAMP NOT NULL,
                                                                                                                                        data_fim TIMESTAMP NOT NULL,
     FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE);


CREATE TABLE avaliacao
    (id SERIAL PRIMARY KEY,
                       id_edicao_autoavaliacao INTEGER NOT NULL,
                                                       data_inicio DATE NOT NULL,
                                                                        data_fim DATE NOT NULL,
                                                                                      status VARCHAR(100) NOT NULL,
                                                                                                          descricao VARCHAR(100) NOT NULL,
                                                                                                                                 observacao VARCHAR(100), -- Campo opcional

     FOREIGN KEY (id_edicao_autoavaliacao) REFERENCES Edicao_Autoavaliacao(id) ON DELETE CASCADE);


CREATE TABLE questionario (id SERIAL PRIMARY KEY,
                                             descricao VARCHAR(100) NOT NULL,
                                                                    categoria VARCHAR(100) NOT NULL,
                                                                                           tipo VARCHAR(100) NOT NULL);


CREATE TABLE avaliacao_questionario
    (id SERIAL PRIMARY KEY,
                       id_avaliacao INTEGER NOT NULL,
                                            id_questionario INTEGER NOT NULL,
     FOREIGN KEY (id_avaliacao) REFERENCES Avaliacao(id) ON DELETE CASCADE,
     FOREIGN KEY (id_questionario) REFERENCES Questionario(id) ON DELETE CASCADE,
                                                                         UNIQUE (id_avaliacao,
                                                                                 id_questionario)-- Garante que a combinação de avaliação e questionário seja única
);


CREATE TABLE pergunta (id SERIAL PRIMARY KEY,
                                         descricao VARCHAR(100) NOT NULL,
                                                                categoria VARCHAR(100) NOT NULL,
                                                                                       tipo VARCHAR(100) NOT NULL,
                                                                                                         tipo_Escala INTEGER NOT NULL);


CREATE TABLE resposta
    (id SERIAL PRIMARY KEY,
                       id_pergunta INTEGER NOT NULL,
                                           id_usuario INTEGER NOT NULL,
                                                              id_avaliacao_questionario INTEGER NOT NULL,
                                                                                                texto VARCHAR(500) NOT NULL,
                                                                                                                   data TIMESTAMP NOT NULL,
     FOREIGN KEY (id_pergunta) REFERENCES Pergunta(id) ON DELETE CASCADE,
     FOREIGN KEY (id_usuario) REFERENCES Usuario(id) ON DELETE CASCADE,
     FOREIGN KEY (id_avaliacao_questionario) REFERENCES Avaliacao_Questionario(id) ON DELETE CASCADE);


CREATE TABLE grupo_perguntas (id SERIAL PRIMARY KEY,
                                                tipo VARCHAR(100) NOT NULL,
                                                                  descricao VARCHAR(400) NOT NULL);


CREATE TABLE perguntas_grupo_perguntas
    (id SERIAL PRIMARY KEY,
                       id_grupo_perguntas INTEGER NOT NULL,
                                                  id_pergunta INTEGER NOT NULL,
                                                                      ordem_das_perguntas INTEGER NOT NULL,
     FOREIGN KEY (id_grupo_perguntas) REFERENCES grupo_perguntas(id) ON DELETE CASCADE,
     FOREIGN KEY (id_pergunta) REFERENCES pergunta(id) ON DELETE CASCADE,
                                                                 UNIQUE (id_grupo_perguntas,
                                                                         id_pergunta)-- Garante que a combinação de grupo de perguntas e pergunta seja única
);


CREATE TABLE grupo_perguntas_questionario
    (id SERIAL PRIMARY KEY,
                       id_questionario INTEGER NOT NULL,
                                               id_grupo_perguntas INTEGER NOT NULL,
                                                                          ordem_dos_grupos INTEGER NOT NULL,
     FOREIGN KEY (id_questionario) REFERENCES questionario(id) ON DELETE CASCADE,
     FOREIGN KEY (id_grupo_perguntas) REFERENCES grupo_perguntas(id) ON DELETE CASCADE,
                                                                               UNIQUE (id_questionario,
                                                                                       id_grupo_perguntas)-- Garante que a combinação de questionário e grupo de perguntas seja única
);

-- ALTER TABLE usuario
-- ADD COLUMN tipo VARCHAR(20) NOT NULL;

commit;