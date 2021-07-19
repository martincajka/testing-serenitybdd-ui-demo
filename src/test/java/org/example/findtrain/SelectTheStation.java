package org.example.findtrain;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectTheStation implements Interaction {
    private final String station;
    private final Target inputField;

    public SelectTheStation(String station, Target inputField) {
        this.station = station;
        this.inputField = inputField;
    }

    @Override
    @Step(value = "{0} enters station '#station' to search field")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(station).into(inputField)
        );
    }

    public static StationBuilder called(String station) {
        return new StationBuilder(station);
    }


    public static class StationBuilder {
        private final String station;

        public StationBuilder(String station) {
            this.station = station;
        }

        public Interaction in(Target inputField){
            return instrumented(SelectTheStation.class,station,inputField);
        }
    }
}
