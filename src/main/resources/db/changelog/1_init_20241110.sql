-- liquibase formatted sql

-- changeset aaron:1
use `mcdse105`;

create table `product` (
	id bigint not null auto_increment,
    name varchar(200) not null,
    description varchar(255) not null,
    category varchar(200) not null,
    price decimal(10,2) not null,
    quantity int,
    primary key (id)
);

insert into `product` (name, description, category, price, quantity)
values ("Dendeng Nyet Berapi", "Dendeng is a classic dark and oily dish made up of tender beef marinated in spices and herbs and is usually served with rice and any other foods.", "Canned and Packed Food", 15, 1000);

insert into `product` (name, description, category, price, quantity)
values ("sambal Nyet Berapi", "Spicy and fragrant sambal original made by KA which best served with rice", "Canned and Packed Food", 16, 1000);
