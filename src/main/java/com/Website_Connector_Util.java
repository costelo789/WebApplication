package com;

import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("util")
public class Website_Connector_Util {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /** List exam by moduleid
     * /**showListExamByModuleId
     * API between UI layer and Application layer, list all the exams belong to the input module
     * @param moduleName specify which module need to be get the information
     * @return a string of json package
     * @throws SQLException error in database
     */
    @Path("createModule")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String showCreateModule(@FormParam("moduleName") String moduleName, @FormParam("semesterId") int semesterId) throws SQLException {
        return Response_Client.responseClient(Communicate_MySQL_Util.createModule(moduleName, semesterId)).toString();
    }

    /** List exam by moduleid
     * /**showListExamByModuleId
     * API between UI layer and Application layer, list all the exams belong to the input module
     * @param moduleId specify which module need to be get the information
     * @return a string of json package
     * @throws SQLException error in database
     */
  //List exam by moduleid
    @Path("listExamByModuleId")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListExamByModuleId(@QueryParam("moduleId") int moduleId) throws SQLException {
        System.out.println(moduleId);
        return Communicate_MySQL_Util.listExamByModuleId(moduleId).toString();
    }

    /** List session by moduleid
     * /**showListSessionByModuleId
     * API between UI layer and Application layer, list all the exams belong to the input module
     * @param moduleId specify which module need to be get the information
     * @return a string of json package
     * @throws SQLException error in database
     */
    //List session by module id
    @Path("listSessionByModuleId")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListSessionByModuleId(@QueryParam("moduleId") int moduleId) throws SQLException {
        return Communicate_MySQL_Util.listSessionByModuleId(moduleId).toString();
    }

    /** List attendance by sessionsid
     * showListAttendanceBySession
     * API between UI layer and Application layer, list all the attendance belong to a session
     * @param sessionId specify which sessions need to get the information
     * @return a string of json package
     * @throws SQLException error in database
     */
  //List attendance by sessionid
    @Path("listAttendanceBySession")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListAttendanceBySession(@QueryParam("sessionId") int sessionId) throws SQLException {
        return Communicate_MySQL_Util.listAttendanceBySession(sessionId).toString();
    }

    /** List all module
     * showListModule
     * API between UI layer and Application layer, list all the modules
     * @return a string of json package
     * @throws SQLException error in database
     */
  //List all module
    @Path("listModule")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showListModule() throws SQLException {
        return Communicate_MySQL_Util.listModule().toString();
    }

}