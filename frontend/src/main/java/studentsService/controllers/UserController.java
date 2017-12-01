package studentsService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import studentsService.beans.UserViewModel;
import studentsservice.entities.UserEntity;
import studentsservice.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserService userService;

    private final TypeDescriptor userEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserEntity.class));
    private final TypeDescriptor userViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserViewModel.class));

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserViewModel> getAllUsers() {
        List<UserEntity> allUsers = userService.findAll();
        return (List<UserViewModel>) conversionService.convert(allUsers, userEntityTypeDescriptor, userViewModelTypeDescriptor);
    }
}
