package org.example.findtrain;


import net.serenitybdd.screenplay.targets.Target;

public class FindTrainFromHomePageComponent {
    public static final Target FROM_DESTINATION = Target.the("origin input field")
            .locatedBy("#vyhladanie-spojenia input[name=from]");
    public static final Target TO_DESTINATION = Target.the("destination input field")
            .locatedBy("#vyhladanie-spojenia input[name=to]");
    public static final Target SEARCH_BTN = Target.the("search button")
            .locatedBy("#vyhladanie-spojenia button.vyhladat.sp");

}
