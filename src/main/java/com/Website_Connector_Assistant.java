package com;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;

@Path("assistant")
public class Website_Connector_Assistant {
    ////////////////////////////////////LIST////////////////////////////////////////////////////////////////////////////

	/**  listAccountById
     * We input an account Id and the method will return a list of account according to id input
     * @param accountId is used to list account
     * @return JSON Array, use to return account information
     */
    @Path("listAccountById")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListAccountById(@QueryParam("accountId") int accountId) throws SQLException {
        //System.out.println(Communicate_MySQL_Student.listStudentByModuleId(moduleId));
        return Communicate_MySQL_Assistant.listAccountById(accountId).toString();
    }

    /**listSessionByModule
     * @param moduleName is used to specify which module we want to get information of sessions it belong to
     * @return JSON Array, use to list the sessions which the input module belong to
     */
    @Path("listSessionByModule")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListSessionByModule(@QueryParam("moduleName") String moduleName) throws SQLException {
        //System.out.println(Communicate_MySQL_Student.listStudentByModuleId(moduleId));
        return Communicate_MySQL_Assistant.listSessionByModule(moduleName).toString();
    }

    ////////////////////////////////////CREATE//////////////////////////////////////////////////////////////////////////



    /**assignLecturer
     * The method will assign a lecturer to a module according to the input
     * @param lecturerID specify which lecturer need to be assigned
     * @param modID specify the module the lecturer will teach
     * @return Do not return anything, the method just adds an instance into database
     */
    @Path("assignLecturer")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showAssignLecturer(@FormParam("lecturerID") int lecturerID, @FormParam("modID") int modID) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.assignLecturer(lecturerID, modID)).toString();
    }


    ////////////////////////////////////MODIFY//////////////////////////////////////////////////////////////////////////




    ////////////////////////////////////DELETE//////////////////////////////////////////////////////////////////////////



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** List all the Lecturers */
    /**listLecturer
     * The method is used to get the information of all lecturers
     * @return JSON Array, a list of lecturers information will be return
     */
    @Path("listLecturer")	//Name the path same as the method calling SQL
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListLecturer() throws SQLException {	//add another verb before the old name: show, create, change, delete. Only these verb for specific cases.
        return Communicate_MySQL_Assistant.listLecturer().toString();
    }

    /** List all the Students */
    /**listStudent
     * The method is used to get the information of all students
     * @return JSON Array, a list of all students will be returned
     */
    @Path("listStudent")	//Name the path same as the method calling SQL
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListStudent() throws SQLException {	//add another verb before the old name: show, create, change, delete. Only these verb for specific cases.
        //return "HI";
    	/*JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
    	JsonObject entry = Json.createObjectBuilder().add("surname", "Nguyen").build();
    	arrayBuilder.add(entry)

    	return Response.ok().entity(Communicate_MySQL_Student.listStudent().build().toString()).build();*/
        return Communicate_MySQL_Assistant.listStudent().toString();
    }

    /**createSemester
     * The methods require inputs of the beginning and end date of the semester to create a new semester
     * @param dayFr  specify the beginning day of the semester
     * @param monthFr specify the beginning month of the semester
     * @param yearFr  specify the beginning year of the semester
     * @param dayTo   specify the end day of the semester
     * @param monthTo specify the end month of the semester
     * @param yearTo  specify the end year of the semester
     * @return Do not return anything, the method just adds an instance into database
     */
    @Path("createSemester")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showCreateSemester(@FormParam("dayFr") int dayFr, @FormParam("monthFr") int monthFr, @FormParam("yearFr") int yearFr,
                                     @FormParam("dayTo") int dayTo, @FormParam("monthTo") int monthTo, @FormParam("yearTo") int yearTo) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.createSemester(dayFr, monthFr, yearFr, dayTo, monthTo, yearTo)).toString();
    }

    /**createSession
     * Method is used to create a new Session with module id specify which module the session belong to and the time it begin and end
     * @param modId specify the module id we want to create
     * @param day   specify the session day
     * @param month specify the session month
     * @param year  specify the session year
     * @param hours specify the session begin hour of a session
     * @param min   specify the session begin minute of a session
     * @param sec   specify the session begin second of a session
     * @param hours1    specify the session end hour of a session
     * @param min1  specify the session end minute of a session
     * @param sec1  specify the session end second of a session
     * @return Do not return anything because we only add an instance into database
     */
    @Path("createSession")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showCreateSession(@FormParam("modId") int modId, @FormParam("day") int day, @FormParam("month") int month,
                                    @FormParam("year") int year, @FormParam("hourFr") int hours, @FormParam("minFr") int min, @FormParam("secFr") int sec,
                                    @FormParam("hourTo") int hours1, @FormParam("minTo") int min1, @FormParam("secTo") int sec1) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.createSession(modId, day, month, year, hours, min, sec, hours1, min1, sec1)).toString();
    }

    /**createExam
     * Method is used to create new exam
     * @param modId specify the module id we want to create
     * @param day   specify the day of the exam we want to create
     * @param month specify the month of the exam we want to create
     * @param year  specify the year of the exam  we want to create
     * @param hours specify the hour of the exam begin we want to create
     * @param min   specify the minutes of the exam begin we want to create
     * @param sec   specify the second of the exam begin we want to create
     * @param hours1 specify the hour of the exam end we want to create
     * @param min1  specify the minutes of the exam end we want to create
     * @param sec1  specify the second of the exam end we want to create
     * @param Tyear specify the year of exam deadline we want to create
     * @param Tmonth    specify the month of exam deadline we want to create
     * @param Tdate specify the day of exam deadline we want to create
     * @param Thour specify the hour of exam deadline we want to create
     * @param Tminute specify the minute of exam deadline we want to create
     * @param Tsecond specify the second of exam deadline we want to create
     * @return Do not return anything, because we only add new instance of exam into the database
     * @throws SQLException error in database
     */
    @Path("createExam")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showCreateExam(@FormParam("modId") int modId,   @FormParam("day") int day, @FormParam("month") int month,
                                 @FormParam("year") int year,     @FormParam("hourFr") int hours, @FormParam("minFr") int min, @FormParam("secFr") int sec,
                                 @FormParam("hourTo") int hours1, @FormParam("minTo") int min1, @FormParam("secTo") int sec1, @FormParam("Tyear") int Tyear,
                                 @FormParam("Tmonth") int Tmonth, @FormParam("Tdate") int Tdate, @FormParam("Thour") int Thour,
                                 @FormParam("Tmin") int Tminute,  @FormParam("Tsec") int Tsecond) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.createExam(modId, day, month, year, hours, min, sec, hours1, min1, sec1,
                Tyear, Tmonth, Tdate, Thour, Tminute, Tsecond)).toString();
    }

    /**
     * add student account
     * @param login  receive login
     * @param pass receive pass
     * @param firstname receive firstname
     * @param lastname receive lastname
     * @return  Message
     * @throws SQLException
     */
    //Create Student
    @Path("createStudent")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String showCreateStudent(@FormParam("login") String login, @FormParam("pass") String pass, @FormParam("firstname") String firstname, @FormParam("lastname") String lastname) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.createStudent(login, pass, firstname, lastname)).toString();
    }    //Create Lecturer

    /**
     * add lecturer account
     * @param login     receive login
     * @param pass  receive pass
     * @param firstname receive firstname
     * @param lastname  receive lastname
     * @return  Message
     * @throws SQLException
     */
    @Path("createLecturer")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String showCreateLecturer(@FormParam("login") String login, @FormParam("pass") String pass, @FormParam("firstname") String firstname, @FormParam("lastname") String lastname) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.createLecturer(login, pass, firstname, lastname)).toString();
    }

    /**modifyAccount
     * The method allow assistant to modify an already exist account
     * @param id specify an account id we want to modify
     * @param login the account login name
     * @param pass  the account password
     * @param fname the account first name
     * @param lname the account last name
     * @return Do not return anything, the method just modifies an instance into database
     */
    @Path("modifyAccount")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showModifyAccount(@FormParam("accountId") int id, @FormParam("login") String login,
                                    @FormParam("pass") String pass, @FormParam("fname") String fname, @FormParam("lname") String lname) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.modifyAccount(id, login, pass, fname, lname)).toString();
    }

    /**modifySemester
     * The method allow assistant to modify an already exist semester
     * @param semesterid specify the semester id we want to modify
     * @param yearfrom    specify the beginning year of the semester
     * @param monthfrom   specify the beginning month of the semester
     * @param datefrom    specify the beginning day of the semester
     * @param yearto      specify the end year of the semester
     * @param monthto     specify the end month of the semester
     * @param dateto      specify the end day of the semester
     * @return Do not return anything, the method just modifies an instance into database
     */
    @Path("modifySemester")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showModifySemester(@FormParam("semesterId") int semesterid, @FormParam("yearFr") int yearfrom,
                                     @FormParam("monthFr") int monthfrom, @FormParam("dateFr") int datefrom, @FormParam("yearTo") int yearto,
                                     @FormParam("monthTo") int monthto, @FormParam("dateTo") int dateto) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.modifySemester(semesterid, yearfrom, monthfrom, datefrom, yearto, monthto, dateto)).toString();
    }


    /**modifyModule
	 *  The method allow assistant to modify an already exist module
	 * @param moduleid specify the module id we want to  modify
	 * @param modulename specify the module name
	 * @param semesterid specify the semester name
	 * @return Do not return anything, the method just modifies an instance into database
	 */
    @Path("modifyModule")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showModifyModule(@FormParam("moduleId") int moduleid, @FormParam("moduleName") String modulename,@FormParam("semesterid") int semesterid) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.modifyModule(moduleid, modulename, semesterid)).toString();
    }

    /**modifySession
     * The method allow assistant to modify an already exist Session
     * @param sessionsid specify the which session id need to be modified
     * @param yeardate  specify the year of the session
     * @param monthdate specify the month of the session
     * @param datedate  specify the day of the session
     * @param hourfrom  specify the beginning hour of the session
     * @param minutefrom specify the beginning minute of the session
     * @param secondfrom  specify the beginning second of the session
     * @param hourto   specify the end hour of the session
     * @param minuteto  specify the end minute of the session
     * @param secondto  specify the end second of the session
     * @return Do not return anything, the method just modifies an instance into database
     */
    @Path("modifySession")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showModifySession(@FormParam("sessionId") int sessionsid, @FormParam("moduleId") int moduleid,@FormParam("year") int yeardate,
                                    @FormParam("month") int monthdate, @FormParam("day") int datedate, @FormParam("hourFr") int hourfrom,
                                    @FormParam("minFr") int minutefrom, @FormParam("secFr") int secondfrom, @FormParam("hourTo") int hourto,
                                    @FormParam("minTo") int minuteto, @FormParam("secTo") int secondto) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.modifySession(sessionsid, moduleid, yeardate, monthdate, datedate, hourfrom, minutefrom,
                secondfrom, hourto, minuteto, secondto)).toString();
    }

    /**modifyExam
     * The method allow assistant to change the information of an exam
     * @param examId specify which exam we want to modify
     * @param year specify the year that the exam takes place
     * @param month specify the month that the exam takes place
     * @param day specify the second that the exam takes place
     * @param hours specify the beginning hour of the exam
     * @param min specify the beginning minute of the exam
     * @param sec specify the beginning second of the exam
     * @param hours1    specify the end hour of the exam
     * @param min1  specify the end minute of the exam
     * @param sec1  specify the end second of the exam
     * @param Tyear  specify the deadline (year) of the exams
     * @param Tmonth specify the deadline (month) of the exams
     * @param Tdate  specify the deadline (day) of the exams
     * @param Thour  specify the deadline (hour) of the exams
     * @param Tminute specify the deadline (minuter) of the exams
     * @param Tsecond specify the deadline (second) of the exams
     * @return Do not return anything, the method just modifies an instance into database
     */
    @Path("modifyExam")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showModifyExam(@FormParam("examId") int examId,   @FormParam("day") int day, @FormParam("month") int month,
                                 @FormParam("year") int year,     @FormParam("hourFr") int hours, @FormParam("minFr") int min, @FormParam("secFr") int sec,
                                 @FormParam("hourTo") int hours1, @FormParam("minTo") int min1, @FormParam("secTo") int sec1, @FormParam("Tyear") int Tyear,
                                 @FormParam("Tmonth") int Tmonth, @FormParam("Tday") int Tdate, @FormParam("Thour") int Thour,
                                 @FormParam("Tmin") int Tminute,  @FormParam("Tsec") int Tsecond) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.modifyExam(examId, day, month, year, hours, min, sec, hours1, min1, sec1,
                Tyear, Tmonth, Tdate, Thour, Tminute, Tsecond)).toString();
    }

    /**deleteAccount
     *The method allow assistant to delete an account
     * @param id specify the account we want to delete
     * @return Do not return anything, the method just delete an instance in the database
     */
    @Path("deleteAccount")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showDeleteAccount(@FormParam("id") int id) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.deleteAccount(id)).toString();
    }

    /**deleteSemester
     * The method allow assistant to delete a semester
     * @param semesterid specify the semester we want to delete
     * @return Do not return anything, the method just delete an instance in the database
     */
    @Path("deleteSemester")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showDeleteSemester(@FormParam("semesterid") int semesterid) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.deleteSemester(semesterid)).toString();
    }

    /**deleteModule
     * The method allow assistant to delete a module
     * @param modulesid specify the module we want to delete
     * @return Do not return anything, the method just delete an instance in the database
     */
    @Path("deleteModule")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showDeleteModule(@FormParam("modulesid") int modulesid) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.deleteModule(modulesid)).toString();
    }

    /**deleteSession
     * The method allow assistant to delete a session
     * @param sessionsid specify the session we want to delete
     * @return Do not return anything, the method just delete an instance in the database
     */
    @Path("deleteSession")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showDeleteSession(@FormParam("sessionsid") int sessionsid) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.deleteSession(sessionsid)).toString();
    }

    /**deleteExam
     * The method allow assistant to delete an exam
     * @param examsid specify which session we want to delete
     * @return Do not return anything, the method just delete an instance in the database
     */
    @Path("deleteExam")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showDeleteExam(@FormParam("examsid") int examsid) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Assistant.deleteExam(examsid)).toString();
    }


    /**listAllExamWithModule
     * This method is used to get the information all exams in all modules
     * @return JSON Array, a list of exams in all modules will be returned
     */
    @Path("listAllExamWithModule")	//Name the path same as the method calling SQL
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListAllExamWithModule() throws SQLException {	//add another verb before the old name: show, create, change, delete. Only these verb for specific cases.
        //System.out.println(Communicate_MySQL_Student.listAllExamWithModule().toString());
        return Communicate_MySQL_Assistant.listAllExamWithModule().toString();
    }

    /**listSemester
     * This method is used to get the semester id according to the information we input
     * @return JSON Array, a list of Semester which match with the input will be returned
     */
    @Path("listSemester")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListSemester() throws SQLException {
        return Communicate_MySQL_Assistant.listSemester().toString();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Automatic generate the official exam list
     *
     * @param moduleId pass module id number
     * @return  JSON package string of list of students who are allowed to take the exam
     * @throws SQLException
     */
    //Generate exam list
    @Path("generate_Exam_List")    //Name the path same as the method calling SQL
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showGenerate_Exam_List(@QueryParam("moduleId") int moduleId) throws SQLException {    //add another verb before the old name: show, create, change, delete. Only these verb for specific cases.
        generate_Exam_List.generateAttendanceCountList(Communicate_MySQL_Assistant.listStudentAttendanceCountByModuleId(moduleId));
        generate_Exam_List.generateSessionCountList( Communicate_MySQL_Assistant.listSessionCountByModuleId(moduleId));
        return generate_Exam_List.verifyExamList().toString();
    }



}
