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

public class Communicate_MySQL {

    private static String jdbcUrl = "jdbc:mysql://localhost:3306/Web_Application_Team3";
    private static String username = "root";
    private static String password = "mynewpassword";




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Phat
    /** List all the Students */
    public static void listStudent() {
        //The query for MySQL
        String query = "{ call listStudent() }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            //stmt.setInt(1, studentId);

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "id | firstname | lastname " +
                    "| studentid "));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("id") + " | "
                                + rs.getString("firstname") + " | "
                                + rs.getString("lastname") + " | "
                                + rs.getString("studentid") + " | "
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /** List all the Assistant */
    public static void listAssistant() {
        //The query for MySQL
        String query = "{ call listAssistant() }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            //stmt.setInt(1, studentId);

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "id | firstname | lastname " +
                    "| assistantid "));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("id") + " | "
                                + rs.getString("firstname") + " | "
                                + rs.getString("lastname") + " | "
                                + rs.getString("assistantid") + " | "
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /** List all the Lecturers */
    public static void listLecturer() {
        //The query for MySQL
        String query = "{ call listLecturer() }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            //stmt.setInt(1, studentId);

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "id | firstname | lastname " +
                    "| studentid "));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("id") + " | "
                                + rs.getString("firstname") + " | "
                                + rs.getString("lastname") + " | "
                                + rs.getString("lecturerid") + " | "
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /** List account by given ID
     */
    public static void listAccountById(int accountId) {
        //The query for MySQL
        String query = "{ call listAccountById(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, accountId);// I don't understand this part??

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "id | firstname | lastname " +
                    "| login | pass "));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("id") + " | "
                                + rs.getString("firstname") + " | "
                                + rs.getString("lastname") + " | "
                                + rs.getString("login") + " | "
                                + rs.getString("pass") + " | "
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /** List all the students belong to a module*/

    public static void listStudentByModuleId(int moduleId) {
        //The query for MySQL
        String query = "{ call listStudentByModuleId(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, moduleId);// I don't understand this part??

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "id | firstname | lastname " +
                    "| modulesname"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("studentid") + " | "
                                + rs.getString("firstname") + " | "
                                + rs.getString("lastname") + " | "
                                + rs.getString("modulesname") + " | "
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /** List all the exams belong to a given semester*/

    public static void listExamBySemester(int semesterId) {
        //The query for MySQL
        String query = "{ call listExamBySemester(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, semesterId);// I don't understand this part??

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "semesterid | modulesname | examsdate " +
                    "| examsfrom | examsto | deadline"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("semesterid") + " | "
                                + rs.getString("modulesname") + " | "
                                + rs.getString("examsdate") + " | "
                                + rs.getString("examsfrom") + " | "
                                + rs.getString("examsto") + " | "
                                + rs.getString("deadline") + " | "
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /** List all the exams belong to a given module*/

    public static void listExamByModuleName( String moduleName) {
        //The query for MySQL
        String query = "{ call listExamByModuleName(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setString(1, moduleName);// I don't understand this part??

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "modulesid | modulesname | examsdate " +
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
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    /** List all the exams of a given students which they have registered*/

    public static void listExamByStudent(int studentId) {
        //The query for MySQL
        String query = "{ call listExamByStudent(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentId);// I don't understand this part??

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "studentid | firstname | lastname " +
                    "| examsid "));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("studentid") + " | "
                                + rs.getString("firstname") + " | "
                                + rs.getString("lastname") + " | "
                                + rs.getString("examsid") + " | "
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Minh
    /**
     * List exam of a student given studentid
     *
     * @param studentId
     */
    public static void listExamOfAStudent(int studentId) {
        //The query for MySQL
        String query = "{ call listExamOfAStudent(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentId);

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "examsid | modulesid | examsdate " +
                    "| examsfrom | examsto | deadline"));
            while (rs.next()) {
                Date examsdate = rs.getDate("examsdate");
                Time examsfrom = rs.getTime("examsfrom");
                Time examsto = rs.getTime("examsto");
                Timestamp deadline = rs.getTimestamp("deadline");

                /* Compare time and date
                if (examsfrom.getTime() < examsto.getTime()){
                    System.out.println("Yes");
                }
                */


                System.out.println(String.format("%s",
                        rs.getInt("examsid") + " | "
                                + rs.getInt("modulesid") + " | "
                                + examsdate + " | "
                                + examsfrom + " | "
                                + examsto + " | "
                                + deadline));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void listSessionsOverlap() {
        //The query for MySQL
        String query = "{ call listSessionsOverlap() }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "sessionsid | modulesid | sessionsdate " +
                    "| sessionsfrom | sessionsto | deadline"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getInt("sessionsid") + " | "
                                + rs.getInt("modulesid") + " | "
                                + rs.getDate("examsdate") + " | "
                                + rs.getTime("examsfrom") + " | "
                                + rs.getTime("examsto") + " | "
                                + rs.getTimestamp("deadline")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void listSessionByModule(String moduleName) {
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
            JSONArray A = JSON_converter.convertWithoutType(rs);
            System.out.println(A);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void listStudentAttendance(int studentId) {
        //The query for MySQL
        String query = "{ call listStudentAttendance(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentId);

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "studentid | sessionsid |" +
                    "attendancetimestamp"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getInt("studentid") + " | "
                                + rs.getInt("sessionsid") + " | "
                                + rs.getTimestamp("attendancetimestamp")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void listAllExamWithModule() {
        //The query for MySQL
        String query = "{ call listAllExamWithModule()}";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "examsid | modulesid | " +
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
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void listOverlapExams() {
        //The query for MySQL
        String query = "{ call listOverlapExams() }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "examsid | modulesid | " +
                    "examsdate | " +
                    "examsfrom | " +
                    "examsto | " +
                    "deadline"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getInt("examsid") + " | "
                                + rs.getInt("modulesid") + " | "
                                + rs.getDate("examsdate") + " | "
                                + rs.getTime("examsfrom") + " | "
                                + rs.getTime("examsto") + " | "
                                + rs.getTimestamp("deadline")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void listSessionByDate(String date) {
        //The query for MySQL
        String query = "{ call listSessionByDate(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            Date convertedDate = Date.valueOf(date);
            stmt.setDate(1, convertedDate);
            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "sessionsid | modulesid | " +
                    "sessionsdate | " +
                    "sessionsfrom | " +
                    "sessionsto"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getInt("sessionsid") + " | "
                                + rs.getInt("modulesid") + " | "
                                + rs.getDate("sessionsdate") + " | "
                                + rs.getTime("sessionsfrom") + " | "
                                + rs.getTime("sessionsto")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void listParticipantByExam(int examId) {
        //The query for MySQL
        String query = "{ call listParticipantByExam(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {


            stmt.setInt(1, examId);
            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "firstname | lastname | " +
                    "studentid"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("firstname") + " | "
                                + rs.getString("lastname") + " | "
                                + rs.getInt("studentid")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void viewRegisteredExamsByStudent(int studentId) {
        //The query for MySQL
        String query = "{ call viewRegisteredExamsByStudent(?) }";
        //Variable for the result
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {


            stmt.setInt(1, studentId);
            rs = stmt.executeQuery();
            System.out.println(String.format("%s", "modulesname | examsdate | " +
                    "examsFrom | " +
                    "examsTo"));
            while (rs.next()) {
                System.out.println(String.format("%s",
                        rs.getString("modulesname") + " | "
                                + rs.getDate("examsDate") + " | "
                                + rs.getTime("examsFrom") + " | "
                                + rs.getTime("examsTo")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////Nhu

    public static void createExam(int modId, int day, int month, int year, int hours, int min, int sec, int hours1, int min1, int sec1,
                                  int Tyear, int Tmonth, int Tdate, int Thour, int Tminute, int Tsecond, int Tnano) throws SQLException{
        Date examDate = new Date(year, month, day);
        Time examFrom = new Time(hours,min,sec);
        Time examTo = new Time(hours1,min1,sec1);
        Timestamp deadline = new Timestamp(Tyear-1900, Tmonth, Tdate, Thour, Tminute, Tsecond, Tnano);
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
    }

    public static void createSession(int modId, int day, int month, int year, int hours, int min, int sec, int hours1, int min1, int sec1) {
        Date sesDate = new Date(day, month, year);
        Time sesFrom = new Time(hours,min,sec);
        Time sesTo = new Time(hours1,min1,sec1);
        //The query for MySQL
        String query = "{ call createSession(?,?,?,?) }";
        //Variable for the result

        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, modId);
            stmt.setDate(2, sesDate);
            stmt.setTime(3, sesFrom);
            stmt.setTime(4, sesTo);

            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createSemester(int dayFr, int monthFr, int yearFr, int dayTo, int monthTo, int yearTo) {
        Date sesFrom = new Date(dayFr, monthFr, yearFr);
        Date sesTo = new Date(dayTo, monthTo, yearTo);
        //The query for MySQL
        String query = "{ call createSession(?,?) }";
        //Variable for the result

        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setDate(1, sesFrom);
            stmt.setDate(2, sesTo);

            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void examRegistration(int studentID, int examID){
        String query = "{ call examRegistration(?,?)}";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentID);
            stmt.setInt(2, examID);

            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void assignLecturer(int lecturerID, int modID){
        String query = "{ call assignLecturer(?,?)}";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, lecturerID);
            stmt.setInt(2, modID);

            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void moduleEnroll(int studentID, int modID){
        String query = "{ call moduleEnroll(?,?)}";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentID);
            stmt.setInt(2, modID);

            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void signAttendance(int studentID, int sesID) {
        String query = "{ call signAttendance(?,?)}";

        ResultSet rs;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setInt(1, studentID);
            stmt.setInt(2, sesID);

            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////Quang

    public static void modifyAccount(int id, String login, String pass, String fname, String lname) {
        String query = "{ call modifyAccount(?,?,?,?,?) }";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, login);
            stmt.setString(3, pass);
            stmt.setString(4, fname);
            stmt.setString(5, lname);
            stmt.executeQuery();
            System.out.println("Succeeded.");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteAccount(int id) {
        String query = "{ call deleteAccount(?) }";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, id);
            stmt.executeQuery();
            System.out.println("Succeeded.");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void modifySemester(int semesterid, int yearfrom, int monthfrom, int datefrom, int yearto, int monthto,int dateto) {
        Date semesterfrom = new Date(yearfrom-1900, monthfrom, datefrom);
        Date semesterto = new Date(yearto-1900, monthto, dateto);
        String query = "{ call modifySemester(?,?,?) }";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, semesterid);
            stmt.setDate(2, semesterfrom);
            stmt.setDate(3, semesterto);
            stmt.executeQuery();
            System.out.println("Succeeded.");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteSemester(int semesterid) {
        String query = "{ call deleteSemester(?) }";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, semesterid);
            stmt.executeQuery();
            System.out.println("Succeeded.");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void modifyModule(int modulesid, String modulesname) {
        String query = "{ call modifyModule(?,?) }";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, modulesid);
            stmt.setString(2, modulesname);
            stmt.executeQuery();
            System.out.println("Succeeded.");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteModule(int modulesid) {
        String query = "{ call deleteModule(?) }";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, modulesid);
            stmt.executeQuery();
            System.out.println("Succeeded.");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void modifySession(int sessionsid, int yeardate, int monthdate, int datedate,
                                     int hourfrom, int minutefrom, int secondfrom, int hourto, int minuteto, int secondto) {
        Date sessionsdate = new Date(yeardate-1900, monthdate, datedate);
        Time sessionsfrom = new Time(hourfrom, minutefrom, secondfrom);
        Time sessionsto = new Time(hourto, minuteto, secondto);
        String query = "{ call modifySession(?,?,?,?) }";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, sessionsid);
            stmt.setDate(2, sessionsdate);
            stmt.setTime(3, sessionsfrom);
            stmt.setTime(4, sessionsto);
            stmt.executeQuery();
            System.out.println("Succeeded.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteSession(int sessionsid) {
        String query = "{ call deleteSession(?) }";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, sessionsid);
            stmt.executeQuery();
            System.out.println("Succeeded.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void modifyExam(int examsid, int yeardate, int monthdate, int datedate,
                                  int hourfrom, int minutefrom, int secondfrom, int hourto, int minuteto, int secondto,
                                  int deadyear, int deadmonth, int deaddate, int deadhour, int deadminute, int deadsecond) {
        Date examsdate = new Date(yeardate-1900, monthdate, datedate);
        Time examsfrom = new Time(hourfrom, minutefrom, secondfrom);
        Time examsto = new Time(hourto, minuteto, secondto);
        Timestamp deadline = new Timestamp(deadyear-1900, deadmonth, deaddate, deadhour, deadminute, deadsecond,0);
        String query = "{ call modifyExam(?,?,?,?,?) }";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, examsid);
            stmt.setDate(2, examsdate);
            stmt.setTime(3, examsfrom);
            stmt.setTime(4, examsto);
            stmt.setTimestamp(5, deadline);
            stmt.executeQuery();
            System.out.println("Succeeded.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteExam(int examsid) {
        String query = "{ call deleteExam(?) }";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, examsid);
            stmt.executeQuery();
            System.out.println("Succeeded.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
