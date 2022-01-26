package api.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/apiRerun.txt",
        glue = "api/step_definitions",
        plugin = {"json:target/api-rerun-report","rerun:target/apiRerun.txt"}
)

public class RerunRunner {
}
