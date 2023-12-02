package edu.mondragon.mikel_murua.repartidores4.zzz_seguridad;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

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
