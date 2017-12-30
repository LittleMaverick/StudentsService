package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import studentsservice.service.HeadOfPracticeService;
import studentsservice.service.StudentService;
import studentsservice.service.UserService;


import java.security.Principal;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private HeadOfPracticeService headOfPracticeService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password");
        }

        model.setViewName("login");

        return model;
    }


    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {
        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("errorMsg", user.getName() + ", у Вас нет прав доступа к этой странице.");
        } else {
            model.addObject("errorMsg", "У Вас нет прав доступа к этой странице.");
        }

        model.setViewName("/accessDenied");
        return model;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String redirectUserToPage() {
        String defaultRedirectionURL = "login";
        String defaultUserRole = "ROLE_STUDENT";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User userDetails = (User) authentication.getPrincipal();

            for (GrantedAuthority authority : userDetails.getAuthorities()) {
                defaultUserRole = authority.getAuthority();
            }

            switch (defaultUserRole) {
                case "ROLE_STUDENT": {
                    String username = userDetails.getUsername();
                    int studentId = studentService.findByUserId(userService.findByUsername(username)
                            .getId())
                            .getId();
                    defaultRedirectionURL = "redirect:/userPage/" + studentId;
                    break;
                }
                case "ROLE_ADMIN": {
                    defaultRedirectionURL = "redirect:/adminPage";
                    break;
                }
                case "ROLE_HEADMASTER": {
                    String username = userDetails.getUsername();
                    int headMasterId = headOfPracticeService.findByUserId(userService.findByUsername(username)
                            .getId())
                            .getId();
                    defaultRedirectionURL = "redirect:/headMasterPage/" + headMasterId;
                    break;
                }
            }
            return defaultRedirectionURL;
        } else {
            return defaultRedirectionURL;
        }
    }

    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public String adminPage() {
        return "adminPage";
    }

    @RequestMapping(value = "/userPage/{id}", method = RequestMethod.GET)
    public String userPage() {
        return "userPage";
    }

    @RequestMapping(value = "/headMasterPage/{id}", method = RequestMethod.GET)
    public String headMasterPage() { return "headMasterPage"; }

    @RequestMapping(value = "/studentRegistrationPage", method = RequestMethod.GET)
    public String studentRegistration() {
        return "studentRegistration";
    }

    @RequestMapping(value = "/headMasterRegistrationPage", method = RequestMethod.GET)
    public String headMasterRegistration() {
        return "headMasterRegistration";
    }

    @RequestMapping(value = "/facultyRegistrationPage", method = RequestMethod.GET)
    public String FacultyRegistration() {
        return "facultyRegistration";
    }

    @RequestMapping(value = "/specialityRegistrationPage", method = RequestMethod.GET)
    public String SpecialityRegistration() {
        return "specialityRegistration";
    }

    @RequestMapping(value = "/createPracticeRequest", method = RequestMethod.GET)
    public String PracticeRequestCreation() {
        return "practiceRequest";
    }

    @RequestMapping(value = "/practices", method = RequestMethod.GET)
    public String PracticeRequestsPage() {
        return "allPracticeRequests";
    }

}