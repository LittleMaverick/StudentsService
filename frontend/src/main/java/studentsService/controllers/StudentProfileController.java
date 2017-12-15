package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import studentsService.beans.StudentDataViewModel;
import studentsService.beans.StudentProfileViewModel;
import studentsservice.entities.StudentEntity;
import studentsservice.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentProfileController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private StudentService studentService;


    private final TypeDescriptor studentEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentEntity.class));
    private final TypeDescriptor studentProfileViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentProfileViewModel.class));

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentProfileViewModel> getStudentProfile(@PathVariable String id) {
        StudentEntity student = studentService.findById(Integer.parseInt(id));
        List <StudentEntity> temp = new ArrayList<>();
        temp.add(student);
        return (List<StudentProfileViewModel>) conversionService.convert(temp, studentEntityTypeDescriptor, studentProfileViewModelTypeDescriptor);
    }
}
