create table conteiner(
    id bigint not null auto_increment,
    cliente varchar(100) not null,
    numero varchar(11) not null unique,
    tipo varchar(7) not null,
    status varchar(5) not null,
    categoria varchar(10) not null,

    primary key(id)
);
