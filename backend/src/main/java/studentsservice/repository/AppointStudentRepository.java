package studentsservice.repository;

import org.springframework.data.repository.CrudRepository;
import studentsservice.entities.AppointStudentEntity;

import java.util.List;


public interface AppointStudentRepository extends CrudRepository<AppointStudentEntity, Integer>{

    List<AppointStudentEntity> findByStudentId(int studentId);
    List<AppointStudentEntity> findByPracticeId(int practiceId);
}
