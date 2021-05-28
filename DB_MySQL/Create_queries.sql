-------------------------------------------------
#*****************QUERIES************************
-------------------------------------------------
# LISTS QUERIES
select * from course;
select count(*) from course; /* 8 records */
select * from student;
select count(*) from student; /* 40 records */
select * from trainer;
select count(*) from trainer; /* 6 records */
select * from assignment;
select count(*) from trainer; /* 6 records */
select * from course_student;
select count(*) from course_student; /* 44 records */
select * from course_trainer;
select count(*) from course_trainer; /* 10 records */
select * from assign_student;
select count(*) from assign_student; /* 44 records */
select *  from course_assign;
select count(*) from course_assign;/* 8 records */
----------------------------------------------------------------------------------------------------
#students from every course
select first_name, last_name, subject, type from course_student
inner join student on course_student.st_id=student.id
inner join course on course_student.st_subj_id=course.id
where course_student.st_subj_id;

select student.first_name,student.last_name, course.subject, course.type from course_student
inner join student on course_student.st_id=student.id
inner join course on course_student.st_subj_id=course.id
where course_student.st_subj_id=1;
----------------------------------------------------------------------------------------------------
#trainers from every course
select trainer.first_name, trainer.last_name, course.subject , course.type
from course_trainer
inner join trainer on course_trainer.tr_id=trainer.id
inner join course on course_trainer.tr_subj_id=course.id;
----------------------------------------------------------------------------------------------------
#assignments from every course
select course.subject, assignment.title, assignment.description, assignment.sub_date_time 
from course_assign
inner join assignment on course_assign.as_id=assignment.id
inner join course on course_assign.as_subj_id=course.id ;
----------------------------------------------------------------------------------------------------
#students with more than one courses
select student.first_name, student.last_name, student.date_of_birth 
from course_student 
inner join student on course_student.st_id=student.id 
inner join course on course_student.st_subj_id=course.id 
group by st_id having count(*)>1;
----------------------------------------------------------------------------------------------------
#assigments per student
select student.first_name, student.last_name, assignment.title, assignment.description, assignment.sub_date_time 
from assign_student
inner join assignment on assign_student.assign_id=assignment.id
inner join student on assign_student.assign_st_id=student.id ;


