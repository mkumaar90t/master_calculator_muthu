package PageObjectModel;

import BaseClass.CommonBaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BorrowingCalculatorPage extends CommonBaseClass {
    public static By calculatePageHeader = By.className("text--white");
    public static By applicationTypeSingle = By.xpath("//label[@for='application_type_single']");
    public static By applicationTypeJoint = By.xpath("//label[@for='application_type_joint']");
    public static By noOfDependantsDropDown = By.xpath("//*[@title='Number of dependants']");
    public static By homeToLiveIn = By.xpath("//*[@for='borrow_type_home']");
    public static By residentialInvestment = By.xpath("//*[@for='borrow_type_investment']");
    public static By incomeField = By.xpath("//*[@aria-labelledby='q2q1']");
    public static By jointApplicantIncomeField = By.xpath("//*[@aria-labelledby='q2q3']");
    public static By otherIncomeField = By.xpath("//*[@aria-labelledby='q2q2']");
    public static By jointApplicantOtherIncomeField = By.xpath("//*[@aria-labelledby='q2q4']");
    public static By livingExpenseField = By.id("expenses");
    public static By homeLoanRepaymentField = By.id("homeloans");
    public static By otherLoanRepaymentField = By.id("otherloans");
    public static By otherCommitmentsField = By.xpath("//*[@aria-labelledby='q3q4']");
    public static By creditCardLimitsField = By.id("credit");
    public static By borrowButton = By.xpath("//*[contains(@class, 'btn--borrow__calculate')]");
    public static By borrowAmount = By.className("borrow__result__text__amount");
    public static By startOverButton = By.className("start-over");
    public static By singleApplicantRadioButton = By.xpath("//*[@aria-labelledby='q1q1']/li[1]");
    public static By jointApplicantRadioButton = By.xpath("//*[@aria-labelledby='q1q1']/li[2]");
    public static By livingPurposeRadioButton = By.xpath("//*[@aria-labelledby='q1q3']/li[1]");
    public static By investmentPurposeRadioButton = By.xpath("//*[@aria-labelledby='q1q3']/li[2]");
    public static By borrowErrorMessage = By.className("borrow__" +
            "error__text");

    /**
     * This method selects the application type radio button based on the parameter passed (Single/Joint)
     * @param applicationType
     */
    public static void selectApplicationtype(String applicationType) throws InterruptedException {
        if(applicationType.contains("Single")){
            driver.findElement(applicationTypeSingle).click();
            if(driver.findElement(BorrowingCalculatorPage.singleApplicantRadioButton).getAttribute("class").equalsIgnoreCase("selected")){
                log.info("Selected application type is Single");
            }else{
                log.error("Failed to select Single application type option");
                Assert.assertTrue("Failed to select Single application type option", false);
            }
        }else{
            driver.findElement(applicationTypeJoint).click();
            if(driver.findElement(BorrowingCalculatorPage.jointApplicantRadioButton).getAttribute("class").equalsIgnoreCase("selected")){
                log.info("Selected application type is Joint");
            }else{
                log.error("Failed to select joint application type option");
                Assert.assertTrue("Failed to select joint application type option", false);
            }
        }
    }

    /**
     * This method selects the no of Dependants for the drop down field
     * @param dependants
     */
    public static void selectNoOfDependants(int dependants){
        Select dependantDropDownField = new Select(driver.findElement(noOfDependantsDropDown));
        dependantDropDownField.selectByVisibleText(String.valueOf(dependants));
        if(dependantDropDownField.getFirstSelectedOption().getText().equalsIgnoreCase(String.valueOf(dependants))){
            log.info("Selected number of dependants is " + dependants);
        }else{
            log.error("Failed to select no dependants");
            Assert.assertTrue("Failed to select no dependants", false);
        }
    }

    /**
     * This method selects the purpose of property buy based on the parameter passed (Live/Investment)
     * @param purpose
     */
    public static void selectPurposeOfBuy(String purpose) throws InterruptedException {
        if(purpose.contains("Live")){
            driver.findElement(homeToLiveIn).click();
            if(driver.findElement(BorrowingCalculatorPage.livingPurposeRadioButton).getAttribute("class").equalsIgnoreCase("selected")){
                log.info("Selected Property you would like to buy is Home to live in");
            }else{
                log.error("Failed to select Home to live in option");
                Assert.assertTrue("Failed to select Home to live in option", false);
            }
        }else{
            driver.findElement(residentialInvestment).click();
            if(driver.findElement(BorrowingCalculatorPage.investmentPurposeRadioButton).getAttribute("class").equalsIgnoreCase("selected")){
                log.info("Selected Property you would like to buy is Residential Investment");
            }else{
                log.error("Failed to select Residential Investment option");
                Assert.assertTrue("Failed to select Residential Investment option", false);
            }
        }
    }

    /**
     * This method enters the income amount into income text field
     * @param income
     */
    public static void enterYourIncome(int income){
        driver.findElement(incomeField).sendKeys(String.valueOf(income));
        System.out.println(driver.findElement(BorrowingCalculatorPage.incomeField).getAttribute("value"));
        System.out.println(driver.findElement(BorrowingCalculatorPage.incomeField).getAttribute("value").replace(",",""));
        if(driver.findElement(BorrowingCalculatorPage.incomeField).getAttribute("value").replace(",","").equals(String.valueOf(income))){
            log.info("Entered Income before tax is "+ income);
        }else{
            log.error("Failed to enter Income before tax");
            Assert.assertTrue("Failed to enter Income before tax", false);
        }
    }

    /**
     * This method enters the Other income amount into Other income text field
     * @param otherIncome
     */
    public static void enterOtherIncome(int otherIncome){
        driver.findElement(otherIncomeField).sendKeys(String.valueOf(otherIncome));
        if(driver.findElement(BorrowingCalculatorPage.otherIncomeField).getAttribute("value").replace(",","").equals(String.valueOf(otherIncome))){
            log.info("Entered Other Income is "+ otherIncome);
        }else{
            log.error("Failed to enter Other Income");
            Assert.assertTrue("Failed to enter Other Income", false);
        }
    }

    /**
     * This method enters the joint applicant income amount into 2nd applicant income text field
     * @param jointIncome
     */
    public static void enterJointApplicantIncome(int jointIncome){
        driver.findElement(jointApplicantIncomeField).sendKeys(String.valueOf(jointIncome));
        if(driver.findElement(BorrowingCalculatorPage.jointApplicantIncomeField).getAttribute("value").replace(",","").equals(String.valueOf(jointIncome))){
            log.info("Entered joint applicant Income before tax is "+ jointIncome);
        }else{
            log.error("Failed to enter joint applicant Income");
            Assert.assertTrue("Failed to enter joint applicant Income", false);
        }
    }

    /**
     * This method enters the joint applicant other income amount into 2nd applicant other income text field
     * @param jointOtherIncome
     */
    public static void enterJointApplicantOtherIncome(int jointOtherIncome){
        driver.findElement(jointApplicantOtherIncomeField).sendKeys(String.valueOf(jointOtherIncome));
        if(driver.findElement(BorrowingCalculatorPage.jointApplicantOtherIncomeField).getAttribute("value").replace(",","").equals(String.valueOf(jointOtherIncome))){
            log.info("Entered joint applicant Other Income is "+ jointOtherIncome);
        }else{
            log.error("Failed to enter joint applicant Other Income");
            Assert.assertTrue("Failed to enter joint applicant Other Income", false);
        }
    }

    /**
     * This method enters the expenses amount into Other expenses text field
     * @param expense
     */
    public static void enterLivingExpenses(int expense){
        driver.findElement(livingExpenseField).sendKeys(String.valueOf(expense));
        if(driver.findElement(BorrowingCalculatorPage.livingExpenseField).getAttribute("value").replace(",","").equals(String.valueOf(expense))){
            log.info("Entered Living expenses is "+ expense);
        }else{
            log.error("Failed to enter Living expenses");
            Assert.assertTrue("Failed to enter Living expenses", false);
        }
    }

    /**
     * This method enters the Home loan repayment amount into Home loan repayment text field
     * @param repayment
     */
    public static void enterHomeLoanRepayment(int repayment){
        driver.findElement(homeLoanRepaymentField).sendKeys(String.valueOf(repayment));
        if(driver.findElement(BorrowingCalculatorPage.homeLoanRepaymentField).getAttribute("value").replace(",","").equals(String.valueOf(repayment))){
            log.info("Enter Current Home loan repayment is "+ repayment);
        }else{
            log.error("Failed to enter Current Home loan repayment");
            Assert.assertTrue("Failed to enter Current Home loan repayment", false);
        }
    }

    /**
     * This method enters the Other loan repayment amount into Other loan repayment text field
     * @param otherRepayment
     */
    public static void enterOtherLoanRepayment(int otherRepayment){
        driver.findElement(otherLoanRepaymentField).sendKeys(String.valueOf(otherRepayment));
        if(driver.findElement(BorrowingCalculatorPage.otherLoanRepaymentField).getAttribute("value").replace(",","").equals(String.valueOf(otherRepayment))){
            log.info("Enter Other loan repayment is "+ otherRepayment);
        }else{
            log.error("Failed to enter Other loan repayment");
            Assert.assertTrue("Failed to enter Other loan repayment", false);
        }
    }

    /**
     * This method enters the Other Commitment amount into Other Commitment text field
     * @param otherCommitment
     */
    public static void enterOtherCommitments(int otherCommitment){
        driver.findElement(otherCommitmentsField).sendKeys(String.valueOf(otherCommitment));
        if(driver.findElement(BorrowingCalculatorPage.otherCommitmentsField).getAttribute("value").replace(",","").equals(String.valueOf(otherCommitment))){
            log.info("Enter Other Commitments is "+ otherCommitment);
        }else{
            log.error("Failed to enter Other Commitments");
            Assert.assertTrue("Failed to enter Other Commitments", false);
        }
    }

    /**
     * This method enters the total credit card limit amount into total credit card limit text field
     * @param creditCardLimit
     */
    public static void enterTotalCreditCardLimit(int creditCardLimit){
        driver.findElement(creditCardLimitsField).sendKeys(String.valueOf(creditCardLimit));
        if(driver.findElement(BorrowingCalculatorPage.creditCardLimitsField).getAttribute("value").replace(",","").equals(String.valueOf(creditCardLimit))){
            log.info("Enter Total credit card limits is "+ creditCardLimit);
        }else{
            log.error("Failed to enter Total credit card limits");
            Assert.assertTrue("Failed to enter Total credit card limits", false);
        }
    }

    /**
     * This method clicks on work out borrow button
     */
    public static void clickOnWorkOutBorrowBtn(){
        driver.findElement(borrowButton).click();
        log.info("Clicked on Work out Borrow button");
    }

    /**
     * This method clicks on Start Over button
     */
    public static void clickOnStartOverBtn(){
        driver.findElement(startOverButton).click();
        log.info("Clicked on Start over button");
    }


}
