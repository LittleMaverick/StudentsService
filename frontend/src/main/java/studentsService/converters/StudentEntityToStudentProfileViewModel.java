package studentsService.converters;

import org.springframework.core.convert.converter.Converter;
import studentsService.beans.StudentProfileViewModel;
import studentsservice.entities.AppointStudentEntity;
import studentsservice.entities.StudentEntity;

public class StudentEntityToStudentProfileViewModel implements Converter< StudentEntity, StudentProfileViewModel>{

    @Override
    public StudentProfileViewModel convert(StudentEntity studentEntity) {
        StudentProfileViewModel studentProfileViewModel = new StudentProfileViewModel();

        studentProfileViewModel.setId(String.valueOf(studentEntity.getId()));
        studentProfileViewModel.setFirstName(studentEntity.getFirstname());
        studentProfileViewModel.setLastName(studentEntity.getLastname());
        studentProfileViewModel.setEmail(studentEntity.getEmail());
        studentProfileViewModel.setStatus(studentEntity.getStatus());
        studentProfileViewModel.setGroupNumber(String.valueOf(studentEntity.getGroupNumber()));
        studentProfileViewModel.setSpeciality(studentEntity.getSpecialitiesBySpecialityId().getName());
        studentProfileViewModel.setFaculty(studentEntity.getSpecialitiesBySpecialityId().getFacultiesByFacultyId().getName());

        for (AppointStudentEntity appointStudentEntity : studentEntity.getAppointStudentsById()){
            studentProfileViewModel.setCompany(appointStudentEntity.getPracticesByPracticeId().getCompany());
            studentProfileViewModel.setPracticePeriod(String.valueOf(appointStudentEntity.getPracticesByPracticeId().getStartDate()) + " - "
                                                    + String.valueOf(appointStudentEntity.getPracticesByPracticeId().getFinishDate()));
        }

        return studentProfileViewModel;
    }
}
