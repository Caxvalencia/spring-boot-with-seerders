package com.example.demo.factories;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.github.javafaker.Faker;

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
        Faker faker = new Faker();

        for (int idx = 0; idx < numberUser; idx++) {
            User user = new User();

            user.setName(faker.name().fullName());
            user.setEmail(faker.internet().emailAddress());

            this.userRepository.save(user);
        }
    }
}