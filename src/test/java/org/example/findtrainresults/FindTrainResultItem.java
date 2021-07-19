package org.example.findtrainresults;

import net.serenitybdd.screenplay.targets.Target;

public class FindTrainResultItem {
    public static final Target ORIGIN_STATION = Target.the("Origin station displayed in train result(s) for day '{0}' ")
            .locatedBy("//*[@class='row dayConnections']//h2[contains(text(),'{0}')]//following-sibling::div{1}//tr[1]//*[@class='trainStop']");
    public static final Target DESTINATION_STATION = Target.the("Destination station displayed in train result(s) for day '{0}' ")
            .locatedBy("//*[@class='row dayConnections']//h2[contains(text(),'{0}')]//following-sibling::div{1}//tr[2]//*[@class='trainStop']");
    public static final Target DEPARTURE_TIME = Target.the("Departure time displayed in train result(s) for day '{0}' ")
            .locatedBy("//*[@class='row dayConnections']//h2[contains(text(),'{0}')]//following-sibling::div{1}//tr[1]//th");
    public static final Target ARRIVAL_TIME = Target.the("Arrival time displayed in train result(s) for day '{0}' ")
            .locatedBy("//*[@class='row dayConnections']//h2[contains(text(),'{0}')]//following-sibling::div{1}//tr[2]//th");

}
