package com.example.flowableexample.controller;

import com.example.flowableexample.model.TaskRepresentation;
import com.example.flowableexample.service.MyService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyRestController
 * @Description TODO
 * @Author user05
 * @Date 24/03/2022 11:10
 * @Version 1.0
 **/
@RestController
public class MyRestController {
    @Autowired
    private MyService myService;

    @PostMapping("/process")
    public void startProcessInstance() {
        myService.startProcesses();
    }

    @GetMapping(value = {"/tasks"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TaskRepresentation> getTasks(@RequestParam String assignee) {
        List<Task> tasks = myService.getTasks(assignee);
        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
        for (Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
        }

        return dtos;
    }
}
