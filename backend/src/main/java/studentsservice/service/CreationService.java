package studentsservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentsservice.entities.*;

@Service
@Transactional
public class CreationService {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentsService;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private HeadOfPracticeService headOfPracticeService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private PracticeService practiceService;


    @Transactional
    public void createStudent(UserEntity userEntity, StudentEntity studentEntity){

        userService.save(userEntity);

        UserEntity entity = userService.findByUsername(userEntity.getUsername());
        studentEntity.setUserId(entity.getId());
        studentEntity.setUserByUserId(entity);

        SpecialityEntity specialityEntity = specialityService.findById(studentEntity.getSpecialityId());
        studentEntity.setSpecialitiesBySpecialityId(specialityEntity);

        studentsService.save(studentEntity);
    }

    @Transactional
    public void createHeadOfPractice(UserEntity userEntity, HeadOfPracticeEntity headOfPracticeEntity){

        userService.save(userEntity);

        UserEntity entity = userService.findByUsername(userEntity.getUsername());
        headOfPracticeEntity.setUserId(entity.getId());
        headOfPracticeEntity.setUsersByUserId(entity);

        headOfPracticeService.save(headOfPracticeEntity);
    }

    @Transactional
    public void createFaculty(FacultyEntity facultyEntity){
        facultyService.save(facultyEntity);
    }

    @Transactional
    public void createSpeciality(SpecialityEntity specialityEntity){

        FacultyEntity facultyEntity = facultyService.findById(specialityEntity.getFacultyId());

        specialityEntity.setFacultiesByFacultyId(facultyEntity);

        specialityService.save(specialityEntity);
    }

    @Transactional
    public void createPractice(PracticeEntity practiceEntity){

        HeadOfPracticeEntity headOfPracticeEntity = headOfPracticeService.findById(practiceEntity.getHeadOfPracticeId());

        practiceEntity.setHeadofpracticesByHeadOfPracticeId(headOfPracticeEntity);

        FacultyEntity facultyEntity = facultyService.findById(practiceEntity.getFacultyId());

        practiceEntity.setFacultiesByFacultyId(facultyEntity);

        SpecialityEntity specialityEntity = specialityService.findById(practiceEntity.getSpecialityId());

        practiceEntity.setSpecialitiesBySpecialityId(specialityEntity);

        practiceService.save(practiceEntity);
    }
}
