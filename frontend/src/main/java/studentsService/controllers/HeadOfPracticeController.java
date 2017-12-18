package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import studentsService.dto.HeadMasterDTO;
import studentsService.dto.StudentDTO;
import studentsservice.components.EntityCreator;
import studentsservice.entities.HeadOfPracticeEntity;
import studentsservice.entities.StudentEntity;
import studentsservice.entities.UserEntity;
import studentsservice.service.CreationService;
import studentsservice.service.HeadOfPracticeService;

import java.util.Map;

@Controller
public class HeadOfPracticeController {

    @Autowired
    private CreationService creationService;

    @Autowired
    private EntityCreator entityCreator;

    @RequestMapping(value = "/headMasterRegistration", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> headMasterRegistration(@RequestBody HeadMasterDTO headMasterDTO) {

        UserEntity userEntity = entityCreator.getUserEntity(headMasterDTO.getRole(),
                headMasterDTO.getUsername(),
                headMasterDTO.getPassword());

        HeadOfPracticeEntity headOfPracticeEntity = entityCreator.getHeadOfPracticeEntity(headMasterDTO.getName());


        creationService.createHeadOfPractice(userEntity, headOfPracticeEntity);

        return null;
    }
}
