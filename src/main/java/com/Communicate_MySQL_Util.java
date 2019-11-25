package com;

import org.json.JSONArray;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

import java.sql.DriverManager;
import java.sql.Time;
import java.sql.Date;
import java.sql.Timestamp;

public class Communicate_MySQL_Util {
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/Web_Application_Team3";
    private static String username = "root";
    private static String password = "020240";

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////CREATE ACCOUNT///////////////////////////////////////////



    //Create Module
    public static String createModule(String moduleName, int semesterId) throws SQLException{
        //The query for MySQL
        String query = "{ call createModule(?,?) }";
        //Variable for the result
        System.out.println(moduleName);
        System.out.println(semesterId);
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, moduleName);
            stmt.setInt(2, semesterId);

            rs = stmt.executeQuery();
            //JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Created successfully";
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }



    /** List exam by moduleid
     * /**showListExamByModuleId
     * API between UI layer and Application layer, list all the exams belong to the input module
     * @param moduleId specify which module need to be get the information
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray listExamByModuleId(int moduleId) {
        //The query for MySQL
        String query = "{ call listExamByModuleId(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, moduleId);// I don't understand this part??

            rs = stmt.executeQuery();
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /** List session by moduleid
     * /**showListSessionByModuleId
     * API between UI layer and Application layer, list all the exams belong to the input module
     * @param moduleId specify which module need to be get the information
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray listSessionByModuleId(int moduleId) {
        //The query for MySQL
        String query = "{ call listSessionByModuleId(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, moduleId);// I don't understand this part??

            rs = stmt.executeQuery();
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /** List attendance by sessionsid
     * showListAttendanceBySession
     * API between UI layer and Application layer, list all the attendance belong to a session
     * @param sessionsId specify which sessions need to get the information
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray listAttendanceBySession(int sessionsId) {
        //The query for MySQL
        String query = "{ call listAttendanceBySession(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, sessionsId);// I don't understand this part??

            rs = stmt.executeQuery();
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /** List all module
     * showListModule
     * API between UI layer and Application layer, list all the modules
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray listModule() {
        //The query for MySQL
        String query = "{ call listModule() }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
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
