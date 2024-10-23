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
        'W4nd3rl3y R0dr1gu3s de S0uz4',
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


COMMIT;