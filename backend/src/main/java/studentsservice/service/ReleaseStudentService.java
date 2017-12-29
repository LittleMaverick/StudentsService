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
public class ReleaseStudentService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private AppointStudentService appointStudentService;

    @Transactional
    public void releaseStudent(int studentId){

        StudentEntity studentEntity = studentService.findById(studentId);

        studentEntity.setStatus("Available");

        studentService.save(studentEntity);

        List<AppointStudentEntity> appointStudentEntities = appointStudentService.findByStudentId(studentId);
        for (AppointStudentEntity appointStudentEntity : appointStudentEntities) {

            PracticeEntity practiceEntity = practiceService.findById(appointStudentEntity.getPracticeId());

            practiceEntity.setAvailableQuantity(practiceEntity.getAvailableQuantity() + 1);

            practiceEntity.setStatus("Available");

            practiceService.save(practiceEntity);

            appointStudentService.delete(appointStudentEntity.getId());
        }
    }
}