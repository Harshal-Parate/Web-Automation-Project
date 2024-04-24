package org.hdp.tests.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeatureFiles",
        glue = {"org.hdp.tests.StepDefinitions"},
        monochrome = true, // More formatted view
        plugin = {"pretty", "html:src/test/resources/CucumberHtmlReports/HtmlCucumber"},
        //tags = "@SmokeTest"
        tags = "@GoogleFeature"
)
public class LoginRunner {}