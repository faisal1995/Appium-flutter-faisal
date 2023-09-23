import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:build/cucumber-report.html"},
    tags = "@Account",
    snippets = SnippetType.CAMELCASE,
    glue = {"glue"},
    features = {"src/test/resources"}
)

public class RunCucumberTest {
}