package com.siigo.api.tasks;

import com.siigo.api.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUser implements Task {

    private final User userInfo;

    public CreateUser(User userInfo) {
        this.userInfo = userInfo;
    }

    public static CreateUser withInfo(User userInfo) {
        return instrumented(CreateUser.class, userInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/users")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(userInfo))
        );
    }
} 