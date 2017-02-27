package com.example.user.thirsty;

import java.util.ArrayList;

/**
 * Created by Admin on 2/27/2017.
 */

public class WaterSourceReportList {
    private static ArrayList<WaterSourceReport> sourceReportList;

    public WaterSourceReportList() {
        sourceReportList = new ArrayList<WaterSourceReport>();
    }

    public static void addReport(WaterSourceReport report) {
        sourceReportList.add(report);
    }

    public static void removeReport(int reportNumber) {
        sourceReportList.remove(reportNumber - 1);
    }

    public static int getSize() {
       return sourceReportList.size();
    }

    public static Object[] printList() {
        return sourceReportList.toArray();
    }
}
