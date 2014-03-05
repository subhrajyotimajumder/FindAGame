package com.ipp.findagame.util.concurrent;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * When Queue is full later object will
 * be flooded those will capture here
 * @author Subhrajyoti
 *
 */
public class UsageStatRejectedExecutionHandler implements RejectedExecutionHandler{
    @Override
    public void rejectedExecution(Runnable runnable,
            ThreadPoolExecutor executor){
    	//TODO rejection Handle explicitly
        System.out.println(runnable.toString() + " : I've been rejected ! ");
    }
}