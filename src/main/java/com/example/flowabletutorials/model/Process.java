package com.example.flowabletutorials.model;

import lombok.Data;

import java.util.Date;

@Data
public class Process {
    private String executionId;
    private String processInstanceId;
    private String name;
    private String description;
    private String processDefinitionId;
    private String processDefinitionName;
    private String processDefinitionKey;
    private Date startTime;
    private String startUser;
}
