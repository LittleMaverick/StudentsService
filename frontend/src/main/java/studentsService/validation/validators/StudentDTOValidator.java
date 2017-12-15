package studentsService.validation.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import studentsService.dto.StudentDTO;
import studentsservice.service.StudentService;
import studentsservice.service.UserService;

@Component
public class StudentDTOValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return StudentDTO.class.equals(aClass);
    }

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Override
    public void validate(Object obj, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"role","Field is required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","Field is required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","Field is required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"faculty","Field is required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"speciality","Field is required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"groupNumber","Field is required");

        StudentDTO studentDTO = (StudentDTO) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","Field is required");
        if(userService.findByUsername(studentDTO.getUsername()) != null){
            errors.rejectValue("username","Username has been already in use");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","Field is required");
        if(userService.findByPassword(studentDTO.getPassword()) != null){
            errors.rejectValue("password","Password has been already in use");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","Field is required");
        if(studentService.findByEmail(studentDTO.getEmail()) != null){
            errors.rejectValue("email","Email has been already in use");
        }

    }
}
