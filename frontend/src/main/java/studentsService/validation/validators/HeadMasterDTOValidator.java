package studentsService.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import studentsService.dto.HeadMasterDTO;
import studentsservice.service.UserService;

@Component
public class HeadMasterDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return HeadMasterDTO.class.equals(aClass);
    }

    @Autowired
    private UserService userService;

    @Override
    public void validate(Object obj, Errors errors) {

        HeadMasterDTO headMasterDTO = (HeadMasterDTO) obj;

        if (userService.findByUsername(headMasterDTO.getUsername()) != null) {
            errors.rejectValue("username", "Username has been already in use");
        }
    }
}
