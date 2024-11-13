-- Inserir dados na tabela Endereco

begin;

INSERT INTO endereco (logradouro, numero, bairro, cidade, complemento)
VALUES ('Av. Antônio de Cássia',
        '472',
        'Jardim Santo Antônio',
        'Santa Rita do Sapucaí',
        NULL);


INSERT INTO instituicao (email, cnpj, razao_social, nome_fantasia, telefone, email_responsavel, telefone_responsavel, nome_responsavel, situacao, id_endereco)
VALUES ('secretaria@fai-mg.br',
        '24.492.860/0003-10',
        'Fundação Educandário Santarritense',
        'FAI - Centro de Ensino Superior em Gestão, Tecnologia e Educação',
        '(35) 3473-3000',
        'wanderley@gmail.com',
        '(11) 2222-3333',
        'Wanderley Rodrigo de Souza',
        'Ativa',
		1);

INSERT INTO reuniao_cpa (id_instituicao, id_membro_cpa, data_reuniao, horario, pauta) 
VALUES (1, NULL, '2024-10-28', '19:30:00', 'Discussão sobre a nova diretriz da instituição');   

INSERT INTO usuario (id_instituicao, nome, email, senha, telefone, tipo) VALUES
(1, 'Augusto', 'aluno1@instituicao1.com', 'senha123', '123456789', 'Aluno'),
(1, 'Eunice', 'professor1@instituicao1.com', 'senha123', '987654321', 'Professor'),
(1, 'Henrique', 'colaborador1@instituicao2.com', 'senha123', '111222333', 'Colaborador'),
(1, 'Ana Júlia', 'membro1@instituicao2.com', 'senha123', '444555666', 'Membro CPA'),
(NULL,'Gutinho', 'admin@administrador.com', 'senha123', '444555666', 'Administrador');

INSERT INTO edicao_autoavaliacao (id_instituicao, edicao, ano_avaliacao, descricao, data_inicio, data_fim, situacao) VALUES 
        (1, 1, '2024', '
        A Edição de Autoavaliação do 2º Semestre de 2024 é uma oportunidade 
        para a instituição refletir sobre seu desempenho recente. Com a participação 
        de alunos, professores, colaboradores e comunidade externa, os resultados 
        irão guiar melhorias e ajudar a planejar um futuro ainda melhor.', 
        '2024-07-01 00:00:00', 
        '2024-12-31 23:59:59', 
        'Em Andamento');    

INSERT INTO avaliacao (id_edicao_autoavaliacao, id_instituicao, descricao, tema) VALUES 
    (1, 1, 
    'Avaliação voltada para a análise das atividades de pesquisa e extensão da instituição, 
    com foco especial na FAITEC, a Feira de Tecnologia da FAI, e seu impacto no desenvolvimento 
    acadêmico e na interação com a comunidade', 
    'Pesquisa e Extensão');     

INSERT INTO questionario (id_instituicao, descricao, categoria) VALUES 
    (1, 'Avaliação focada na percepção dos alunos sobre a FAITEC, 
    suas contribuições acadêmicas e o impacto das atividades de 
    pesquisa e extensão no seu aprendizado', 'Aluno'),
    (1, 'Questionário voltado para os professores, 
    buscando avaliar a participação e o impacto da FAITEC 
    nas atividades de ensino, pesquisa e extensão', 'Professor');

INSERT INTO grupo_perguntas (id_instituicao, tipo, descricao) VALUES 
    (1, 'FAITEC', 'Avalia como a FAITEC enriquece a formação dos alunos 
    e o impacto das atividades de pesquisa e extensão em suas experiências');

INSERT INTO grupo_perguntas (id_instituicao, tipo, descricao) VALUES 
    (1, 'Impressões do Evento', 'Explora a visão dos professores sobre a FAITEC 
    e como o evento integra ensino, pesquisa e extensão'); 

INSERT INTO pergunta (id_instituicao, descricao, tipo) VALUES 
    (1, 'A feira de tecnologia oferece oportunidades valiosas para interagir com profissionais do setor.', 'Objetiva'),
    (1, 'A feira de tecnologia promove a colaboração entre diferentes áreas do conhecimento.', 'Objetiva'),
    (1, 'Deixe um ponto de melhoria (Opcional):', 'Subjetiva');

COMMIT;