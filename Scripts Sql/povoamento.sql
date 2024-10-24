-- Inserir dados na tabela Endereco

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
        'Wanderley Rodrigues de Souza',
        'Ativa',
		1);

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

INSERT INTO reuniao_cpa (id_instituicao, id_membro_cpa, data_reuniao, horario, pauta) VALUES
(1, null, '2024-10-28', '10:00:00', 'Planejamento do próximo semestre');        

INSERT INTO avaliacao (id_edicao_autoavaliacao, id_instituicao, descricao, tema) VALUES 
    (1, 1, 
    'Avaliação voltada para a análise das atividades de pesquisa e extensão da instituição, 
    com foco especial na FAITEC, a Feira de Tecnologia da FAI, e seu impacto no desenvolvimento 
    acadêmico e na interação com a comunidade', 
    'Pesquisa e Extensão');     

INSERT INTO questionario (id_instituicao, id_avaliacao, descricao, categoria) VALUES 
    (1, 1, 'Avaliação focada na percepção dos alunos sobre a FAITEC, 
    suas contribuições acadêmicas e o impacto das atividades de 
    pesquisa e extensão no seu aprendizado', 'Aluno'),
    (1, 1, 'Questionário voltado para os professores, 
    buscando avaliar a participação e o impacto da FAITEC 
    nas atividades de ensino, pesquisa e extensão', 'Professor'),
    (1, 1, 'Avaliação voltada para os colaboradores da 
    instituição, com o objetivo de medir a percepção sobre 
    a organização e o suporte da FAITEC nas atividades de 
    pesquisa e extensão', 'Colaborador'),
    (1, 1, 'Questionário destinado à comunidade externa, 
    avaliando a relevância e os benefícios da FAITEC como 
    um evento de pesquisa e extensão para a sociedade', 'Comunidade Externa');    

INSERT INTO grupo_perguntas (id_instituicao, id_questionario, tipo, descricao) VALUES 
    (1, 1, 'FAITEC (Aluno)', 'Avalia como a FAITEC enriquece a formação dos alunos 
    e o impacto das atividades de pesquisa e extensão em suas experiências'),
    (1, 2, 'FAITEC (Professor)', 'Explora a visão dos professores sobre a FAITEC 
    e como o evento integra ensino, pesquisa e extensão'),
    (1, 3, 'FAITEC (Colaborador)', 'Analisa a percepção dos colaboradores sobre 
    a FAITEC e suas contribuições para a comunidade e o ambiente educacional'),    
    (1, 4, 'FAITEC (Comunidade Externa)', 'Examina como a comunidade externa 
    vê a FAITEC e seu impacto no desenvolvimento social e tecnológico');

INSERT INTO grupo_perguntas (id_instituicao, id_questionario, tipo, descricao) VALUES 
    (1, 1, 'Impressões do Evento', 'Avalia como a FAITEC enriquece a formação dos alunos 
    e o impacto das atividades de pesquisa e extensão em suas experiências'),
    (1, 2, 'Impressões do Evento', 'Explora a visão dos professores sobre a FAITEC 
    e como o evento integra ensino, pesquisa e extensão'),
    (1, 3, 'Impressões do Evento', 'Analisa a percepção dos colaboradores sobre 
    a FAITEC e suas contribuições para a comunidade e o ambiente educacional'),    
    (1, 4, 'Impressões do Evento', 'Examina como a comunidade externa 
    vê a FAITEC e seu impacto no desenvolvimento social e tecnológico');    

INSERT INTO pergunta (id_instituicao, id_grupo_perguntas, descricao, tipo) VALUES 
    (1, 1, 'A feira de tecnologia oferece oportunidades valiosas para interagir com profissionais do setor.', 'Objetiva'),
    (1, 1, 'A feira de tecnologia promove a colaboração entre diferentes áreas do conhecimento.', 'Objetiva'),
    (1, 1, 'A disponibilidade de materiais da FAITEC é adequada e suficiente para os alunos.', 'Objetiva'),
    (1, 1, 'A participação dos alunos na feira é incentivada pela instituição.', 'Objetiva'),
    (1, 1, 'A organização da feira é eficiente e facilita minha participação.', 'Objetiva'),
    (1, 1, 'As premiações da feira incentivam a participação dos alunos.', 'Objetiva'),
    (1, 1, 'Deixe um oi:', 'Subjetiva');

INSERT INTO pergunta (id_instituicao, id_grupo_perguntas, descricao, tipo) VALUES 
    (1, 2, 'A feira é bem organizada e facilita a participação dos docentes.', 'Objetiva'),
    (1, 2, 'O suporte da instituição na realização da feira é satisfatório.', 'Objetiva'),
    (1, 2, 'A feira proporciona um momento para discutir tendências e inovações na educação.', 'Objetiva'),
    (1, 2, 'A feira me inspira a adotar novas abordagens de ensino para engajar melhor os alunos.', 'Objetiva'),
    (1, 2, 'O evento ajuda a fortalecer a relação entre a instituição e o mercado de trabalho.', 'Objetiva');

INSERT INTO pergunta (id_instituicao, id_grupo_perguntas, descricao, tipo) VALUES 
    (1, 3, 'Sinto que a colaboração entre os setores da FAITEC durante a feira é eficaz.', 'Objetiva'),
    (1, 3, 'Sinto que meu trabalho é valorizado durante a realização da feira.', 'Objetiva'),
    (1, 3, 'A comunicação sobre a feira entre os setores da instituição é eficiente.', 'Objetiva'),
    (1, 3, 'A realização da feira contribui para o desenvolvimento de habilidades colaborativas.', 'Objetiva'),
    (1, 3, 'O impacto positivo da feira na comunidade aumenta a relevância do meu trabalho na instituição.', 'Objetiva');

INSERT INTO pergunta (id_instituicao, id_grupo_perguntas, descricao, tipo) VALUES 
    (1, 4, 'Os projetos apresentados ajudam a solucionar problemas locais.', 'Objetiva'),
    (1, 4, 'O evento é uma oportunidade para as empresas conhecerem novos talentos.', 'Objetiva'),
    (1, 4, 'A divulgação da Feira de Tecnologia da FAITEC é ampla e acessível para todos os membros da comunidade.', 'Objetiva'),
    (1, 4, 'Os materiais promocionais da feira (cartazes, folhetos, etc.) são atrativos e informativos.', 'Objetiva'),
    (1, 4, 'Os alunos demonstram conhecimento prático e habilidades nos projetos apresentados.', 'Objetiva'),
    (1, 4, 'Eu me sinto motivado a participar mais ativamente na comunidade após ver os projetos apresentados na feira.', 'Objetiva');

INSERT INTO pergunta (id_instituicao, id_grupo_perguntas, descricao, tipo) VALUES 
    (1, 5, 'Se você pudesse destacar uma coisa ou um projeto que mais lhe chamou atenção, qual seria?', 'Subjetiva'),
    (1, 5, 'Quais temas ou atividades você gostaria de ver em futuros eventos?', 'Subjetiva'),
    (1, 5, 'O que você acha que poderia ser feito para tornar o evento ainda melhor?', 'Subjetiva');

INSERT INTO pergunta (id_instituicao, id_grupo_perguntas, descricao, tipo) VALUES 
    (1, 6, 'Se você pudesse destacar uma coisa ou um projeto que mais lhe chamou atenção, qual seria?', 'Subjetiva'),
    (1, 6, 'Quais temas ou atividades você gostaria de ver em futuros eventos?', 'Subjetiva'),
    (1, 6, 'O que você acha que poderia ser feito para tornar o evento ainda melhor?', 'Subjetiva');

INSERT INTO pergunta (id_instituicao, id_grupo_perguntas, descricao, tipo) VALUES 
    (1, 7, 'Se você pudesse destacar uma coisa ou um projeto que mais lhe chamou atenção, qual seria?', 'Subjetiva'),
    (1, 7, 'Quais temas ou atividades você gostaria de ver em futuros eventos?', 'Subjetiva'),
    (1, 7, 'O que você acha que poderia ser feito para tornar o evento ainda melhor?', 'Subjetiva');

INSERT INTO pergunta (id_instituicao, id_grupo_perguntas, descricao, tipo) VALUES 
    (1, 8, 'Se você pudesse destacar uma coisa ou um projeto que mais lhe chamou atenção, qual seria?', 'Subjetiva'),
    (1, 8, 'Quais temas ou atividades você gostaria de ver em futuros eventos?', 'Subjetiva'),
    (1, 8, 'O que você acha que poderia ser feito para tornar o evento ainda melhor?', 'Subjetiva');    

COMMIT;