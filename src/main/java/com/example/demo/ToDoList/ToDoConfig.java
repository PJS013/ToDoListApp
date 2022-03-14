package com.example.demo.ToDoList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ToDoConfig {
    @Bean
    CommandLineRunner commandLineRunner(ToDoRepository repository) {
        return args -> {
            ToDo task1 = new ToDo(
                    1,
                    "First task",
                    "Very first task",
                    LocalDate.of(2022, Month.MARCH, 13));
            ToDo task2 = new ToDo(
                    2,
                    "Second task",
                    "The second task",
                    LocalDate.of(2022, Month.MARCH, 13));
            repository.saveAll(List.of(task1, task2));
        };
    }
}
