package comDemoQa.testData;

import allureAttach.AllureAttach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


import static java.lang.String.format;

public class TestData {
    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";

        Configuration.browser = System.getProperty("browser_name", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "105.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");

        if (System.getProperty("selenide.remote") != null) {
            Configuration.remote = System.getProperty("selenide.remote");
        }

    }


    @AfterEach
    void addAttachments() {
        AllureAttach.screenshotAs("Screenshot");
        AllureAttach.pageSource();
        AllureAttach.browserConsoleLogs();
        if ((System.getProperty("selenide.remote") != null)) {
            AllureAttach.addVideo();
        }
    }

    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String day = faker.number().numberBetween(1, 30) + "";
    public String month = "May";

    public String year = faker.number().numberBetween(1990, 2020) + "";

    public String gender = "Male";
    public String state = "Haryana";
    public String city = "Karnal";
    public String hobbie = "Reading";
    public String subject = "Math";
    public String picture = "src/test/resources/111.jpg";
    public String adress = faker.address().fullAddress();
    public String checkPicture = "111.jpg";
    public String fullName = format("%s %s", firstName, lastName);
    public String dateOfBirth = format("%s %s,%s", day, month, year);
    public String stateAndCity = format("%s %s", state, city);
}

