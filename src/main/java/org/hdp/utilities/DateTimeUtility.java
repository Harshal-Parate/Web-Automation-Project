package org.hdp.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtility {

    private DateTimeUtility() {}

    public static String currentDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy - hh:mm:ss");
        return dateTime.format(timeFormatter);
    }
}