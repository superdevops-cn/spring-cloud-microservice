drop table if exists   user ;

create table user
(
    id bigint not null,
    name varchar(40) ,
    age int,
    balance decimal(10,2),
    data_base varchar(40),
    primary key (id)
);