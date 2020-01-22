package com.kodilla.tasks.controller;

import com.kodilla.tasks.domain.Task;
import com.kodilla.tasks.domain.TaskDto;
import com.kodilla.tasks.mapper.TaskMapper;
import com.kodilla.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/v1/task"})
public class TaskController {

    @Autowired
    private DbService service;

    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/getTasks"}
    )
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTaskas());
    }

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/getTask"}
    )
    public TaskDto getTask(@RequestParam Long taskId) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(service.findById(taskId).orElseThrow(TaskNotFoundException::new));
    }

    @RequestMapping(
            method = {RequestMethod.DELETE},
            value = {"/deleteTask"}
    )
    public void deleteTask(@RequestParam Long taskId) {
        service.deleteTask(taskId);
    }

    @RequestMapping(
            method = {RequestMethod.POST},
            value = {"/createTask"},
            consumes = {"application/json"}
    )
    public void createTask(@RequestBody TaskDto taskDto) {
        service.saveTask(taskMapper.mapToTask(taskDto));
    }

    @RequestMapping(
            method = {RequestMethod.PUT},
            value = {"updateTask"}
    )
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return taskMapper.mapToTaskDto(service.saveTask(taskMapper.mapToTask(taskDto)));
    }
}
