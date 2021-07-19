package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import org.example.navigate.Navigate;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.example.navigate.AppPage.HOME_PAGE_SK;

public class NavigateStepDefs {
    @Given("that {string} decides to search for train connection")
    public void thatJohnDecidesToSearchForTrainConnection(String personaName) {
        theActorCalled(personaName).attemptsTo(
              Navigate.to(HOME_PAGE_SK)
        );
    }
}
