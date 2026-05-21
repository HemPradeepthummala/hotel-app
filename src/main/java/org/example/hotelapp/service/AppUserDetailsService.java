package org.example.hotelapp.service;


import org.example.hotelapp.model.User;
import org.example.hotelapp.repository.UserRepository;
import org.example.hotelapp.view.SignUpRequest;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;
  private final IdGenerator idGenerator;

  public AppUserDetailsService(UserRepository userRepository, IdGenerator idGenerator) {
    this.userRepository = userRepository;
    this.idGenerator = idGenerator;
  }

  @Override
  public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
    UserDetails userDetails = userRepository.findUserByUsername(username);
    if (userDetails == null) throw new UsernameNotFoundException("user doesn't exist");
    return userDetails;
  }

  @Transactional
  public String registerUser(SignUpRequest userDetails) {
    User user = new User(idGenerator.generate(), userDetails.username(), userDetails.password());
    this.userRepository.save(user);

    return this.userRepository.findUserIdByUsername(userDetails.username());
  }

  @Bean
  public PasswordEncoder passWordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
