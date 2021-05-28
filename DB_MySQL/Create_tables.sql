use project;
-------------------------------------------------
#create MAIN tables
-------------------------------------------------
create table course(
id int not null auto_increment,
subject varchar(45) not null,
stream varchar(20),
type varchar(20),
start_date date not null,
end_date date not null,
primary key(id)
);

create table assignment(
id int not null auto_increment, 
title varchar(40),
description varchar(80),
sub_date_time date not null,
oral_mark int,
total_mark int not null,
primary key(id)
);

create table trainer(
id int not null auto_increment ,
first_name varchar(45),
last_name varchar(45),
subject varchar(45),
primary key(id)
);

create table student(
id int not null auto_increment,
first_name varchar(45),
last_name varchar(45),
date_of_birth date not null,
tuition_fees int not null,
primary key(id)
);

-------------------------------------------------
#relationships tables MtoM
-------------------------------------------------
create table course_student(
id int not null auto_increment,
st_id int not null,
st_subj_id int not null,
primary key(id),
foreign key(st_id) references student(id),
foreign key(st_subj_id) references course(id)
);

create table course_trainer(
id int not null auto_increment,
tr_id int not null,
tr_subj_id int not null,
primary key(id),
foreign key(tr_id) references trainer(id),
foreign key(tr_subj_id) references course(id)
);

create table course_assign(
id int not null auto_increment,
as_id int not null,
as_subj_id int not null,
primary key(id),
foreign key(as_id) references assignment(id),
foreign key(as_subj_id) references course(id)
);

create table assign_student(
id int not null auto_increment,
assign_id int not null,
assign_st_id int not null,
primary key(id),
foreign key (assign_id) references assignment(id),
foreign key(assign_st_id) references student(id)
);


