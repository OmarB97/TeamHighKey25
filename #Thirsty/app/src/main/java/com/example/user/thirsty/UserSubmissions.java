package com.example.user.thirsty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class UserSubmissions extends AppCompatActivity {
    public List<String> submissions = new ArrayList<>();
    public List<String> reports = Arrays.asList("Water Purity Report", "Water Source Report");
    public int[] count = new int[12];
    private Spinner userSpinner;
    private Spinner reportSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_submissions);

        for (WaterPurityReport report : WaterPurityReportList.getReportList()) {
            if (!submissions.contains(report.getReporter())) {
                submissions.add(report.getReporter());
            }
        }
        for (WaterSourceReport report : WaterSourceReportList.getReportList()) {
            if (!submissions.contains(report.getReporter())) {
                submissions.add(report.getReporter());
            }
        }
        userSpinner = (Spinner) findViewById(R.id.reporterSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, submissions);
        userSpinner.setAdapter(adapter);

        reportSpinner = (Spinner) findViewById(R.id.reportType);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, reports);
        reportSpinner.setAdapter(adapter2);

    }

    public void onButtonClick(View view) {
        String year = "1997";
        String user = "Billy";
        String reportType = "Default";
        count = new int[12];
        double yMax = 0;
        if (view.getId() == R.id.button4) {
            EditText userPrep = (EditText) findViewById(R.id.userYear);
            year = userPrep.getText().toString();
            user = (String) userSpinner.getSelectedItem();
            reportType = (String) reportSpinner.getSelectedItem();
        }

        if (reportType.equals("Water Purity Report")) {
            for (int i = 0; i < 12; i++) {
                for (WaterPurityReport report : WaterPurityReportList.getReportList()) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(report.getDate());
                    if (report.getReporter().equals(user) && (cal.get(Calendar.MONTH))== i && String.valueOf(cal.get(Calendar.YEAR)).equals(year)) {
                        count[i] = count[i] + 1;
                        if (count[i] > yMax) {
                            yMax = count[i];
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < 12; i++) {
                for (WaterSourceReport report : WaterSourceReportList.getReportList()) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(report.getDate());
                    if (report.getReporter().equals(user)  && (cal.get(Calendar.MONTH))== i && String.valueOf(cal.get(Calendar.YEAR)).equals(year)) {
                        count[i] = count[i] + 1;
                        if (count[i] > yMax) {
                            yMax = count[i];
                        }
                    }
                }
            }
        }



        GraphView g = (GraphView) findViewById(R.id.graph);

        g.setTitle(year + ": " + user + "'s " + reportType + " Submissions");
        g.getGridLabelRenderer().setHorizontalAxisTitle("Months");
        g.getGridLabelRenderer().setVerticalAxisTitle("Submissions");


        g.getViewport().setXAxisBoundsManual(true);
        g.getViewport().setMinX(0);
        g.getViewport().setMaxX(13);

        g.getViewport().setYAxisBoundsManual(true);
        g.getViewport().setMinY(0);
        g.getViewport().setMaxY(yMax + 2);
        g.removeAllSeries();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, count[0]),
                new DataPoint(2, count[1]),
                new DataPoint(3, count[2]),
                new DataPoint(4, count[3]),
                new DataPoint(5, count[4]),
                new DataPoint(6, count[5]),
                new DataPoint(7, count[6]),
                new DataPoint(8, count[7]),
                new DataPoint(9, count[8]),
                new DataPoint(10, count[9]),
                new DataPoint(11, count[10]),
                new DataPoint(12, count[11]),
        });

        series.setDrawDataPoints(true);


        g.addSeries(series);
    }
}
