-- Inserir dados na tabela Endereco

INSERT INTO endereco (logradouro, numero, bairro, cidade, complemento)
VALUES ('Av. Antônio de Cássia',
        '472 ',
        'Jardim Santo Antônio',
        'Santa Rita do Sapucaí',
        NULL);
        
        -- ('Avenida Central',
        -- '456',
        -- 'Centro',
        -- 'Pouso Alegre',
        -- NULL
        -- );

-- Inserir dados na tabela instituicao

INSERT INTO instituicao (email, cnpj, razao_social, nome_fantasia, telefone, email_responsavel, telefone_responsavel, nome_responsavel, situacao, id_endereco)
VALUES ('secretaria@fai-mg.br',
        '24.492.860/0003-10',
        'Fundação Educandário Santarritense',
        'FAI - Centro de Ensino Superior em Gestão, Tecnologia e Educação',
        '(35) 3473-3000',
        'membro@fai.com.br',
        '(11) 2222-3333',
        'W4nd3rl3y R0dr1gu3s d S0uz4',
        'Ativa',
		1);

                -- ('contato@outraempresa.com.br',
                --    '98.765.432/0001-56',
                --    'Outra Empresa S.A.',
                --    'OutraEmpresa',
                --    '(21) 2345-6789',
                --    'responsavel@outraempresa.com.br',
                --    '(21) 98765-4321',
                --    'Maria Oliveira',
                --    'Inativa',
		--         2);

INSERT INTO usuario (id_instituicao, nome, email, senha, telefone, tipo) VALUES
(1, 'Augusto', 'aluno1@instituicao1.com', 'senha123', '123456789', 'Aluno'),
(1, 'Eunice', 'professor1@instituicao1.com', 'senha123', '987654321', 'Professor'),
(1, 'Henrique', 'colaborador1@instituicao2.com', 'senha123', '111222333', 'Colaborador'),
(1, 'Ana Júlia', 'membro1@instituicao2.com', 'senha123', '444555666', 'Membro CPA'),
(NULL,'Gutinho', 'admin@administrador.com', 'senha123', '444555666', 'Administrador');

-- Inserindo dados na tabela membro_cpa
INSERT INTO membro_cpa (id_instituicao, cargo, id_usuario) VALUES
(2, 'Coordenador', 4);

-- Inserindo dados na tabela reuniao_cpa
INSERT INTO reuniao_cpa (id_membro_cpa, data_reuniao, horario, pauta) VALUES
(1, '2024-10-15', '10:00:00', 'Reunião de Planejamento'),
(2, '2024-11-01', '14:00:00', 'Avaliação de Resultados');

-- Inserindo dados na tabela edicao_autoavaliacao
INSERT INTO edicao_autoavaliacao (id_instituicao, edicao, ano_avaliacao, descricao, data_inicio, data_fim) VALUES
(1, 1, '2024', 'Autoavaliação do 1º semestre', '2024-01-01', '2024-06-30'),
(2, 2, '2024', 'Autoavaliação do 2º semestre', '2024-07-01', '2024-12-31');

-- Inserindo dados na tabela avaliacao
INSERT INTO avaliacao (id_instituicao, id_edicao_autoavaliacao, descricao, tema) VALUES
(1, 1, 'Avaliação da Instituição 1', 'Educação'),
(2, 1, 'Avaliação da Instituição 2', 'Gestão');

-- Inserindo dados na tabela questionario
INSERT INTO questionario (descricao, categoria) VALUES
('Questionário de Satisfação', 'Aluno'),
('Questionário de Feedback', 'Professor');

-- Inserindo dados na tabela avaliacao_questionario
INSERT INTO avaliacao_questionario (id_avaliacao, id_questionario) VALUES
(1, 1),
(2, 2);

-- Inserindo dados na tabela grupo_perguntas
INSERT INTO grupo_perguntas (tipo, descricao) VALUES
('Grupo A', 'Perguntas sobre satisfação'),
('Grupo B', 'Perguntas sobre melhorias');

-- Inserindo dados na tabela pergunta
INSERT INTO pergunta (descricao, tipo, escala) VALUES
('Você está satisfeito com o atendimento?', 'Objetiva', '["Ótimo", "Bom", "Regular", "Ruim", "Péssimo"]'),
('Quais melhorias você sugere?', 'Subjetiva', NULL);

-- Inserindo dados na tabela resposta
INSERT INTO resposta (id_pergunta, id_usuario, id_avaliacao_questionario, resposta_objetiva, resposta_subjetiva) VALUES
(1, 1, 1, 'Bom', NULL),
(2, 1, 1, NULL, 'Mais atenção no atendimento.');

-- Inserindo dados na tabela perguntas_grupo_perguntas
INSERT INTO perguntas_grupo_perguntas (id_grupo_perguntas, id_pergunta, ordem_das_perguntas) VALUES
(1, 1, 1),
(2, 2, 1);

-- Inserindo dados na tabela grupo_perguntas_questionario
INSERT INTO grupo_perguntas_questionario (id_questionario, id_grupo_perguntas, ordem_dos_grupos) VALUES
(1, 1, 1),
(2, 2, 1);

COMMIT;