package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles/SportsNews.feature",glue="stepDefinition",dryRun=false)
public class SportsNewsTest {

}
