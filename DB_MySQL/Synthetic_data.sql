use project;

#CREATE RELATIONSHIPS BETWEEN ASSIGNMENTS AND COURSES
insert into course_assign
(as_id,as_subj_id)
values
(1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8);
--------------------------------------------------------------------------------------------------------------------------------------------
#CREATE RELATIONSHIPS BETWEEN TRAINER AND COURSES
insert into course_trainer
(tr_id,tr_subj_id)
values
(1,1),(1,2),(2,3),(2,4),(3,5),(3,6),(4,7),(4,8),(5,2),(6,4);
--------------------------------------------------------------------------------------------------------------------------------------------
#CREATE RELATIONSHIPS BETWEEN STUDENTS AND ASSIGNMENTS
insert into assign_student
(assign_id,assign_st_id)
values
(1,1),(1,2),(1,3),(1,4),(1,5),
(2,6),(2,7),(2,8),(2,9),(2,10),
(3,11),(3,12),(3,13),(3,14),(3,15),(3,8),
(4,16),(4,17),(4,18),(4,19),(4,20),
(5,21),(5,22),(5,23),(5,24),(5,25),(5,19),
(6,26),(6,27),(6,28),(6,29),(6,30),
(7,31),(7,32),(7,33),(7,34),(7,35),(7,30),(7,9),
(8,36),(8,37),(8,38),(8,39),(8,40);
--------------------------------------------------------------------------------------------------------------------------------------------
#CREATE RELATIONSHIPS BETWEEN STUDENTS AND COURSES
insert into course_student
(st_id,st_subj_id)
values
(1,1),(2,1),(3,1),(4,1),(5,1),
(6,2),(7,2),(8,2),(9,2),(10,2),
(11,3),(12,3),(13,3),(14,3),(15,3),(8,3),
(16,4),(17,4),(18,4),(19,4),(20,4),
(21,5),(22,5),(23,5),(24,5),(25,5),(19,5),
(26,6),(27,6),(28,6),(29,6),(30,6),
(31,7),(32,7),(33,7),(34,7),(35,7),(30,7),(9,7),
(36,8),(37,8),(38,8),(39,8),(40,8);
--------------------------------------------------------------------------------------------------------------------------------------------
#INSERT COURSES
insert into course
 (subject,stream,type,start_date,end_date)
 values
 ('Java','CB13','FullTime','2021-02-15','2021-09-15'),
 ('Java','CB13','PartTime','2021-02-15','2021-11-15'),
 ('C','CB13','FullTime','2021-02-15','2021-09-15'),
 ('C','CB13','PartTime','2021-02-15','2021-11-15'),
 ('Python','CB13','FullTime','2021-02-15','2021-09-15'),
 ('Python','CB13','PartTime','2021-02-15','2021-11-15'),
 ('JavaScript','CB13','FullTime','2021-02-15','2021-09-15'),
 ('JavaScript','CB13','PartTime','2021-02-15','2021-11-15');

--------------------------------------------------------------------------------------------------------------------------------------------
#TRAINERS
insert into trainer
	(first_name,last_name,subject)
    values
    ('Giorgos','Iraklidis', 'Java'),
    ('Giorgos','Rigopoulos','SQL'),
    ('Kostas','Pappas','C'),
    ('Maria','Xristou','Python'),
    ('Dimitris','Sotiriou','JavaScript'),
    ('Thimios','Fantakis', 'Python');

--------------------------------------------------------------------------------------------------------------------------------------------
#ASSIGNMENTS
insert into assignment
(title, description,sub_date_time,oral_mark,total_mark)
values 
	('Project_A_Java','School DataBase','2021-07-15',100,100),
    ('Project_B_Java','School DataBaseB','2021-09-03',100,100),
    ('Project_A_C','School DataBase','2021-07-15',100,100),
    ('Project_B_C','School DataBaseB','2021-09-03',100,100),
    ('Project_A_Python','School DataBase','2021-07-15',100,100),
    ('Project_B_Python','School DataBaseB','2021-09-03',100,100),
    ('Project_A_JavaScript','School DataBase','2021-07-15',100,100),
    ('Project_B_JavaScript','School DataBaseB','2021-09-03',100,100);  

--------------------------------------------------------------------------------------------------------------------------------------------
#STUDENTS
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Jeramey', 'Kenington', '1999-01-26', 2397);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Gordon', 'McAlpin', '1999-03-16', 2161);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Adina', 'Buxey', '1998-10-17', 1563);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Charissa', 'Ellgood', '1999-01-17', 1762);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Meryl', 'Dargie', '2000-07-11', 1945);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Kala', 'Egar', '1996-02-21', 2119);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Rhiamon', 'Skelding', '2000-06-10', 2414);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Ossie', 'Ferrario', '1996-07-29', 1610);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Harv', 'Stockdale', '2001-02-03', 2064);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Carissa', 'Heintsch', '2000-05-20', 1969);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Malissia', 'Goreisr', '1994-09-25', 2138);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Pierre', 'Gritsaev', '2000-03-25', 2156);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Cristal', 'Utterson', '1997-08-25', 2366);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Murdoch', 'Wohlers', '2001-08-17', 2153);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Kenyon', 'Kingh', '1999-11-12', 1943);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Michal', 'Millmoe', '1996-03-28', 2394);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Katerine', 'Pinkerton', '1995-01-12', 1675);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Elora', 'Kirman', '2001-04-28', 1689);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Irma', 'Pinnick', '1998-08-14', 1884);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Leonidas', 'Munks', '1997-12-26', 2198);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Gertrude', 'Gegg', '1997-01-30', 2027);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Osbourn', 'Bushell', '1997-03-25', 1898);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Gawain', 'Petit', '1996-06-05', 1765);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Ines', 'Breede', '1999-06-26', 1912);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Rani', 'Dowding', '1998-08-17', 2144);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Maighdiln', 'Shillaber', '1997-01-25', 1985);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Calhoun', 'Casado', '2001-05-07', 2448);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Heath', 'Pude', '2000-10-26', 1832);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Branden', 'Wigin', '2000-06-07', 2086);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Filberte', 'Davids', '1994-09-15', 2346);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Zena', 'Brosetti', '2002-03-23', 2381);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Olivier', 'Bateup', '2002-03-03', 2309);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Tobe', 'Bartlosz', '1997-05-14', 2223);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Amandy', 'Semens', '2000-06-28', 2151);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Pietra', 'Brimfield', '1995-09-24', 2052);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Eveleen', 'Latham', '1997-03-01', 2049);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Estella', 'Hayers', '1995-09-24', 2062);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Pierre', 'McCormick', '2002-03-26', 1842);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Nita', 'Spain', '2000-05-16', 2311);
insert into student (first_name, last_name, date_of_birth, tuition_Fees) values ('Warner', 'Goodings', '2000-11-27', 1699);