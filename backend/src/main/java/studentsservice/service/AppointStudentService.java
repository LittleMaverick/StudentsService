package studentsservice.service;


import studentsservice.entities.AppointStudentEntity;

import java.util.List;

public interface AppointStudentService {

    AppointStudentEntity save(AppointStudentEntity entity);
    void delete(int id);

    List<AppointStudentEntity> findAll();
    AppointStudentEntity findById(int id);
    List<AppointStudentEntity> findByStudentId(int student_id);
    List<AppointStudentEntity> findByPracticeId(int practice_id);

}
