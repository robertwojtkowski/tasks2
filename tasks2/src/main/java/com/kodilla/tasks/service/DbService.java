package com.kodilla.tasks.service;

import com.kodilla.tasks.domain.Task;
import com.kodilla.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTaskas(){
        return repository.findAll();
    }

    public Optional<Task> findById(Long id){
        return repository.findById(id);
    }

    public Task saveTask(final Task task){
        return repository.save(task);
    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
