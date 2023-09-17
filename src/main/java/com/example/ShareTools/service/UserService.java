package com.example.ShareTools.service;

import com.example.ShareTools.exception.NotFoundException;
import com.example.ShareTools.model.User;
import com.example.ShareTools.model.enums.Role;
import com.example.ShareTools.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String email = user.getEmail();
        if(userRepo.findByEmail(email) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("User with email: {} created", email);
        userRepo.save(user);
        return true;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void userBanOrUnban(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new NotFoundException("User with id: "+ id +" not found"));
        if(user != null) {
            user.setActive(!user.isActive());
            userRepo.save(user);
        }

    }
}
