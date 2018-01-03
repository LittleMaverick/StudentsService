package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import studentsService.dto.AppointStudentsDTO;
import studentsservice.service.AppointService;
import studentsservice.service.ReleaseStudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppointStudentsController {

    @Autowired
    private AppointService appointService;

    @Autowired
    private ReleaseStudentService releaseStudentService;

    @RequestMapping(value = "/appointStudents", method = RequestMethod.POST)
    @ResponseBody
    public void assignStudents(@RequestBody AppointStudentsDTO appointStudentsDTO) {

        List<Integer> studentsIDs = new ArrayList<>();
        for (String s : appointStudentsDTO.getStudentIDs()) {
            Integer i = Integer.parseInt(s);
            studentsIDs.add(i);
        }

        appointService.appointStudent(Integer.parseInt(appointStudentsDTO.getPracticeId()), studentsIDs);
    }

    @RequestMapping(value = "/releaseStudents", method = RequestMethod.DELETE)
    @ResponseBody
    public void releaseStudents(@RequestBody List<String> studentIDs){

        for(String studentId : studentIDs){
            releaseStudentService.releaseStudent(Integer.parseInt(studentId));
        }
    }

}
