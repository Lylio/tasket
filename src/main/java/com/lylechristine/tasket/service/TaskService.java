package com.lylechristine.tasket.service;

import com.lylechristine.tasket.exception.TaskNotFoundException;
import com.lylechristine.tasket.model.Status;
import com.lylechristine.tasket.model.Task;
import com.lylechristine.tasket.model.TaskRequest;
import com.lylechristine.tasket.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(Status.TODO);
        task.setPosition(taskRepository.countTasksByStatus(Status.TODO));

        return taskRepository.save(task);
    }

    @Transactional
    public void changePosition(TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskRequest.getId())
                .orElseThrow(TaskNotFoundException::new);

        Long oldPosition = task.getPosition();
        Long newPosition = taskRequest.getPosition();
        Status oldStatus = task.getStatus();

        if (oldStatus.equals(taskRequest.getStatus())) {
            if (newPosition > oldPosition) {
                taskRepository.decrementAboveToPosition(newPosition, oldPosition, oldStatus, task.getId());
            } else {
                taskRepository.incrementBelowToPosition(newPosition, oldPosition, oldStatus, task.getId());
            }

            task.setPosition(taskRequest.getPosition());
            taskRepository.save(task);
        } else {
            Status newStatus = taskRequest.getStatus();

            taskRepository.decrementBelow(task.getPosition(), oldStatus, task.getId());
            taskRepository.incrementBelow(taskRequest.getPosition(), newStatus, task.getId());

            task.setPosition(taskRequest.getPosition());
            task.setStatus(taskRequest.getStatus());
            taskRepository.save(task);
        }
    }

    @Transactional
    public Task update(TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskRequest.getId())
                .orElseThrow(TaskNotFoundException::new);
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        return taskRepository.save(task);
    }

    @Transactional
    public void delete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);
        taskRepository.decrementBelow(task.getPosition(), task.getStatus(), task.getId());
        taskRepository.deleteById(id);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
