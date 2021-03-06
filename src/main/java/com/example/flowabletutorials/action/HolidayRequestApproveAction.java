package com.example.flowabletutorials.action;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

@Slf4j
public class HolidayRequestApproveAction implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        log.info("Holiday request is approved.");
    }
}
