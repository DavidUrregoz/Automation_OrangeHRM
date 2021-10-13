package co.com.sofka.runner.orangehrmlogin;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        features = {"src/test/resources/features/webui/orangehrmlogin/login.feature"},
        glue = {"co.com.sofka.stepdefinition.orangehrm.opt1"},
        tags = "not @ignore"
)
public class LoginFromCucumber {
}






