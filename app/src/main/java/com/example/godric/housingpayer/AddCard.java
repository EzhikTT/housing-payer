package com.example.godric.housingpayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AddCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
    }

    public void doButtonClick(View view) {
        switch (view.getId()) {
            case R.id.addCardCancelBtt:
                super.onBackPressed();
                break;
            case R.id.addCardOkBtt:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Sorry. Not supported yet!", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}
