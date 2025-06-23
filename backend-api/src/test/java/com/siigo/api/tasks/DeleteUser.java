package com.siigo.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUser implements Task {

    private final int userId;

    public DeleteUser(int userId) {
        this.userId = userId;
    }

    public static DeleteUser withId(int userId) {
        return instrumented(DeleteUser.class, userId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/users/" + userId)
                        .with(request -> request.header("x-api-key", "reqres-free-v1"))
        );
    }
} 