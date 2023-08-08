package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.expression.Sets;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class MyUserDetailService implements UserDetailsService {
    private final
    UserAccount_Repository userAccountRepository;

    
    public MyUserDetailService(UserAccount_Repository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
    	UserAccount_Pojo userAccount = userAccountRepository.findByUsername(username);
        if (userAccount == null || !userAccount.isEstaActivo()) {
            throw new UsernameNotFoundException("User with username [" + username + "] not found in the system");
        }
        
        return new User( userAccount.getUsername(),userAccount.getContrasena(),userAccount.getListaRoles());
    }
  
    
}
