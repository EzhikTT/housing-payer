package com.example.godric.housingpayer;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.godric.housingpayer.essence.Period;

import java.util.ArrayList;

public class SendData extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
                            DatePickerDialog.OnDateSetListener {

    String chooseService;
    int sy, sm, sd, ey, em, ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);

        createComponents();
    }

    public void doButtonClick(View view) {
        switch (view.getId()) {
            case R.id.sdataCancelBtt:
                super.onBackPressed();
                break;
            case R.id.sdataSendBtt:
                String value = ((EditText) findViewById(R.id.sdataValue)).getText().toString();
                if (value.isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Empty value!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int sum = Integer.parseInt(value);
                    if (sum < 0) {
                        Toast.makeText(getApplicationContext(),
                                "Value <= 0!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    DatePicker s = (DatePicker) findViewById(R.id.startingDatePicker);
                    DatePicker e = (DatePicker) findViewById(R.id.endingDatePicker);
                    //Period tmp = new Period(sy, sm, sd, ey, em, ed);
                    Period tmp = new Period(s.getYear(), s.getMonth(), s.getDayOfMonth(),
                            e.getYear(), e.getMonth(), e.getDayOfMonth());
                    tmp.setValue(sum);
                    int id = MainFunctionsActivity.curUser.getServiceSource().createPeriod(tmp.getStarting(),
                            tmp.getEnding(), tmp.getValue());
                    tmp.setId(id);
                    MainFunctionsActivity.curUser.addPeriodto(tmp, chooseService);
                    Toast.makeText(getApplicationContext(),
                            "Susseccfully send!", Toast.LENGTH_SHORT).show();
                    super.onBackPressed();
                }
                break;
        }
    }

    private void createComponents() {
        ArrayList<String> arr = MainFunctionsActivity.curUser.getServicesName();
        String[] items = new String[arr.size()];
        arr.toArray(items);

        ArrayAdapter<String> tmp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        Spinner s = (Spinner) findViewById(R.id.sdataServiceSpin);
        tmp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(tmp);
        s.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        chooseService = ((TextView)view).getText().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        switch (view.getId()) {
            case R.id.startingDatePicker:
                sy = year;
                sm = monthOfYear;
                sd = dayOfMonth;
                break;

            case R.id.endingDatePicker:
                ey = year;
                em = monthOfYear;
                ed = dayOfMonth;
                break;
        }
    }
}
