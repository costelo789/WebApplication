# 14 Procedures

####################LIST AND VIEW #########################

# List all the Students
DELIMITER //
CREATE PROCEDURE listStudent()
BEGIN
SELECT A.id, A.firstname, A.lastname, S.studentid
FROM Student S JOIN Accounts A ON (S.studentid=A.id);
END //
DELIMITER ;

# List all the students belong to a module
DELIMITER //
CREATE PROCEDURE listStudentByModuleId(IN moduleId INTEGER)
BEGIN
SELECT S.studentid,A.firstname, A.lastname, M.modulesname
FROM  Accounts A JOIN Student S ON( A.id = S.studentid) JOIN Enrollment E ON ( S.studentid = E.studentid) JOIN Modules M ON (M.modulesid = E.modulesid)
WHERE M.modulesid = moduleId;
END //
DELIMITER ;

#List all the attendances of a specific students.
DELIMITER //
CREATE PROCEDURE listStudentAttendance(IN studentId INTEGER) #TODO by student name
BEGIN
    SELECT *
    FROM Attendance A
    WHERE A.studentid = studentId;
END //
DELIMITER ;

#List all the exams of all modules
DELIMITER //
CREATE PROCEDURE listAllExamWithModule()
BEGIN
    SELECT *
    FROM Modules M JOIN Exams E ON (M.modulesid = E.modulesid);
END //
DELIMITER ;

#List all the exams which overlap each other.
DELIMITER //
CREATE PROCEDURE listOverlapExams()
BEGIN
SELECT E1.examsid as "examsid1" ,E1.examsdate as "examsdate1", E1.examsfrom as "examsfrom1" ,E1.examsto as"examsto1" ,E2.examsid as "examsid2",E2.examsdate as "examsdate2",E2.examsfrom as "examsfrom2" ,E2.examsto as "examsto2"
FROM Exams E1 , Exams E2
WHERE E1.examsid < E2.examsid AND
      (E1.examsdate = E2.examsdate) AND
      (E1.examsfrom BETWEEN E2.examsfrom AND E2.examsto) OR
      (E1.examsfrom < E2.examsfrom AND E1.examsto > E2.examsto);
END //
DELIMITER ;

#List sessions of given date
DELIMITER //
CREATE PROCEDURE listSessionByDate(IN sessionDate DATE)
BEGIN
    SELECT *
    FROM Sessions S
    WHERE S.sessionsdate = sessionDate;
END //
DELIMITER ;

# List all the Exams by a given semester
DELIMITER //
CREATE PROCEDURE ListexamBySemester(IN semesterId INTEGER)
BEGIN
SELECT S.semesterid, M.modulesname, E.examsdate, E.examsfrom, E.examsto, E.deadline
FROM Modules M JOIN Semester S ON (M.semesterid = S.semesterid) JOIN Exams E ON (M.modulesid=E.modulesid)
WHERE S.semesterid = semesterId;
END //
DELIMITER ;

# List all the Exams by a given module
DELIMITER //
CREATE PROCEDURE listExamByModuleName(IN moduleName VARCHAR(20))
BEGIN
SELECT M.modulesid, M.modulesname, E.examsdate, E.examsfrom, E.examsto, E.deadline
FROM Modules M JOIN Exams E ON (M.modulesid=E.modulesid)
WHERE M.modulesname = moduleName;
END //
DELIMITER ;

# List all the exams of a given students which they have registered.
DELIMITER //
CREATE PROCEDURE listExamByStudent(IN studentId INTEGER)
BEGIN
SELECT S.studentid, A.firstname, A.lastname, E.examsid
FROM Accounts A JOIN Student S ON ( A.id = S.studentid) JOIN Registration R ON ( S.studentid = R.studentid) JOIN Exams E ON ( R.examsid = E.examsid)
WHERE S.studentid = studentId;
END //
DELIMITER ;

#List all the exam of a student
DELIMITER //
CREATE PROCEDURE listExamOfAStudent (IN id INT)
BEGIN
    SELECT *
    FROM Exams E JOIN Registration R ON (E.examsid = R.examsid)
                 JOIN Modules M ON (M.modulesid = E.modulesid)
    WHERE R.studentid = id;
END //
DELIMITER ;

# Student view his/her registered exams
DELIMITER //
CREATE PROCEDURE viewRegisteredExamsByStudent(IN studentId INTEGER) #TODO by student name
BEGIN
    SELECT M.modulesname, E.examsDate, E.examsFrom, E.examsTo
    FROM   Registration R JOIN Exams E ON ( R.examsid = E.examsid) JOIN Modules M ON ( M.modulesid = E.modulesid)
    WHERE R.studentid= studentId;
END //
DELIMITER ;

#########################CREATE############################

# Exam Registration
DELIMITER //
CREATE PROCEDURE examRegistration( IN studentId INTEGER,
                                   IN examId	INTEGER)
BEGIN
    INSERT INTO Registration(studentid, examsid) VALUES( studentID, examId);
END//

# Module Enroll
CREATE PROCEDURE moduleEnroll( IN studentId INTEGER, IN moduleId INTEGER)
BEGIN
    INSERT INTO enrollment VALUES( studentId, moduleId);
END//

# SignAttendance
CREATE PROCEDURE signAttendance( IN studentId INTEGER,
                                 IN sessionId INTEGER	)
BEGIN
    INSERT INTO Attendance(studentid, sessionsid) VALUES (studentId, sessionId);
END//
DELIMITER ;
