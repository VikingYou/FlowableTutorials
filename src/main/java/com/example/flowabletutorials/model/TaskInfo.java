package com.example.flowabletutorials.model;

import lombok.Data;

import java.util.Date;

@Data
public class TaskInfo {
    private String id;
    private String name;
    private String description;
    private Integer priority;
    private String assignee;
    private String processInstanceId;
    private String executionId;
    private String taskDefinitionId;
    private String processDefinitionId;
    private Date createTime;
    private String taskDefinitionKey;
}
