package studentsService.converters;


import org.springframework.core.convert.converter.Converter;
import studentsService.beans.StudentDataViewModel;
import studentsservice.entities.AppointStudentEntity;
import studentsservice.entities.StudentEntity;

public class StudentEntityToStudentDataViewModel implements Converter<StudentEntity, StudentDataViewModel>
{
    @Override
    public StudentDataViewModel convert(StudentEntity studentEntity) {
        StudentDataViewModel studentDataViewModel = new StudentDataViewModel();
        studentDataViewModel.setId(String.valueOf(studentEntity.getId()));
        studentDataViewModel.setLastName(studentEntity.getLastname());
        studentDataViewModel.setFirstName(studentEntity.getFirstname());
        studentDataViewModel.setFaculty(studentEntity.getSpecialitiesBySpecialityId().getFacultiesByFacultyId().getName());
        studentDataViewModel.setSpeciality(studentEntity.getSpecialitiesBySpecialityId().getName());
        studentDataViewModel.setStatus(studentEntity.getStatus());

        for (AppointStudentEntity appointStudentEntity : studentEntity.getAppointStudentsById()){
            studentDataViewModel.setCompany(appointStudentEntity.getPracticesByPracticeId().getCompany());
            studentDataViewModel.setPracticePeriod(String.valueOf(appointStudentEntity.getPracticesByPracticeId().getStartDate()) + " - "
                    + String.valueOf(appointStudentEntity.getPracticesByPracticeId().getFinishDate()));
        }
        return studentDataViewModel;
    }
}
