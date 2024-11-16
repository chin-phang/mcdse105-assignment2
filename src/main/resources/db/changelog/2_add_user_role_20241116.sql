-- liquibase formatted sql

-- changeset aaron:1
use `mcdse105`;

create table `user` (
	id bigint not null auto_increment,
	username varchar(200) not null,
	email varchar(200) not null,
	password varchar(64) not null,
	primary key (id)
);

create table `role` (
	id int not null auto_increment,
    name varchar(20) not null,
    primary key (id)
);

INSERT INTO `role`(`name`) VALUES ('USER');
INSERT INTO `role`(`name`) VALUES ('ADMIN');
