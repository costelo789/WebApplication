package com;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;

/**
 * Main class.
 *
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/webrest/rest/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com package
        final ResourceConfig rc = new ResourceConfig().packages("com");
        HttpServer server;
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);

        //add path to HTTP static page
        server.getServerConfiguration().addHttpHandler(new StaticHttpHandler(new File(".").getAbsolutePath() +
                "/src/WebContent"));
        //server.getServerConfiguration().addHttpHandler(new StaticHttpHandler(new File(".").getAbsolutePath() +"/src/WebContent"));

        System.out.println(new File(".").getAbsolutePath());
        return server;
    }


    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, SQLException {

        //The server set up Grizzly2

        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();


        /*

        Communicate_MySQL_Assistant.listAccountById(1);//List an account by Id
        Communicate_MySQL_Assistant.listSessionsOverlap();
        Communicate_MySQL_Assistant.listAssistant();
        Communicate_MySQL_Assistant.listSessionByModule("Math");
        Communicate_MySQL_Assistant.createExam(3, 16, 02, 2019, 9,00,00,12,00,00,2019,6,9,23,59,59,0);
        Communicate_MySQL_Assistant.createSession(3, 12, 1, 2018, 13,00,00,16,15,00);
        Communicate_MySQL_Assistant.createSemester(01, 01, 2019,30,0,2019);
        Communicate_MySQL_Assistant.assignLecturer(16, 2);
        Communicate_MySQL_Assistant.modifyAccount(1,"assistant01","pass1","Ho","Tran");
        Communicate_MySQL_Assistant.modifySemester(1, 2016, 9, 02, 2017, 02, 02);
        Communicate_MySQL_Assistant.modifyModule(3, "Alge");
        Communicate_MySQL_Assistant.modifySession(1, 2016, 9, 2, 9, 00, 00, 10, 00, 00);
        Communicate_MySQL_Assistant.modifyExam(1, 2018, 20, 1, 9, 0, 0, 11, 0, 0, 2018, 1,11, 00, 00, 00);
        Communicate_MySQL_Assistant.deleteAccount(1);
        Communicate_MySQL_Assistant.deleteSemester(1);
        Communicate_MySQL_Assistant.deleteModule(1);
        Communicate_MySQL_Assistant.deleteSession(1);
        Communicate_MySQL_Assistant.deleteExam(1);


        Communicate_MySQL_Lecturer.listLecturer();//List all the lecturers
        Communicate_MySQL_Lecturer.listParticipantByExam(1);


        Communicate_MySQL_Student.listStudent();// List all the student
        Communicate_MySQL_Student.listStudentByModuleId(1);// List all the student in a module
        Communicate_MySQL_Student.listStudentAttendance(8);
        Communicate_MySQL_Student.listAllExamWithModule();
        Communicate_MySQL_Student.listOverlapExams();
        Communicate_MySQL_Student.listSessionByDate("2016-10-01");
        Communicate_MySQL_Student.listExamBySemester(1);//List all the exams in a semester
        Communicate_MySQL_Student.listExamByModuleName("Math");// List all the exams in a module according to module name
        Communicate_MySQL_Student.listExamByStudent(1);// List all the exams a student registered
        Communicate_MySQL_Student.listExamOfAStudent(8);
        Communicate_MySQL_Student.viewRegisteredExamsByStudent(8);
        Communicate_MySQL_Student.examRegistration(12, 3);
        Communicate_MySQL_Student.moduleEnroll(12, 3);
        Communicate_MySQL_Student.signAttendance(12, 2);
        */

        //JSONArray test = Communicate_MySQL_Student.listStudentByModuleId(1);// List all the student in a module
        //System.out.println(test);
    }
}

