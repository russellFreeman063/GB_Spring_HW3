package ru.geekbrains.homework3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.homework3.domain.User;
import ru.geekbrains.homework3.repository.UserRepository;
import ru.geekbrains.homework3.services.DataProcessingService;


import java.util.ArrayList;
import java.util.List;

@RestController("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    @GetMapping("tasks/sort")
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    //метод filterUsersByAge
    @GetMapping("tasks/filter/{age}")
    public List<User> filterUserByAge(@PathVariable("age") int age) {

        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    //метод calculateAverageAge
    @GetMapping("tasks/calc")
    public double calculateAverageAge() {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
