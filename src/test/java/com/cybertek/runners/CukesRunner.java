package com.cybertek.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com/cybertek/steps"
        , dryRun =false,
//        tags = "@uc",

//        plugin = {"html:target/Destination"},
        plugin = {
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json",

        }
)
public class CukesRunner {
}
