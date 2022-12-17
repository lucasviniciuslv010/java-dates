package java_util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* What are the problem with java.util.Date Class?
If you are using the java.util.date package to get the current date and time in Java (as it looks more intuitive),
you'll soon find out it's very limited.

The java.util.Date class in itself is not deprecated, when the earlier versions for Java were released it seems like
not much attention was given to details and complexities involved with Date/Time especially internationalization and
developer-friendliness of these classes. This class was first released in Java 1 and soon in Java 1.1 most of its methods
and constructors were deprecated.

No skilled java programmer uses the legacy classes in new applications except when integrating with legacy APIs.
Using those classes nowadays should be considered at least a bad programming practice, if not something worse
(source of bugs, security issues, etc).

-> Links:
https://code2care.org/java/why-avoid-java-util-date-calendar-classes
https://mail.openjdk.org/pipermail/discuss/2022-May/006077.html */

public class Program {

    public static void main(String[] args) throws ParseException {

        System.out.println("-----------------------------------------------------------------------------------------");
        /* SimpleDateFormat
        A concrete class for formatting and parsing dates in a locale-sensitive manner. It allows
        for formatting (date → text), parsing (text → date), and normalization.

        SimpleDateFormat allows you to start by choosing any user-defined patterns for date-time formatting.
        However, you are encouraged to create a date-time formatter with either getTimeInstance, getDateInstance, or
        getDateTimeInstance in DateFormat. Each of these class methods can return a date/time formatter initialized with
        a default format pattern. You may modify the format pattern using the applyPattern methods as desired.
        For more information on using these methods, see DateFormat.

        By default, SimpleDateFormat uses default timezone of system if none specified.

        -> Documentation:
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat.html */

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf3.setTimeZone(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf4.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        System.out.println("-----------------------------------------------------------------------------------------");

        /* Date -> The class Date represents a specific instant in time, with millisecond precision.
        Prior to JDK 1.1, the class Date had two additional functions. It allowed the interpretation of dates as year,
        month, day, hour, minute, and second values. It also allowed the formatting and parsing of date strings.
        Unfortunately, the API for these functions was not amenable to internationalization. As of JDK 1.1, the Calendar
        class should be used to convert between dates and time fields and the DateFormat class should be used to format
        and parse date strings. The corresponding methods in Date are deprecated.

        -> Documentation:
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Date.html

        Be aware that java.util.Date objects do not contain any timezone information by themselves - you cannot set the
        timezone on a Date object.
        Date.toString() actually uses a Calendar to interpret this millisecond time. So printing out a Date makes
        it appear to have a (default) timezone, leading to understandable questions about how to set that timezone.
        -> Link:
        https://stackoverflow.com/questions/2891361/how-to-set-time-zone-of-a-java-util-date?newreg=ca76283bafb249e49c0b21ef68a71f52 */

        Date date1 = new Date();
        Date date2 = new Date(System.currentTimeMillis());
        Date date3 = new Date(0L);
        Date date4 = new Date(1000L*60L*60L*3L);
        Date date5 = sdf1.parse("03/12/2007");
        Date date6 = sdf2.parse("03/12/2007 04:15:30");
        Date date7 = sdf3.parse("03/12/2007 04:15:30");
        Date date8 = sdf4.parse("03/12/2007 04:15:30");

        System.out.println("Date class");
        System.out.println("Date 1: " + date1 + " (Local Time Zone)");
        System.out.println("Date 2: " + date2 + " (Local Time Zone)");
        System.out.println("Date 3: " + date3 + " (Local Time Zone)");
        System.out.println("Date 4: " + date4 + " (Local Time Zone)");
        System.out.println("Date 5: " + date5 + " (Local Time Zone)");
        System.out.println("Date 6: " + date6 + " (Local Time Zone)");
        System.out.println("Date 7: " + date7 + " (Local Time Zone)");
        System.out.println("Date 8: " + date8 + " (Local Time Zone)");

        System.out.println();

        System.out.println("SimpleDateFormat 1: dd/MM/yyyy (Local Time Zone)");
        System.out.println("Date 1: " + sdf1.format(date1) + " (Local Time Zone)");
        System.out.println("Date 2: " + sdf1.format(date2) + " (Local Time Zone)");
        System.out.println("Date 3: " + sdf1.format(date3) + " (Local Time Zone)");
        System.out.println("Date 4: " + sdf1.format(date4) + " (Local Time Zone)");
        System.out.println("Date 5: " + sdf1.format(date5) + " (Local Time Zone)");
        System.out.println("Date 6: " + sdf1.format(date6) + " (Local Time Zone)");
        System.out.println("Date 7: " + sdf1.format(date7) + " (Local Time Zone)");
        System.out.println("Date 8: " + sdf1.format(date8) + " (Local Time Zone)");

        System.out.println();

        System.out.println("SimpleDateFormat 2: dd/MM/yyyy HH:mm:ss (Local Time Zone)");
        System.out.println("Date 1: " + sdf2.format(date1) + " (Local Time Zone)");
        System.out.println("Date 2: " + sdf2.format(date2) + " (Local Time Zone)");
        System.out.println("Date 3: " + sdf2.format(date3) + " (Local Time Zone)");
        System.out.println("Date 4: " + sdf2.format(date4) + " (Local Time Zone)");
        System.out.println("Date 5: " + sdf2.format(date5) + " (Local Time Zone)");
        System.out.println("Date 6: " + sdf2.format(date6) + " (Local Time Zone)");
        System.out.println("Date 7: " + sdf2.format(date7) + " (Local Time Zone)");
        System.out.println("Date 8: " + sdf2.format(date8) + " (Local Time Zone)");

        System.out.println();

        System.out.println("SimpleDateFormat 3: (dd/MM/yyyy HH:mm:ss) - (UTC)");
        System.out.println("Date 1: " + sdf3.format(date1) + " (UTC)");
        System.out.println("Date 2: " + sdf3.format(date2) + " (UTC)");
        System.out.println("Date 3: " + sdf3.format(date3) + " (UTC)");
        System.out.println("Date 4: " + sdf3.format(date4) + " (UTC)");
        System.out.println("Date 5: " + sdf3.format(date5) + " (UTC)");
        System.out.println("Date 6: " + sdf3.format(date6) + " (UTC)");
        System.out.println("Date 7: " + sdf3.format(date7) + " (UTC)");
        System.out.println("Date 8: " + sdf3.format(date8) + " (UTC)");

        System.out.println();

        System.out.println("SimpleDateFormat 4: dd/MM/yyyy HH:mm:ss (America/New_York)");
        System.out.println("Date 1: " + sdf4.format(date1) + " (America/New_York)");
        System.out.println("Date 2: " + sdf4.format(date2) + " (America/New_York)");
        System.out.println("Date 3: " + sdf4.format(date3) + " (America/New_York)");
        System.out.println("Date 4: " + sdf4.format(date4) + " (America/New_York)");
        System.out.println("Date 5: " + sdf4.format(date5) + " (America/New_York)");
        System.out.println("Date 6: " + sdf4.format(date6) + " (America/New_York)");
        System.out.println("Date 7: " + sdf4.format(date7) + " (America/New_York)");
        System.out.println("Date 8: " + sdf4.format(date8) + " (America/New_York)");
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println();


        System.out.println("-----------------------------------------------------------------------------------------");

        /* Calendar
        The Calendar class is an abstract class that provides methods for converting between a specific instant in time
        and a set of calendar fields such as YEAR, MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar
        fields, such as getting the date of the next week. An instant in time can be represented by a millisecond value
        that is an offset from the Epoch, January 1, 1970 00:00:00.000 GMT (Gregorian).

        The class also provides additional fields and methods for implementing a concrete calendar system outside the package.
        Those fields and methods are defined as protected.

        -> Documentation:
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Calendar.html */

        Date date9 = sdf2.parse("03/11/2007 04:15:30");

        Calendar cal = Calendar.getInstance();
        cal.setTime(date9);
        cal.set(Calendar.MONTH, 11); // Calendar month starts at 0 (January = 0, February = 1 ... December = 11)
        cal.add(Calendar.DAY_OF_MONTH, 4);

        System.out.println("Date 10: " + sdf2.format(date9));
        System.out.println("Calendar Date: " + sdf2.format(cal.getTime()));
        System.out.println("Calendar Day: " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("Calendar Month: " + (cal.get(Calendar.MONTH) + 1));
        System.out.println("Calendar Year: " + cal.get(Calendar.YEAR));
        System.out.println("Calendar Hour: " + cal.get(Calendar.HOUR));
        System.out.println("Calendar Minute: " + cal.get(Calendar.MINUTE));
        System.out.println("Calendar Second: " + cal.get(Calendar.SECOND));
        System.out.println("-----------------------------------------------------------------------------------------");

    }

}