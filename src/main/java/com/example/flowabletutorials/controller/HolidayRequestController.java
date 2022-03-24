package com.example.flowabletutorials.controller;

import com.example.flowabletutorials.service.Impl.HolidayRequestServiceImpl;
import com.example.flowabletutorials.model.HolidayRequestProcess;
import com.example.flowabletutorials.model.TaskInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "假期流程接口列表")
@RestController
@RequestMapping("flowable/holidayRequest")
public class HolidayRequestController {
    @Autowired
    private HolidayRequestServiceImpl holidayRequestService;

    @ApiOperation("接口测试，返回Hello+name")
    @GetMapping(value = {"/hello"})
    public String hello(@RequestParam(value = "name") String name) {
        return holidayRequestService.hello(name);
    }

    @ApiOperation("创建流程")
    @PostMapping(value = {"/processes"})
    public HolidayRequestProcess createProcess(@RequestBody HolidayRequestProcess process) {
        HolidayRequestProcess holidayRequestProcess = holidayRequestService.createHolidayRequestProcess(process);

        return holidayRequestProcess;
    }

    @ApiOperation("删除流程")
    @DeleteMapping(value = {"/processes/{pid}"})
    public void deleteProcess(@PathVariable String pid) {
        holidayRequestService.deleteProcessByProcessInstanceId(pid);
    }

    @ApiOperation("查询所有流程")
    @GetMapping(value = {"/processes/all"})
    public List<HolidayRequestProcess> getAllProcesses() {
        List<HolidayRequestProcess> holidayRequestProcess = holidayRequestService.getAllProcesses();

        return holidayRequestProcess;
    }

    @ApiOperation("查询运行中的流程")
    @GetMapping(value = {"/processes/running"})
    public List<HolidayRequestProcess> getRunningProcesses() {
        List<HolidayRequestProcess> holidayRequestProcesses = holidayRequestService.getRunningProcesses();

        return holidayRequestProcesses;
    }

    @ApiOperation("查询结束的流程")
    @GetMapping(value = {"/processes/finished"})
    public List<HolidayRequestProcess> getFinishedProcesses() {
        List<HolidayRequestProcess> holidayRequestProcesses = holidayRequestService.getFinishedProcesses();

        return holidayRequestProcesses;
    }

    @ApiOperation("根据定义key查询流程")
    @GetMapping(value = {"/processes/definitionKey"})
    public List<HolidayRequestProcess> getProcessesByDefinitionKey(@RequestParam("processDefinitionKey") String processDefinitionKey) {
        List<HolidayRequestProcess> holidayRequestProcesses = holidayRequestService.getProcessesByDefinitionKey(processDefinitionKey);

        return holidayRequestProcesses;
    }

    @ApiOperation("根据流程ID查询流程")
    @GetMapping(value = {"/processes/instanceId"})
    public List<HolidayRequestProcess> getProcessByProcessInstanceId(@RequestParam("processInstanceId") String processInstanceId) {
        List<HolidayRequestProcess> holidayRequestProcesses = holidayRequestService.getProcessesByProcessInstanceId(processInstanceId);

        return holidayRequestProcesses;
    }

    @ApiOperation("流程启动")
    @GetMapping(value = {"/processes/starter"})
    public List<HolidayRequestProcess> getProcessesByStarter(@RequestParam("starter") String starter) {
        List<HolidayRequestProcess> holidayRequestProcesses = holidayRequestService.getProcessesByStarter(starter);

        return holidayRequestProcesses;
    }

    @ApiOperation("根据流程id查询任务")
    @GetMapping(value = {"/{pid}/tasks"})
    public List<TaskInfo> getTasksInProcess(@PathVariable String pid) {
        List<TaskInfo> tasks = holidayRequestService.queryTasksInProcess(pid);

        return tasks;
    }

    @ApiOperation("查询任务处理人")
    @GetMapping(value = {"/tasks/assignee"})
    public List<TaskInfo> getTasksByAssignee(@RequestParam("assignee") String assignee) {
        List<TaskInfo> tasks = holidayRequestService.queryTasksByAssignee(assignee);

        return tasks;
    }

    @ApiOperation("根据候选人查询任务组列表")
    @GetMapping(value = {"/tasks/group"})
    public List<TaskInfo> getTaskByCandidateGroup(@RequestParam("candidateGroup") String candidateGroup) {
        List<TaskInfo> tasks = holidayRequestService.queryTasksByCandidateGroup(candidateGroup);

        return tasks;
    }

    @ApiOperation("根据候选人列表查询任务组列表")
    @GetMapping(value = {"/tasks/groups"})
    public List<TaskInfo> getTaskByTaskId(@RequestParam("candidateGroup") List<String> candidateGroups) {
        List<TaskInfo> tasks = holidayRequestService.queryTasksByCandidateGroups(candidateGroups);

        return tasks;
    }

    @ApiOperation("根据任务ID查询任务列表")
    @GetMapping(value = {"/tasks/taskId"})
    public List<TaskInfo> getTasksByTaskId(@RequestParam("taskId") String taskId) {
        List<TaskInfo> tasks = holidayRequestService.queryTasksByTaskID(taskId);

        return tasks;
    }

    @ApiOperation("根据任务ID处理任务")
    @PostMapping(value = {"/tasks/{taskId}"})
    public void handleTask(@PathVariable String taskId, @RequestParam Boolean approve) {
        holidayRequestService.handleTask(taskId, approve);
    }

}
