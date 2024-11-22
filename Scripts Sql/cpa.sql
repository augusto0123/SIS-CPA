-- Excluir essa linhas: 2, 4 e 8 quando for criar banco
-- drop database if exists cpa ;

-- create database cpa;

begin;

-- \c cpa;

CREATE TABLE endereco 
    (id SERIAL PRIMARY KEY,
    logradouro VARCHAR(200) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    bairro VARCHAR(200) NOT NULL,
    cidade VARCHAR(200) NOT NULL,
    complemento VARCHAR(300));


CREATE TABLE instituicao
    (id SERIAL PRIMARY KEY,
    email VARCHAR(200) NOT NULL,
    cnpj VARCHAR(19) NOT NULL,
    razao_social VARCHAR(400) NOT NULL,
    nome_fantasia VARCHAR(400) NOT NULL,
    telefone VARCHAR(20),
    email_responsavel VARCHAR(200) NOT NULL,
    telefone_responsavel VARCHAR(20) NOT NULL,
    nome_responsavel VARCHAR(200) NOT NULL,
    situacao VARCHAR(20) NOT NULL,
    id_endereco INTEGER NOT NULL,
    foto TEXT,
    FOREIGN KEY (id_endereco) REFERENCES endereco(id) ON DELETE CASCADE);


CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    id_instituicao INTEGER,
    nome VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    tipo VARCHAR(30) CHECK (tipo IN ('Aluno', 'Professor', 'Comunidade Externa', 'Colaborador', 'Membro CPA', 'Administrador')),
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE
);
     

CREATE TABLE membro_cpa
    (id SERIAL PRIMARY KEY,
    id_usuario INTEGER NOT NULL,
    id_instituicao INTEGER,
    cargo VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE SET NULL);


CREATE TABLE reuniao_cpa (
    id SERIAL PRIMARY KEY,
    id_instituicao INTEGER,
    id_membro_cpa INTEGER,
    data_reuniao DATE,
    horario TIME, 
    pauta TEXT,
    FOREIGN KEY (id_membro_cpa) REFERENCES Membro_CPA(id) ON DELETE CASCADE,
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE
);


CREATE TABLE edicao_autoavaliacao
    (id SERIAL PRIMARY KEY,
    id_instituicao INTEGER,
    edicao INTEGER NOT NULL,
    ano_avaliacao VARCHAR(4) NOT NULL,
    descricao TEXT NOT NULL,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP NOT NULL,
    situacao VARCHAR(30) CHECK (situacao IN ('Prevista', 'Em Andamento', 'Encerrada')),
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE);


CREATE TABLE avaliacao
    (id SERIAL PRIMARY KEY,
    id_edicao_autoavaliacao INTEGER,
    id_instituicao INTEGER,
    descricao TEXT NOT NULL,
    tema VARCHAR(100),
    FOREIGN KEY (id_edicao_autoavaliacao) REFERENCES edicao_autoavaliacao(id) ON DELETE CASCADE,
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE
    );


CREATE TABLE questionario (
    id SERIAL PRIMARY KEY,
    id_instituicao INTEGER,
    descricao TEXT NOT NULL,
    categoria VARCHAR(30) CHECK (categoria IN ('Aluno', 'Professor', 'Colaborador', 'Comunidade Externa')),
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE
);


CREATE TABLE avaliacao_questionario
    (id SERIAL PRIMARY KEY,
    id_avaliacao INTEGER,
    id_questionario INTEGER,
    id_instituicao INTEGER,
    FOREIGN KEY (id_avaliacao) REFERENCES Avaliacao(id) ON DELETE CASCADE,
    FOREIGN KEY (id_questionario) REFERENCES Questionario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE,
    UNIQUE (id_avaliacao, id_questionario));

    
CREATE TABLE grupo_perguntas 
    (id SERIAL PRIMARY KEY,
    id_instituicao INTEGER,
    tipo VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE
    );

CREATE TABLE pergunta (
    id SERIAL PRIMARY KEY,
    id_instituicao INTEGER,
    descricao VARCHAR(500) NOT NULL,
    tipo VARCHAR(20) CHECK (tipo IN ('Objetiva', 'Subjetiva')),
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE
);

CREATE TABLE resposta
    (id SERIAL PRIMARY KEY,
    id_pergunta INTEGER,
    id_usuario INTEGER,
    id_instituicao INTEGER,
    id_avaliacao INTEGER,
    resposta_objetiva VARCHAR(30) CHECK (resposta_objetiva IN ('Discordo Totalmente', 'Discordo', 'Neutro', 'Concordo', 'Concordo Totalmente')),
    resposta_subjetiva TEXT,
    FOREIGN KEY (id_pergunta) REFERENCES Pergunta(id) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_avaliacao) REFERENCES avaliacao(id) ON DELETE CASCADE,
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE
    );


CREATE TABLE perguntas_grupo_perguntas
    (id SERIAL PRIMARY KEY,
    id_grupo_perguntas INTEGER,
    id_pergunta INTEGER,
    id_instituicao INTEGER,
    ordem_das_perguntas INTEGER,
    FOREIGN KEY (id_grupo_perguntas) REFERENCES grupo_perguntas(id) ON DELETE CASCADE,
    FOREIGN KEY (id_pergunta) REFERENCES pergunta(id) ON DELETE CASCADE,
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE,
    UNIQUE (id_grupo_perguntas, id_pergunta));


CREATE TABLE grupo_perguntas_questionario
    (id SERIAL PRIMARY KEY,
    id_questionario INTEGER,
    id_instituicao INTEGER,
    id_grupo_perguntas INTEGER,
    ordem_dos_grupos INTEGER,
    FOREIGN KEY (id_questionario) REFERENCES questionario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_grupo_perguntas) REFERENCES grupo_perguntas(id) ON DELETE CASCADE,
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id) ON DELETE CASCADE,
    UNIQUE (id_questionario, id_grupo_perguntas));

commit;