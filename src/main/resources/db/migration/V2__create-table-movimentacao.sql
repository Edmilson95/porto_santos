create table movimentacoes(
        id bigint not null auto_increment,
        tipo_movimentacao varchar(20) not null,
        data_hora_inicio datetime not null,
        data_hora_fim datetime not null,
        conteiner_id bigint not null,

        primary key (id),
        foreign key (conteiner_id) references conteiner (id)
);