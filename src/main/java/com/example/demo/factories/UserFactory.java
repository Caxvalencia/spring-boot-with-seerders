package com.example.demo.factories;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    @Autowired
    private UserRepository userRepository;

    public void create() {
        this.create(1);
    }

    public void create(int numberUser) {
        for (int idx = 0; idx < numberUser; idx++) {
            User user = new User();

            user.setName("name");
            user.setEmail("admin@admin.com");

            this.userRepository.save(user);
        }
    }
}