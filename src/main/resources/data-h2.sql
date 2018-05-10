-- @PASSWORD = user
SET @PASSWORD = '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW';


-- EMPLOYEE PHOTOS
insert into arquivo(id, content) values
(0,  FILE_READ('./src/main/resources/static/photos/face.jpg'));

--AUTHENTICATION
INSERT into usuario(id, username, password, name, email, experience, skill, active, picture_id) VALUES
(100, 'user', @PASSWORD, 'Master Yoda','yoda@stars.wars','Masters Unidentified Jedi, Garro, Qui-Gon Jinn', 'Deflect Force Lightning, Strategic Mastery, Acting Skills, Indomitable Will, Battle Meditation, Sensing Death And Force-aided Acrobatics.',  TRUE, 0);

--ROLES
insert into papel(id, role) values
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- USER_ROLES
insert into usuario_papeis (usuario_id, papeis_id) values
(100, 1);

-- PessoaFisica
insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cpf, data_Nascimento, rg, sexo, cnpj, inscricao_estadual, inscricao_municipal, endereco_id)
            values ('PF', 103, 'john.smith@mailinator.com', 'John', '54999999999', '11111111111', current_date(), '1111111111', 'M', '', '', '', null);
insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cpf, data_Nascimento, rg, sexo, cnpj, inscricao_estadual, inscricao_municipal, endereco_id)
            values ('PF', 304, 'fulano.bitcho@mailinator.com', 'Fulano', '54888888888', '22222222222', current_date(), '2222222222', 'M', '', '', '', null);
insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cpf, data_Nascimento, rg, sexo, cnpj, inscricao_estadual, inscricao_municipal, endereco_id)
            values ('PF', 405, 'edgar.dti@mailinator.com', 'Edgar', '54333333333', '33333333333', current_date(), '3333333333', 'M', '', '', '', null);

-- Quarto
INSERT INTO quarto(id, descricao, disponivel, numero, tipo) VALUES (100, 'Q100', true, '100', 'STANDARD');
INSERT INTO quarto(id, descricao, disponivel, numero, tipo) VALUES (101, 'Q101', true, '101', 'DUPLO');
INSERT INTO quarto(id, descricao, disponivel, numero, tipo) VALUES (102, 'Q102', true, '102', 'MASTER');
INSERT INTO quarto(id, descricao, disponivel, numero, tipo) VALUES (103, 'Q103', true, '103', 'PRESIDENCIAL');

-- diaria
insert into Diaria (id, tipo_diaria, data, quarto_id, reserva_id, cliente_id) values (101, 'AVULSA', '2018-04-17', 100, null, 103); 
insert into Diaria (id, tipo_diaria, data, quarto_id, reserva_id, cliente_id) values (102, 'AVULSA', '2018-04-17', 101, null, 304);
insert into Diaria (id, tipo_diaria, data, quarto_id, reserva_id, cliente_id) values (103, 'AVULSA', '2018-04-17', 102, null, 405);

