package com.kodilla.tasks.mapper;

import com.kodilla.tasks.domain.Task;
import com.kodilla.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class TaskMapperTest {
    @Autowired
    TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        TaskDto taskDto = new TaskDto(2L, "tytul", "cos_tam");
        Task result = taskMapper.mapToTask(taskDto);
        Assert.assertEquals("tytul", result.getTitle());
    }

    @Test
    public void testMapToTaskDto() {
        Task task = new Task(2L, "tytul", "cos_tam");
        TaskDto result = taskMapper.mapToTaskDto(task);
        Assert.assertEquals("tytul", result.getTitle());
    }

    @Test
    public void testMapToTaskDtoList() {
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(2L, "tytul", "cos_tam"));
        List<TaskDto> result = taskMapper.mapToTaskDtoList(taskList);
        Assert.assertEquals(1, result.size());
    }
}