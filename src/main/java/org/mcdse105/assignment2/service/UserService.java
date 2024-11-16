package org.mcdse105.assignment2.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mcdse105.assignment2.entity.User;
import org.mcdse105.assignment2.repository.RoleRepository;
import org.mcdse105.assignment2.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public User registerNewUser(User user) {
        // salt user password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String saltPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(saltPassword);

        user.addRoles(roleRepository.findByName("USER")); // add default role: USER

        return userRepository.save(user);
    }

    public boolean verifyEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}