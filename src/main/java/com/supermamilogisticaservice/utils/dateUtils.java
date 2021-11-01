package com.supermamilogisticaservice.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateUtils {
    public static String DATE_FORMAT = "yyyy-MM-dd";

    public static Date getDateFromString(String date)
    {
        DateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);

        try
        {
            return sdf.parse(date);
        }
        catch (ParseException e)
        {
            return null;
        }
    }

    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return dateFormat.format(date);
    }
}
