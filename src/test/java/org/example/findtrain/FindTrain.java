package org.example.findtrain;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.example.findtrain.FindTrainFromHomePageComponent.*;

public class FindTrain implements Task {
    private final String origin;
    private final String destination;

    public FindTrain(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    @Step(value = "{0} searches for train from #origin to #destination")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectTheStation.called(origin).in(FROM_DESTINATION),
                SelectTheStation.called(destination).in(TO_DESTINATION),
                Click.on(SEARCH_BTN)
        );
    }

    public static FindTrain forItinerary(String origin, String destination) {
        return instrumented(FindTrain.class,origin,destination);
    }

}
