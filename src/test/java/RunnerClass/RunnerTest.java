package RunnerClass;


import BaseClass.CommonBaseClass;
import com.github.mkolisnyk.cucumber.runner.AfterSuite;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/report/cucumber.json",
        retryCount  = 0,
        reportPrefix = "Loan_Calculator_Result",
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        jsonUsageReport = "target/report/cucumber-usage.json",
        usageReport = true,
        toPDF = true,
        excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@passed" },
        outputFolder = "target/report")

@CucumberOptions( plugin = {"html:target/report/loanCalculator-html-report",
        "json:target/report/cucumber.json", "pretty:target/report/cucumber-pretty.txt",
        "usage:target/report/cucumber-usage.json", "junit:target/report/cucumber-results.xml",
        "com.cucumber.listener.ExtentCucumberFormatter:target/report/Extent-report.html"},
        features = {"src/test/Java/FeatureFiles/"},
        glue = {"StepDefinitions"},
        tags = {"@Calculate"})

public class RunnerTest extends CommonBaseClass {

    @AfterSuite
    public static void reporting() throws Exception {
        driver.quit();
        isBrowserOpened = false;
    }



}
