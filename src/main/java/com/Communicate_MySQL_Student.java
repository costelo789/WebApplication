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

public class Communicate_MySQL_Student {

    private static String jdbcUrl = "jdbc:mysql://localhost:3306/Web_Application_Team3";
    private static String username = "root";
    private static String password = "mynewpassword";

    /**List Student Attendance
     * API between UI layer and Application layer, list all the attendance of a student
     * @param studentId specify the which student need to get the information about all the exams he/she has already registered
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray listStudentAttendance(int studentId) {
        //The query for MySQL
        String query = "{ call listStudentAttendance(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, studentId);
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

    /**showViewRegisteredExamsByStudent
     * API between UI layer and Application layer, list all the exams belong to the a student
     * @param studentId specify the which student need to get the information about all the exams he/she has already registered
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray viewRegisteredExamsByStudent(int studentId) {
        //The query for MySQL
        String query = "{ call viewRegisteredExamsByStudent(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, studentId);
            rs = stmt.executeQuery();
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    /** List all the exams belong to a given module*/
    /**showListExamByModuleName
     * API between UI layer and Application layer, list all the exams which are overlap
     * @return a string of json package
     */
    public static JSONArray listOverlapExams() {
        //The query for MySQL
        String query = "{ call listOverlapExams() }";
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

    /** List all the exams belong to a given module*/
    /**showListExamByModuleName
     * API between UI layer and Application layer, list all the exams belong to the input module name
     * @param moduleName specify the which module need to get the information about all the exams belong to it
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray listExamByModuleName( String moduleName) {
        //The query for MySQL
        String query = "{ call listExamByModuleName(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setString(1, moduleName);// I don't understand this part??

            rs = stmt.executeQuery();
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**showListExamOfAStudent
     * API between UI layer and Application layer, list all the exams belong to the a student
     * @param studentId specify the which student need to get the information about all the exams he/she has already registered
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray listExamOfAStudent(int studentId) {
        //The query for MySQL
        String query = "{ call listExamOfAStudent(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentId);

            rs = stmt.executeQuery();
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////CREATE/////////////////////////////////////////////////////////////////////////

    /**createExamRegistration
     * API between UI layer and Application layer, allow a student registers to an exam
     * @param studentID specify which student wants to register
     * @param examID    specify which exam a student wants to register to
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static String examRegistration(int studentID, int examID){
        String query = "{ call examRegistration(?,?)}";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentID);
            stmt.setInt(2, examID);

            rs = stmt.executeQuery();
            //JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Created successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**createModuleEnroll
     * API between UI layer and Application layer, allow a student enrolls to a module
     * @param studentID specify which student wants to enroll
     * @param modID  specify which module a student wants to enroll to
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static String moduleEnroll(int studentID, int modID){
        String query = "{ call moduleEnroll(?,?)}";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentID);
            stmt.setInt(2, modID);

            rs = stmt.executeQuery();
            //JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Created successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**createSignAttendance
     * API between UI layer and Application layer, allow a student signs attendance
     * @param studentID specify which student wants to sign attendance
     * @param sesID specify which session a student wants to sign
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static String signAttendance(int studentID, int sesID) {
        String query = "{ call signAttendance(?,?)}";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentID);
            stmt.setInt(2, sesID);

            rs = stmt.executeQuery();
            //JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Created successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**List all the Registered Exams by a student Id*/
    /**showListRegisteredExamByStudentId
     * API between UI layer and Application layer, list all the registered exams of a student
     * @param studentId specify the which student need to get the information about all the exams he/she has already registered
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray listRegisteredExamByStudentId(int studentId) {
        //The query for MySQL
        String query = "{ call listRegisteredExamByStudentId(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentId);// I don't understand this part??
            rs = stmt.executeQuery();
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**List all the Attendance by a student Id*/
    /**showListSignedAttendanceByStudentId
     * API between UI layer and Application layer, list all the attendance which he/she has attended
     * @param studentId specify the which student need to get the information about all the exams he/she has already registered
     * @return a string of json package
     * @throws SQLException error in database
     */
    public static JSONArray listSignedAttendanceByStudentId(int studentId) {
        //The query for MySQL
        String query = "{ call listSignedAttendanceByStudentId(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentId);// I don't understand this part??

            rs = stmt.executeQuery();
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**Delete exam registration*/
    /**deleteRegistration
     * API between UI layer and Application layer, delete an exam registration specify by a student
     * @param examsid 	specify which exam has to be un-registered
     * @param studentid specify which exam has to be un-registered
     * @return String of JSON package with information
     * @throws SQLException error in database
     */
    public static String deleteRegistration(int examsid, int studentid) {
        String query = "{ call deleteRegistration(?,?) }";
        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, examsid);
            stmt.setInt(2, studentid);
            System.out.println(examsid +" "+studentid);
            rs = stmt.executeQuery();
            //JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Delete successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**Delete Attendance*/
    /**deleteAttendance
     * API between UI layer and Application layer, a student un-signs attendance
     * @param sessionsid specify which session need to be un-signed
     * @param studentid  specify of student
     * @return String of JSON package with information
     * @throws SQLException error in database
     */
    public static String deleteAttendance(int sessionsid, int studentid) {
        String query = "{ call deleteAttendance(?,?) }";
        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, sessionsid);
            stmt.setInt(2, studentid);
            rs = stmt.executeQuery();
            //JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Delete successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

}
