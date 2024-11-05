select * from department;
select * from course;
-- 
select d.name, count(c.id)
from department d, course c
where d.id = c.deptId
group by d.name
order by count(c.id), d.name;

select * from student;
select * from studentcourse;
-- 
select c.name, count(st.studentID)
from course c, studentcourse st
where st.courseId = c.id
group by c.name
order by count(st.studentID) desc, c.name ASC;

select * from course;
select * from facultycourse;
select * from faculty;

-- write a query to list names of all courses where the number of faculty assigned to thoses courses is zero
-- course name in asc order
select name from course
where deptid is null; 
select c.name
from course c
left join facultycourse fc on c.id = fc.courseId
where fc.facultyId is null
order by c.name asc;
-- you can also write like this
SELECT c.name
FROM course c
WHERE NOT EXISTS (
    SELECT 1
    FROM facultyCourse fc
    WHERE fc.courseid = c.id
)
ORDER BY c.name ASC;

SELECT c.name
FROM course c
WHERE c.id NOT IN (
    SELECT fc.courseid
    FROM facultyCourse fc
)
ORDER BY c.name ASC;
-- list course names and name of students in those courses for all courses where there are no assigned faculty
-- number of students first in desc, then course name in asc
select c. name , count(sc.studentID)
from course c, studentcourse sc
where
 c.id = sc.courseId and
 c.id not in (select courseId from facultyCourse)
group by c.name
order by count(sc.studentID) desc, c.name;

---
select c. name , count(st.studentID)
from course c, studentcourse st
where st.courseId = c.id and sc.courseId = c.id
group by c.name
order by count(st.studentID) desc, c.name;

-- Total number of students enrolled during each school year
-- school year in ASC, Total Number of students in desc
select * from studentcourse;

select count(distinct studentId) AS Students , year(startDate) AS Year
from studentcourse sc
group by year(startDate)
order by year ASC , students desc;

-- List start date and total number of students in classes in august of each year
select startDate, count(distinct studentId)
from studentcourse
where monthname(startDate) = 'August'
group by startDate
order by startDate, count(distinct studentId);

-- Query to list students first name , last name and number of courses they are taking in their major dept
select s.firstname, s.lastname, count(sc.courseId)
from student s, studentcourse sc, course c, department d
where s.id = sc.studentId and sc.courseId = c.id and c.deptId = d.id and s.majorId = d.id
group by s.firstname, s.lastname
order by count(sc.courseId) desc, s.firstname, s.lastname;

-- query to list Firstname, lastname, avg progress of all students achieving avr progress of less than 50%
-- Avg progress displayed should be rounded ro 1 decimal
select * from studentcourse;
select s.firstname As First_Name, s.lastname As Last_Name, round(AVG(sc.progress), 1) As Average_Progress
from student s
Join studentcourse sc on s.id = sc.studentId
group by s.id, s.firstname, s.lastname
HAVING Avg(sc.progress) < 50
order by Average_Progress desc, First_Name asc, Last_Name asc;

-- List each course name and Avg progress of students in that course
-- Avg progress rounded to one decimal place
select c.name As Course_Name, Round(Avg(sc.progress), 1) As Average_Progress
from course c, studentcourse sc
where c.id = sc.courseId
group by c.name
order by Average_Progress desc, Course_Name;

-- Write a query that shows course name and avg student progress of the course with 
-- highest avg progress in the system.
select 
c.name As Course_Name, Round(Avg(sc.progress), 1) As Average_Progress
from course c, studentcourse sc
where c.id = sc.courseId
group by Course_Name
order by Average_Progress desc
limit 1;

-- Write a query that outputs the faculty First Name, Last Name and Average Progress 
-- made over all of their courses

select
f.firstname As First_Name,
f.lastname As Last_Name,
Round(Avg(sc.progress), 1) As Average_Progress
from faculty f, studentcourse sc, course c, department d
where sc.courseId = c.id and c.deptId = d.id and d.id = f.deptid
group by First_Name, Last_Name
order by Average_Progress desc, First_Name, Last_Name;

select
f.firstname As First_Name,
f.lastname As Last_Name,
Round(Avg(sc.progress), 1) As Average_Progress
from faculty f
join course c on f.id = c.deptid
join studentcourse sc on c.id = sc.courseId
group by f.id, First_Name, Last_Name
order by Average_Progress desc, First_Name, Last_Name;

SELECT 
    s.firstname AS First_Name,
    s.lastname AS Last_Name,
    CASE
        WHEN MIN(sc.progress) >= 70 THEN 'A'
        WHEN MIN(sc.progress) >= 60 THEN 'B'
        WHEN MIN(sc.progress) >= 50 THEN 'C'
        WHEN MIN(sc.progress) >= 40 THEN 'D'
        ELSE 'F'
    END AS Minimum_Grade,
    CASE
        WHEN MAX(sc.progress) >= 70 THEN 'A'
        WHEN MAX(sc.progress) >= 60 THEN 'B'
        WHEN MAX(sc.progress) >= 50 THEN 'C'
        WHEN MAX(sc.progress) >= 40 THEN 'D'
        ELSE 'F'
    END AS Maximum_Grade
FROM 
    student s
JOIN 
    studentcourse sc ON s.id = sc.studentId
GROUP BY 
    s.firstname, s.lastname
ORDER BY 
    Minimum_Grade DESC,
    Maximum_Grade DESC,
    s.firstname ASC,
    s.lastname ASC;
    
SELECT 
    s.firstname AS First_Name,
    s.lastname AS Last_Name,
    -- Minimum Grade calculation based on minimum progress
    (SELECT 
        'A' 
     WHERE MIN(sc.progress) >= 70) 
    OR (SELECT 
        'B' 
     WHERE MIN(sc.progress) >= 60 AND MIN(sc.progress) < 70)
    OR 'C' AS Minimum_Grade,
    -- Maximum Grade calculation based on maximum progress
    (SELECT 
        'A' 
     WHERE MAX(sc.progress) >= 70) 
    OR (SELECT 
        'B' 
     WHERE MAX(sc.progress) >= 60 AND MAX(sc.progress) < 70)
    OR 'C' AS Maximum_Grade
FROM 
    student s
JOIN 
    studentcourse sc ON s.id = sc.studentId
GROUP BY 
    s.firstname, s.lastname
ORDER BY 
    Minimum_Grade DESC,
    Maximum_Grade DESC,
    s.firstname ASC,
    s.lastname ASC;
    
    
    
    

