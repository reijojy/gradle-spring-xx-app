package cradle.spring.xx.app.service;

import cradle.spring.xx.app.dao.InstructorDao;
import cradle.spring.xx.app.entity.Course;
import cradle.spring.xx.app.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorDao instructorDao;

    @Override
    public Instructor getInstructorById(int theId) {

        System.out.println("Inside method Inside method: " + getClass().getName() +  " getInstuctorById");
        return instructorDao.getInstructorById(theId);

    }

    @Override
    public String getInstructorLastName(int theId) {
        return instructorDao.getInstructorLastName(theId);
    }
    public List<Course> getInstructorCourse(int theId) {
        return instructorDao.getInstructorCourse(theId);
    }
    public Instructor fooGetInstructor(int theId) {
        return instructorDao.fooGetInstructor(theId);
    }

    public Instructor addInstructor(Instructor theInstructor) {

        return instructorDao.addInstructor(theInstructor);

    }
    public Instructor saveInstructor(Instructor theInstructor) {

        return instructorDao.saveInstructor(theInstructor);

    }
    public Instructor updateEmail(int theId, String email) {
        return instructorDao.updateEmail(theId, email);
    }
    public List<Instructor> findByEmailEndsWith(String domain) {

        return instructorDao.findByEmailEndsWith(domain);

    }
    public List<Instructor> findAllInstructors() {

        return instructorDao.findAllInstructors();

    }
}
