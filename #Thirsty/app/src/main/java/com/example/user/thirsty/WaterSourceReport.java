package com.example.user.thirsty;

import java.util.Date;

/**
 * Created by Dennis Eddington on 2/27/2017.
 * @author Dennis Eddington
 * @author Heather Song
 */

public class WaterSourceReport {
    private int reportNumber;
    private Date currentDate;
    private float longitude;
    private float latitude;
    private String waterType;
    private String waterCondition;
    private String reporter;

    /**
     * Creates a WaterSourceReport to be inputted in the WaterSourceReportList.
     *
     * @param longitude the longitude of the water source
     * @param latitude the latitude of the water source
     * @param waterType the type of water found
     * @param waterCondition the condition of the water found
     * @param username the user that submitted the information
     */
    public WaterSourceReport(float latitude, float longitude, String waterType, String waterCondition,
                             String username) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
        this.currentDate = new Date();
        this.reportNumber = WaterSourceReportList.getSize() + 1;
        this.reporter = username;
    }

    /**
     * Will return the date that the WaterSourceReport was created on.
     *
     * @return date the report was created on
     */
    public Date getDate() {
        return currentDate;
    }

    /**
     * Will return the longitude that the WaterSourceReport was found at.
     *
     * @return longitude of the water
     */
    public Float getLongitude() {
        return longitude;
    }

    /**
     * Will return the latitude that the WaterSourceReport was found at.
     *
     * @return longitude of the water
     */
    public Float getLatitude() {
        return latitude;
    }


    /**
     * Will return the type of water WaterSourceReport contains.
     *
     * @return type of water
     */
    public String getWaterType() {
        return waterType;
    }

    /**
     * Will return the condition of water WaterSourceReport contains.
     *
     * @return condition of water
     */
    public String getWaterCondition() {
        return waterCondition;
    }

    /**
     * Will return the user that submitted this WaterSourceReport.
     *
     * @return user that created the report
     */
    public String getReporter() {
        return reporter;
    }

    /**
     * Will return the report number for the WaterSourceReport.
     *
     * @return the application generated report number
     */
    public int getReportNumber() {
        return reportNumber;
    }

}
