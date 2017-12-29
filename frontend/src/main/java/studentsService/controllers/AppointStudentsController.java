package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import studentsService.dto.AppointStudentsDTO;
import studentsservice.service.AppointService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppointStudentsController {

    @Autowired
    private AppointService appointService;

    @RequestMapping(value = "/appointStudents", method = RequestMethod.POST)
    @ResponseBody
    public void assignStudents(@RequestBody AppointStudentsDTO appointStudentsDTO) {

        List<Integer> studentsIDs = new ArrayList<>();
        for (String s : appointStudentsDTO.getStudentIDs()) {
            Integer i = Integer.parseInt(s);
            studentsIDs.add(i);
        }

        appointService.AppointStudent(Integer.parseInt(appointStudentsDTO.getPracticeId()), studentsIDs);
    }
}
