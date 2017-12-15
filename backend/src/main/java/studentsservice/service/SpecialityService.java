package studentsservice.service;


import studentsservice.entities.SpecialityEntity;

import java.util.List;

public interface SpecialityService {

    SpecialityEntity save(SpecialityEntity entity);

    List<SpecialityEntity> findAll();
    SpecialityEntity findById(int id);
    List<SpecialityEntity> findSpecialitiesByFacultyId(int faculty_id);
    SpecialityEntity findByName(String name);

}
