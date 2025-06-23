package com.siigo.api.tasks;

import com.siigo.api.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateUser implements Task {

    private final int userId;
    private final User userInfo;

    public UpdateUser(int userId, User userInfo) {
        this.userId = userId;
        this.userInfo = userInfo;
    }

    public static UpdateUser withInfo(int userId, User userInfo) {
        return instrumented(UpdateUser.class, userId, userInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/users/" + userId)
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .header("x-api-key", "reqres-free-v1")
                                .body(userInfo))
        );
    }
} 