package studentsservice.service;

import studentsservice.entities.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity save(UserEntity userEntity);

    void delete(int id);

    List<UserEntity> findAll();

    UserEntity findById(int id);

    UserEntity findByUsername(String username);

    UserEntity findByPassword(String password);

    UserEntity findByUsernameAndPasswordAndRole(String username, String password, String role);
}
