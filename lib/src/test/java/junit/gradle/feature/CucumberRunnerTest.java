package junit.gradle.feature;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")   // Point to the folder where your feature files are located (inside src/test/resources/features)
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "junit.gradle.feature.stepdefs")  // Point to step definitions
public class CucumberRunnerTest {
}