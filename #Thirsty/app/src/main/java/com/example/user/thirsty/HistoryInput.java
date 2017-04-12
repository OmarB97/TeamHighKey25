package com.example.user.thirsty;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Erika Trejo on 4/4/2017.
 * @author Erika Trejo
 * @author Heather Song
 * @author Dennis Eddington
 */

public class HistoryInput extends AppCompatActivity {
    public List<String> historyType = Arrays.asList("Virus", "Contaminant");
    String history2;

    private Spinner historySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_input);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        historySpinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, historyType);
        historySpinner.setAdapter(adapter);
    }

    /**
     *
     * @param view the button to be pressed
     */
    public void onButtonClick(View view) {
        String historyYear = "0";
        String history2 = "2017";
        Float latitudeLoc = 0.0f;
        Float longitudeLoc = 0.0f;
        if (view.getId() == R.id.history) {
            EditText userPrep = (EditText) findViewById(R.id.yearText);
            historyYear = userPrep.getText().toString();
            history2 = (String) historySpinner.getSelectedItem();

            EditText userPrep2 = (EditText) findViewById(R.id.longitudeText);
            longitudeLoc = Float.parseFloat(userPrep2.getText().toString());

            EditText userPrep3 = (EditText) findViewById(R.id.latitudeText);
            latitudeLoc = Float.parseFloat(userPrep3.getText().toString());        }

        //GraphView graph = (GraphView) findViewById(R.id.graph);
        float[] months = new float[12];
        int numReports = 0;
        float sum = 0;
        for (int i = 0; i < 12; i++) {
             numReports = 0;
             sum = 0;
             for (WaterPurityReport report : WelcomeScreen.activePurityReportList.getReportList()) {
                 Calendar cal = Calendar.getInstance();
                 cal.setTime(report.getDate());
                 //Log.d("val", history2);
                 //Log.d("!!!!!!", latitudeLoc.toString());
                 //Log.d("??????", report.getLatitude().toString());
                 if (history2.equals("Virus") && (cal.get(Calendar.MONTH))== i && String.valueOf(cal.get(Calendar.YEAR)).equals(historyYear)
                         && latitudeLoc.equals(report.getLatitude()) && latitudeLoc.equals(report.getLatitude())) {
                     sum += report.getVirusPPM();
                     numReports++;
                     //Log.d("&&&&&", report.getVirusPPM().toString());
                 }
                 if (history2.equals("Contaminant") && String.valueOf(cal.get(Calendar.YEAR)).equals(historyYear) && (cal.get(Calendar.MONTH))== i
                         && latitudeLoc.equals(report.getLatitude()) && latitudeLoc.equals(report.getLatitude())) {
                     sum += report.getContaminantPPM();
                     numReports++;
                 }
             }
             if (numReports == 0 ) {
                 months[i] = 0.0f;
             } else {
                 months[i] = sum / numReports;
             }
        }

        double[] monthsDouble = new double[12];
        double yMax = 0;
        for (int i = 0; i < 12; i++) {
            double ppm = Double.parseDouble(Float.toString(months[i]));
            monthsDouble[i] = ppm;
            if (ppm > yMax) {
                yMax = ppm + 50;
            }
        }

        Log.d("******", Arrays.toString(monthsDouble));

        GraphView g = (GraphView) findViewById(R.id.graph);

        if (history2.equals("Virus")) {
            g.setTitle("Virus PPM Trend");
            g.getGridLabelRenderer().setHorizontalAxisTitle("Months");
        } else {
            g.setTitle("Contaminant PPM Trend");
        }
        g.getGridLabelRenderer().setVerticalAxisTitle("PPM");
        g.getGridLabelRenderer().setPadding(5);
        g.removeAllSeries();
        g.getViewport().setXAxisBoundsManual(true);
        g.getViewport().setMinX(0);
        g.getViewport().setMaxX(13);

        g.getViewport().setYAxisBoundsManual(true);
        g.getViewport().setMinY(0);
        g.getViewport().setMaxY(yMax);


        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, monthsDouble[0]),
                new DataPoint(2, monthsDouble[1]),
                new DataPoint(3, monthsDouble[2]),
                new DataPoint(4, monthsDouble[3]),
                new DataPoint(5, monthsDouble[4]),
                new DataPoint(6, monthsDouble[5]),
                new DataPoint(7, monthsDouble[6]),
                new DataPoint(8, monthsDouble[7]),
                new DataPoint(9, monthsDouble[8]),
                new DataPoint(10, monthsDouble[9]),
                new DataPoint(11, monthsDouble[10]),
                new DataPoint(12, monthsDouble[11]),
        });

        series.setDrawDataPoints(true);


        g.addSeries(series);
    }


}
