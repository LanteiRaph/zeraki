CREATE database IF NOT EXISTS education;

CREATE TABLE institution (
                             institution_id INT(11) NOT NULL AUTO_INCREMENT,
                             institution_name VARCHAR(250),
                             PRIMARY KEY(institution_id)
);

CREATE TABLE course(
                       course_id INT(11) NOT NULL AUTO_INCREMENT,
                       course_name VARCHAR(250),
                       institution INT(11),
                       PRIMARY KEY(course_id),
                       FOREIGN KEY(institution) REFERENCES institution(institution_id)
);

CREATE TABLE student(
                        student_id INT(11) NOT NULL AUTO_INCREMENT,
                        student_name VARCHAR(250),
                        course INT(11),
                        PRIMARY KEY(student_id),
                        FOREIGN KEY(course) REFERENCES course(course_id)
);




-- Question B
SELECT  institution_name, course_name, COUNT(students) AS NUMBER_OF_STUDENTS FROM
    (SELECT  institution.institution_name AS INSTITUTION_NAME, course.course_name AS COURSE_NAME, student.student_id AS students
        FROM course
        JOIN institution ON course.institution = institution.institution_id
        JOIN student ON course.course_id = student.course
        ) as custom
GROUP BY course_name;