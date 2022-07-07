package com.cydeo.step_definitions;

/*
In the class we will be able to pass pre- & post conditions to each scenario and each step
 */

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import io.cucumber.java.sk.Tak;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import from io.cucumber.java not from junit
    @Before ()
    public void setupScenario(){
        System.out.println("====Setting up browser using cucumber @Before");
    }

    @Before()
    public void setupScenarioForLogins(){
        System.out.println("==== this will only apply to scenarios with @login tag");
    }

    @Before()  //birden fazla before yada @after yapabiliriz.
    public void setupForDatabaseScenarios(){
        System.out.println("==== this will only apply to scenarios with @db tag");
    }

    @After
    public void teardownnScenario(Scenario scenario){

        //scenario.isFailed.()  --> if scenario fails this method will return TRUE boolean value


        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }


        //BrowserUtils.sleep(5);
        Driver.closeDriver(); //tüm senariyolardan sonra driverı kapatmak için.


        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");
    }

   // @BeforeStep
    public void setupStep(){
        System.out.println("-----------> applying setup using @BeforeStep");
    }

    //@AfterStep
    public void afterStep(){
        System.out.println("-------> applying tearDown using @AfterStep");
    }



}
