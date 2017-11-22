package studentsservice.repository;

import org.springframework.data.repository.CrudRepository;
import studentsservice.entities.AppointStudentEntity;

import java.util.List;


public interface AppointStudentRepository extends CrudRepository<AppointStudentEntity, Integer>{

    List<AppointStudentEntity> findByStudentId(int student_id);
    List<AppointStudentEntity> findByPracticeId(int practice_id);
}
