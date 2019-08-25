drop table if exists d_user;
/*CREATE TYPE role AS ENUM ('USER','ADMIN');*/
create table d_user (
                      id bigserial primary key not null ,
                      first_name varchar(70) not null ,
                      last_name varchar(70) not null ,
                      email varchar(255) not null unique ,
                      password varchar(50) not null,
                      phone_number varchar(100) not null unique,
                      role varchar(20) not null

);

INSERT INTO d_user (full_name, last_name, email, password, role ,phone_number) values
('Admin','Admin','admin@admin',12345,'ADMIN','+375251234567'),
('User','User','user@user',54321,'USER','+375251234567');


/*CREATE TYPE status AS ENUM (
  'NEW','REVIEWING',
  'IN_PROCESS','DELIVERED'
  );*/

drop table if exists d_order;
create table d_order (
                       id bigserial primary key not null,
                       date_of_order date not null ,
                       delivery_date date not null ,
                       address varchar(100) not null,
                       status varchar(30) not null
);


insert into d_order (date_of_order, delivery_date, address, status)values
('2019-01-10','2019-01-13','Nemiga 14','NEW'),
('2017-04-22','2017-04-25','Nekrasova 17','REVIEWING'),
('2017-02-19','2017-04-25','Kolosa 10','IN_PROCESS'),
('2016-09-11','2016-09-13','Krasnaya 10','DELIVERED'),
('2010-10-30','2010-11-03','Leningradskaya 20','NEW');



drop table if exists brand;
create table brand(
                    id bigserial primary key not null,
                    name varchar(50) not null ,
                    country varchar(70) not null
);

insert into brand (name, country) values
('Xiaomi','China'),
('Huawei','China'),
('Iphone','USA'),
('Nokia','Finland'),
('Sony','Japan');


drop table if exists seller;
create table seller (
                      id bigserial primary key not null,
                      name varchar(70) not null ,
                      rating float not null
);


insert into seller (name, rating) values
('MobileX',7),
('Svaznoi',10),
('Life',9),
('Velcom',10),
('MTS',6);

drop table if exists product;
create table product (
                       id bigserial primary key not null ,
                       name varchar(100) not null ,
                       date_of_issue date not null ,
                       product_characteristic text not null ,
                       price decimal not null check (price > 0),
                       brand_id bigint

);
/*alter table product drop constraint product_brand_id_fkey;*/
alter table product add constraint product_brand_id_fkey FOREIGN KEY (brand_id)
  REFERENCES brand (id) on delete cascade;


insert into product (name, date_of_issue, product_characteristic, price, brand_id)
values ('Mi6','2018-02-05','Color: Grey, Screen:6.3, Camera:48 MP, Memory:32 GB',560.50,(select id  from brand where id = 1)),
       ('Nova 4','2016-03-10','Color: White, Screen:5.97, Camera:13 MP, Memory:64 GB',490.10,(select id  from brand where id = 2 )),
       ('X','2015-09-30','Color: Black, Screen:6.4, Camera:12 MP, Memory:128 GB',890.60,(select id from brand where id = 3 )),
       ('Lumia','2015-10-24','Color: Screen:6.26, Camera:48 MP, Memory:8 GB',350,(select id from brand where id = 4 )),
       ('Xperia','2009-10-14','Color: Green, Screen:5.45, Camera:8 MP, Memory:32 GB',201.50,(select id from brand where id = 5 ));


drop table if exists good_in_order;
create table good_in_order (
                             order_id bigint ,
                             product_id bigint,
                             primary key (order_id, product_id),
                             quantity_of_goods_in_the_order int not null
);

/*alter table goodInOrder drop constraint good_in_order_order_id_fkey;*/
alter table good_in_order add constraint good_in_order_order_id_fkey FOREIGN KEY (order_id)
  REFERENCES d_order (id) on delete cascade;

/*alter table goodInOrder drop constraint good_in_order_product_id_fkey;*/
alter table good_in_order add constraint good_in_order_product_id_fkey FOREIGN KEY (product_id)
  REFERENCES product (id) on delete cascade;

insert into good_in_order (order_id, product_id, quantity_of_goods_in_the_order)values
((select id from d_order where id = 1),(select id from  product where  id = 1),1),
((select id from d_order where id = 2),(select id from  product where  id = 2),2),
((select id from d_order where id = 3),(select id from  product where  id = 3),3),
((select id from d_order where id = 4),(select id from  product where  id = 4),4),
((select id from d_order where id = 5),(select id from  product where  id = 5),5);

select d.date_of_order, d.delivery_date, d.address, d.status, p.name
from d_order as d left join good_in_order as g on g.order_id = d.id left join product as p on p.id = g.product_id;

select p.id, p.name, p.date_of_issue, p.product_characteristic, p.price, b.name, b.country
from product as p left join brand as b on p.brand_id = b.id where p.id = 1;


select * from product;