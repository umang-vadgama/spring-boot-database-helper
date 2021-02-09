CREATE TABLE student801.dept (
	branch_code numeric(10) NOT NULL,
	branch_name varchar(50) NULL,
	CONSTRAINT dept_pk PRIMARY KEY (branch_code)
);

CREATE TABLE student801.student_enroll (
	student_id numeric NOT NULL ,
	student_fname varchar(50) NULL,
	student_lname varchar(50) NULL,
	contact_number varchar(15) NULL,
	branch_id numeric NULL,
	date_of_birth date NULL,
	CONSTRAINT student_enroll_pk PRIMARY KEY (student_id),
	CONSTRAINT student_enroll_fk FOREIGN KEY (branch_id) REFERENCES student801.dept(branch_code)
);

create sequence  student_enroll_seq start with 1 owned by student801.student_enroll.student_id;

alter table student801.student_enroll alter column student_id set default nextval('student_enroll_seq'::regclass);