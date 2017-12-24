package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import studentsService.beans.PracticeViewModel;
import studentsService.dto.PracticeDTO;
import studentsservice.components.EntityCreator;
import studentsservice.entities.PracticeEntity;
import studentsservice.service.AppointService;
import studentsservice.service.CreationService;
import studentsservice.service.PracticeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PracticeController {

    @Autowired
    private CreationService creationService;

    @Autowired
    private EntityCreator entityCreator;

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private AppointService appointService;

    private final TypeDescriptor ListOfPracticeEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeEntity.class));
    private final TypeDescriptor ListOfPracticeViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeViewModel.class));

    private final TypeDescriptor practiceEntityTypeDescriptor = TypeDescriptor.valueOf(PracticeEntity.class);
    private final TypeDescriptor practiceViewModelTypeDescriptor = TypeDescriptor.valueOf(PracticeViewModel.class);


    @RequestMapping(value = "/practice", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> registerPractice(@RequestBody PracticeDTO practiceDTO) {

/*        UserEntity userEntity = entityCreator.getUserEntity(studentDTO.getRole(),
                studentDTO.getUsername(),
                studentDTO.getPassword());

        StudentEntity studentEntity = entityCreator.getStudentEntity(studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getEmail(),
                Integer.parseInt(studentDTO.getSpeciality()),
                Integer.parseInt(studentDTO.getGroupNumber()));*/


       // creationService;
        return null;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public void test() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);


        appointService.AppointStudent(1, list);
    }
}
