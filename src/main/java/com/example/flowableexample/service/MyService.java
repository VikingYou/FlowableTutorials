package com.example.flowableexample.service;

import com.example.flowableexample.model.Person;
import com.example.flowableexample.repository.PersonRepository;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MyService
 * @Description TODO
 * @Author user05
 * @Date 24/03/2022 11:07
 * @Version 1.0
 **/
@Service
@Transactional
public class MyService {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private PersonRepository personRepository;

    public void startProcesses(String assignee) {
        Person person = personRepository.findByUsername(assignee);
        Map<String ,Object> variables = new HashMap<>();
        variables.put("person",person);
        runtimeService.startProcessInstanceByKey("oneTaskProcess",variables);
    }

    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssigned().list();
    }

    public void createDemoUsers(){
        if (personRepository.findAll().size() ==0){
//            personRepository.save(new Person("jbarrez","Joram","Barrez",new Date()));
        }
    }

}
