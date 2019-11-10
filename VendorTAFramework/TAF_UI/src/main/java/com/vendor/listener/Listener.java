package com.vendor.listener;

import lombok.extern.slf4j.Slf4j;
import org.testng.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Slf4j
public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener, IConfigurationListener {

    /**
     * This belongs to ISuiteListener and will execute before the Suite start
     */
    @Override
    public void onStart(ISuite iSuite) {
        log.info("___________________{} SUITE IS ___________________", iSuite.getName());
    }

    /**
     * This belongs to ISuiteListener and will execute before the Suite is finished
     */
    @Override
    public void onFinish(ISuite iSuite) {
        log.info("___________________{} SUITE IS ___________________\n", iSuite.getName());
    }

    /**
     * This belongs to ITestListener and will execute before starting of Test set/batch
     */
    @Override
    public void onStart(ITestContext iTestContext) {
    }

    /**
     * This belongs to ITestListener and will execute, once the Test set/batch is finished
     */
    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    /**
     * This belongs to ITestListener and will execute only when the scenario is pass
     */
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        printITestResult(iTestResult);
    }

    /**
     * This belongs to ITestListener and will execute only on the event of fail scenario
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        printITestResult(iTestResult);
    }

    /**
     * This belongs to ITestListener and will execute before the main scenario start (@Test)
     */
    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("TEST METHOD START     : {}.{} Status -> {}",
                getClassName(iTestResult.getInstanceName()), iTestResult.getName(), convertStatus(iTestResult.getStatus()));
    }

    /**
     * This belongs to ITestListener and will execute only if any of the main scenario(@Test) get skipped
     */
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("TEST METHOD SKIPPED   : {}.{} Status -> {}",
                getClassName(iTestResult.getInstanceName()), iTestResult.getName(), convertStatus(iTestResult.getStatus()));
    }

    /**
     * This belongs to ITestListener and will execute each time Test fails but is within success percentage.
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    /**
     * This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test
     */
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isConfigurationMethod())
            log.info("CONFIGURATION START   : {} Status -> {}",
                    getClassAndMethodName(iInvokedMethod.getTestMethod().getQualifiedName(), "\\."), convertStatus(iTestResult.getStatus()));
    }

    /**
     * This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test
     */
    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    @Override
    public void onConfigurationSuccess(ITestResult iTestResult) {
        log.info("CONFIGURATION FINISH  : {} Status -> {}",
                getClassAndMethodName(iTestResult.getMethod().getQualifiedName(), "\\."), convertStatus(iTestResult.getStatus()));
    }

    @Override
    public void onConfigurationFailure(ITestResult iTestResult) {
        log.info("CONFIGURATION FAILURE : {} Status -> {}",
                getClassAndMethodName(iTestResult.getMethod().getQualifiedName(), "\\."), convertStatus(iTestResult.getStatus()));
    }

    @Override
    public void onConfigurationSkip(ITestResult iTestResult) {
        log.info("CONFIGURATION SKIP    : {} Status ->",
                getClassAndMethodName(iTestResult.getMethod().getQualifiedName(), "\\."), convertStatus(iTestResult.getStatus()));
    }

    protected void printITestResult(ITestResult iTestResult) {
        log.info("TEST METHOD FINISH    : {}.{} Status -> {} ", getClassName(iTestResult.getInstanceName()), iTestResult.getName(), convertStatus(iTestResult.getStatus()));
    }

    protected String getClassAndMethodName(String qualifiedName, String sign) {
        String[] result = qualifiedName.split(sign);
        ArrayList<String> array = new ArrayList<>();
        Collections.addAll(array, result);
        return array.get(array.size() - 2) + sign.substring(1) + array.get(array.size() - 1);
    }

    private String getClassName(String getInstanceName) {
        String[] result = getInstanceName.split("\\.");
        ArrayList<String> array = new ArrayList<>();
        array.addAll(Arrays.asList(result));
        return array.get(array.size() - 1);
    }

    private String convertStatus(int status) {
        String strStatus = null;
        switch (status) {
            case ITestResult.STARTED:
                strStatus = "STARTED";
                break;
            case ITestResult.SUCCESS:
                strStatus = "SUCCESS";
                break;
            case ITestResult.FAILURE:
                strStatus = "FAILED";
                break;
            case ITestResult.SKIP:
                strStatus = "SKIPPED";
                break;
        }
        return strStatus;
    }
}
