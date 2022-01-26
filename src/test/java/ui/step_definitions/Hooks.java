package ui.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ui.utils.DriverUtils;

public class Hooks {

    @Before
    public void setupUI(){
        DriverUtils.getDriver();
    }

    @After
    public void tearDown(){
        DriverUtils.tearDown();
    }
}
