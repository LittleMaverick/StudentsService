package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import studentsService.beans.StudentDataViewModel;
import studentsService.beans.StudentViewModel;
import studentsservice.entities.StudentEntity;
import studentsservice.service.StudentService;

import java.util.List;

@Controller
public class StudentDataController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private StudentService studentService;

    private final TypeDescriptor studentEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentEntity.class));
    private final TypeDescriptor studentDataViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentDataViewModel.class));


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getAllStudents() {
        List<StudentEntity> allStudents = studentService.findAll();
        return (List<StudentViewModel>) conversionService.convert(allStudents, studentEntityTypeDescriptor, studentDataViewModelTypeDescriptor);
    }
}
