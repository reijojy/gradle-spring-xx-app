package cradle.spring.xx.app.dao;

import cradle.spring.xx.app.entity.Course;
import cradle.spring.xx.app.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorDaoStubImpl implements InstructorDaoStub {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public List<Course> getInstructorCourses(int theId) {
        System.out.println("<== At the beginning of: " + getClass().getName() +
                " method getInstructorCourse");
        Instructor instructor = instructorRepository.findById(theId);
        if (instructor != null)
            System.out.println("==> " + instructor.getFirstName() + " <==");
        else System.out.println("==> instructor = null <==");

        if (instructor != null)
            System.out.println("==> courses size is " + instructor.getCourses().size()
                    + " <==");
        return instructor.getCourses();
    }
}
