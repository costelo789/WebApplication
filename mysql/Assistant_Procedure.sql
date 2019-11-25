# 17 Procedures

####################LIST AND VIEW #########################

# List account by a given ID
CREATE PROCEDURE listAccountById(IN accountId INTEGER)
BEGIN
SELECT A.id, A.firstname, A.lastname, A.login, A.pass
FROM  Accounts A
WHERE A.id = accountId
END //
DELIMITER ;

# List all the Assistant
DELIMITER //
CREATE PROCEDURE listAssistant()
BEGIN
    SELECT AA.id, AA.firstname, AA.lastname, A.assistantid
    FROM Assistant A JOIN Accounts AA ON (A.assistantid=AA.id);
END //
DELIMITER ;

# List all the Sessions belong to a given module
DELIMITER //
CREATE PROCEDURE listSessionByModule(IN moduleName VARCHAR(20))
BEGIN
    SELECT *
    FROM Sessions S JOIN Modules M ON (M.modulesid = S.modulesid)
    WHERE M.modulesname = moduleName;
END //
DELIMITER ;


#########################CREATE############################

# Create Exam
DELIMITER //
CREATE PROCEDURE createExam (   IN moduleId	 INTEGER,
                                IN examDate DATE,
                                IN examFrom TIME,
                                IN examTo   TIME,
                                IN deadLine TIMESTAMP)
BEGIN
    INSERT INTO Exams VALUES (last_insert_id(), moduleId, examDate, examFrom, examTo, deadLine);
END//

DELIMITER ;

# Create Sessions
DELIMITER //
CREATE PROCEDURE createSessions( IN moduleId	INTEGER, IN sessionsDate DATE, IN sessionsFrom TIME,
                   IN sessionsTo TIME)
BEGIN
    INSERT INTO Sessions(modulesid, sessionsdate, sessionsfrom, sessionsto) VALUES (moduleId, sessionsDate, sessionsFrom, sessionsTo);
END//
DELIMITER ;

# Create Semester
DELIMITER //
CREATE PROCEDURE createSemester(
    IN semesterFrom	DATE,
    IN semesterTo	DATE)
BEGIN
    INSERT INTO Semester(semesterfrom,semesterto) VALUES(semesterFrom, semesterTo);
END//
DELIMITER ;

# assignLecturer
DELIMITER //
CREATE PROCEDURE assignLecturer ( IN lecturerId INTEGER,
                                  IN moduleId INTEGER)
BEGIN
    INSERT INTO Teaching VALUES( lecturerId, moduleId);
END//
DELIMITER ;

###################MODIFY###########################

# Modify an account
DELIMITER //
CREATE PROCEDURE modifyAccount(
IN	aid       	INTEGER,
IN	alogin		VARCHAR(20),
IN	apass		VARCHAR(20),
IN	afirstname	VARCHAR(20),
IN	alastname	VARCHAR(20)
)
BEGIN
UPDATE Accounts
SET
login = alogin,
pass = apass,
firstname = afirstname,
lastname = alastname
WHERE id = aid;
END //
DELIMITER ;

# Modify a semester
DELIMITER //
CREATE PROCEDURE modifySemester(
IN	ssemesterid	INTEGER,
IN	ssemesterfrom	DATE,
IN	ssemesterto	DATE
)
BEGIN
UPDATE Semester
SET
semesterfrom = ssemesterfrom,
semesterto = ssemesterto
WHERE semesterid = ssemesterid;
END //
DELIMITER ;

# Modify a module
DELIMITER //
CREATE PROCEDURE modifyModule(
IN	mmodulesid	INTEGER,
IN	mmodulesname	VARCHAR(20)
)
BEGIN
UPDATE Modules
SET
modulesname = mmodulesname
WHERE modulesid = mmodulesid;
END //
DELIMITER ;

# Modify a session
DELIMITER //
CREATE PROCEDURE modifySession(
IN	ssessionsid	INTEGER,
IN	ssessionsdate	DATE,
IN	ssessionsfrom	TIME,
IN	ssessionsto	TIME
)
BEGIN
UPDATE Sessions
SET
sessionsdate = ssessionsdate,
sessionsfrom = ssessionsfrom,
sessionsto = ssessionsto
WHERE sessionsid = ssessionsid;
END //
DELIMITER ;

# Modify an exam
DELIMITER //
CREATE PROCEDURE modifyExam(
IN	eexamsid	INTEGER,
IN	eexamsdate	DATE,
IN	eexamsfrom	TIME,
IN	eexamsto	TIME,
IN	edeadline	TIMESTAMP
)
BEGIN
UPDATE Exams
SET
examsdate = eexamsdate,
examsfrom = eexamsfrom,
examsto = eexamsto,
deadline = edeadline
WHERE examsid = eexamsid;
END //
DELIMITER ;

########################DELETE###########################

# Delete an account
DELIMITER //
CREATE PROCEDURE deleteAccount(IN aid INTEGER)
BEGIN
DELETE FROM Accounts
WHERE id = aid;
END //
DELIMITER ;

# Delete a semester
DELIMITER //
CREATE PROCEDURE deleteSemester(IN ssemesterid INTEGER)
BEGIN
DELETE FROM Semester
WHERE semesterid = ssemesterid;
END //
DELIMITER ;

# Delete a module
DELIMITER //
CREATE PROCEDURE deleteModule(IN mmodulesid INTEGER)
BEGIN
DELETE FROM Modules
WHERE modulesid = mmodulesid;
END //
DELIMITER ;

# Delete a session
DELIMITER //
CREATE PROCEDURE deleteSession(IN ssessionsid INTEGER)
BEGIN
DELETE FROM Sessions
WHERE sessionsid = ssessionsid;
END //
DELIMITER ;

# Delete an exam
DELIMITER //
CREATE PROCEDURE deleteExam(IN eexamsid INTEGER)
BEGIN
DELETE FROM Exams
WHERE examsid = eexamsid;
END //
DELIMITER ;
