package com.lylechristine.tasket.controller;

import com.lylechristine.tasket.model.Task;
import com.lylechristine.tasket.model.TaskRequest;
import com.lylechristine.tasket.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PutMapping("{id}")
    public Task update(@PathVariable("id") Long id, @RequestBody TaskRequest taskRequest) {
        return taskService.update(taskRequest);
    }

    @PostMapping
    public Task create(@RequestBody TaskRequest taskRequest) {
        return taskService.create(taskRequest);
    }

    @PostMapping("/position")
    public void changePosition(@RequestBody TaskRequest taskRequest) {
        taskService.changePosition(taskRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        taskService.delete(id);
    }

    @GetMapping
    public List<Task> list() {
        return taskService.getAll();
    }

}
