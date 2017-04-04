package com.example.user.thirsty;

import java.util.ArrayList;

/**
 * Created by Dennis Eddington on 2/27/2017.
 * @author Dennis Eddington
 */

public class WaterSourceReportList {
    private static ArrayList<WaterSourceReport> sourceReportList;

    /**
     * Will create an arraylist that will hold WaterSourceReport objects.
     */
    public WaterSourceReportList() {
        sourceReportList = new ArrayList<WaterSourceReport>();
    }

    /**
     * Will add a WaterSourceReport to the arraylist.
     *
     * @param report the report to be added
     */
    public static void addReport(WaterSourceReport report) {
        sourceReportList.add(report);
    }

    /**
     * Will remove a water report from the arraylist.
     *
     * @param reportNumber the index of the report to be removed
     */
    public static void removeReport(int reportNumber) {
        sourceReportList.remove(reportNumber - 1);
    }


    /**
     * Returns the size of the respective arraylist.
     *
     * @return the size of the arraylist
     */
    public static int getSize() {
       return sourceReportList.size();
    }

    /**
     * Returns an array of the WaterSourceReports
     *
     * @return Object array containing WaterSourceReports
     */
    public static Object[] printList() {
        return sourceReportList.toArray();
    }

    /**
     * Will return the report contained at a specific index of the arraylist
     *
     * @param index the report to be pulled from the list
     * @return the report pulled from the list
     */
    public static WaterSourceReport getReport(int index) {
        return sourceReportList.get(index);
    }

    public static void clearList() {
        sourceReportList.clear();
    }

    public static ArrayList<WaterSourceReport> getReportList() {
        return sourceReportList;
    }
}
