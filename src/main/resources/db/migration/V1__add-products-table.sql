create table products(
    id bigint not null primary key auto_increment,
    name varchar(255) not null,
    short_name varchar(100) not null,
    description text not null,
    net_weight decimal(10, 3) not null,
    unit_of_measure varchar(10) not null,
    gtin varchar(14) not null,
    is_perishable tinyint(1) not null,
    created_at datetime not null,
    updated_at datetime not null
);