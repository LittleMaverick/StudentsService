package studentsservice.repository;

import org.springframework.data.repository.CrudRepository;
import studentsservice.entities.StudentEntity;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer>{

    List<StudentEntity> findByfirstname(String firstname);
    List<StudentEntity> findBylastname(String lastname);
    List<StudentEntity> findByGroupNumber(int groupNumber);
    List<StudentEntity> findByStatus(String status);
    StudentEntity findByEmail(String email);
    StudentEntity findByUserId(int userId);
}
