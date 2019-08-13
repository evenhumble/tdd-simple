package io.hedwig.testngcases.demotests;

import org.testng.*;

import java.util.concurrent.atomic.AtomicInteger;

public class TmpSuiteListener implements ISuiteListener,ITestListener  {

  private AtomicInteger passedCount = new AtomicInteger(0);
  public TmpSuiteListener(){
    System.out.println("init listener............");
  }

  @Override
  public void onFinish(ISuite suite) {
    System.out.println(this);
    System.out.println("Finishing TestSuite");
  }
 
  @Override
  public void onStart(ISuite suite) {
    System.out.println(this);
    System.out.println("Starting TestSuite");
  }

  @Override
  public void onTestStart(ITestResult iTestResult) {
    System.out.println(this);

  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {
    passedCount.getAndIncrement();
    System.out.println(passedCount);
  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {

  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

  }

  @Override
  public void onStart(ITestContext iTestContext) {

  }

  @Override
  public void onFinish(ITestContext iTestContext) {

  }
}
