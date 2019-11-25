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

public class Communicate_MySQL_Assistant {
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/Web_Application_Team3";
    private static String username = "root";
    private static String password = "mynewpassword";

    // 18 Methods

    /**
     * listAccountById
     * We input an account Id and the method will return a list of account according to id input
     *
     * @param accountId is used to list account
     * @return JSON Array, use to return account information
     */
    public static JSONArray listAccountById(int accountId) {
        //The query for MySQL
        String query = "{ call listAccountById(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, accountId);

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

    /**
     * listSessionsOverlap()
     * Method is used to return a list of sessions overlap with each other
     *
     * @return JSON Array, use to list all the sessions which overlap with each other
     */
    //No procedure yet
    public static JSONArray listSessionsOverlap() {
        //The query for MySQL
        String query = "{ call listSessionsOverlap() }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            rs = stmt.executeQuery();
            /*System.out.println(String.format("%s", "sessionsid | modulesid | sessionsdate " +
                    "| sessionsfrom | sessionsto | deadline"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getInt("sessionsid") + " | "
                                + rs.getInt("modulesid") + " | "
                                + rs.getDate("examsdate") + " | "
                                + rs.getTime("examsfrom") + " | "
                                + rs.getTime("examsto") + " | "
                                + rs.getTimestamp("deadline")));
            }*/
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * listSessionByModule
     *
     * @param moduleName is used to specify which module we want to get information of sessions it belong to
     * @return JSON Array, use to list the sessions which the input module belong to
     */
    public static JSONArray listSessionByModule(String moduleName) {
        //The query for MySQL
        String query = "{ call listSessionByModule(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setString(1, moduleName);

            rs = stmt.executeQuery();
            /*System.out.println(String.format("%s", "sessionsid | modulesid |" +
                    " sessionsdate " +
                    "| sessionsfrom | sessionsto |" +
                    "modulesname"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getInt("sessionsid") + " | "
                                + rs.getInt("modulesid") + " | "
                                + rs.getDate("sessionsdate") + " | "
                                + rs.getTime("sessionsfrom") + " | "
                                + rs.getTime("sessionsto") + " | "
                                + rs.getString("modulesname")));
            }
            rs.first();*/
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }


    /**
     * listSemester
     * This method is used to get the semester id according to the information we input
     *
     * @return JSON Array, a list of Semester which match with the input will be returned
     */
    public static JSONArray listSemester() {

        //The query for MySQL
        String query = "{ call listSemesterId() }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {


            rs = stmt.executeQuery();
            /*System.out.println(String.format("%s", "id | firstname | lastname " +
                    "| modulesname"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("studentid") + " | "
                                + rs.getString("firstname") + " | "
                                + rs.getString("lastname") + " | "
                                + rs.getString("modulesname") + " | "
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

    /**
     * listAllExamWithModule
     * This method is used to get the information all exams in all modules
     *
     * @return JSON Array, a list of exams in all modules will be returned
     */
    public static JSONArray listAllExamWithModule() {
        //The query for MySQL
        String query = "{ call listAllExamWithModule()}";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            rs = stmt.executeQuery();
            /*System.out.println(String.format("%s", "examsid | modulesid | " +
                    "modulesname | " +
                    "examsdate | " +
                    "examsfrom | " +
                    "examsto | " +
                    "deadline"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getInt("examsid") + " | "
                                + rs.getInt("modulesid") + " | "
                                + rs.getString("modulesname") + " | "
                                + rs.getDate("examsdate") + " | "
                                + rs.getTime("examsfrom") + " | "
                                + rs.getTime("examsto") + " | "
                                + rs.getTimestamp("deadline")));
            }*/
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /** List all the Lecturers */
    /**
     * listLecturer
     * The method is used to get the information of all lecturers
     *
     * @return JSON Array, a list of lecturers information will be return
     */
    public static JSONArray listLecturer() {
        //The query for MySQL
        String query = "{ call listLecturer() }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            //stmt.setInt(1, studentId);

            rs = stmt.executeQuery();
            /*
            System.out.println(String.format("%s", "id | firstname | lastname " +
                    "| studentid "));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("id") + " | "
                                + rs.getString("firstname") + " | "
                                + rs.getString("lastname") + " | "
                                + rs.getString("lecturerid") + " | "
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

    /** List all the Students */
    /**
     * listStudent
     * The method is used to get the information of all students
     *
     * @return JSON Array, a list of all students will be returned
     */
    public static JSONArray listStudent() {
        //The query for MySQL
        String query = "{ call listStudent() }";
        //Variable for the result
        ResultSet rs;

        try
                (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
                 CallableStatement stmt = conn.prepareCall(query)) {

            //stmt.setInt(1, studentId);

            rs = stmt.executeQuery();
            /*System.out.println(String.format("%s", "id | firstname | lastname " +
                    "| studentid "));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("id") + " | "
                                + rs.getString("firstname") + " | "
                                + rs.getString("lastname") + " | "
                                + rs.getString("studentid") + " | "
                ));
            }*/
            /*JsonArrayBuilder output = Json_Converter.convertWithoutType(rs);
            System.out.println(output.build());*/
            JSONArray output = JSON_converter.convertWithoutType(rs);
            System.out.println(output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
    /////////////////////////////////////CREATE/////////////////////////////////////////////////////////////////////////

    /**
     * assignLecturer
     * The method will assign a lecturer to a module according to the input
     *
     * @param lecturerID specify which lecturer need to be assigned
     * @param modID      specify the module the lecturer will teach
     * @return Do not return anything, the method just adds an instance into database
     */
    public static String assignLecturer(int lecturerID, int modID) {
        String query = "{ call assignLecturer(?,?)}";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, lecturerID);
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

    /**
     * createExam
     * Method is used to create new exam
     *
     * @param modId   specify the module id we want to create
     * @param day     specify the day of the exam we want to create
     * @param month   specify the month of the exam we want to create
     * @param year    specify the year of the exam  we want to create
     * @param hours   specify the hour of the exam begin we want to create
     * @param min     specify the minutes of the exam begin we want to create
     * @param sec     specify the second of the exam begin we want to create
     * @param hours1  specify the hour of the exam end we want to create
     * @param min1    specify the minutes of the exam end we want to create
     * @param sec1    specify the second of the exam end we want to create
     * @param Tyear   specify the year of exam deadline we want to create
     * @param Tmonth  specify the month of exam deadline we want to create
     * @param Tdate   specify the day of exam deadline we want to create
     * @param Thour   specify the hour of exam deadline we want to create
     * @param Tminute specify the minute of exam deadline we want to create
     * @param Tsecond specify the second of exam deadline we want to create
     * @return Do not return anything, because we only add new instance of exam into the database
     * @throws SQLException error in database
     */
    public static String createExam(int modId, int day, int month, int year, int hours, int min, int sec, int hours1, int min1, int sec1,
                                    int Tyear, int Tmonth, int Tdate,
                                    int Thour, int Tminute, int Tsecond) throws SQLException {
        String dateStr = Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day); //TODO TURN INPUT INTO A STRING WITH THE CORRECT STRUCTURE
        String timeFr = Integer.toString(hours) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
        String timeTo = Integer.toString(hours1) + ":" + Integer.toString(min1) + ":" + Integer.toString(sec1);
        String timeSt = Integer.toString(Tyear) + "-" + Integer.toString(Tmonth) + "-" + Integer.toString(Tdate) + " " +
                Integer.toString(Thour) + ":" + Integer.toString(Tminute) + ":" + Integer.toString(Tsecond);

        Date examDate = Date.valueOf(dateStr);
        Time examFrom = Time.valueOf(timeFr);
        Time examTo = Time.valueOf(timeTo);

        Timestamp deadline = Timestamp.valueOf(timeSt);

//The query for MySQL
        String query = "{ call createExam(?,?,?,?,?) }";
//Variable for the result

        ResultSet rs;

        Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
        CallableStatement stmt = conn.prepareCall(query);

        stmt.setInt(1, modId);
        stmt.setDate(2, examDate);
        stmt.setTime(3, examFrom);
        stmt.setTime(4, examTo);
        stmt.setTimestamp(5, deadline);

        rs = stmt.executeQuery();
//JSONArray output = JSON_converter.convertWithoutType(rs);
//System.out.println(output);
        return "Created successfully";
    }

    /**
     * createSession
     * Method is used to create a new Session with module id specify which module the session belong to and the time it begin and end
     *
     * @param modId  specify the module id we want to create
     * @param day    specify the session day
     * @param month  specify the session month
     * @param year   specify the session year
     * @param hours  specify the session begin hour of a session
     * @param min    specify the session begin minute of a session
     * @param sec    specify the session begin second of a session
     * @param hours1 specify the session end hour of a session
     * @param min1   specify the session end minute of a session
     * @param sec1   specify the session end second of a session
     * @return Do not return anything because we only add an instance into database
     */
    public static String createSession(int modId, int day, int month, int year,
                                       int hours, int min, int sec,
                                       int hours1, int min1, int sec1) {
        String dateStr = Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day); //TODO TURN INPUT INTO A STRING WITH THE CORRECT STRUCTURE
        String timeFr = Integer.toString(hours) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
        String timeTo = Integer.toString(hours1) + ":" + Integer.toString(min1) + ":" + Integer.toString(sec1);

        Date sesDate = Date.valueOf(dateStr);
        Time sesFrom = Time.valueOf(timeFr);
        Time sesTo = Time.valueOf(timeTo);
//The query for MySQL
        String query = "{ call createSessions(?,?,?,?) }";
//Variable for the result

        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, modId);
            stmt.setDate(2, sesDate);
            stmt.setTime(3, sesFrom);
            stmt.setTime(4, sesTo);

            rs = stmt.executeQuery();
//JSONArray output = JSON_converter.convertWithoutType(rs);
//System.out.println(output);
            return "Created successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**
     * createSemester
     * The methods require inputs of the beginning and end date of the semester to create a new semester
     *
     * @param dayFr   specify the beginning day of the semester
     * @param monthFr specify the beginning month of the semester
     * @param yearFr  specify the beginning year of the semester
     * @param dayTo   specify the end day of the semester
     * @param monthTo specify the end month of the semester
     * @param yearTo  specify the end year of the semester
     * @return Do not return anything, the method just adds an instance into database
     */
    public static String createSemester(int dayFr, int monthFr, int yearFr, int dayTo, int monthTo, int yearTo) {    //TODO have problem
        String dateFr = Integer.toString(yearFr) + "-" + Integer.toString(monthFr) + "-" + Integer.toString(dayFr); //TODO TURN INPUT INTO A STRING WITH THE CORRECT STRUCTURE
        String dateTo = Integer.toString(yearTo) + "-" + Integer.toString(monthTo) + "-" + Integer.toString(dayTo);
        Date sesFrom = Date.valueOf(dateFr);    //TODO AFTER HAVE THE CORRECT STRUCTURED STRING USE THIS METHOD TO SEND THE INPUT AS A CORRECT ARGUMENT TO MySQL
        Date sesTo = Date.valueOf(dateTo);

//The query for MySQL
        String query = "{ call createSemester(?,?) }";
//Variable for the result

        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setDate(1, sesFrom);
            stmt.setDate(2, sesTo);

            rs = stmt.executeQuery();
//JSONArray output = JSON_converter.convertWithoutType(rs);
//System.out.println(output);
            return "Created successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
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
    public static String createStudent(String login, String pass, String firstname, String lastname) throws SQLException {
        try {
            insertIntoAccount(login, pass, firstname, lastname);
            int temp;
            temp = listIdByLogin(login);
            insertIntoStudent(temp);
            return "Created successfully";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**
     * add lecturer account
     * @param login     receive login
     * @param pass  receive pass
     * @param firstname receive firstname
     * @param lastname  receive lastname
     * @return  Message
     * @throws SQLException
     */
    //Create Lecturer
    public static String createLecturer(String login, String pass, String firstname, String lastname) throws SQLException {
        try {
            insertIntoAccount(login, pass, firstname, lastname);
            int temp;
            temp = listIdByLogin(login);
            insertIntoLecturer(temp);
            return "Created successfully";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**
     * add account
     *
     * @param login     receive login
     * @param pass  receive pass
     * @param firstname receive firstname
     * @param lastname  receive lastname
     * @throws SQLException
     */
    public static void insertIntoAccount(String login, String pass, String firstname, String lastname) throws SQLException {
        String query = "{ call createAccount(?,?,?,?) }";

        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, login);
            stmt.setString(2, pass);
            stmt.setString(3, firstname);
            stmt.setString(4, lastname);

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     * list account id by login
     *
     * @param login  receive login string
     * @return
     * @throws SQLException
     */
    public static int listIdByLogin(String login) throws SQLException {
        String query = "{ call listIdByLogin(?) }";

        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, login);

            rs = stmt.executeQuery();
            int id = 0;

            while (rs.next()) {
                id = rs.getInt("id");
            }
            return id;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     * Add account to student table
     *
     * @param studentId  receive student id number
     * @throws SQLException
     */
    public static void insertIntoStudent(int studentId) throws SQLException {
        String query = "{ call createStudent(?) }";

        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, studentId);

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     * Add account to lecturer table
     *
     * @param lecturerId  receive lecturerid number
     * @throws SQLException
     */
    public static void insertIntoLecturer(int lecturerId) throws SQLException {
        String query = "{ call createLecturer(?) }";

        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, lecturerId);

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            throw ex;
        }
    }
/////////////////////////////////MODIFY/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * modifyAccount
     * The method allow assistant to modify an already exist account
     *
     * @param id    specify an account id we want to modify
     * @param login the account login name
     * @param pass  the account password
     * @param fname the account first name
     * @param lname the account last name
     * @return Do not return anything, the method just modifies an instance into database
     */
    public static String modifyAccount(int id, String login, String pass, String fname, String lname) {
        ResultSet rs;
        String query = "{ call modifyAccount(?,?,?,?,?) }";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, login);
            stmt.setString(3, pass);
            stmt.setString(4, fname);
            stmt.setString(5, lname);
            rs = stmt.executeQuery();
            //JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Modify successfully";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**
     * modifySemester
     * The method allow assistant to modify an already exist semester
     *
     * @param semesterid specify the semester id we want to modify
     * @param yearFr     specify the beginning year of the semester
     * @param monthFr    specify the beginning month of the semester
     * @param dateFr     specify the beginning day of the semester
     * @param yearTo     specify the end year of the semester
     * @param monthTo    specify the end month of the semester
     * @param dateTo     specify the end day of the semester
     * @return Do not return anything, the method just modifies an instance into database
     */
    public static String modifySemester(int semesterid, int yearFr, int monthFr, int dateFr, int yearTo, int monthTo, int dateTo) {
        String dateFrom = Integer.toString(yearFr) + "-" + Integer.toString(monthFr) + "-" + Integer.toString(dateFr);
        String dayTo = Integer.toString(yearTo) + "-" + Integer.toString(monthTo) + "-" + Integer.toString(dateTo);

        System.out.println(semesterid);

        Date semesterfrom = Date.valueOf(dateFrom);
        Date semesterto = Date.valueOf(dayTo);
        System.out.println(semesterfrom);
        System.out.println(semesterto);
        String query = "{ call modifySemester(?,?,?) }";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, semesterid);
            stmt.setDate(2, semesterfrom);
            stmt.setDate(3, semesterto);
            rs = stmt.executeQuery();
            //JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Modify successfully";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**
     * modifyModule
     * The method allow assistant to modify an already exist module
     *
     * @param modulesId   specify the module id we want to  modify
     * @param modulesName specify the module name
     * @param semesterid  specify the semester name
     * @return Do not return anything, the method just modifies an instance into database
     */
    public static String modifyModule(int modulesId, String modulesName, int semesterid) {
        String query = "{ call modifyModule(?,?,?) }";
        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, modulesId);
            stmt.setString(2, modulesName);
            stmt.setInt(3, semesterid);
            rs = stmt.executeQuery();
            //JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Modify successfully";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**
     * modifySession
     * The method allow assistant to modify an already exist Session
     *
     * @param sessionsId specify the which session id need to be modified
     * @param year       specify the year of the session
     * @param month      specify the month of the session
     * @param day        specify the day of the session
     * @param hours      specify the beginning hour of the session
     * @param min        specify the beginning minute of the session
     * @param sec        specify the beginning second of the session
     * @param hours1     specify the end hour of the session
     * @param min1       specify the end minute of the session
     * @param sec1       specify the end second of the session
     * @return Do not return anything, the method just modifies an instance into database
     */
    public static String modifySession(int sessionsId, int moduleId, int year, int month, int day,
                                       int hours, int min, int sec,
                                       int hours1, int min1, int sec1) {
        String dateStr = Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day); //TODO TURN INPUT INTO A STRING WITH THE CORRECT STRUCTURE
        String timeFr = Integer.toString(hours) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
        String timeTo = Integer.toString(hours1) + ":" + Integer.toString(min1) + ":" + Integer.toString(sec1);

        Date sesDate = Date.valueOf(dateStr);
        Time sesFrom = Time.valueOf(timeFr);
        Time sesTo = Time.valueOf(timeTo);

        String query = "{ call modifySession(?,?,?,?,?) }";
        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, sessionsId);
            stmt.setInt(2, moduleId);
            stmt.setDate(3, sesDate);
            stmt.setTime(4, sesFrom);
            stmt.setTime(5, sesTo);
            rs = stmt.executeQuery();
            //	JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Modify successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**
     * modifyExam
     * The method allow assistant to change the information of an exam
     *
     * @param examId  specify which exam we want to modify
     * @param year    specify the year that the exam takes place
     * @param month   specify the month that the exam takes place
     * @param day     specify the second that the exam takes place
     * @param hours   specify the beginning hour of the exam
     * @param min     specify the beginning minute of the exam
     * @param sec     specify the beginning second of the exam
     * @param hours1  specify the end hour of the exam
     * @param min1    specify the end minute of the exam
     * @param sec1    specify the end second of the exam
     * @param Tyear   specify the deadline (year) of the exams
     * @param Tmonth  specify the deadline (month) of the exams
     * @param Tdate   specify the deadline (day) of the exams
     * @param Thour   specify the deadline (hour) of the exams
     * @param Tminute specify the deadline (minuter) of the exams
     * @param Tsecond specify the deadline (second) of the exams
     * @return Do not return anything, the method just modifies an instance into database
     */
    public static String modifyExam(int examId, int day, int month, int year, int hours, int min, int sec, int hours1, int min1, int sec1,
                                    int Tyear, int Tmonth, int Tdate, int Thour, int Tminute, int Tsecond) throws SQLException {
        String dateStr = Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day); //TODO TURN INPUT INTO A STRING WITH THE CORRECT STRUCTURE
        String timeFr = Integer.toString(hours) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
        String timeTo = Integer.toString(hours1) + ":" + Integer.toString(min1) + ":" + Integer.toString(sec1);
        String timeSt = Integer.toString(Tyear) + "-" + Integer.toString(Tmonth) + "-" + Integer.toString(Tdate) + " " +
                Integer.toString(Thour) + ":" + Integer.toString(Tminute) + ":" + Integer.toString(Tsecond);

        Date examDate = Date.valueOf(dateStr);
        Time examFrom = Time.valueOf(timeFr);
        Time examTo = Time.valueOf(timeTo);
        Timestamp deadline = Timestamp.valueOf(timeSt);

        String query = "{ call modifyExam(?,?,?,?,?) }";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, examId);
            stmt.setDate(2, examDate);
            stmt.setTime(3, examFrom);
            stmt.setTime(4, examTo);
            stmt.setTimestamp(5, deadline);
            rs = stmt.executeQuery();
            return "Modify successfully";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

/////////////////////////////////////////DELETE/////////////////////////////////////////////////////////////////////

    /**
     * deleteAccount
     * The method allow assistant to delete an account
     *
     * @param id specify the account we want to delete
     * @return Do not return anything, the method just delete an instance in the database
     */
    public static String deleteAccount(int id) {
        String query = "{ call deleteAccount(?) }";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            return "Delete successfully";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**
     * deleteSemester
     * The method allow assistant to delete a semester
     *
     * @param semesterid specify the semester we want to delete
     * @return Do not return anything, the method just delete an instance in the database
     */
    public static String deleteSemester(int semesterid) {
        String query = "{ call deleteSemester(?) }";
        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, semesterid);
            rs = stmt.executeQuery();
            return "Delete successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**
     * deleteModule
     * The method allow assistant to delete a module
     *
     * @param modulesid specify the module we want to delete
     * @return Do not return anything, the method just delete an instance in the database
     */
    public static String deleteModule(int modulesid) {
        String query = "{ call deleteModule(?) }";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, modulesid);
            rs = stmt.executeQuery();
            return "Delete successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**
     * deleteSession
     * The method allow assistant to delete a session
     *
     * @param sessionsid specify the session we want to delete
     * @return Do not return anything, the method just delete an instance in the database
     */
    public static String deleteSession(int sessionsid) {
        String query = "{ call deleteSession(?) }";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, sessionsid);
            rs = stmt.executeQuery();
            //JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Delete successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

    /**
     * deleteExam
     * The method allow assistant to delete an exam
     *
     * @param examsid specify which session we want to delete
     * @return Do not return anything, the method just delete an instance in the database
     */
    public static String deleteExam(int examsid) {
        String query = "{ call deleteExam(?) }";
        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, examsid);
            rs = stmt.executeQuery();
            //JSONArray output = JSON_converter.convertWithoutType(rs);
            //System.out.println(output);
            return "Delete successfully";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error, please check: " + ex.getMessage();
        }
    }

///////////////////////////////GENERATE EXAM LIST/////////////////////////////////////

    /**
     * List attendance count by moduleid
     */
    public static JSONArray listStudentAttendanceCountByModuleId(int moduleId) {
//The query for MySQL
        String query = "{ call listStudentAttendanceCountByModuleId(?) }";
//Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, moduleId);// I don't understand this part??

            rs = stmt.executeQuery();
/*System.out.println(String.format("%s", "modulesid | modulesname | examsdate " +
"| examsfrom | examsto | deadline"));
while (rs.next()) {
System.out.println(String.format("%s",
rs.getString("modulesid") + " | "
+ rs.getString("modulesname") + " | "
+ rs.getString("examsdate") + " | "
+ rs.getString("examsfrom") + " | "
+ rs.getString("examsto") + " | "
+ rs.getString("deadline") + " | "
));
}*/
            JSONArray output = JSON_converter.convertWithoutType(rs);
//generate_Exam_List.generateAttendanceCountList(output);
            System.out.println("1:" + output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * List session count by moduleid
     */
    public static JSONArray listSessionCountByModuleId(int moduleId) {
//The query for MySQL
        String query = "{ call listSessionCountByModuleId(?) }";
//Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, moduleId);// I don't understand this part??

            rs = stmt.executeQuery();
/*System.out.println(String.format("%s", "modulesid | modulesname | examsdate " +
"| examsfrom | examsto | deadline"));
while (rs.next()) {
System.out.println(String.format("%s",
rs.getString("modulesid") + " | "
+ rs.getString("modulesname") + " | "
+ rs.getString("examsdate") + " | "
+ rs.getString("examsfrom") + " | "
+ rs.getString("examsto") + " | "
+ rs.getString("deadline") + " | "
));
}*/
            JSONArray output = JSON_converter.convertWithoutType(rs);
//generate_Exam_List.generateSessionCountList(output);
            System.out.println("2:" + output);
            return output;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
