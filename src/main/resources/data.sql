drop table if exists d_user;
create table d_user (
                      id bigserial primary key not null ,
                      first_name varchar(70) not null ,
                      last_name varchar(70) not null ,
                      email varchar(255) not null unique ,
                      password varchar(50) not null,
                      role varchar(20) not null

);

INSERT INTO d_user (full_name, last_name, email, password, role) values
('Admin','Admin','admin@admin',12345,'ADMIN'),
('User','User','user@user',54321,'USER');
