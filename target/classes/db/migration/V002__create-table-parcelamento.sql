create table parcelamentos(
    id bigint not null auto_increment,
    cliente_id bigint not null,
    descricao varchar(20) not null,
    valor_total decimal(10, 2) not null,
    quantidade_parcelas tinyint,
    data_criacao datetime not null,

    primary key (id)

);
alter table parcelamentos add constraint fk_parcelamentos_clientes
foreign key (cliente_id) references clientes (id);
