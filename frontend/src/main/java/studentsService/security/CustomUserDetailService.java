package studentsService.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import studentsservice.entities.UserEntity;
import studentsservice.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        UserEntity userEntity = userService.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        String userName = userEntity.getUsername();
        String password = userEntity.getPassword();

        GrantedAuthority grantedAuthority = (GrantedAuthority) () -> userEntity.getRole();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(grantedAuthority);

        UserDetails details = new User(userName,password,true,true,true,true,authorities);
        return details;
    }
}
