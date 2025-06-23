package com.siigo.api.features;

import com.siigo.api.models.User;
import com.siigo.api.questions.ResponseCode;
import com.siigo.api.tasks.CreateUser;
import com.siigo.api.tasks.GetUsers;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SerenityJUnit5Extension.class)
public class UsersApiTest {

    private static final String BASE_URL = "https://reqres.in/api";

    @Test
    public void getUserListTest() {
        // Arrange
        Actor edison = Actor.named("Edison the API Tester")
                .whoCan(CallAnApi.at(BASE_URL));

        // Act
        edison.attemptsTo(
                GetUsers.fromPage(2)
        );

        // Assert
        edison.should(
                seeThat("The response code", ResponseCode.was(), equalTo(200))
        );
    }

    @Test
    public void createUserTest() {
        // Arrange
        Actor edison = Actor.named("Edison the API Tester")
                .whoCan(CallAnApi.at(BASE_URL));

        User user = User.anUser()
                .withName("Edison")
                .andJob("QA Automation")
                .build();

        // Act
        edison.attemptsTo(
                CreateUser.withInfo(user)
        );

        // Assert
        edison.should(
                seeThat("The response code", ResponseCode.was(), equalTo(201))
        );
    }
} 