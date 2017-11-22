package studentsservice.service.Impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentsservice.entities.StudentEntity;
import studentsservice.repository.StudentRepository;
import studentsservice.service.StudentService;

import java.util.List;

@Service("jpaStudentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity save(StudentEntity entity) {
        return studentRepository.save(entity);
    }

    public void delete(int id) {
        studentRepository.delete(id);
    }


    public List<StudentEntity> findAll() {
        return Lists.newArrayList(studentRepository.findAll());
    }


    public List<StudentEntity> findByFirstName(String firstname) {
        return studentRepository.findByFirstName(firstname);
    }


    public List<StudentEntity> findByLastName(String lastname) {
        return studentRepository.findByLastName(lastname);
    }


    public List<StudentEntity> findByGroupNumber(int groupNumber) {
        return studentRepository.findByGroupNumber(groupNumber);
    }


    public List<StudentEntity> findByStatus(String status) {
        return studentRepository.findByStatus(status);
    }


    public StudentEntity findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }


    public StudentEntity findById(int id) {
        return studentRepository.findOne(id);
    }
}
