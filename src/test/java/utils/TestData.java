package utils;

import com.github.javafaker.Faker;
import models.User;

import java.util.Locale;

public class TestData {

    private static final Faker faker = new Faker(Locale.ENGLISH);

    public static User randomUser() {
        long timestamp = System.currentTimeMillis();
        return new User(
                faker.name().firstName().toLowerCase() + timestamp + "@test.ru",
                faker.internet().password(6, 10),
                faker.name().firstName()
        );
    }

    public static User shortPasswordUser() {
        long timestamp = System.currentTimeMillis();
        return new User(
                faker.name().firstName().toLowerCase() + timestamp + "@test.ru",
                "12345",
                faker.name().firstName()
        );
    }
}
