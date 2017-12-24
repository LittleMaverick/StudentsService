package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import studentsService.beans.SpecialityViewModel;
import studentsService.dto.SpecialityDTO;
import studentsService.validation.validators.SpecialityDTOValidator;
import studentsservice.components.EntityCreator;
import studentsservice.entities.SpecialityEntity;
import studentsservice.service.CreationService;
import studentsservice.service.SpecialityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private EntityCreator entityCreator;

    @Autowired
    private CreationService creationService;

    @Autowired
    private SpecialityDTOValidator specialityDTOValidator;

    private final TypeDescriptor specialityEntityTypeDescriptor = TypeDescriptor.valueOf(SpecialityEntity.class);
    private final TypeDescriptor specialityViewModelTypeDescriptor = TypeDescriptor.valueOf(SpecialityViewModel.class);

    private final TypeDescriptor ListOfSpecialityEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityEntity.class));
    private final TypeDescriptor ListOfSpecialityViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityViewModel.class));


    @RequestMapping(value = "/getSpecialities", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityViewModel> getSpecialities() {
        List<SpecialityEntity> specialityEntities = specialityService.findAll();
        return (List<SpecialityViewModel>) conversionService.convert(specialityEntities,ListOfSpecialityEntityTypeDescriptor,ListOfSpecialityViewModelTypeDescriptor);
    }

    @RequestMapping(value = "faculty/{id}/specialities", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityViewModel> getSpecialities(@PathVariable int id) {
        List<SpecialityEntity> specialityEntities = specialityService.findSpecialitiesByFacultyId(id);
        return (List<SpecialityViewModel>) conversionService.convert(specialityEntities,ListOfSpecialityEntityTypeDescriptor,ListOfSpecialityViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/registrationSpeciality", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> registerSpeciality(@RequestBody SpecialityDTO specialityDTO, BindingResult bindingResult) {


        specialityDTOValidator.validate(specialityDTO, bindingResult);

        if (bindingResult.hasErrors() ){
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getCode());
            }
            return errors;
        }

        SpecialityEntity specialityEntity = entityCreator.getSpecialityEntity(specialityDTO.getName(),Integer.parseInt(specialityDTO.getFacultyId()));

        creationService.createSpeciality(specialityEntity);
        return null;
    }

/*    @RequestMapping(value = "/specialities/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SpecialityViewModel getFacultyById(@PathVariable int id) {
        SpecialityEntity specialityEntity = specialityService.findById(id);
        return (SpecialityViewModel) conversionService.convert(specialityEntity, specialityEntityTypeDescriptor, specialityViewModelTypeDescriptor);
    }*/

}
