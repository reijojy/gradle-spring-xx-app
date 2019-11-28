package cradle.spring.xx.app.dao;

import cradle.spring.xx.app.entity.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

    // Poistaa Optionalin findById
    Instructor findById(int theId);

    // LIKE CONCAT('%' :domain")
    @Query("select i from Instructor i where i.email LIKE CONCAT('%',  :domain)")
    List<Instructor> findByEmailEndsWith(@Param("domain") String domain);
    @Query("select i from Instructor i")
    List<Instructor> findAllInstructors();

}
