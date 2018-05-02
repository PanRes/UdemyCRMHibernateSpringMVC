INSERT INTO udemy_crm.customer (id, first_name, last_name, email) VALUES (1, 'Panagiotis', 'Ressos', 'p.ressos@hotmail.com');
INSERT INTO udemy_crm.customer (id, first_name, last_name, email) VALUES (2, 'Makis', 'Kotsovos', 'mccoy@gmail.com');
INSERT INTO udemy_crm.customer (id, first_name, last_name, email) VALUES (3, 'Aggelos', 'Perlianis', 'angel@gmail.com');

-- auto-generated definition
create table customer
(
  id         int auto_increment
    primary key,
  first_name varchar(45) null,
  last_name  varchar(45) null,
  email      varchar(45) not null,
  constraint customer_email_uindex
  unique (email)
)
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci

    engine = InnoDB;

