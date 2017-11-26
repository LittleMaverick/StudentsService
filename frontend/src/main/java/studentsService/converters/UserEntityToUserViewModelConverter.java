package studentsService.converters;

import org.springframework.core.convert.converter.Converter;
import studentsService.beans.UserViewModel;
import studentsservice.entities.UserEntity;

public class UserEntityToUserViewModelConverter implements Converter<UserEntity, UserViewModel> {

    @Override
    public UserViewModel convert(UserEntity userEntity) {
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setId(String.valueOf(userEntity.getId()));
        userViewModel.setUsername(userEntity.getUsername());
        userViewModel.setPassword(userEntity.getPassword());
        userViewModel.setRole(userEntity.getRole());
        return userViewModel;
    }
}
