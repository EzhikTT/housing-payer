package com.example.godric.housingpayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.godric.housingpayer.data.CardDataSource;

public class AddCardActivity extends AppCompatActivity {

    CardDataSource cardData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        cardData =  new CardDataSource(this);
    }

    public void doButtonClick(View view) {
        switch (view.getId()) {
            case R.id.addCardCancelBtt:
                super.onBackPressed();
                break;
            case R.id.addCardOkBtt:
                Toast toast;
                EditText numberEt = (EditText) findViewById(R.id.addCardNumberEditText);
                EditText yearEt = (EditText) findViewById(R.id.addCardYearEditText);
                EditText ownerEt = (EditText) findViewById(R.id.addCardOwnerEditText);

                String number = numberEt.getText().toString();
                String tmp = yearEt.getText().toString();
                String owner = ownerEt.getText().toString();

                int year;
                if (!numberChecking(number)) {
                    Toast.makeText(getApplicationContext(),
                            "Number card invalid", Toast.LENGTH_SHORT).show();
                    break;
                }
                try {
                    year = Integer.parseInt(tmp);
                    if (2016 < year && year < 9999) {
                        // ok
                        if (!cardData.createCard(number, year, owner)) {
                            Toast.makeText(getApplicationContext(),
                                    "Card existed", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),
                                    "Card successfully created", Toast.LENGTH_SHORT).show();
                            super.onBackPressed();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),
                                "Year invalid", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),
                            "Year invalid", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    private boolean numberChecking(String num) {
        /*
        if (num.length() != 16)
            return false;
        */
        return true;
    }
}
