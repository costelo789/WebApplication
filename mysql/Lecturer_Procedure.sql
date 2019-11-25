# 2 Procedures

####################LIST AND VIEW #########################

# List all the Lecturers
DELIMITER //
CREATE PROCEDURE listLecturer()
BEGIN
SELECT A.id, A.firstname, A.lastname, L.lecturerid
FROM Lecturer L JOIN Accounts A ON (L.lecturerid=A.id);
END //
DELIMITER ;

#List exam participants
DELIMITER //
CREATE PROCEDURE listParticipantByExam(IN examId INTEGER) #TODO check to make sure
BEGIN
    SELECT A.firstname, A.lastname, S.studentid
    FROM Accounts A JOIN Student S ON( A.id = S.studentid) JOIN Registration R ON (S.studentid = R.studentid ) JOIN Exams E ON ( E.examsid = R.examsid)
    WHERE E.examsid= examId;
END //
DELIMITER ;
