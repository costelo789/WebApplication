#########################NEW###############################

#########################LECTURER###############################
#10 Methods

#List semester id by sfrom sto
DELIMITER //
CREATE PROCEDURE listSemesterId(IN sfrom DATE,
                                IN sto DATE)
BEGIN
    SELECT Se.semesterid as "semesterid", Se.semesterfrom as "semesterfrom"
         , Se.semesterto as "semesterto"
    FROM Semester Se
    WHERE Se.semesterfrom = sfrom and Se.semesterto = sto;
END //
DELIMITER ;

#List module id by module name
DELIMITER //
CREATE PROCEDURE listModule()
BEGIN
    SELECT M.modulesid as "modulesid", M.modulesname as "modulesname"
    FROM Modules M;
END //
DELIMITER ;

#List exam by module name
DELIMITER //
CREATE PROCEDURE listExamByModuleName(IN moduleName VARCHAR(20))
BEGIN
    SELECT *
    FROM Exams E JOIN Modules M ON (M.modulesid = E.modulesid)
    WHERE M.modulesname = moduleName;
END //
DELIMITER ;

#List student by first name and last name
DELIMITER //
CREATE PROCEDURE listStudentByName(IN erstename VARCHAR(20),
                                   IN familienname VARCHAR(20))
BEGIN
    SELECT S.studentid as "studentid", A.firstname as "firstname",
           A.lastname as "lastname"
    FROM Accounts A JOIN Student S ON A.id = S.studentid
    WHERE A.firstname = erstename and A.lastname = familienname;
END //
DELIMITER ;

drop procedure listSessionByModuleId;
#List session by module name
DELIMITER //
CREATE PROCEDURE listSessionByModuleId(IN moduleId INT)
BEGIN
    SELECT Se.modulesid as "modulesid", Se.sessionsdate as "sessionsdate",
           Se.sessionsfrom as "sessionsfrom", Se.sessionsto as "sessionsto",
           M.modulesname as "modulesname", Se.sessionsid as "sessionsid"
    FROM Sessions Se JOIN Modules M ON M.modulesid = Se.modulesid
    WHERE M.modulesid = moduleId;
END //
DELIMITER ;

#List registration by examsid
DELIMITER //
CREATE PROCEDURE listRegistrationByExam(IN examId INT)
BEGIN
    SELECT R.studentid as "studentid", A.firstname as "firstname",
           A.lastname as "lastname", R.examsid as "examsid"
    FROM Registration R JOIN Accounts A ON R.studentid = A.id
    WHERE R.examsid = examId;
END //
DELIMITER ;

#List attendance by sessionsid
DELIMITER //
CREATE PROCEDURE listAttendanceBySession(IN sessionId INT)
BEGIN
    SELECT Att.studentid as "studentid", A.firstname as "firstname",
           A.lastname as "lastname", Att.sessionsid as "sessionsid"
    FROM Attendance Att JOIN Accounts A ON Att.studentid = A.id
    WHERE Att.sessionsid = sessionId;
END //
DELIMITER ;

#List enrollment by moduleid
DELIMITER //
CREATE PROCEDURE listEnrollmentByModuleId(IN moduleId INT)
BEGIN
    SELECT E.studentid as "studentid", A.firstname as "firstname",
           A.lastname as "lastname", E.modulesid as "modulesid"
    FROM Enrollment E JOIN Accounts A ON E.studentid = A.id
    WHERE E.modulesid = moduleId;
END //
DELIMITER ;

#List session overlaps
DELIMITER //
CREATE PROCEDURE listSessionsOverlap()
BEGIN
    SELECT S1.sessionsid as "sessionsid1", S1.sessionsfrom as "sessionsfrom1",
           S1.sessionsto as "sessionsto1", S1.sessionsdate as "sessionsdate1",
           S2.sessionsid as "sessionsid2", S2.sessionsfrom as "sessionsfrom2",
           S2.sessionsto as "sessionsto2", S2.sessionsdate as "sessionsdate2"
    FROM Sessions S1, Sessions S2
    WHERE S1.sessionsid < S2.sessionsid AND
          (S1.sessionsdate = S2.sessionsdate) AND
          (S1.sessionsfrom BETWEEN S2.sessionsfrom AND S2.sessionsto) OR
        (S1.sessionsfrom < S2.sessionsfrom AND S1.sessionsto > S2.sessionsto);
END //
DELIMITER ;

# List all the Exams by a given module
DELIMITER //
CREATE PROCEDURE listExamByModuleId(IN moduleId INT)
BEGIN
    SELECT M.modulesid, M.modulesname, E.examsdate, E.examsfrom, E.examsto, E.deadline, E.examsid
    FROM Modules M JOIN Exams E ON (M.modulesid=E.modulesid)
    WHERE M.modulesid = moduleId;
END //
DELIMITER ;

#########################STUDENT###############################

4 methods

# List all the Registered Exams by a student Id
DELIMITER //
CREATE PROCEDURE listRegisteredExamByStudentId(IN studentId INT)
BEGIN
    SELECT M.modulesid, M.modulesname, E.examsdate, E.examsfrom, E.examsto, E.deadline, E.examsid
    FROM Exams E JOIN Modules M ON (M.modulesid=E.modulesid)
    JOIN Registration R ON E.examsid = R.examsid
    WHERE R.studentid = studentId;
END //
DELIMITER ;

# List all the Signed Attendance by a student Id
DELIMITER //
CREATE PROCEDURE listSignedAttendanceByStudentId(IN studentId INT)
BEGIN
    SELECT M.modulesid, M.modulesname, Se.sessionsdate, Se.sessionsfrom, Se.sessionsto,
    Se.sessionsid
    FROM Sessions Se JOIN Modules M ON (M.modulesid=Se.modulesid)
    JOIN Attendance Att ON Se.sessionsid = Att.sessionsid
    WHERE Att.studentid = studentId;
END //
DELIMITER ;

# Delete Registration
DELIMITER //
CREATE PROCEDURE deleteRegistration(IN examsid INTEGER)
BEGIN
DELETE FROM Registration R
WHERE R.examsid = examsid;
END //
DELIMITER ;

# Delete Attendance
DELIMITER //
CREATE PROCEDURE deleteAttendance(IN sessionsid INTEGER)
BEGIN
DELETE FROM Attendance Att
WHERE Att.sessionsid = sessionsid;
END //
DELIMITER ;