package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import studentsService.beans.HeadOfPracticeViewModel;
import studentsService.dto.HeadMasterDTO;
import studentsService.dto.StudentDTO;
import studentsService.validation.validators.HeadMasterDTOValidator;
import studentsservice.components.EntityCreator;
import studentsservice.entities.HeadOfPracticeEntity;
import studentsservice.entities.StudentEntity;
import studentsservice.entities.UserEntity;
import studentsservice.service.CreationService;
import studentsservice.service.HeadOfPracticeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HeadOfPracticeController {

    @Autowired
    private CreationService creationService;

    @Autowired
    private EntityCreator entityCreator;

    @Autowired
    private HeadMasterDTOValidator headMasterDTOValidator;

    @Autowired
    private HeadOfPracticeService headOfPracticeService;

    @Autowired
    private ConversionService conversionService;

    private final TypeDescriptor ListOfHeadOfPracticeEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HeadOfPracticeEntity.class));
    private final TypeDescriptor ListOfHeadOfPracticeViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HeadOfPracticeViewModel.class));

    @RequestMapping(value = "/headMasterRegistration", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> headMasterRegistration(@RequestBody HeadMasterDTO headMasterDTO, BindingResult bindingResult) {

        headMasterDTOValidator.validate(headMasterDTO, bindingResult);

        if (bindingResult.hasErrors() ){
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getCode());
            }
            return errors;
        }

        UserEntity userEntity = entityCreator.getUserEntity(headMasterDTO.getRole(),
                headMasterDTO.getUsername(),
                headMasterDTO.getPassword());

        HeadOfPracticeEntity headOfPracticeEntity = entityCreator.getHeadOfPracticeEntity(headMasterDTO.getName());


        creationService.createHeadOfPractice(userEntity, headOfPracticeEntity);

        return null;
    }

    @RequestMapping(value = "/headMaster", method = RequestMethod.GET)
    @ResponseBody
    public List<HeadOfPracticeViewModel> getHeadMasters() {
        List<HeadOfPracticeEntity> headOfPracticeEntities = headOfPracticeService.findAll();
        return (List<HeadOfPracticeViewModel>) conversionService.convert(headOfPracticeEntities, ListOfHeadOfPracticeEntityTypeDescriptor, ListOfHeadOfPracticeViewModelTypeDescriptor);
    }
}
