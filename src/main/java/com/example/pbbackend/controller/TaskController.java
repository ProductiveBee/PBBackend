package com.example.pbbackend.controller;

import com.example.pbbackend.model.Task;
import com.example.pbbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView showAddTaskForm() {
         return new RedirectView("CreateTask");
    }

    @PostMapping("/tasks")
    public @ResponseBody ResponseEntity<String> createNewTask() {

        // somehow get the user id of currently logged in user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            System.out.println("If ke andar " + username);
        } else {
            String username = principal.toString();
            System.out.println("else ke andar "+ username);
        }
        // check if the sum of all priorities = 100
        // loop through and save task
//        taskRepository.findByUser(account_id);
//        taskRepository.save(task);
        return new ResponseEntity<String>("POST added successfully!", HttpStatus.OK);
    }
}
