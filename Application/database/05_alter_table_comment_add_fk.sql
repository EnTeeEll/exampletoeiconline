use toeiconline;
alter table comment add constraint fk_comment_user foreign key (userid) references user(userid);
alter table comment add constraint fr_comment_listenguidline foreign key (listenguidlineid)
    references listenguidline(listenguidlineid);