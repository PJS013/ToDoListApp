package com.example.demo;

import com.example.demo.ToDoList.ToDo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class ToDoListAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoListAppApplication.class, args);
    }

}
