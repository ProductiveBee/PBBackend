package com.example.pbbackend.controller;

import com.example.pbbackend.model.Task;
import com.example.pbbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // returns all the tasks
    @GetMapping("/tasks")
    public String showAllTasks(Task task) {
    // fetch all the tasks for the day for this user and pass it to html
        return "Tasks";
    }

    // shows the form to add a new task
    @GetMapping("/tasks/new")
    public String showAddTaskForm() {
         return "CreateTask";
    }

    @PostMapping("/tasks")
    public @ResponseBody ResponseEntity<String> createNewTask() {
    // check if the sum of all priorities = 100
    // somehow get the user id of currently logged in user
    // loop through and save task
        taskRepository.findByUser(account_id);
        taskRepository.save(task);
        return new ResponseEntity<String>("POST added successfully!", HttpStatus.OK);
    }
}
