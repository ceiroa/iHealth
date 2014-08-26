/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author crme1980
 */
public class DateHelper {

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final Calendar cal = Calendar.getInstance();

    public static String now() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        return sdf.format(cal.getTime());
    }

    public static String formatDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        return sdf.format(date);
    }

    public static boolean isCorrectFormat(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            sdf.format(date);
        }catch(IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
