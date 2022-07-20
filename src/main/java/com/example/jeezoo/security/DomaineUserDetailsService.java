//package com.example.jeezoo.security;
//
//import com.example.jeezoo.user.domain.UserRepository;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//
//
//@Component
//public class DomainUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public DomainUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        com.example.jeezoo.user.domain.model.User appUser = userRepository.findByUsername(username)
////                .orElseThrow(() -> new AuthenticationServiceException("username " + username + " not found"));
////
////        return User.builder()
////                .username(username)
////                .password(appUser.getPassword())
////                .roles(appUser.getRoles().toArray(new String[0]))
////                .accountExpired(false)
////                .accountLocked(false)
////                .credentialsExpired(false)
////                .disabled(false)
////                .build();
////    }
//}