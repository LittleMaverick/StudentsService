package studentsservice.service;


import studentsservice.entities.FacultyEntity;

import java.util.List;

public interface FacultyService {

    FacultyEntity save(FacultyEntity entity);

    List<FacultyEntity> findAll();
    FacultyEntity findById(int id);
    FacultyEntity findByName(String name);
}
