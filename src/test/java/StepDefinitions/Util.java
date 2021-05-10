package StepDefinitions;

import BaseClass.CommonBaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Util extends CommonBaseClass {

    public static String scenarioName;
    public static Scenario scenario;

    /**
     * This method will be executed before each scenario
     * @param scenarios
     * @throws IOException
     */
    @Before
    public void before(Scenario scenarios) throws IOException {
        initialize();
        scenarioName = scenarios.getName();
        scenario = scenarios;
        log.info("================================================================================================");
        log.info("======== Scenario Name: " + scenarioName + " ========");
        log.info("================================================================================================");
    }

    /**
     * This method will be executed after each scenario and logs the Pass/Fail
     *
     */
    @After
    public void after(){
        if(scenario.isFailed()){
            takeScreenShot(scenario);
            log.error("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            log.error("++++++++ Failed: Scenario Name- " + scenarioName + "++++++++");
            log.error("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }else{
            log.info("------------------------------------------------------------------------------------------------");
            log.info("--------- Passed: Scenario Name- " + scenarioName + " ---------");
            log.info("------------------------------------------------------------------------------------------------");
        }
    }



}
