package studentsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentsservice.components.EntityCreator;
import studentsservice.entities.AppointStudentEntity;
import studentsservice.entities.PracticeEntity;
import studentsservice.entities.StudentEntity;

import java.util.List;

@Service
@Transactional
public class AppointService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private EntityCreator entityCreator;

    @Autowired
    private AppointStudentService appointStudentService;

    @Transactional
    public void AppointStudent(int practiceId, List<Integer> studentIDs){

        PracticeEntity practiceEntity = practiceService.findById(practiceId);

        // todo проверочка
        practiceEntity.setAvailableQuantity(practiceEntity.getAvailableQuantity() - studentIDs.size());

        if(practiceEntity.getAvailableQuantity() == 0){
            practiceEntity.setStatus("Filled");
        }

        practiceService.save(practiceEntity);

        for (int studentID : studentIDs) {
            StudentEntity studentEntity = studentService.findById(studentID);

            studentEntity.setStatus("Busy");
            studentService.save(studentEntity);

            AppointStudentEntity appointStudentEntity = entityCreator.getAppointStudent(studentID, practiceId);
            appointStudentEntity.setStudentsByStudentId(studentEntity);
            appointStudentEntity.setPracticesByPracticeId(practiceEntity);

            appointStudentService.save(appointStudentEntity);
        }

    }
}
