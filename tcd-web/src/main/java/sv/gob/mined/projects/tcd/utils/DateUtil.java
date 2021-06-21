package sv.gob.mined.projects.tcd.utils;

import javax.enterprise.context.ApplicationScoped;
import java.util.Calendar;
import java.util.Date;


public final class DateUtil {

    private static Calendar CALENDAR = Calendar.getInstance();

    public static Date addYears(Date current, int n){
        CALENDAR.setTime(current);
        CALENDAR.add(Calendar.YEAR, n);
        return CALENDAR.getTime();
    }
}
