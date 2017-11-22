package studentsservice.repository;

import org.springframework.data.repository.CrudRepository;
import studentsservice.entities.FacultyEntity;


public interface FacultyRepository extends CrudRepository<FacultyEntity, Integer> {

    FacultyEntity findByName(String name);
}
