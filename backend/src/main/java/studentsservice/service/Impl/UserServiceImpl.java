package studentsservice.service.Impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentsservice.entities.UserEntity;
import studentsservice.repository.UserRepository;
import studentsservice.service.UserService;

import java.util.List;

@Service("jpaUserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    public UserEntity save(UserEntity userEntity) {

        return userRepository.save(userEntity);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    @Transactional
    public List<UserEntity> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Transactional
    public UserEntity findById(int id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public UserEntity findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    @Transactional
    public UserEntity findByUsernameAndPasswordAndRole(String username, String password, String role) {
        return userRepository.findByUsernameAndPasswordAndRole(username, password, role);
    }
}
