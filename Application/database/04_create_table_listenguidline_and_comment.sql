use toeiconline;

create table listenguidline (
                                listenguidlineid bigint not null primary key auto_increment,
                                title varchar(512) null,
                                image varchar(255) null,
                                content text null,
                                createddate timestamp null,
                                modifieddate timestamp null
);

create table comment (
                         commentid bigint not null primary key auto_increment,
                         commentcontent text null,
                         userid bigint null,
                         listenguidlineid bigint null,
                         createddate timestamp null
)