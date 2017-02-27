package com.example.user.thirsty;

import java.util.Date;

/**
 * Created by USER on 2/27/2017.
 * @author Dennis Eddington
 */

public class WaterSourceReport {
    private int reportNumber;
    private Date currentDate;
    private String location;
    private String waterType;
    private String waterCondition;
    private String reporter;

    public WaterSourceReport(String location, String waterType, String waterCondition,
                             String username) {
        this.location = location;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
        this.currentDate = new Date();
        this.reportNumber = WaterSourceReportList.getSize() + 1;
        this.reporter = username;
    }

    public Date getDate() {
        return currentDate;
    }

    public String getLocation() {
        return location;
    }

    public String getWaterType() {
        return waterType;
    }

    public String getWaterCondition() {
        return waterCondition;
    }

    public String getReporter() {
        return reporter;
    }

    public int getReportNumber() {
        return reportNumber;
    }

}
