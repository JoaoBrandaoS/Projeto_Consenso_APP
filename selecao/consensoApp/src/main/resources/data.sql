
INSERT INTO `tipo_usuario` (`nome`)
VALUES
  ("cliente"),
  ("prestador");

INSERT INTO `Usuario` (`nome`,`sobrenome`,`senha`,`email`,`tipo_usuario_id_tipo_usuario`)
VALUES
  ("admin","admin","(12345678","admin@gmail.com",2),
  ("Gabriel Frost","Dillon Russo","(337) 318-5256","congue.a@hotmail.com",2),
  ("Caleb David","Mary Cooper","1-695-714-6651","vitae@aol.org",2),
  ("Jillian Gilbert","Boris Hull","1-176-355-3428","blandit.mattis@aol.edu",2),
  ("Ali French","Hyacinth Cross","(562) 885-4670","vestibulum.accumsan@protonmail.net",1),
  ("Julie Yang","Orli Bowman","1-823-836-8448","neque.nullam@protonmail.ca",1),
  ("Jillian Blair","Kuame Klein","(664) 458-0765","eu@icloud.org",2),
  ("Dylan Cunningham","Madeson Wilkerson","1-739-723-2465","libero.donec.consectetuer@yahoo.org",2),
  ("Forrest Waters","Kylie Michael","1-258-855-0513","proin.non@hotmail.net",1),
  ("Gretchen Tyler","Vance Shields","1-727-438-1330","lectus.a@yahoo.couk",1);



INSERT INTO `servico` (`nome`,`descricao`, `usuario_id_usuario`)
VALUES
("pular codar","pulando muito",1),
("pedrinhas","carregarei pedra",2);


INSERT INTO `agendamento` (`data`,`hora`, `servicos_id_servico`, `usuario_id_usuario`)
VALUES
("2023-04-03","18:30",1,5),
("2023-05-04","21:20",2,6);


