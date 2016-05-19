package com.example.godric.housingpayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.godric.housingpayer.essence.User;

public class MainFunctionsActivity extends AppCompatActivity {

    public static User curUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_functions);
        curUser = new User();
    }

    public void doButtonClick(View view) {
        switch (view.getId()) {
            case R.id.mainAddCardBtt:

                Intent intent = new Intent(this, AddCardActivity.class);
                startActivity(intent);
                break;

            case R.id.mainLogoutBtt:

                super.onBackPressed();
                break;

            case R.id.mainPayBtt:

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Sorry. Not supported yet!", Toast.LENGTH_SHORT);
                toast.show();
                break;

            case R.id.mainSendDataBtt:

                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "Sorry. Not supported yet!", Toast.LENGTH_SHORT);
                toast1.show();
                break;
        }
    }
}
