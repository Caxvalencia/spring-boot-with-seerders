package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.example.demo.seeders.Seeder;
import com.example.demo.seeders.UsersTableSeeder;

@Profile("seed")
@SpringBootApplication
public class DatabaseSeeder {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DatabaseSeeder.class, args);

        System.out.println("Finishing process...");
        System.exit(0);
    }

    @Bean
    public CommandLineRunner runner() {
        Class<?>[] seeders = { UsersTableSeeder.class };

        return new CommandLineRunner() {
            @Autowired
            private AutowireCapableBeanFactory beanFactory;

            @Override
            public void run(String... args) throws Exception {
                System.err.println("Starting seeders...");

                for (Class<?> seederReflect : seeders) {
                    System.err.println("Running seeder " + seederReflect.getSimpleName());

                    Object instance = seederReflect.getConstructor().newInstance();
                    this.beanFactory.autowireBean(instance);

                    Seeder seeder = (Seeder) instance;
                    seeder.run();
                }
            }
        };
    }

}