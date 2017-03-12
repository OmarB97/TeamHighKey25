package com.example.user.thirsty;

import java.util.Date;

/**
 * Created by Dennis Eddington on 3/12/2017.
 * @author Dennis Eddington
 */

public class WaterPurityReport {
    private int reportNumber;
    private Date currentDate;
    private float virusPPM;
    private float contaminantPPM;
    private float longitude;
    private float latitude;
    private String overallCondition;
    private String reporter;

    /**
     * Creates a WaterPurityReport to be inputted in the WaterPurityReportList.
     *
     * @param contaminantPPM the contaminantPPM of the water source
     * @param virusPPM the virusPPM of the water source
     * @param longitude the longitude of the water source
     * @param latitude the latitude of the water source
     * @param overallCondition the condition of the water found
     * @param username the user that submitted the information
     */
    public WaterPurityReport(float virusPPM, float contaminantPPM, float latitude, float longitude, String overallCondition,
                             String username) {
        this.contaminantPPM = contaminantPPM;
        this.virusPPM = virusPPM;
        this.longitude = longitude;
        this.latitude = latitude;
        this.overallCondition = overallCondition;
        this.currentDate = new Date();
        this.reportNumber = WaterPurityReportList.getSize() + 1;
        this.reporter = username;
    }

    /**
     * Will return the date that the WaterPurityReport was created on.
     *
     * @return date the report was created on
     */
    public Date getDate() {
        return currentDate;
    }

    /**
     * Will return the contaminantPPM that the WaterPurityReport was found at.
     *
     * @return contaminantPPM of the water
     */
    public Float getContaminantPPM() {
        return contaminantPPM;
    }

    /**
     * Will return the virusPPM that the WaterPurityReport was found at.
     *
     * @return contaminantPPM of the water
     */
    public Float getVirusPPM() {
        return virusPPM;
    }

    /**
     * Will return the longitude that the WaterPurityReport was found at.
     *
     * @return longitude of the water
     */
    public Float getLongitude() {
        return longitude;
    }

    /**
     * Will return the latitude that the WaterPurityReport was found at.
     *
     * @return longitude of the water
     */
    public Float getLatitude() {
        return latitude;
    }


    /**
     * Will return the condition of water WaterPurityReport contains.
     *
     * @return condition of water
     */
    public String getOverallCondition() {
        return overallCondition;
    }

    /**
     * Will return the user that submitted this WaterPurityReport.
     *
     * @return user that created the report
     */
    public String getReporter() {
        return reporter;
    }

    /**
     * Will return the report number for the WaterPurityReport.
     *
     * @return the application generated report number
     */
    public int getReportNumber() {
        return reportNumber;
    }
}
