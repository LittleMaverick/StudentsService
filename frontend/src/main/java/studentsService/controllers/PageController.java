package studentsService.controllers;

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


import java.security.Principal;

@Controller
public class PageController {

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

    @RequestMapping(value = "/redirectManager", method = RequestMethod.GET)
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
                    defaultRedirectionURL = "userPage";
                    break;
                }
                case "ROLE_ADMIN": {
                    defaultRedirectionURL = "adminPage";
                    break;
                }
                case "ROLE_HEAD_MASTER": {
                    defaultRedirectionURL = "/headMasterPage";
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

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String userPage() {
        return "userPage";
    }
}