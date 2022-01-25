package ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ui",
        glue = "ui/step_definitions",
        plugin = {"json:target/ui-rerun-report","rerun:target/uiRerun.txt"}
)
public class RerunRunner {
}
