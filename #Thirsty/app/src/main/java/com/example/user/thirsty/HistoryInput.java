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

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 * @author Heather Song
 * @author Erika Trejo
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
        if (view.getId() == R.id.history) {
            EditText userPrep = (EditText) findViewById(R.id.yearText);
            historyYear = userPrep.getText().toString();
            history2 = (String) historySpinner.getSelectedItem();
        }

        //GraphView graph = (GraphView) findViewById(R.id.graph);
        float[] months = new float[12];
        int numReports = 0;
        for (int i = 1; i < 13; i++) {
            numReports = 0;
             for (WaterPurityReport report : WelcomeScreen.activePurityReportList.getReportList()) {
                 Calendar cal = Calendar.getInstance();
                 cal.setTime(report.getDate());
                 Log.d("val", history2);
                 if (history2.equals("Virus") && historyYear.equals("2017") && (cal.get(Calendar.MONTH))== i - 1) {
                     months[i - 1] += report.getVirusPPM();
                     Log.d("*******", report.getVirusPPM().toString());
                 }
                 if (history2.equals("Contaminant") && historyYear.equals("2017")&& (cal.get(Calendar.MONTH))== i - 1) {
                     months[i - 1] += report.getContaminantPPM();
                 }
                 numReports++;
             }
            months[i - 1] = ((float) months[i - 1]) / numReports;
        }

        GraphView g = (GraphView) findViewById(R.id.graph);
        g.removeAllSeries();
        g.getViewport().setXAxisBoundsManual(true);
        g.getViewport().setMinX(0);
        g.getViewport().setMaxX(13);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, months[0]),
                new DataPoint(2, months[1]),
                new DataPoint(3, months[2]),
                new DataPoint(4, months[3]),
                new DataPoint(5, months[4]),
                new DataPoint(6, months[5]),
                new DataPoint(7, months[6]),
                new DataPoint(8, months[7]),
                new DataPoint(9, months[8]),
                new DataPoint(10, months[9]),
                new DataPoint(11, months[10]),
                new DataPoint(12, months[11]),



        });

        g.addSeries(series);
    }


}
