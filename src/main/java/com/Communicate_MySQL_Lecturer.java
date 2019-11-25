package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

import java.sql.DriverManager;
import java.sql.Time;
import java.sql.Date;
import java.sql.Timestamp;

import org.json.JSONArray;

public class Communicate_MySQL_Lecturer {

    private static String jdbcUrl = "jdbc:mysql://localhost:3306/Web_Application_Team3";
    private static String username = "root";
    private static String password = "mynewpassword";

    // 2 Methods

    ///////////////////////////LIST AND VIEW////////////////////////////////////////////////////////////////////////////


    /**showListStudentByExamId
     * API between UI layer and Application layer, list all students who attended to the exam
     * @param examId specify which exam the lecturer wants to get the list of attended student
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray listParticipantByExam(int examId) {
        //The query for MySQL
        String query = "{ call listParticipantByExam(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {


            stmt.setInt(1, examId);
            rs = stmt.executeQuery();
            /*System.out.println(String.format("%s", "id | firstname | lastname " +
        	"| login | pass "));
			while (rs.next()) {
    		System.out.println(String.format("%s",
            	rs.getString("id") + " | "
                    + rs.getString("firstname") + " | "
                    + rs.getString("lastname") + " | "
                    + rs.getString("login") + " | "
                    + rs.getString("pass") + " | "
    		));
			}*/
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /** List all the students belong to a module
     * API between UI layer and Application layer, list all students who attended to the module
     * @param moduleId specify which exam the lecturer wants to get the list of attended student
     * @return a string of json package
     * @throws SQLException error in database
     */

    public static JSONArray listStudentByModuleId(int moduleId) {
        //The query for MySQL
        String query = "{ call listStudentByModuleId(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, moduleId);
            rs = stmt.executeQuery();
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println("Announce: "+output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /** List enrollment by moduleid*/
    /**showListEnrollmentByModuleId
     * API between UI layer and Application layer, list all the students who enrolled to the input module
     * @param moduleId specify which module need to be get the information
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray listEnrollmentByModuleId(int moduleId) {
        //The query for MySQL
        String query = "{ call listEnrollmentByModuleId(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, moduleId);
            rs = stmt.executeQuery();
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /** List registration by examsid*/
    /**showListRegistrationByExam
     * API between UI layer and Application layer, list all the students who registered to the input exam
     * @param examId specify which module need to be get the information
     * @return a string of json package
     */
    public static JSONArray listRegistrationByExam(int examId) {
        //The query for MySQL
        String query = "{ call listRegistrationByExam(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, examId);
            rs = stmt.executeQuery();
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}