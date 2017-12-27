package studentsservice.components;

import org.springframework.stereotype.Component;
import studentsservice.entities.*;

import java.sql.Date;

@Component
public class EntityCreator {

    public UserEntity getUserEntity(String role, String username, String password){

        UserEntity userEntity = new UserEntity();

        userEntity.setRole(role);
        userEntity.setUsername(username);
        userEntity.setPassword(password);

        return userEntity;
    }

    public StudentEntity getStudentEntity(String firstname, String lastname, String email,
                                          int specialityId, int groupNumber){

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setFirstname(firstname);
        studentEntity.setLastname(lastname);
        studentEntity.setEmail(email);
        studentEntity.setSpecialityId(specialityId);
        studentEntity.setGroupNumber(groupNumber);
        studentEntity.setStatus("Available");

        return studentEntity;
    }

    public HeadOfPracticeEntity getHeadOfPracticeEntity(String name){

        HeadOfPracticeEntity headOfPracticeEntity = new HeadOfPracticeEntity();

        headOfPracticeEntity.setName(name);

        return headOfPracticeEntity;
    }

    public FacultyEntity getFacultyEntity(String name){

        FacultyEntity facultyEntity = new FacultyEntity();

        facultyEntity.setName(name);

        return facultyEntity;
    }

    public SpecialityEntity getSpecialityEntity(String name, int facultyId){

        SpecialityEntity specialityEntity = new SpecialityEntity();

        specialityEntity.setName(name);
        specialityEntity.setFacultyId(facultyId);

        return specialityEntity;
    }

    public PracticeEntity getPracticeEntity(int headOfPracticeId, String company, Date startDate, Date finishDate,
                                            int totalQuantity, int facultyId, int specialityId){

        PracticeEntity practiceEntity = new PracticeEntity();

        practiceEntity.setHeadOfPracticeId(headOfPracticeId);

        practiceEntity.setCompany(company);

        practiceEntity.setStartDate(startDate);

        practiceEntity.setFinishDate(finishDate);

        practiceEntity.setTotalQuantity(totalQuantity);

        practiceEntity.setAvailableQuantity(totalQuantity);

        practiceEntity.setFacultyId(facultyId);

        practiceEntity.setSpecialityId(specialityId);

        practiceEntity.setStatus("Available");

        return practiceEntity;
    }

    public AppointStudentEntity getAppointStudent(int studentId, int practiceId){
        AppointStudentEntity appointStudentEntity = new AppointStudentEntity();

        appointStudentEntity.setStudentId(studentId);
        appointStudentEntity.setPracticeId(practiceId);

        return  appointStudentEntity;
    }

}
