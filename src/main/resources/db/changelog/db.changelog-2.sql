-- liquibase formatted sql

-- changeset daniel.pimentel:2.0 dbms:mysql

insert into address (id, zip_code, street, number, district, city, country) VALUES
    (1,'12345-679','Rua 1','1','BH','MG','BR'),
    (2,'12345-679','Rua 2','1','BH','MG','BR'),
    (3,'12345-679','Rua 3','1','BH','MG','BR'),
    (4,'12345-679','Rua 4','1','BH','MG','BR'),
    (5,'12345-679','Rua 5','1','BH','MG','BR'),
    (6,'12345-679','Rua 1','1','BH','MG','BR'),
    (7,'12345-679','Rua 2','1','BH','MG','BR'),
    (8,'12345-679','Rua 3','1','BH','MG','BR'),
    (9,'12345-679','Rua 4','1','BH','MG','BR'),
    (10,'12345-679','Rua 5','1','BH','MG','BR');

-- changeset daniel.pimentel:2.1 dbms:mysql

insert into company (name, document, vacancies, site, address_id) VALUES
     ('Empresa 1','123456789','1','www.empresa1.com.br', 1),
     ('Empresa 2','3215468789','4','www.empresa2.com.br', 2),
     ('Empresa 3','87454512135','1','www.empresa3.com.br', 3),
     ('Empresa 4','987512231','5','www.empresa4.com.br', 4),
     ('Empresa 5','231545689','10','www.empresa5.com.br', 5);

-- changeset daniel.pimentel:2.2 dbms:mysql

insert into user (name, document, login, password, salary, age, company_id, address_id) VALUES
     ('Usuário 1','6544848956','user1','user1','2000.00','20',1, 1),
     ('Usuário 2','54532454353','user2','user2','2430.10','23',2, 2),
     ('Usuário 3','12421342134','user3','user3','5000.00','54',5, 3),
     ('Usuário 4','2312342423','user4','user4','4030.80','32',4, 3),
     ('Usuário 5','656346431','user5','user5','5340.50','33',5, 4),
     ('Usuário 6','9876202838','user6','user6','6030.00','43',5, 5),
     ('Usuário 7','9876534567','user7','user7','1570.44','52',2, 6),
     ('Usuário 8','2356343234','user8','user8','5630.05','18',3, 7),
     ('Usuário 9','2343675434','user9','user9','4543.50','23',5, 8),
     ('Usuário 10','2145566576','user10','user10','6216.10','32',2, 9),
     ('Usuário 11','8799898789','user11','user11','4805.00','53',5, 7),
     ('Usuário 12','78974654632','user12','user12','7582.00','25',5, 10),
     ('Usuário 13','6568655453','user13','user13','5820.40','45',2, 1),
     ('Usuário 14','53456798726','user14','user14','2850.97','29',5, 5);