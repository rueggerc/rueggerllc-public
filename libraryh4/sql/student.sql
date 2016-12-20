
drop table student_course;
drop table student;
drop table course;

create table student 
(
	id				bigint not null primary key,
	first_name		varchar(40) not null,
	last_name		varchar(40) not null,
	status 			integer not null
);

create table course
(
	id			bigint not null primary key,
	name		varchar(40) not null,
	teacher		varchar(40) not null,
	status 		integer not null
);
 
create table student_course
(
	student_id	bigint,
	course_id		bigint,
	primary key (student_id, course_id),
	constraint fk_student foreign key (student_id) references student (id),
	constraint fk_course  foreign key (course_id)  references course (id)
);