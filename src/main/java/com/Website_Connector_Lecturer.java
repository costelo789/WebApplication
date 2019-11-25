package com;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;

/**
 * Website connector for student methods
 */
@Path("lecturer")
public class Website_Connector_Lecturer {

	/**showListStudentByExamId
     * API between UI layer and Application layer, list all students who attended to the exam
     * @param examId specify which exam the lecturer wants to get the list of attended student
     * @return a string of json package
     * @throws SQLException error in database
     */
    @Path("listParticipantByExam")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListStudentByModuleIdOld(@QueryParam("examId") int examId) throws SQLException {
        //System.out.println(Communicate_MySQL_Student.listStudentByModuleId(moduleId));
        return Communicate_MySQL_Lecturer.listParticipantByExam(examId).toString();
    }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** List all the students belong to a module
     * API between UI layer and Application layer, list all students who attended to the module
     * @param moduleId specify which exam the lecturer wants to get the list of attended student
     * @return a string of json package
     * @throws SQLException error in database
     */
    @Path("listStudentByModuleId")	//Name the path same as the method calling SQL
    @GET
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String showListStudentByModuleId(@QueryParam("moduleId") int moduleId) throws SQLException {	//add another verb before the old name: show, create, change, delete. Only these verb for specific cases.
    	//int moduleId = output.getModuleId();
    	//System.out.println(Communicate_MySQL_Student.listStudentByModuleId(moduleId));
        return Communicate_MySQL_Lecturer.listStudentByModuleId(moduleId).toString();
    }

    /** List enrollment by moduleid*/
    /**showListEnrollmentByModuleId
     * API between UI layer and Application layer, list all the students who enrolled to the input module
     * @param moduleId specify which module need to be get the information
     * @return a string of json package
     * @throws SQLException error in database
     */
    @Path("listEnrollmentByModuleId")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListEnrollmentByModuleId(@QueryParam("moduleId") int moduleId) throws SQLException {
        System.out.println(moduleId);
        return Communicate_MySQL_Lecturer.listEnrollmentByModuleId(moduleId).toString();
    }

    /** List registration by examsid*/
    /**showListRegistrationByExam
     * API between UI layer and Application layer, list all the students who registered to the input exam
     * @param examId specify which module need to be get the information
     * @return a string of json package
     */
    @Path("listRegistrationByExam")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListRegistrationByExam(@QueryParam("examId") int examId) throws SQLException {
        return Communicate_MySQL_Lecturer.listRegistrationByExam(examId).toString();
    }
}
