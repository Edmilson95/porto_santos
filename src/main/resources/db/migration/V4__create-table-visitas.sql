create table visitas (
    id bigint not null auto_increment,
    conteiner_id bigint not null,
    movimentacao_id bigint not null,
    data datetime not null,

    primary key(id),
    constraint fk_visitas_conteiner_id foreign key(conteiner_id) references conteiner(id),
    constraint fk_visitas_movimentacao_id foreign key(movimentacao_id) references movimentacoes(id)
);
