package api.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "api/step_definitions",
        plugin = {"json:target/apiReport.json","rerun:target/apiRerun.txt"}
)

public class Runner {
}
