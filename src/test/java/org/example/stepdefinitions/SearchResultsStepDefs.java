package org.example.stepdefinitions;

import io.cucumber.java.en.Then;

import java.time.LocalDate;
import java.time.LocalTime;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.example.findtrainresults.TheFindTrainResults.*;
import static org.hamcrest.Matchers.*;

public class SearchResultsStepDefs {
    @Then("he should see only valid connections with departure later than current time for selected route")
    public void heShouldSeeOnlyValidConnectionsWithDepartureLaterThanCurrentTimeForSelectedRoute() {
        String origin = theActorInTheSpotlight().recall("origin");
        String destination = theActorInTheSpotlight().recall("destination");
        LocalTime searchTime = theActorInTheSpotlight().recall("currentTime");
        LocalDate today = LocalDate.now();

        theActorInTheSpotlight().should(
            seeThat(departureStationsForDay(today), everyItem(equalTo(origin))),
            seeThat(arrivalStationsForDay(today), everyItem(equalTo(destination))),
            seeThat(departureTimesForDay(today), everyItem(greaterThanOrEqualTo(searchTime))),
            seeThat(arrivalTimesForDay(today), everyItem(greaterThan(searchTime)))
        );
    }
}
