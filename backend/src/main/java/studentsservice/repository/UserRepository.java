package studentsservice.repository;

import org.springframework.data.repository.CrudRepository;
import studentsservice.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

    UserEntity findByUsername(String username);
    UserEntity findByPassword(String password);
    UserEntity findByUsernameAndPasswordAndRole(String username, String password, String role);
}
