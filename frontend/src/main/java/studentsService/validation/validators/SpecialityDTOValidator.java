package studentsService.validation.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import studentsService.dto.SpecialityDTO;
import studentsservice.service.SpecialityService;

@Component
public class SpecialityDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return SpecialityDTO.class.equals(aClass);
    }

    @Autowired
    private SpecialityService specialityService;

    @Override
    public void validate(Object obj, Errors errors) {

        SpecialityDTO specialityDTO = (SpecialityDTO) obj;

        if (specialityService.findByName(specialityDTO.getName()) != null) {
            errors.rejectValue("name", "This specialty already exists");
        }
    }
}
