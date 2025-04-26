package com.example.todo_app.controller;

import com.example.todo_app.model.Task;
import com.example.todo_app.repository.TaskRepository;
import com.example.todo_app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("tasks", taskService.getAllTasks());
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task){
        taskService.saveTask(task);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/updsate/{id}")
    public String updateTaskStatus(@PathVariable Long id, @RequestParam boolean completed){
        taskService.updateTaskStatus(id,completed);
        return "redirect:/";
    }


}
