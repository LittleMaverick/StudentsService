package studentsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentsservice.entities.StudentEntity;

@Service
@Transactional
public class DeletionService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    public void deleteStudent(int id){

        StudentEntity studentEntity = studentService.findById(id);

        userService.delete(studentEntity.getUserId());
    }
}
