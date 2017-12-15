package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import studentsService.beans.FacultyViewModel;
import studentsservice.entities.FacultyEntity;
import studentsservice.service.FacultyService;

import java.util.List;

@Controller
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private ConversionService conversionService;

    private final TypeDescriptor facultyEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyEntity.class));
    private final TypeDescriptor facultyViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyViewModel.class));


    @RequestMapping(value = "/getFaculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyViewModel> getFaculties(){
        List<FacultyEntity> facultyEntities = facultyService.findAll();
        return (List<FacultyViewModel>)
                conversionService.convert(facultyEntities, facultyEntityTypeDescriptor, facultyViewModelTypeDescriptor);
    }
}
