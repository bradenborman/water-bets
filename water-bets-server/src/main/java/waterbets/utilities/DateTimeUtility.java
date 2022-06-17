package waterbets.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateTimeUtility {

    private static final DateTimeFormatter STORAGE_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");

    private static final DateTimeFormatter DATE_TIME_FORMATS = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS"))
            .appendOptional(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"))
            .toFormatter();

    public static LocalDateTime parseDate(String dateTime) {
        String slashDateTime = dateTime.replace("-", "/");
        return LocalDateTime.parse(slashDateTime, DATE_TIME_FORMATS);
    }

    public static String toStandardStorageFormat(LocalDateTime dateTime) {
        return dateTime.format(STORAGE_FORMAT);
    }

}