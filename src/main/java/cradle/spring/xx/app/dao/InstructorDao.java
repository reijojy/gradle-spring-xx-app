package cradle.spring.xx.app.dao;

import cradle.spring.xx.app.entity.Course;
import cradle.spring.xx.app.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorDao {
    public Instructor getInstructorById(int Id);
    public Instructor fooGetInstructor(int theId);
    public Instructor addInstructor(Instructor theInstructor);
    public Instructor saveInstructor(Instructor theInstructor);
    public Instructor updateEmail(int theId, String email);
    public List<Instructor> findByEmailEndsWith(String domain);
    public List<Instructor> findAllInstructors();
    public String getInstructorLastName(int theId);
    public List<Course> getInstructorCourse(int theId);

}
