package studentsservice.service;

import studentsservice.entities.StudentEntity;

import java.util.List;

public interface StudentService  {

    StudentEntity save(StudentEntity entity);
    void delete(int id);

    List<StudentEntity> findAll();
    List<StudentEntity> findByfirstname(String firstname);
    List<StudentEntity> findBylastname(String lastname);
    List<StudentEntity> findByGroupNumber(int groupNumber);
    List<StudentEntity> findByStatus(String status);
    StudentEntity findByEmail(String email);
    StudentEntity findById(int id);
}
