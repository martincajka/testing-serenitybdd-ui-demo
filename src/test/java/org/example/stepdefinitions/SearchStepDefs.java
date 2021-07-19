package org.example.stepdefinitions;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.Wait;
import org.example.findtrain.FindTrain;
import org.example.findtrainresults.FindTrainResultItem;

import java.time.LocalTime;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.example.findtrain.DepartureDay.today;
import static org.example.utils.XpathExp.onIndex;

public class SearchStepDefs {
    @When("he searches for train from {string} to {string}")
    public void heSearchesForTrainFromTo(String origin, String destination) {
        theActorInTheSpotlight().remember("origin", origin);
        theActorInTheSpotlight().remember("destination", destination);
        theActorInTheSpotlight().remember("currentTime", LocalTime.now());

        theActorInTheSpotlight().attemptsTo(
                FindTrain.forItinerary(origin, destination),
                Switch.toNewWindow(),
                Wait.until(
                        the(FindTrainResultItem.ORIGIN_STATION.of(today(), onIndex(1))),
                        isCurrentlyVisible()).forNoLongerThan(20).seconds()
        );
    }
}
