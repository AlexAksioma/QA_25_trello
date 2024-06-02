package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    Logger logger = LoggerFactory.getLogger(TestNGListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("start test --> "+result.getName()+" =======================");
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("success test --> "+result.getName()+" =======================");
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("failed test --> "+result.getName()+" =======================");
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("skipped test --> "+result.getName()+" =======================");
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("start testing on date --> "+context.getStartDate()+" =======================");
        logger.info("start testing on host --> "+context.getHost()+" =======================");
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("stop testing on date --> "+context.getStartDate()+" =======================");
        ITestListener.super.onFinish(context);
    }
}
