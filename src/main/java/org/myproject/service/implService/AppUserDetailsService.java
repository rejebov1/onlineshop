package org.myproject.service.implService;

import org.myproject.repository.dao.hibernateDao.UserDao;
import org.myproject.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    /*private static final Logger logger = Logger.getLogger(AppUserDetailsService.class);

    @Autowired
    private UserDao userDao;

    @Getter
    private Long userId;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.getByEmail(email);
        if(user == null){
            logger.info("While authorization User "+email+" not found");
            throw new UsernameNotFoundException(email);
        }
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .builder()
                .roles()
                .accountLocked(false)
                .accountExpired(false)
                .disabled(false)
                .password(user.getPassword())
                .username(user.getEmail())
                .authorities(buildUserAuthorities(user))
                .build();

        return userDetails;
    }

    private Collection<? extends GrantedAuthority> buildUserAuthorities(User user) {
        Set<GrantedAuthority> collector = new HashSet<>();
        collector.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return collector;
    }*/

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.getByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .builder()
                .roles()
                .accountLocked(false)
                .accountExpired(false)
                .disabled(false)
                .password(user.getPassword())
                .username(user.getEmail())
                .authorities(buildUserAuthorities(user))
                .build();

        return userDetails;
    }

    private Collection<? extends GrantedAuthority> buildUserAuthorities(User user) {
        Set<GrantedAuthority> collector = new HashSet<>();
        collector.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return collector;

        //return new AppUserDetails(user.getId());
    }
}
