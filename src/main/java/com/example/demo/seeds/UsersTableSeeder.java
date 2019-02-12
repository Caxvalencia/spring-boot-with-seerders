package com.example.demo.seeds;

import com.example.demo.factories.UserFactory;

import org.springframework.beans.factory.annotation.Autowired;

public class UsersTableSeeder extends Seeder {

    @Autowired
    private UserFactory userFactory;

    public void run() {
        this.userFactory.create(50);
    }
}