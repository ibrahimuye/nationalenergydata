package com.cybertek.steps;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Hooks {


    @Before(order = 1)
    public void setUp(){
//        System.out.println("I am setting up the test from the Hooks class!!!");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // you can also add maximize screen here
    }



//    @Before(order = 2)
//    public void getTestData() {
//        ExcelUtil excelUtil = new ExcelUtil( ConfigurationReader.getProperty("filePath"),"7-2");
//        testData = excelUtil.getDataList();
//    }



    @After
    public void tearDown(Scenario scenario){
//        System.out.println("I am reporting the results");
        // I want to take screenshot when current scenario fails.
        // scenario.isFailed()  --> tells if the scenario failed or not
        if (scenario.isFailed()) {
            // this line is for taking screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // this line is adding the screenshot to the report
            scenario.embed(screenshot, "image/png");
        }

//        System.out.println("Closing driver");
//        Driver.closeDriver();
    }


}

