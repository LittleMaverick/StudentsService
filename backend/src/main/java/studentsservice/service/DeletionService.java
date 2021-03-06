package studentsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentsservice.entities.AppointStudentEntity;
import studentsservice.entities.PracticeEntity;
import studentsservice.entities.StudentEntity;

import java.util.List;

@Service
@Transactional
public class DeletionService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private AppointStudentService appointStudentService;

    @Autowired
    private PracticeService practiceService;

    @Transactional
    public void deleteStudent(int id){

        StudentEntity studentEntity = studentService.findById(id);

        List<AppointStudentEntity> appointStudentEntities = appointStudentService.findByStudentId(id);

        for(AppointStudentEntity appointStudentEntity : appointStudentEntities){
            PracticeEntity practiceEntity = practiceService.findById(appointStudentEntity.getPracticeId());
            practiceEntity.setAvailableQuantity(practiceEntity.getAvailableQuantity() + 1);
            if(practiceEntity.getStatus().equals("Filled")){
                practiceEntity.setStatus("Available");
            }
            practiceService.save(practiceEntity);
        }

        userService.delete(studentEntity.getUserId());
    }

    @Transactional
    public void deletePractice(int id){

        List<AppointStudentEntity> appointStudentEntities = appointStudentService.findByPracticeId(id);

        for(AppointStudentEntity appointStudentEntity : appointStudentEntities){

            StudentEntity studentEntity = studentService.findById(appointStudentEntity.getStudentId());

            studentEntity.setStatus("Available");

            studentService.save(studentEntity);
        }

        practiceService.delete(id);
    }
}
