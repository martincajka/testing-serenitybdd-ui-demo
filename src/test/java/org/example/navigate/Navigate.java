package org.example.navigate;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navigate implements Task {
    private final AppPage page;

    public Navigate(AppPage page) {
        this.page = page;
    }

    @Override
    @Step(value = "{0} navigates to #page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(page.url())
        );
    }

    public static Navigate to(AppPage page) {
        return instrumented(Navigate.class, page);
    }
}
