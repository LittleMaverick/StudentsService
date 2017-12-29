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
import studentsservice.service.DeletionService;
import studentsservice.service.PracticeService;

import java.util.List;
import java.util.Map;
import java.sql.Date;

@Controller
public class PracticeController {

    @Autowired
    private CreationService creationService;

    @Autowired
    private EntityCreator entityCreator;

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private DeletionService deletionService;

    @Autowired
    private ConversionService conversionService;

    private final TypeDescriptor ListOfPracticeEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeEntity.class));
    private final TypeDescriptor ListOfPracticeViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeViewModel.class));

    private final TypeDescriptor practiceEntityTypeDescriptor = TypeDescriptor.valueOf(PracticeEntity.class);
    private final TypeDescriptor practiceViewModelTypeDescriptor = TypeDescriptor.valueOf(PracticeViewModel.class);

    @RequestMapping(value = "/practice", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> registerPractice(@RequestBody PracticeDTO practiceDTO) {

        PracticeEntity practiceEntity = entityCreator.getPracticeEntity(Integer.parseInt(practiceDTO.getHeadOfPracticeId()),
                practiceDTO.getCompany(), Date.valueOf(practiceDTO.getStartDate()), Date.valueOf(practiceDTO.getFinishDate()),
                Integer.parseInt(practiceDTO.getTotalQuantity()),
                Integer.parseInt(practiceDTO.getFacultyId()),
                Integer.parseInt(practiceDTO.getSpecialityId())
        );

        creationService.createPractice(practiceEntity);

        return null;
    }

    @RequestMapping(value = "/AvailablePractice", method = RequestMethod.GET)
    @ResponseBody
    public List<PracticeViewModel> getAvailablePractices() {

        List<PracticeEntity> practiceEntities = practiceService.findByStatus("Available");

        return (List<PracticeViewModel>) conversionService.convert(practiceEntities, ListOfPracticeEntityTypeDescriptor, ListOfPracticeViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/allPractices", method = RequestMethod.GET)
    @ResponseBody
    public List<PracticeViewModel> getAllPractices() {

        List<PracticeEntity> practiceEntities = practiceService.findAll();

        return (List<PracticeViewModel>) conversionService.convert(practiceEntities, ListOfPracticeEntityTypeDescriptor, ListOfPracticeViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/practices", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, String> deletePractices(@RequestBody List<String> practicesIDs) {

        for(String practiceId : practicesIDs) {
            deletionService.deletePractice(Integer.parseInt(practiceId));
        }

        return null;
    }

}