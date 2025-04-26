package com.example.todo_app.service;

import com.example.todo_app.model.Task;
import com.example.todo_app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task saveTask(Task task){
        task.setCreatedAt(LocalDateTime.now());
        return  taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public void updateTaskStatus(Long id, boolean completed) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(completed);
        taskRepository.save(task);
    }

}
