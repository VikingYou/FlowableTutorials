package org.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @ClassName CallExternalSystemDelegateExecution
 * @Description TODO
 * @Author ycd20
 * @Date 2022/4/20 18:44
 * @Version 1.0
 **/
public class CallExternalSystemDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Calling the external system for employee " +
                execution.getVariable("employee"));
    }
}
