package org.example.findtrainresults;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.example.findtrain.DepartureDay;
import org.example.utils.XpathExp;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TheFindTrainResults {

    public static Question<List<String>> departureStationsForDay(LocalDate date){
        return stationsForDate(date, FindTrainResultItem.ORIGIN_STATION);
    }

    public static Question<List<String>> arrivalStationsForDay(LocalDate date){
        return stationsForDate(date, FindTrainResultItem.DESTINATION_STATION);
    }

    public static Question<List<LocalTime>> departureTimesForDay(LocalDate date){
        return departureArrivalTimesForDay(date, FindTrainResultItem.DEPARTURE_TIME);
    }

    public static Question<List<LocalTime>> arrivalTimesForDay(LocalDate date){
        return departureArrivalTimesForDay(date, FindTrainResultItem.ARRIVAL_TIME);
    }

    @NotNull
    private static Question<List<LocalTime>> departureArrivalTimesForDay(LocalDate date, Target timeElement) {
        return actor -> timeElement.of(DepartureDay.of(date), XpathExp.getAll()).resolveAllFor(actor).stream()
                .map(el -> LocalTime.parse(el.getText(), DateTimeFormatter.ofPattern("HH:mm")))
                .collect(Collectors.toList());
    }

    @NotNull
    private static Question<List<String>> stationsForDate(LocalDate date, Target station) {
        return actor -> station.of(DepartureDay.of(date), XpathExp.getAll()).resolveAllFor(actor).stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
