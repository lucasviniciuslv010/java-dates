package java_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/* java.time -> The main API for dates, times, instants, and durations.
The classes defined here represent the principle date-time concepts, including instants, durations, dates, times,
time-zones and periods. They are based on the ISO calendar system, which is the de facto world calendar following the
proleptic Gregorian rules. All the classes are immutable and thread-safe.

-> Documentation:
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/package-summary.html */

public class Program {

    public static void main(String[] args) {

        System.out.println("-----------------------------------------------------------------------------------------");
        /* ZoneId -> A time-zone ID, such as Europe/Paris.
        A ZoneId is used to identify the rules used to convert between an Instant and a LocalDateTime.
        There are two distinct types of ID:

        * Fixed offsets - a fully resolved offset from UTC/Greenwich, that uses the same offset for all local date-times
        * Geographical regions - an area where a specific set of rules for finding the offset from UTC/Greenwich apply

        Most fixed offsets are represented by ZoneOffset. Calling normalized() on any ZoneId will ensure that a fixed
        offset ID will be represented as a ZoneOffset.

        Time-zone IDs
        The ID is unique within the system. There are three types of ID.

        * The simplest type of ID is that from ZoneOffset. This consists of 'Z' and IDs starting with '+' or '-'.
        * The next type of ID are offset-style IDs with some form of prefix, such as 'GMT+2' or 'UTC+01:00'. The recognised
        prefixes are 'UTC', 'GMT' and 'UT'. The offset is the suffix and will be normalized during creation. These IDs can
        be normalized to a ZoneOffset using normalized().
        * The third type of ID are region-based IDs. A region-based ID must be of two or more characters, and not start
        with 'UTC', 'GMT', 'UT' '+' or '-'. Region-based IDs are defined by configuration, see ZoneRulesProvider.
        The configuration focuses on providing the lookup from the ID to the underlying ZoneRules.

        The equals method should be used for comparisons.

        -> Documentation:
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/ZoneId.html */

        ZoneId zone1 = ZoneId.of("+02:00");
        ZoneId zone2 = ZoneId.of("UTC");
        ZoneId zone3 = ZoneId.of("America/New_York");
        ZoneId zone4 = ZoneId.systemDefault();

        System.out.println("ZoneId 1: " + zone1);
        System.out.println("ZoneId 2: " + zone2);
        System.out.println("ZoneId 3: " + zone3);
        System.out.println("ZoneId 4: " + zone4);
        System.out.println();
        System.out.println("ZoneId 1 normalized: " + zone1.normalized() + " -> ZoneOffSet");
        System.out.println("ZoneId 2 normalized: " + zone2.normalized() + " -> ZoneOffSet");
        System.out.println("ZoneId 3 normalized: " + zone3.normalized() + " -> ZoneId");
        System.out.println("ZoneId 4 normalized: " + zone4.normalized() + " -> ZoneId");
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println();


        System.out.println("-----------------------------------------------------------------------------------------");

        /* ZoneOffset -> A time-zone offset from Greenwich/UTC, such as +02:00.
        A time-zone offset is the amount of time that a time-zone differs from Greenwich/UTC. This is usually a fixed number
        of hours and minutes.
        Different parts of the world have different time-zone offsets. The rules for how offsets vary by place and time
        of year are captured in the ZoneId class.
        For example, Paris is one hour ahead of Greenwich/UTC in winter and two hours ahead in summer. The ZoneId instance
        for Paris will reference two ZoneOffset instances - a +01:00 instance for winter, and a +02:00 instance for summer.
        In 2008, time-zone offsets around the world extended from -12:00 to +14:00. To prevent any problems with that
        range being extended, yet still provide validation, the range of offsets is restricted to -18:00 to 18:00 inclusive.

        The equals method should be used for comparisons.

        -> Documentation:
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/ZoneOffset.html */

        ZoneOffset offset1 = ZoneOffset.of("+02:00");
        ZoneOffset offset2 = ZoneOffset.of("Z");
        ZoneOffset offset3 = ZoneOffset.ofHours(-5);
        ZoneOffset offset4 = zone4.getRules().getOffset(Instant.now());

        System.out.println("ZoneOffset 1: " + offset1);
        System.out.println("ZoneOffset 2: " + offset2);
        System.out.println("ZoneOffset 3: " + offset3);
        System.out.println("ZoneOffset 4: " + offset4);
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println();


        System.out.println("-----------------------------------------------------------------------------------------");

        /* DateTimeFormatter -> Formatter for printing and parsing date-time objects.
        The main date-time classes provide two methods - one for formatting, format(DateTimeFormatter formatter),
        and one for parsing, parse(CharSequence text, DateTimeFormatter formatter).

        For example:
        LocalDate date = LocalDate.now();
        String text = date.format(formatter);
        LocalDate parsedDate = LocalDate.parse(text, formatter);

        In addition to the format, formatters can be created with desired Locale, Chronology, ZoneId, and DecimalStyle.

        -> Documentation:
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/format/DateTimeFormatter.html */

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(zone2);

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(zone2);

        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(zone2);
        DateTimeFormatter dtf6 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(zone3);
        DateTimeFormatter dtf7 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(zone4);

        DateTimeFormatter dtf8 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(offset2);
        System.out.println("-----------------------------------------------------------------------------------------");

        /* LocalTime - A time without a time-zone in the ISO-8601 calendar system, such as 10:15:30.
        LocalTime is an immutable date-time object that represents a time, often viewed as hour-minute-second. Time is
        represented to nanosecond precision. For example, the value "13:45.30.123456789" can be stored in a LocalTime.

        This class does not store or represent a date or time-zone. Instead, it is a description of the local time as
        seen on a wall clock. It cannot represent an instant on the time-line without additional information such as an
        offset or time-zone.

        The equals method should be used for comparisons.

        Documentation:
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/LocalTime.html */

        LocalTime lt1 = LocalTime.now();

        // The ZoneId will be discarded after being used to calculate the time.
        LocalTime lt2 = LocalTime.now(zone3);

        LocalTime lt3 = LocalTime.of(4, 15, 30);
        LocalTime lt4 = LocalTime.parse("04:15:30");

        // LocalDateTime to LocalTime.
        LocalTime lt5 = LocalDateTime.parse("2007-12-03T04:15:30").toLocalTime();
        LocalTime lt6 = LocalDateTime.parse("03/12/2007 04:15:30", dtf4).toLocalTime();

        // The ZoneId will be discarded after being used to calculate the time.
        LocalTime lt7 = LocalTime.ofInstant(Instant.parse("2007-12-03T04:15:30Z"), zone3);

        System.out.println("LocalTime 1: " + lt1);
        System.out.println("LocalTime 2: " + lt2);
        System.out.println("LocalTime 3: " + lt3);
        System.out.println("LocalTime 4: " + lt4);
        System.out.println("LocalTime 5: " + lt5);
        System.out.println("LocalTime 6: " + lt6);
        System.out.println("LocalTime 7: " + lt7);
        System.out.println();
        System.out.println("Formatter: HH:mm:ss (UTC)");
        System.out.println("LocalTime will not be adjusted even using a formatter with timezone.");
        System.out.println("LocalTime 7: " + dtf1.format(lt7));
        System.out.println("LocalTime 7: " + lt7.format(dtf1));
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println();


        System.out.println("-----------------------------------------------------------------------------------------");

        /* LocalDate -> A date without a time-zone in the ISO-8601 calendar system, such as 2007-12-03.
        LocalDate is an immutable date-time object that represents a date, often viewed as year-month-day. Other date
        fields, such as day-of-year, day-of-week and week-of-year, can also be accessed.
        For example, the value "2nd October 2007" can be stored in a LocalDate.

        This class does not store or represent a time or time-zone. Instead, it is a description of the date, as used for
        birthdays. It cannot represent an instant on the time-line without additional information such as an offset or
        time-zone.

        The equals method should be used for comparisons.

        -> Documentation:
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/LocalDate.html */

        LocalDate ld1 = LocalDate.now();

        // The ZoneId will be discarded after being used to calculate the time.
        LocalDate ld2 = LocalDate.now(zone3);

        LocalDate ld3 = LocalDate.of(2007, 12, 3);
        LocalDate ld4 = LocalDate.parse("2007-12-03");
        LocalDate ld5 = LocalDate.parse("03/12/2007", dtf2);

        // LocalDateTime to LocalDate.
        LocalDate ld6 = LocalDateTime.parse("2007-12-03T04:15:30").toLocalDate();
        LocalDate ld7 = LocalDateTime.parse("03/12/2007 04:15:30", dtf4).toLocalDate();

        // The ZoneId will be discarded after being used to calculate the time.
        LocalDate ld8 = LocalDate.ofInstant(Instant.parse("2007-12-03T04:15:30Z"), zone3);

        System.out.println("LocalDate 1: " + ld1);
        System.out.println("LocalDate 2: " + ld2);
        System.out.println("LocalDate 3: " + ld3);
        System.out.println("LocalDate 4: " + ld4);
        System.out.println("LocalDate 5: " + ld5);
        System.out.println("LocalDate 6: " + ld6);
        System.out.println("LocalDate 7: " + ld7);
        System.out.println("LocalDate 8: " + ld8);
        System.out.println();
        System.out.println("Formatter: dd/MM/yyyy (UTC)");
        System.out.println("LocalDate will not be adjusted even using a formatter with timezone.");
        System.out.println("LocalDate 8: " + dtf3.format(ld8));
        System.out.println("LocalDate 8: " + ld8.format(dtf3));
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println();


        System.out.println("-----------------------------------------------------------------------------------------");

        /* LocalDateTime -> A date-time without a time-zone in the ISO-8601 calendar system, such as 2007-12-03T10:15:30.
        LocalDateTime is an immutable date-time object that represents a date-time, often viewed as
        year-month-day-hour-minute-second. Other date and time fields, such as day-of-year, day-of-week and week-of-year,
        can also be accessed. Time is represented to nanosecond precision.
        For example, the value "2nd October 2007 at 13:45.30.123456789" can be stored in a LocalDateTime.

        This class does not store or represent a time-zone. Instead, it is a description of the date, as used for
        birthdays, combined with the local time as seen on a wall clock. It cannot represent an instant on the time-line
        without additional information such as an offset or time-zone.

        The equals method should be used for comparisons.

        -> Documentation:
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/LocalDateTime.html */

        LocalDateTime ldt1 = LocalDateTime.now();

        // The ZoneId will be discarded after being used to calculate the time.
        LocalDateTime ldt2 = LocalDateTime.now(zone3);

        LocalDateTime ldt3 = LocalDateTime.of(2007, 12, 3, 4, 15, 30);
        LocalDateTime ldt4 = LocalDateTime.parse("2007-12-03T04:15:30");
        LocalDateTime ldt5 = LocalDateTime.parse("03/12/2007 04:15:30", dtf4);

        // The ZoneId will be discarded after being used to calculate the time.
        LocalDateTime ldt6 = LocalDateTime.ofInstant(Instant.parse("2007-12-03T04:15:30Z"), zone3);

        System.out.println("LocalDateTime Class:");
        System.out.println("LocalDateTime 1: " + ldt1);
        System.out.println("LocalDateTime 2: " + ldt2);
        System.out.println("LocalDateTime 3: " + ldt3);
        System.out.println("LocalDateTime 4: " + ldt4);
        System.out.println("LocalDateTime 5: " + ldt5);
        System.out.println("LocalDateTime 6: " + ldt6);
        System.out.println();
        System.out.println("Formatter: dd/MM/yyyy HH:mm:ss (UTC)");
        System.out.println("LocalDateTime will not be adjusted even using a formatter with timezone.");
        System.out.println("LocalDateTime 6: " + dtf5.format(ldt6));
        System.out.println("LocalDateTime 6: " + ldt6.format(dtf5));
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println();


        System.out.println("-----------------------------------------------------------------------------------------");

        /* Instant -> An instantaneous point on the time-line.
       This class models a single instantaneous point on the time-line. This might be used to record event time-stamps
       in the application.

        The range of an instant requires the storage of a number larger than a long. To achieve this, the class stores a
        long representing epoch-seconds and an int representing nanosecond-of-second, which will always be between 0 and
        999,999,999. The epoch-seconds are measured from the standard Java epoch of 1970-01-01T00:00:00Z where instants
        after the epoch have positive values, and earlier instants have negative values. For both the epoch-second and
        nanosecond parts, a larger value is always later on the time-line than a smaller value.

        The equals method should be used for comparisons.

        -> Documentation:
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/Instant.html

        Warning:
        Instant is a Stamp of time from the moment of time (UTC), a stamp of time that is relevant to the flow of
        human time, but without a time zone. Instant does not have Time Zone but can deal with it given that a Zone
        information is supplied */

        Instant instant1 = Instant.now();
        Instant instant2 = Instant.now(Clock.systemUTC());
        Instant instant3 = Instant.ofEpochMilli(System.currentTimeMillis());
        Instant instant4 = Instant.parse("2007-12-03T04:15:30Z");

        Instant instant5 = ZonedDateTime.parse("2007-12-03T04:15:30Z").toInstant();

        System.out.println("Instant 1: " + instant1 + " (UTC)");
        System.out.println("Instant 2: " + instant2 + " (UTC)");
        System.out.println("Instant 3: " + instant3 + " (UTC)");
        System.out.println("Instant 4: " + instant4 + " (UTC)");
        System.out.println("Instant 5: " + instant5 + " (UTC)");
        System.out.println();
        System.out.println("Formatter: dd/MM/yyyy HH:mm:ss (UTC) -> (America/New_York) -> (Local Time Zone)");
        System.out.println("Instant will be adjusted to the formatter time zone.");
        System.out.println("Instant 5: " + dtf5.format(instant5) + " (UTC)");
        System.out.println("Instant 5: " + dtf6.format(instant5) + " (America/New_York)");
        System.out.println("Instant 5: " + dtf7.format(instant5) + " (Local Time Zone)");
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println();


        System.out.println("-----------------------------------------------------------------------------------------");

        /* ZonedDateTime:
        A date-time with a time-zone in the ISO-8601 calendar system, such as 2007-12-03T10:15:30+01:00 Europe/Paris.

        ZonedDateTime is an immutable representation of a date-time with a time-zone. This class stores all date and
        time fields, to a precision of nanoseconds, and a time-zone, with a zone offset used to handle ambiguous local
        date-times. For example, the value "2nd October 2007 at 13:45.30.123456789 +02:00 in the Europe/Paris time-zone"
        can be stored in a ZonedDateTime.

        This class handles conversion from the local time-line of LocalDateTime to the instant time-line of Instant.
        The difference between the two time-lines is the offset from UTC/Greenwich, represented by a ZoneOffset.

        In terms of design, this class should be viewed primarily as the combination of a LocalDateTime and a ZoneId.
        The ZoneOffset is a vital, but secondary, piece of information, used to ensure that the class represents an
        instant, especially during a daylight savings overlap.

        Documentation:
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/ZonedDateTime.html */

        ZonedDateTime zdt1 = ZonedDateTime.now();
        ZonedDateTime zdt2 = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime zdt3 = ZonedDateTime.now(Clock.systemUTC());
        ZonedDateTime zdt4 = ZonedDateTime.of(ld3, lt3, ZoneId.of("UTC"));
        ZonedDateTime zdt5 = ZonedDateTime.of(ldt3, ZoneId.of("UTC"));
        ZonedDateTime zdt6 = ZonedDateTime.parse("2007-12-03T04:15:30Z");
        ZonedDateTime zdt7 = ZonedDateTime.parse("03/12/2007 04:15:30", dtf5);

        System.out.println("ZonedDateTime 1: " + zdt1);
        System.out.println("ZonedDateTime 2: " + zdt2);
        System.out.println("ZonedDateTime 3: " + zdt3);
        System.out.println("ZonedDateTime 4: " + zdt4);
        System.out.println("ZonedDateTime 5: " + zdt5);
        System.out.println("ZonedDateTime 6: " + zdt6);
        System.out.println("ZonedDateTime 7: " + zdt7);
        System.out.println();
        System.out.println("Formatter: dd/MM/yyyy HH:mm:ss (UTC) -> (America/New_York) -> (Local Time Zone)");
        System.out.println("ZonedDateTime will be adjusted to the formatter time zone.");
        System.out.println("ZonedDateTime 7: " + dtf5.format(zdt7) + " (UTC)");
        System.out.println("ZonedDateTime 7: " + dtf6.format(zdt7) + " (America/New_York)");
        System.out.println("ZonedDateTime 7: " + dtf7.format(zdt7) + " (Local Time Zone)");
        System.out.println("ZonedDateTime 7: " + dtf8.format(zdt7) + " (UTC)");
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println();


        System.out.println("-----------------------------------------------------------------------------------------");

        /* Get field values from a date(/time)

         * Enum ChronoField -> A standard set of fields.
         This set of fields provide field-based access to manipulate a date, time or date-time. The standard set of fields
         can be extended by implementing TemporalField.

         These fields are intended to be applicable in multiple calendar systems. For example, most non-ISO calendar systems
         define dates as a year, month and day, just with slightly different rules. The documentation of each field explains
         how it operates.

         -> Documentation:
         https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/temporal/ChronoField.html */

        LocalTime lt = LocalTime.parse("04:15:30");
        LocalDate ld = LocalDate.parse("2007-12-03");
        LocalDateTime ldt = LocalDateTime.parse("2007-12-03T04:15:30");
        Instant instant = Instant.parse("2007-12-03T04:15:30Z");
        ZonedDateTime zdt = ZonedDateTime.parse("2007-12-03T04:15:30Z");

        System.out.println("LocalTime: " + lt);
        System.out.println("LocalDate: " + ld);
        System.out.println("LocalDateTime: " + ldt);
        System.out.println("Instant: " + instant);
        System.out.println("ZonedDateTime: " + zdt);

        System.out.println();
        System.out.println("LocalDate day: " + ld.getDayOfMonth());
        System.out.println("LocalDateTime day: " + ldt.getDayOfMonth());
        System.out.println("Instant day: " + instant.atZone(zone2).get(ChronoField.DAY_OF_MONTH));
        System.out.println("ZonedDateTime day: " + zdt.get(ChronoField.DAY_OF_MONTH));
        System.out.println();

        System.out.println("LocalDate month: " + ld.getMonth());
        System.out.println("LocalDateTime month: " + ldt.getMonth());
        System.out.println("Instant month: " + instant.atZone(zone2).get(ChronoField.MONTH_OF_YEAR));
        System.out.println("ZonedDateTime month: " + zdt.get(ChronoField.MONTH_OF_YEAR));

        System.out.println();

        System.out.println("LocalDate year: " + ld.getYear());
        System.out.println("LocalDateTime year: " + ldt.getYear());
        System.out.println("Instant year: " + instant.atZone(zone2).get(ChronoField.YEAR));
        System.out.println("ZonedDateTime year: " + zdt.get(ChronoField.YEAR));

        System.out.println();

        System.out.println("LocalTime hour: " + lt.getHour());
        System.out.println("LocalDateTime hour: " + ldt.getHour());
        System.out.println("Instant hour: " + instant.atZone(zone2).get(ChronoField.HOUR_OF_DAY));
        System.out.println("ZonedDateTime hour: " + zdt.get(ChronoField.HOUR_OF_DAY));

        System.out.println();

        System.out.println("LocalTime minute: " + lt.getMinute());
        System.out.println("LocalDateTime minute: " + ldt.getMinute());
        System.out.println("Instant minute: " + instant.atZone(zone2).get(ChronoField.MINUTE_OF_HOUR));
        System.out.println("ZonedDateTime minute: " + zdt.get(ChronoField.MINUTE_OF_HOUR));

        System.out.println();

        System.out.println("LocalTime second: " + lt.getSecond());
        System.out.println("LocalDateTime second: " + ldt.getSecond());
        System.out.println("Instant second: " + instant.atZone(zone2).get(ChronoField.SECOND_OF_MINUTE));
        System.out.println("ZonedDateTime second: " + zdt.get(ChronoField.SECOND_OF_MINUTE));
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println();


        System.out.println("-----------------------------------------------------------------------------------------");

        /* Enum ChronoUnit -> A standard set of date periods units.
        This set of units provide unit-based access to manipulate a date, time or date-time. The standard set of units
        can be extended by implementing TemporalUnit.

        These units are intended to be applicable in multiple calendar systems. For example, most non-ISO calendar systems
        define units of years, months and days, just with slightly different rules. The documentation of each unit explains
        how it operates.

         -> Documentation:
         https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/temporal/ChronoUnit.html */

        System.out.println("LocalTime: " + lt);

        LocalTime hoursAgoLocalTime = lt.minusHours(2);
        System.out.println("2 hours ago: " + hoursAgoLocalTime);

        LocalTime hoursLaterLocalTime = lt.plusHours(2);
        System.out.println("2 hours later: " + hoursLaterLocalTime);

        System.out.println("--------------------------------------");

        System.out.println("LocalDate: " + ld);

        LocalDate pastWeekLocalDate = ld.minusWeeks(1);
        System.out.println("Past week: " + pastWeekLocalDate);

        LocalDate nextWeekLocalDate = ld.plusWeeks(1);
        System.out.println("Next week: " + nextWeekLocalDate);

        System.out.println("--------------------------------------");

        System.out.println("LocalDateTime: " + ldt);

        LocalDateTime pastWeekLocalDateTime = ldt.minusWeeks(1);
        System.out.println("Past week: " + pastWeekLocalDateTime);

        LocalDateTime nextWeekLocalDateTime = ldt.plusWeeks(1);
        System.out.println("Next week: " + nextWeekLocalDateTime);

        System.out.println("--------------------------------------");

        System.out.println("Instant: " + instant);

        Instant pastWeekInstant = instant.minus(7, ChronoUnit.DAYS);
        System.out.println("Past week: " + pastWeekInstant);

        Instant nextWeekInstant = instant.plus(7, ChronoUnit.DAYS);
        System.out.println("Next week: " + nextWeekInstant);

        System.out.println("--------------------------------------");

        System.out.println("ZonedDateTime: " + zdt);

        ZonedDateTime pastWeekZonedDateTime = zdt.minus(1, ChronoUnit.WEEKS);
        System.out.println("Past week: " + pastWeekZonedDateTime);

        ZonedDateTime nextWeekZonedDateTime = zdt.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next week: " + nextWeekZonedDateTime);
        System.out.println("-----------------------------------------------------------------------------------------");

        /* Duration -> A time-based amount of time, such as 34.5 seconds.
        This class models a quantity or amount of time in terms of seconds and nanoseconds. It can be accessed using other
        duration-based units, such as minutes and hours. In addition, the DAYS unit can be used and is treated as exactly
        equal to 24 hours, thus ignoring daylight savings effects. See Period for the date-based equivalent to this class.

         -> Documentation:
         https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/Duration.html */

        System.out.println("LocalTime:");
        Duration duration1 = Duration.between(hoursAgoLocalTime, hoursLaterLocalTime);
        System.out.println(hoursAgoLocalTime + " -> " + hoursLaterLocalTime + " = " + duration1.toHours() + " hours");

        System.out.println();

        System.out.println("LocalDate:");
        Duration duration2 = Duration.between(pastWeekLocalDate.atStartOfDay(), nextWeekLocalDate.atStartOfDay());
        System.out.println(pastWeekLocalDate + " -> " + nextWeekLocalDate + " = " + duration2.toDays() + " days");

        System.out.println();

        System.out.println("LocalDateTime:");
        Duration duration3 = Duration.between(pastWeekLocalDateTime, nextWeekLocalDateTime);
        System.out.println(pastWeekLocalDateTime + " -> " + nextWeekLocalDateTime + " = " + duration3.toDays() + " days");

        System.out.println();

        System.out.println("Instant:");
        Duration duration4 = Duration.between(pastWeekInstant, nextWeekInstant);
        System.out.println(pastWeekInstant + " -> " + nextWeekInstant + " = " + duration4.toDays() + " days");

        System.out.println();

        System.out.println("ZoneDateTime:");
        Duration duration5 = Duration.between(pastWeekZonedDateTime, nextWeekZonedDateTime);
        System.out.println(pastWeekZonedDateTime + " -> " + nextWeekZonedDateTime + " = " + duration5.toDays() + " days");
        System.out.println("-----------------------------------------------------------------------------------------");

    }

}
