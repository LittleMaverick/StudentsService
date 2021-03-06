package studentsService.validation.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
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

        StudentDTO studentDTO = (StudentDTO) obj;

        if (userService.findByUsername(studentDTO.getUsername()) != null) {
            errors.rejectValue("username", "Username has been already in use");
        }

        if(studentService.findByEmail(studentDTO.getEmail()) != null){
            errors.rejectValue("email","Email has been already in use");
        }

    }
}
