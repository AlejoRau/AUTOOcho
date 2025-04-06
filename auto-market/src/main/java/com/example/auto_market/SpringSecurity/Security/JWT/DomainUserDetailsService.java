package com.example.auto_market.SpringSecurity.Security.JWT;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.auto_market.cliente.repository.ClienteRepository;
import com.example.auto_market.cliente.Cliente ;






@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final ClienteRepository ClienteRepository;

    public DomainUserDetailsService( ClienteRepository ClienteRepository ) {
        this.ClienteRepository = ClienteRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username ) {
        log.debug("Authenticating {}", username);
      
        Cliente cliente = ClienteRepository.findByEmail(username.toLowerCase())
        
        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + username));
    return createSpringSecurityUser(cliente);
        }
                
    

    private UserDetails createSpringSecurityUser(  Cliente cliente ) {
        List<GrantedAuthority> grantedAuthorities = 
        new ArrayList<>(cliente.getAuthorities());
        User u =  new User (cliente.getUsername(), cliente.getPassword(), grantedAuthorities) ; 
        return u;
    }

}


