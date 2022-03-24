# 流程引擎教程Flowable6.7.2
# 环境要求 JDK17+Gradle+SpringBoot+Swagger
# 请假流程Demo
``` shell
创建流程 curl -X POST "http://localhost:8045/flowable/holidayRequest/processes" -H "accept: */*" -H "Content-Type: application/json" -d "{\"employName\":\"Viking\",\"processDefinitionKey\":\"holidayRequest\",\"reason\":\"For travel\",\"requestDays\":3}"
获取审批任务  curl -X GET "http://localhost:8045/flowable/holidayRequest/6e140e52-ab0f-11ec-ab3e-2c6dc1450565/tasks" -H "accept: */*"
审批通过   curl -X POST "http://localhost:8045/flowable/holidayRequest/tasks/6e1769ba-ab0f-11ec-ab3e-2c6dc1450565?approve=true" -H "accept: */*" -d ""
```