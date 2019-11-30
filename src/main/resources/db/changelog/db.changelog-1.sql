-- liquibase formatted sql

-- changeset daniel.pimentel:1.0 dbms:mysql

create table address
(
    id       bigint auto_increment
        primary key,
    zip_code varchar(9)   null,
    street   varchar(255) null,
    number   int          null,
    district varchar(255) null,
    city     varchar(255) null,
    country  varchar(255) null
);

-- changeset daniel.pimentel:1.1 dbms:mysql

create table company
(
    id         bigint auto_increment
        primary key,
    name       varchar(100) not null,
    document   varchar(17)  not null,
--     age        int          null,
    vacancies  int          not null,
    site       varchar(255) not null,
    address_id bigint       null
);

-- changeset daniel.pimentel:1.2 dbms:mysql

create table user
(
    id         bigint auto_increment
        primary key,
    name       varchar(100)   not null,
    document   varchar(13)    not null,
    login      varchar(200)   not null,
    password   varchar(200)   not null,
    salary     decimal(19, 2) null,
    age        int            null,
    company_id bigint         null,
    address_id bigint         null
);


-- changeset daniel.pimentel:2.3 dbms:mysql

    alter table company
       add constraint FKgfifm4874ce6mecwj54wdb3ma
       foreign key (address_id)
       references address (id);

    alter table user
       add constraint FKddefmvbrws3hvl5t0hnnsv8ox
       foreign key (address_id)
       references address (id);

    alter table user
       add constraint FK2yuxsfrkkrnkn5emoobcnnc3r
       foreign key (company_id)
       references company (id);

--     alter table user
--        add constraint FK5pcy4q210geeovjssr0k3goek
--        foreign key (id)
--        references company (id);