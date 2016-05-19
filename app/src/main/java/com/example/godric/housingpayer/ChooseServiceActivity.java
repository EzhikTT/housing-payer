package com.example.godric.housingpayer;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.godric.housingpayer.essence.Period;

import java.util.ArrayList;

public class ChooseServiceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView chsum;

    String chooseCard = "";
    String chooseService = "" ;
    String choosePiriod = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_service);

        createComponents();
    }

    public void doButtonClick(View view) {
        switch (view.getId()) {
            case R.id.chooseCancelBtt:
                super.onBackPressed();
                break;
            case R.id.choosePayBtt:
                if (chooseCard.isEmpty() || choosePiriod.isEmpty() || chooseService.isEmpty()
                        || chsum.getText().toString().equals("0")) {
                    Toast.makeText(getApplicationContext(),
                            "Can not pay. Checking input!", Toast.LENGTH_SHORT).show();
                }
                else {
                    MainFunctionsActivity.curUser.pay(chooseService, choosePiriod);
                    Toast.makeText(getApplicationContext(),
                            "Pay successfully!", Toast.LENGTH_SHORT).show();
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
        Spinner s = (Spinner) findViewById(R.id.chooseServicesSpiner);
        tmp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(tmp);
        s.setOnItemSelectedListener(this);


        ArrayList<String> numbers = MainFunctionsActivity.curUser.getCardsNumber();
        String[] nbs = new String[numbers.size()];
        numbers.toArray(nbs);

        ArrayAdapter<String> cards = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nbs);
        Spinner scard = (Spinner) findViewById(R.id.chooseCardSpinner);
        cards.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scard.setAdapter(cards);
        scard.setOnItemSelectedListener(this);

        chsum = (TextView) findViewById(R.id.chooseSumary);
        chsum.setText("0");
    }

    ///////// listener ///////////////////

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choosed = ((TextView)view).getText().toString();
        switch (parent.getId()) {
            case R.id.chooseServicesSpiner:
                chooseService = choosed;

                ArrayList<Period> items = MainFunctionsActivity.curUser.getServiceByName(choosed).getPeriod();
                String[] nbs = new String[items.size()];
                ArrayList<String> tmp = new ArrayList<String>();
                for (Period p : items) {
                    tmp.add(p.toString());
                }
                tmp.toArray(nbs);

                ArrayAdapter<String> cards = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nbs);
                Spinner scard = (Spinner) findViewById(R.id.choosePeriodSpinner);
                cards.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                scard.setAdapter(cards);
                scard.setOnItemSelectedListener(this);

                break;

            case R.id.choosePeriodSpinner:
                choosePiriod = choosed;

                chsum.setText(String.valueOf(MainFunctionsActivity.curUser.getPeriodByName(choosed).getValue()
                        * MainFunctionsActivity.curUser.getServiceByName(chooseService).getPrice()));

                break;

            case R.id.chooseCardSpinner:
                chooseCard = choosed;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
