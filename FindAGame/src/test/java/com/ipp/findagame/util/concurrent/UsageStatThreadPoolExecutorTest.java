package com.ipp.findagame.util.concurrent;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class UsageStatThreadPoolExecutorTest {
  private UsageStatThreadPoolExecutor instance;


@BeforeClass
  public void beforeClass() {
//	  instance = UsageStatThreadPoolExecutor.getInstance();
  }

  @AfterClass
  public void afterClass() {
	  instance = null;
  }


  @Test(threadPoolSize=2)
  public void sumitTask() {
	  System.out.println("hello");
//    throw new RuntimeException("Test not implemented");
  }
}
