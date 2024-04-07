package org.hdp.Listener;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    Logger logger = LogManager.getLogger(Listeners.class);

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    public void onTestFailure (ITestResult result) {
        logger.error("Failure of test"+ result.getName(), result.getThrowable());
        Allure.step(result.getName());
    }

    public void onTestSkipped (ITestResult result) {
        logger.error("Skip of test"+ result.getName(), result.getThrowable());
        Allure.step(result.getName());
    }
}