package cradle.spring.xx.app.dao;

import cradle.spring.xx.app.entity.Course;
import cradle.spring.xx.app.entity.Instructor;
import cradle.spring.xx.app.entity.InstructorDetail;
import cradle.spring.xx.app.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorDaoImpl implements InstructorDao{

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public Instructor getInstructorById(int theId) {

        System.out.println("Inside method Inside method: " + getClass().getName() +  " getInstuctorById");
        return instructorRepository.findById(theId);
    }
    @Override
    public String getInstructorLastName(int theId) {
        Instructor tempInstructor =  instructorRepository.findById(theId);
        if (tempInstructor != null)
            return tempInstructor.getLastName();
        else return null;
    }
    public List<Course> getInstructorCourse(int theId) {
        Instructor tempInstructor =  instructorRepository.findById(theId);
        System.out.println("<=== inside: " + getClass().getName() + " method getInstructorCourse");
        System.out.println("===> Size of list: " + tempInstructor.getCourses().size()  + " <===");
        if (tempInstructor != null)
            return tempInstructor.getCourses();
        else return null;
    }
    @Override
    public Instructor fooGetInstructor(int theId) {
        Instructor tempInstructor = instructorRepository.findById(theId);
        // Return too many implementations
        //return tempInstructor.orElse(new Instructor());
        //return tempInstructor.orElseGet(() -> new Instructor());
        return tempInstructor;
    }
    public Instructor addInstructor(Instructor theInstructor) {

        // Obsolote
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();
        try {
            System.out.println("Begin Transaction");
            session.beginTransaction();

            // save the instructor
            session.save(theInstructor);

            System.out.println("Committing");
            session.getTransaction().commit();
        } finally {
            session.close();
        }

        return theInstructor;
    }
    public Instructor saveInstructor(Instructor theInstructor) {

        instructorRepository.save(theInstructor);
        return theInstructor;
    }
    @Override
    public Instructor updateEmail(int theId, String email) {

        Instructor tempInstructor = instructorRepository.findById(theId);
        tempInstructor.setEmail(email);
        instructorRepository.save(tempInstructor);
        return tempInstructor;
    }
    public List<Instructor> findByEmailEndsWith(String domain) {
        List<Instructor> instructors = instructorRepository.findByEmailEndsWith(domain);
        return instructors;
    }
    public List<Instructor> findAllInstructors() {
        List<Instructor> instructors = instructorRepository.findAllInstructors();
        return instructors;
    }
}
