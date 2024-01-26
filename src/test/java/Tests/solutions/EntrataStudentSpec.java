package Tests.solutions;

import Tests.base_test.BaseTest;
import drivers.GlobalSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import page_objects.*;
import util.GeneralModule;
import util.PropertiesReader;

public class EntrataStudentSpec extends BaseTest {

    @Test
    public void test_user_can_enter_the_form_details_to_request_demo_for_student() {
        GlobalSpecification.setup();
        driver = GlobalSpecification.driver;
        generalMod = new GeneralModule();
        HomePage homePage = new HomePage(driver);
        StudentPage studentPage = new StudentPage(driver);
        WatchDemoPage watchDemoPage = new WatchDemoPage(driver);
        // Navigate to home page
        homePage.navigateToHomePage();
        // Accept cookie popup
        homePage.handleCookiePopup();
        // Select student from solutions dropdoen
        homePage.selectDropdownOptionFromMenu("Solutions", "Student");
        // Verify student page heading is displayed
        assertTrue("Entrata Student Page Heading is not displayed", generalMod.verifyElementIsDisplayed(studentPage.entrataStudentHeading));
        // click on watch demo button
        generalMod.clickOnWatchDemoBtn();
        // enter the form details
        generalMod.enterValueByLabel("First Name", "Test User");
        generalMod.enterValueByLabel("Last Name", "Test User Last Name");
        generalMod.enterValueByLabel("Email", "test@gmail.com");
        generalMod.enterValueByLabel("Company Name", "Entrata Test Automation");
        generalMod.enterValueByLabel("Phone Number", "10101019292");
        generalMod.selectValueFromDropdown(watchDemoPage.unitCountDropdown, "101 - 200");
        generalMod.enterValueByLabel("Job Title:", "SDET");

        // verify details are entered
        verifyInputValueByLabel("First Name", "Test User");
        verifyInputValueByLabel("First Name", "Test User");
        verifyInputValueByLabel("Last Name", "Test User Last Name");
        verifyInputValueByLabel("Email", "test@gmail.com");
        verifyInputValueByLabel("Company Name", "Entrata Test Automation");
        verifyInputValueByLabel("Phone Number", "10101019292");
        verifyInputValueByLabel("Job Title:", "SDET");
    }

    @Test
    public void test_user_can_enter_the_form_details_to_request_job_costing() {
        GlobalSpecification.setup();
        driver = GlobalSpecification.driver;
        generalMod = new GeneralModule();
        HomePage homePage = new HomePage(driver);
        JobCostingPage jobCostingPage = new JobCostingPage(driver);
        WatchDemoPage watchDemoPage = new WatchDemoPage(driver);
        homePage.navigateToHomePage();
        homePage.handleCookiePopup();
        homePage.selectDropdownOptionFromMenu("Products", "Job Costing");
        assertTrue("Job Costing Page Heading is not displayed", generalMod.verifyElementIsDisplayed(jobCostingPage.jobCostingHeading));

        generalMod.clickOnWatchDemoBtn();
        generalMod.enterValueByLabel("First Name", "Test User");
        generalMod.enterValueByLabel("Last Name", "Test User Last Name");
        generalMod.enterValueByLabel("Email", "test@gmail.com");
        generalMod.enterValueByLabel("Company Name", "Entrata Test Automation");
        generalMod.enterValueByLabel("Phone Number", "10101019292");
        generalMod.selectValueFromDropdown(watchDemoPage.unitCountDropdown, "101 - 200");
        generalMod.enterValueByLabel("Job Title:", "SDET");

        verifyInputValueByLabel("First Name", "Test User");
        verifyInputValueByLabel("First Name", "Test User");
        verifyInputValueByLabel("Last Name", "Test User Last Name");
        verifyInputValueByLabel("Email", "test@gmail.com");
        verifyInputValueByLabel("Company Name", "Entrata Test Automation");
        verifyInputValueByLabel("Phone Number", "10101019292");
        verifyInputValueByLabel("Job Title:", "SDET");
    }

    @Test
    public void test_user_login_functionality() {
        GlobalSpecification.setup();
        driver = GlobalSpecification.driver;
        generalMod = new GeneralModule();
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        homePage.navigateToHomePage();
        homePage.handleCookiePopup();
        generalMod.clickOnSignInBtn();
        signInPage.selectUserLoginType("Property Manager Login");
        String userName = PropertiesReader.getCustomConfigValue("username");
        String password = PropertiesReader.getCustomConfigValue("password");
        logInPage.login(userName, password);
        String errorMsg = "The username and password provided are not valid. Please try again.";
        assertTrue("Expected error message is not displayed", isElementTextEqualToExpected(logInPage.invalidCredentialsErrorMsg, errorMsg));
    }


    @AfterTest
    public static void closeDriver() {
        GlobalSpecification.teardown();
    }
}
