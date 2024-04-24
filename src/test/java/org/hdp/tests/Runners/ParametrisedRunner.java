package org.hdp.tests.Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeatureFiles",
        glue = {"org.hdp.tests.StepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "html:src/test/resources/CucumberHtmlReports/HtmlCucumber"},
        tags = "@parameters"
)
public class ParametrisedRunner {}
