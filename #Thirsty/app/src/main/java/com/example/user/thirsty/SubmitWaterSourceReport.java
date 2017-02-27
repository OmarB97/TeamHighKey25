package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class SubmitWaterSourceReport extends AppCompatActivity {
    public List<String> legalTypes = Arrays.asList("Bottled", "Well", "Stream", "Lake", "Spring", "Other");
    public List<String> legalConditions = Arrays.asList("Waste", "Treatable-Clear", "Treatable-Muddy", "Potable");
    private Spinner typeSpinner;
    private Spinner conditionSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_water_source_report);

        typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, legalTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        conditionSpinner = (Spinner) findViewById(R.id.conditionSpinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, legalConditions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conditionSpinner.setAdapter(adapter2);
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.submit) {
            EditText locationPrep = (EditText) findViewById(R.id.location_field);
            String location = locationPrep.getText().toString();

            String user = getIntent().getStringExtra("Username");

            String waterType = (String) typeSpinner.getSelectedItem();
            String waterCondition = (String) conditionSpinner.getSelectedItem();

            if (location.length() > 0 ) {
                WelcomeScreen.activeSourceReportList.addReport(new WaterSourceReport(location, waterType, waterCondition, user.substring(1)));
                Toast reportCreated = Toast.makeText(SubmitWaterSourceReport.this,
                        "Report successfully created!", Toast.LENGTH_SHORT);
                reportCreated.show();
                Intent i = new Intent(SubmitWaterSourceReport.this, WelcomeScreenLoggedIn.class);
                i.putExtra("Username", user);
                startActivity(i);
            } else {
                Toast.makeText(this, "Please insert a location", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
