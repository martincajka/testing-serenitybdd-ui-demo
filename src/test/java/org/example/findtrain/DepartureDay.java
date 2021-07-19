package org.example.findtrain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DepartureDay {

    public static String of(LocalDate localDateTime) {
        if (LocalDate.now().equals(localDateTime)) {
            return "Dnes";
        } else if (LocalDate.now().plusDays(1).equals(localDateTime)) {
            return "Zajtra - " + localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } else if (LocalDate.now().minusDays(1).equals(localDateTime)) {
            return "Včera - " + localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
        return localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String today(){
        return of(LocalDate.now());
    }

    public static String tomorrow(){
        return of(LocalDate.now().plusDays(1));
    }

    public static String yesterday(){
        return of(LocalDate.now().minusDays(1));
    }


}
