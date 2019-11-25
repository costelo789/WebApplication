package com;

import java.sql.SQLException;

import javax.ws.rs.QueryParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

@Path("student")
public class Website_Connector_Student {

	/**List attendance of a student
	 *List Student Attendance
     * API between UI layer and Application layer, list all the attendance of a student
     * @param studentId specify the which student need to get the information about all the exams he/she has already registered
     * @return a string of json package
     * @throws SQLException error in database
     */
    @Path("listStudentAttendance")	//Name the path same as the method calling SQL
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListStudentAttendance(@QueryParam("studentId") int studentId) throws SQLException {	//add another verb before the old name: show, create, change, delete. Only these verb for specific cases.
        //System.out.println(Communicate_MySQL_Student.listStudentByModuleId(studentId));
        return Communicate_MySQL_Student.listStudentAttendance(studentId).toString();
    }

    /** List all the exams belong to a given module*/
    /**showListExamByModuleName
     * API between UI layer and Application layer, list all the exams which are overlap
     * @return a string of json package
     */
    @Path("listOverlapExams")	//Name the path same as the method calling SQL
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListoverlapExams() throws SQLException {	//add another verb before the old name: show, create, change, delete. Only these verb for specific cases.
        //System.out.println(Communicate_MySQL_Student.listAllExamWithModule().toString());
        return Communicate_MySQL_Student.listOverlapExams().toString();
    }

    /** List all the exams belong to a given module*/
    /**showListExamByModuleName
     * API between UI layer and Application layer, list all the exams which are overlap
     * @return a string of json package
     */
    @Path("listExamByModuleName")	//Name the path same as the method calling SQL
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListExamByModuleName(@QueryParam("moduleName") String moduleName) throws SQLException {	//add another verb before the old name: show, create, change, delete. Only these verb for specific cases.
        //System.out.println(Communicate_MySQL_Student.listExamByModuleName(moduleName));
        return Communicate_MySQL_Student.listExamByModuleName(moduleName).toString();
    }

    /**showListExamOfAStudent
     * API between UI layer and Application layer, list all the exams belong to the a student
     * @param studentId specify the which student need to get the information about all the exams he/she has already registered
     * @return a string of json package
     * @throws SQLException error in database
     */
    @Path("listExamOfAStudent")	//Name the path same as the method calling SQL
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListExamOfAStudent(@QueryParam("studentId") int studentId) throws SQLException {	//add another verb before the old name: show, create, change, delete. Only these verb for specific cases.
        //System.out.println(Communicate_MySQL_Student.listExamOfAStudent(studentId));
        return Communicate_MySQL_Student.listExamOfAStudent(studentId).toString();
    }

    /**showViewRegisteredExamsByStudent
     * API between UI layer and Application layer, list all the exams belong to the a student
     * @param studentId specify the which student need to get the information about all the exams he/she has already registered
     * @return a string of json package
     * @throws SQLException error in database
     */
    //List registered exams of a student
    @Path("viewRegisteredExamsByStudent")	//Name the path same as the method calling SQL
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showViewRegisteredExamsByStudent(@QueryParam("studentId") int studentId) throws SQLException {	//add another verb before the old name: show, create, change, delete. Only these verb for specific cases.
        //System.out.println(Communicate_MySQL_Student.viewRegisteredExamsByStudent(studentId));
        return Communicate_MySQL_Student.viewRegisteredExamsByStudent(studentId).toString();
    }


    /////////////////////////////////////CREATE/////////////////////////////////////////////////////////////////////////
    /**createExamRegistration
     * API between UI layer and Application layer, allow a student registers to an exam
     * @param studentId specify which student wants to register
     * @param examID    specify which exam a student wants to register to
     * @return a string of json package
     * @throws SQLException error in database
     */
    @Path("examRegistration")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String createExamRegistration(@FormParam("studentId") int studentId,@FormParam("examId") int examID) throws SQLException {
    	System.out.println(studentId + " " + examID);
        //System.out.println(Communicate_MySQL_Student.examRegistration(studentId,examID));
        return Response_Client.responseClient(Communicate_MySQL_Student.examRegistration(studentId,examID)).toString();
    }

    /**createModuleEnroll
     * API between UI layer and Application layer, allow a student enrolls to a module
     * @param studentId specify which student wants to enroll
     * @param moduleId  specify which module a student wants to enroll to
     * @return a string of json package
     * @throws SQLException error in database
     */
    @Path("moduleEnroll")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String createModuleEnroll(@FormParam("studentId") int studentId,@FormParam("moduleId") int moduleId) throws SQLException {
        //System.out.println(Communicate_MySQL_Student.moduleEnroll(studentId,moduleId));
        return Response_Client.responseClient(Communicate_MySQL_Student.moduleEnroll(studentId,moduleId)).toString();
    }

    /**createSignAttendance
     * API between UI layer and Application layer, allow a student signs attendance
     * @param studentId specify which student wants to sign attendance
     * @param sessionId specify which session a student wants to sign
     * @return a string of json package
     * @throws SQLException error in database
     */
    @Path("signAttendance")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String createSignAttendance(@FormParam("studentId") int studentId,@FormParam("sessionId") int sessionId) throws SQLException {
        //System.out.println(Communicate_MySQL_Student.signAttendance(studentId,sessionId));
        return Response_Client.responseClient(Communicate_MySQL_Student.signAttendance(studentId,sessionId)).toString();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**List all the Registered Exams by a student Id*/
    /**showListRegisteredExamByStudentId
     * API between UI layer and Application layer, list all the registered exams of a student
     * @param studentId specify the which student need to get the information about all the exams he/she has already registered
     * @return a string of json package
     * @throws SQLException error in database
     */
    @Path("listRegisteredExamByStudentId")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListRegisteredExamByStudentId(@QueryParam("studentId") int studentId) throws SQLException {
        //System.out.println(studentId);
        return Communicate_MySQL_Student.listRegisteredExamByStudentId(studentId).toString();
    }

    /**List all the Attendance by a student Id*/
    /**showListSignedAttendanceByStudentId
     * API between UI layer and Application layer, list all the attendance which he/she has attended
     * @param studentId specify the which student need to get the information about all the exams he/she has already registered
     * @return a string of json package
     * @throws SQLException error in database
     */
    @Path("listSignedAttendanceByStudentId")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListSignedAttendanceByStudentId(@QueryParam("studentId") int studentId) throws SQLException {
        //System.out.println(studentId);
        return Communicate_MySQL_Student.listSignedAttendanceByStudentId(studentId).toString();
    }

    /**Delete exam registration*/
    /**deleteRegistration
     * API between UI layer and Application layer, delete an exam registration specify by a student
     * @param examsId 	specify which exam has to be un-registered
     * @param studentId specify which exam has to be un-registered
     * @return String of JSON package with information
     * @throws SQLException error in database
     */
    @Path("deleteRegistration")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showDeleteRegistration(@FormParam("examsId") int examsId, @FormParam("studentId") int studentId) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Student.deleteRegistration(examsId, studentId)).toString();
    }

    /**Delete Attendance*/
    /**deleteAttendance
     * API between UI layer and Application layer, a student un-signs attendance
     * @param sessionId specify which session need to be un-signed
     * @param studentId  specify of student
     * @return String of JSON package with information
     * @throws SQLException error in database
     */
    @Path("deleteAttendance")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showDeleteAttendance(@FormParam("sessionId") int sessionId, @FormParam("studentId") int studentId) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Student.deleteAttendance(sessionId, studentId)).toString();
    }
}
