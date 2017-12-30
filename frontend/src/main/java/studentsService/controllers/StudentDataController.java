package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import studentsService.beans.StudentAndHeadViewModel;
import studentsService.beans.StudentDataViewModel;
import studentsService.beans.StudentViewModel;
import studentsService.dto.StudentDTO;
import studentsService.validation.validators.StudentDTOValidator;
import studentsservice.components.EntityCreator;
import studentsservice.entities.AppointStudentEntity;
import studentsservice.entities.StudentEntity;
import studentsservice.entities.UserEntity;
import studentsservice.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentDataController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDTOValidator studentDTOValidator;

    @Autowired
    private CreationService creationService;

    @Autowired
    private DeletionService deletionService;

    @Autowired
    private EntityCreator entityCreator;

    @Autowired
    private AppointStudentService appointStudentService;

    private final TypeDescriptor studentEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentEntity.class));
    private final TypeDescriptor studentDataViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentDataViewModel.class));

    private final TypeDescriptor ListOfStudentEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentEntity.class));
    private final TypeDescriptor ListOfStudentAndHeadViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentAndHeadViewModel.class));


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getAllStudents() {
        List<StudentEntity> allStudents = studentService.findAll();
        return (List<StudentViewModel>) conversionService.convert(allStudents, studentEntityTypeDescriptor, studentDataViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/students", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, String> deleteStudent(@RequestBody List<String> studentIDs){

        for(String studentID : studentIDs){
            deletionService.deleteStudent(Integer.parseInt(studentID));
        }

        return null;
    }

    @RequestMapping(value = "/registrationStudent", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> registrationStudent(@RequestBody StudentDTO studentDTO, BindingResult bindingResult) {

        studentDTOValidator.validate(studentDTO, bindingResult);

        if (bindingResult.hasErrors() ){
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getCode());
            }
            return errors;
        }

        UserEntity userEntity = entityCreator.getUserEntity(studentDTO.getRole(),
                                                            studentDTO.getUsername(),
                                                            studentDTO.getPassword());

        StudentEntity studentEntity = entityCreator.getStudentEntity(studentDTO.getFirstName(),
                        studentDTO.getLastName(),
                        studentDTO.getEmail(),
                        Integer.parseInt(studentDTO.getSpeciality()),
                        Integer.parseInt(studentDTO.getGroupNumber()));


        creationService.createStudent(userEntity, studentEntity);

        return null;
    }

    @RequestMapping(value = "/students/headMaster/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentAndHeadViewModel> getHeadAndStudents(@PathVariable String id) {

        List<AppointStudentEntity> appointStudentEntities = appointStudentService.findAll();

        List<StudentEntity> studentEntities = new ArrayList<>();

        for (AppointStudentEntity appointStudentEntity : appointStudentEntities){

            if ((String.valueOf(appointStudentEntity.getPracticesByPracticeId().getHeadOfPracticeId())).equals(id)){

                studentEntities.add(appointStudentEntity.getStudentsByStudentId());
            }
        }

        return (List<StudentAndHeadViewModel>) conversionService.convert(studentEntities, ListOfStudentEntityTypeDescriptor, ListOfStudentAndHeadViewModelTypeDescriptor);
    }

}