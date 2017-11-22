package studentsservice.repository;

import org.springframework.data.repository.CrudRepository;
import studentsservice.entities.SpecialityEntity;

import java.util.List;


public interface SpecialityRepository extends CrudRepository<SpecialityEntity, Integer> {

    List<SpecialityEntity> findSpecialitiesByFacultyId(int faculty_id);
    SpecialityEntity findByName(String name);
}
