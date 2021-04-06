create table user(
    userid      bigint auto_increment primary key,
    name        varchar(255) null,
    password    varchar(255) null,
    fullname    varchar(300) null,
    createddate timestamp    null,
    rodeid      bigint       null,
    roleid      bigint       null
)