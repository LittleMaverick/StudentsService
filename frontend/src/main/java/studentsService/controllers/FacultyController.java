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
import studentsService.beans.FacultyViewModel;
import studentsService.dto.FacultyDTO;
import studentsService.validation.validators.FacultyDTOValidator;
import studentsservice.components.EntityCreator;
import studentsservice.entities.FacultyEntity;
import studentsservice.service.CreationService;
import studentsservice.service.FacultyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private EntityCreator entityCreator;

    @Autowired
    private CreationService creationService;

    @Autowired
    private FacultyDTOValidator facultyDTOValidator;

    private final TypeDescriptor facultyEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyEntity.class));
    private final TypeDescriptor facultyViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyViewModel.class));


    @RequestMapping(value = "/getFaculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyViewModel> getFaculties(){
        List<FacultyEntity> facultyEntities = facultyService.findAll();
        return (List<FacultyViewModel>)
                conversionService.convert(facultyEntities, facultyEntityTypeDescriptor, facultyViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/facultyRegistration", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> registerFaculty(@RequestBody FacultyDTO facultyDTO, BindingResult bindingResult) {

        facultyDTOValidator.validate(facultyDTO, bindingResult);

        if (bindingResult.hasErrors() ){
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getCode());
            }
            return errors;
        }

        FacultyEntity facultyEntity = entityCreator.getFacultyEntity(facultyDTO.getName());

        creationService.createFaculty(facultyEntity);

        return null;
    }
}
