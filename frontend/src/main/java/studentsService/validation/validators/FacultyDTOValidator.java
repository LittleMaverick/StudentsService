package studentsService.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import studentsService.dto.FacultyDTO;
import studentsservice.service.FacultyService;

@Component
public class FacultyDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return FacultyDTO.class.equals(aClass);
    }

    @Autowired
    private FacultyService facultyService;

    @Override
    public void validate(Object obj, Errors errors) {

        FacultyDTO facultyDTO = (FacultyDTO) obj;

        if (facultyService.findByName(facultyDTO.getName()) != null) {
            errors.rejectValue("name", "This faculty already exists");
        }
    }
}
