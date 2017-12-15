package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import studentsService.beans.SpecialityViewModel;
import studentsservice.entities.SpecialityEntity;
import studentsservice.service.SpecialityService;

import java.util.List;

@Controller
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private ConversionService conversionService;

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

/*    @RequestMapping(value = "/specialities/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SpecialityViewModel getFacultyById(@PathVariable int id) {
        SpecialityEntity specialityEntity = specialityService.findById(id);
        return (SpecialityViewModel) conversionService.convert(specialityEntity, specialityEntityTypeDescriptor, specialityViewModelTypeDescriptor);
    }*/

}
