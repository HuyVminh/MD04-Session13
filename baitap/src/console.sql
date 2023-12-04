CREATE DATABASE baitap_ss13;
USE baitap_ss13;

create table category(
    id int primary key auto_increment,
    name varchar(255) not null unique,
    status boolean default true
);
create table product(
    id int primary key auto_increment,
    name varchar(255) not null,
    price double not null,
    category_id int not null,
    foreign key (category_id) references category(id)
);

delimiter //
create procedure proc_show_category()
begin
    select * from category;
end //

delimiter //
create procedure proc_show_product()
begin
    select * from product;
end //

delimiter //
create procedure proc_add_category(in c_name varchar(255))
begin
    insert into category(name) values (c_name);
end
//

delimiter //
create procedure proc_update_category(in id_update int,in c_name varchar(255),in c_status boolean)
begin
    update category set name = c_name, status = c_status where id = id_update;
end //

delimiter //
create procedure proc_find_category_by_id(in c_id int)
begin
    select * from category where id = c_id;
end //

delimiter //
create procedure proc_add_product(in p_name varchar(255),in p_price double,in p_category_id int)
begin
    insert into product(name,price,category_id) values (p_name,p_price,p_category_id);
end //