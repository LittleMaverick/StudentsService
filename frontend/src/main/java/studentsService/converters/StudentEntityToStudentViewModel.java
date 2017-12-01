package studentsService.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.ConversionService;
import studentsService.beans.SpecialityViewModel;
import studentsService.beans.StudentViewModel;
import studentsService.beans.UserViewModel;
import studentsservice.entities.StudentEntity;

public class StudentEntityToStudentViewModel implements Converter<StudentEntity, StudentViewModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public StudentViewModel convert(StudentEntity studentEntity) {
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setId(String.valueOf(studentEntity.getId()));
        studentViewModel.setFirstName(studentEntity.getFirstname());
        studentViewModel.setLastName(studentEntity.getLastname());
        studentViewModel.setEmail(studentEntity.getEmail());
        studentViewModel.setStatus(studentEntity.getStatus());
        studentViewModel.setGroupNumber(String.valueOf(studentEntity.getGroupNumber()));
        //studentViewModel.setSpeciality(studentEntity.getSpecialitiesBySpecialityId().getName());
        studentViewModel.setSpeciality(conversionService.convert(studentEntity.getSpecialitiesBySpecialityId(), SpecialityViewModel.class));

        studentViewModel.setUserViewModel(conversionService.convert(studentEntity.getUsersById(), UserViewModel.class));
        return studentViewModel;
    }
}
