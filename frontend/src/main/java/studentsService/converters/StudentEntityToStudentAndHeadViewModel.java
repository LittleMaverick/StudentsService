package studentsService.converters;

import org.springframework.core.convert.converter.Converter;
import studentsService.beans.StudentAndHeadViewModel;
import studentsservice.entities.AppointStudentEntity;
import studentsservice.entities.StudentEntity;

public class StudentEntityToStudentAndHeadViewModel implements Converter<StudentEntity, StudentAndHeadViewModel> {

    @Override
    public StudentAndHeadViewModel convert(StudentEntity studentEntity) {

        StudentAndHeadViewModel studentAndHeadViewModel = new StudentAndHeadViewModel();

        studentAndHeadViewModel.setFirstName(studentEntity.getFirstname());

        studentAndHeadViewModel.setLastName(studentEntity.getLastname());

        studentAndHeadViewModel.setStatus(studentEntity.getStatus());

        studentAndHeadViewModel.setSpeciality(studentEntity.getSpecialitiesBySpecialityId().getName());

        studentAndHeadViewModel.setFaculty(studentEntity.getSpecialitiesBySpecialityId().getFacultiesByFacultyId().getName());

        for (AppointStudentEntity appointStudentEntity : studentEntity.getAppointStudentsById()){

            studentAndHeadViewModel.setId(String.valueOf(appointStudentEntity.getPracticesByPracticeId().getHeadOfPracticeId()));

            studentAndHeadViewModel.setStudentId(String.valueOf(appointStudentEntity.getStudentId()));

            studentAndHeadViewModel.setCompany(appointStudentEntity.getPracticesByPracticeId().getCompany());

            studentAndHeadViewModel.setPracticePeriod(String.valueOf(appointStudentEntity.getPracticesByPracticeId().getStartDate()) + " - "
                    + String.valueOf(appointStudentEntity.getPracticesByPracticeId().getFinishDate()));
        }

        return studentAndHeadViewModel;
    }

}
