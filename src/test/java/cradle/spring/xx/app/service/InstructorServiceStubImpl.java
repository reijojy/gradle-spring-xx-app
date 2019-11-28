package cradle.spring.xx.app.service;

import cradle.spring.xx.app.dao.InstructorDao;
import cradle.spring.xx.app.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceStubImpl implements InsructorServiceStub {

    @Autowired
    private InstructorDao instructorDao;

    @Override
    public List<Course> getInstructorCourses(int theId) {
        return null;
    }
}
