package comDemoQa.testData;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Locale;

import static java.lang.String.format;

public class TestData {


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

