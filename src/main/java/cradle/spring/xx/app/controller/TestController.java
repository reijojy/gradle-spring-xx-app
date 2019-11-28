package cradle.spring.xx.app.controller;


import cradle.spring.xx.app.entity.Course;
import cradle.spring.xx.app.entity.Instructor;
import cradle.spring.xx.app.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;


@RestController
@RequestMapping("/instructor")
public class TestController {

    @Autowired
    private InstructorService instructorService;

    @RequestMapping("/test")
    public @ResponseBody  String getTestString() {
        return "This is the ultimate teststring from " + getClass().getName();
    }

    // Just for initial testing
    @RequestMapping("/connection")
    public String getConnectionTest() {
        if (getConnection()) {
            return "Connection success";
        } else {
            return "Connection FAILURE";
        }
    }

    @CrossOrigin
    @RequestMapping("/byid")
    public Instructor getInstructorById(@RequestParam("InstructorId") int theId) {
        Instructor tempInstructor = instructorService.getInstructorById(theId);

        if(tempInstructor != null)
            return tempInstructor;
        else
            return new Instructor();
    }
    @CrossOrigin
    @RequestMapping("/getLastName")
    public String getInstructorLastName(@RequestParam("InstructorId") int theId) {
        // Tämä on vain mocMvc:tä varten tehty
        return instructorService.getInstructorLastName(theId);
    }
    @CrossOrigin
    @RequestMapping("/getCourseCount")
    public List<Course> getInstructorCoursesCount(@RequestParam("InstructorId") int theId) {
        // Tämä on vain mocMvc:tä varten tehty
        System.out.println("<==== inside  getInstructorCoursesCount( ====>");
        System.out.println("====> insructorId: " + theId +  " <====");
        List<Course> courses = instructorService.getInstructorCourse(theId);
        if (courses != null)
            System.out.println("====> " + courses.size() + " <====");
        else System.out.println("====> courses is null <====");
        return courses;
    }
    @RequestMapping("/fooinstructor")
    public Instructor fooGetInstructorById(@RequestParam("InstructorId") int theId) {

        return instructorService.fooGetInstructor(theId);
    }

    @CrossOrigin
    @RequestMapping("/addinstructor")
    public String addInstructor(@RequestParam("firstname") String firstName,
                                @RequestParam("lastname") String lastName,
                                @RequestParam("email") String email) {

        // obsolote use funtion with @RequestBody
        Instructor theInstructor = new Instructor(firstName, lastName, email);
        instructorService.addInstructor(theInstructor);

        return theInstructor.toString();
    }

    @CrossOrigin
    @PostMapping("/addjson")
    public Instructor saveJSONInstructor(@RequestBody Instructor theInstructor) {
        System.out.println(getClass().getName() + " Metodi saveJsonInstructor");
        return instructorService.saveInstructor(theInstructor);

    }
    @RequestMapping("/updemail")
    public Instructor updateEmail(@RequestParam("instructorId") int theId,
                              @RequestParam("email") String email)
    {

        return instructorService.updateEmail(theId, email);
    }

    @RequestMapping("/byemail")
    public  List<Instructor> getInstuctorsByEmailEndsWith(@RequestParam("emaildomain")
                                                         String domain){
        return instructorService.findByEmailEndsWith(domain);
        //List<Instructor> theInstructors = instructorService.findByEmailEndsWith(domain);

        // int count = theInstructors.size();
        // return "The query produced " + Integer.toString(count) + " matches";
    }
    @CrossOrigin
    @RequestMapping("/allinstructors")
    public List<Instructor> getAllInstructorsQuery() {

        return instructorService.findAllInstructors();
        // List<Instructor> theInstructors = instructorService.findAllInstructors();
        //int count = theInstructors.size();
        //return "The query produced " + Integer.toString(count) + " matches";

    }
    // Just for initial testing
    private boolean getConnection() {

        String url ="jdbc:mysql://jyrki.mysql.database.azure.com:3306/hb-01-one-to-one-uni";
        String user = "jyrki@jyrki";
        String password = "f8WtS!29";
        Connection conn = null;
        boolean isConnection = false;
        try {
            System.out.println("Connecting to database");

            conn =
                    DriverManager.getConnection(url, user, password);
            System.out.println("Connecting success");
        }  catch (SQLException e) {
            System.out.println("Could not establish connection");
            //System.out.println(e.toString());
            e.printStackTrace();
        }
        if (conn != null) {
            isConnection = true;
            System.out.println("Close connection");
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return isConnection;
    }

}
