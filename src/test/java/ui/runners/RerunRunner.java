package ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/uiRerun.txt",
        glue = "ui/step_definitions",
        plugin = {"json:target/ui-rerun-report","rerun:target/uiRerun.txt"}
)
public class RerunRunner {
}
