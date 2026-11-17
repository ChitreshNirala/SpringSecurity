package com.practice.basic_authentication.service;

import com.practice.basic_authentication.repository.UserDetailsRepository;
import com.practice.basic_authentication.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminUserInitializer {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initializeAdminUser() {
        return args -> {
            if (userDetailsRepository.findByUsername("admin").isEmpty()) {
                Users adminUser = new Users();
                adminUser.setUsername("admin");
                adminUser.setPassword(passwordEncoder.encode("admin123"));
                adminUser.setRole("ROLE_ADMIN");
                userDetailsRepository.save(adminUser);
                System.out.println("Default admin user created with username: admin and password: admin123");
            }
        };
    }
}
