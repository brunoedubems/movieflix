package br.com.brunoedubems.movieflix.service;

import br.com.brunoedubems.movieflix.entity.User;
import br.com.brunoedubems.movieflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User save(User user) {
       String password = user.getPassword();
       user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

}
