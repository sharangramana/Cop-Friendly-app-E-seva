package com.example.server.service;
import com.example.server.dao.DepartmentmemberDao;
import com.example.server.dao.DepartmentmemberDaoimplementation;
import com.example.server.model.Department_member;
//import com.example.server.dto.RegisterRequest;
//import com.example.server.model.User;
//import com.example.server.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.time.Instant.now;
import com.example.server.dto.RegisterRequest;

@Service
@AllArgsConstructor
@Slf4j
public class AuthService {

    private final DepartmentmemberDaoimplementation userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(RegisterRequest registerRequest) {
//        Department_member user = new Department_member();
//        user.setUsername(registerRequest.getUsername());
//        user.setEmail(registerRequest.getEmail());
//        user.setPassword(encodePassword(registerRequest.getPassword()));
//        user.setCreated(now());
//        user.setEnabled(false);

//        userRepository.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}

