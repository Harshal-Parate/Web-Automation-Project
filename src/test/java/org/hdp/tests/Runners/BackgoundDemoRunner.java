package org.hdp.tests.Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeatureFiles/BackgroundDemo/backgroundDemo.feature",
        glue = {"org.hdp.tests.StepDefinitions.BackgroundDemoStepsDefs"},
        monochrome = true
)
public class BackgoundDemoRunner {
}