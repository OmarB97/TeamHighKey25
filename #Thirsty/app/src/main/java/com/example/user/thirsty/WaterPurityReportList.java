package com.example.user.thirsty;

import java.util.ArrayList;

/**
 * Created by Dennis Eddington on 3/12/2017.
 * @author Dennis Eddington
 */

public class WaterPurityReportList {
    private static ArrayList<WaterPurityReport> purityReportList;

    /**
     * Will create an arraylist that will hold WaterPurityReport objects.
     */
    public WaterPurityReportList() {
        purityReportList = new ArrayList<WaterPurityReport>();
    }

    /**
     * Will add a WaterPurityReport to the arraylist.
     *
     * @param report the report to be added
     */
    public static void addReport(WaterPurityReport report) {
        purityReportList.add(report);
    }

    /**
     * Will remove a water report from the arraylist.
     *
     * @param reportNumber the index of the report to be removed
     */
    public static void removeReport(int reportNumber) {
        purityReportList.remove(reportNumber - 1);
    }


    /**
     * Returns the size of the respective arraylist.
     *
     * @return the size of the arraylist
     */
    public static int getSize() {
        return purityReportList.size();
    }

    /**
     * Returns an array of the WaterPurityReports
     *
     * @return Object array containing WaterPurityReports
     */
    public static Object[] printList() {
        return purityReportList.toArray();
    }

    /**
     * Will return the report contained at a specific index of the arraylist
     *
     * @param index the report to be pulled from the list
     * @return the report pulled from the list
     */
    public static WaterPurityReport getReport(int index) {
        return purityReportList.get(index);
    }
}
