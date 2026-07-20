package utils;

import com.github.javafaker.Faker;
import models.User;

import java.util.Locale;

public class TestData {
    private static final Faker faker = new Faker(new Locale("en"));

    public static User randomUser(){
        return new User(
                faker.internet().emailAddress(),
                faker.internet().password(6, 10),
                faker.name().firstName()
        );
    }

    public static User shortPasswordUser(){
        return new User(
                faker.internet().emailAddress(),
                "12345",
                faker.name().firstName()
        );
    }











}
