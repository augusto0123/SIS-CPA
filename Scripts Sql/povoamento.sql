-- Inserir dados na tabela Endereco

INSERT INTO endereco (id_instituicao, logradouro, numero, bairro, cep, complemento, id_endereco)
VALUES ('Rua das Flores',
        '123',
        'Jardim Botânico',
        '12345-678',
        'Apto 101', 1), 
        
        ('Avenida Central',
        '456',
        'Centro',
        '23456-789',
        NULL,
        2);

-- Inserir dados na tabela instituicao

INSERT INTO instituicao (email, cnpj, razao_social, nome_fantasia, telefone, email_responsavel, telefone_responsavel, nome_responsavel, situacao)
VALUES ('contato@exemplo.com.br',
        '12.345.678/0001-95',
        'Instituição Exemplo Ltda',
        'Exemplo',
        '(11) 1234-5678',
        'responsavel@exemplo.com.br',
        '(11) 98765-4321',
        'José da Silva',
        'Ativa'), ('contato@outraempresa.com.br',
                   '98.765.432/0001-56',
                   'Outra Empresa S.A.',
                   'OutraEmpresa',
                   '(21) 2345-6789',
                   'responsavel@outraempresa.com.br',
                   '(21) 98765-4321',
                   'Maria Oliveira',
                   'Inativa');

-- Inserir dados na tabela usuario

INSERT INTO usuario (id_instituicao, nome, email, senha, telefone, situacao, data_cadastro)
VALUES (1,
        'Ana Souza',
        'ana.souza@exemplo.com.br',
        'senha123',
        '(11) 1234-5678',
        'Ativa',
        CURRENT_DATE), (2,
                        'Carlos Lima',
                        'carlos.lima@outraempresa.com.br',
                        'senha456',
                        '(21) 2345-6789',
                        'Inativo',
                        CURRENT_DATE);

-- Inserir dados na tabela membro_cpa

INSERT INTO membro_cpa (id_instituicao, cargo)
VALUES (1,
        'Coordenador'), (1,
                         'Vice-Coordenador');

-- Inserir dados na tabela reuniao_cpa

INSERT INTO reuniao_cpa (id_membro_cpa, data_reuniao, horario, pauta)
VALUES (1,
        '2024-09-10',
        '09:00:00',
        'Planejamento Estratégico'), (2,
                                      '2024-09-15',
                                      '14:00:00',
                                      'Avaliação de Desempenho'), (3,
                                                                   '2024-09-20',
                                                                   '11:00:00',
                                                                   'Revisão de Metas');

-- Inserir dados na tabela edicao_autoavaliacao

INSERT INTO edicao_autoavaliacao (id_instituicao, edicao, ano_avaliacao, descricao, data_inicio, data_fim)
VALUES (1,
        '1ª Edição',
        '2024',
        'Avaliação de 2024',
        '2024-01-01',
        '2024-12-31'), (2,
                        '2ª Edição',
                        '2024',
                        'Avaliação de 2024',
                        '2024-01-01',
                        '2024-12-31');

-- Inserir dados na tabela avaliacao

INSERT INTO avaliacao (id_edicao_autoavaliacao, data_inicio, data_fim, status, descricao, observacao)
VALUES (1,
        '2024-01-01',
        '2024-06-30',
        'Concluída',
        'Avaliação Semestral',
        'Nenhuma observação'), (2,
                                '2024-07-01',
                                '2024-12-31',
                                'Em Andamento',
                                'Avaliação Anual',
                                NULL);

-- Inserir dados na tabela questionario

INSERT INTO questionario (descricao, categoria, tipo)
VALUES ('Questionário de Satisfação',
        'Satisfação',
        'Quantitativo'), ('Questionário de Desempenho',
                          'Desempenho',
                          'Qualitativo');

-- Inserir dados na tabela avaliacao_questionario

INSERT INTO avaliacao_questionario (id_avaliacao, id_questionario)
VALUES (1,
        1), (2,
             2);

-- Inserir dados na tabela pergunta

INSERT INTO pergunta (descricao, categoria, tipo, tipo_escala)
VALUES ('Qual o seu nível de satisfação?',
        'Satisfação',
        'Quantitativo',
        5), ('Como você avalia o desempenho?',
             'Desempenho',
             'Qualitativo',
             0);

-- Inserir dados na tabela resposta

INSERT INTO resposta (id_pergunta, id_usuario, id_avaliacao_questionario, texto, data)
VALUES (1,
        1,
        1,
        'Muito satisfeito',
        CURRENT_TIMESTAMP), (2,
                             2,
                             2,
                             'Bom',
                             CURRENT_TIMESTAMP);

-- Inserir dados na tabela grupo_perguntas

INSERT INTO grupo_perguntas (tipo, descricao)
VALUES ('Grupo A',
        'Grupo de perguntas sobre satisfação geral'), ('Grupo B',
                                                       'Grupo de perguntas sobre desempenho');

-- Inserir dados na tabela perguntas_grupo_perguntas

INSERT INTO perguntas_grupo_perguntas (id_grupo_perguntas, id_pergunta, ordem_das_perguntas)
VALUES (1,
        1,
        1), (2,
             2,
             1);

-- Inserir dados na tabela grupo_perguntas_questionario

INSERT INTO grupo_perguntas_questionario (id_questionario, id_grupo_perguntas, ordem_dos_grupos)
VALUES (1,
        1,
        1), (2,
             2,
             1);