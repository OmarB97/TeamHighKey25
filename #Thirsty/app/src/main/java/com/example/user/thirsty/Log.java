package com.example.user.thirsty;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Dennis Eddington on 4/22/2017.
 * @author Dennis Eddington
 */

public class Log {
    public String name;
    public String date; //auto-generated

    public Log(String name) {
        this.name = name;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar();
        this.date = sdf.format(calendar.getTime());

    }


    public static void writeLogEvent(String logType, String name) {
        Log log = new Log(name);

        WelcomeScreen.rootReference.child("Event Log").child(logType).push().setValue(log);
    }
}
