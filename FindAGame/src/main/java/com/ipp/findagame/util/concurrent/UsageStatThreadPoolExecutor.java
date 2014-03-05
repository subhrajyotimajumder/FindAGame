package com.ipp.findagame.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UsageStatThreadPoolExecutor implements Cloneable{
	//this needs to configure in properties file
	int  corePoolSize  =    10;
    int  maxPoolSize   =   20;
    long keepAliveTime = 600;
    int initialQueueSize = 1000;
    private ExecutorService executorService = null;

    private UsageStatThreadPoolExecutor() {
        
        setExecutorService(new ThreadPoolExecutor(corePoolSize, maxPoolSize, 
        		keepAliveTime,TimeUnit.SECONDS,
        		new LinkedBlockingQueue<Runnable>(initialQueueSize),
        		new UsageStatRejectedExecutionHandler()));
        
    }
    private static UsageStatThreadPoolExecutor INSTANCE = new UsageStatThreadPoolExecutor();
    
    public static synchronized UsageStatThreadPoolExecutor getInstance() {
    	if(INSTANCE==null){
				INSTANCE = new UsageStatThreadPoolExecutor();
    	}
    	return INSTANCE;
	}
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException("Singleton class");
    }
    
    /**
     * Accept json data
     */
    public void sumitTask(String usageStatJson){
    	executorService.submit(new UsageStatCallable(usageStatJson));
    }
    
    /**
     * 
     * @return
     */
	public ExecutorService getExecutorService() {
		return null;
	}
	/**
	 * false method
	 * @param executorService
	 */
	public void setExecutorService(ExecutorService executorService) {
		
	}
}
