package com.example.godric.housingpayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.godric.housingpayer.data.CardDataSource;
import com.example.godric.housingpayer.essence.User;

public class MainFunctionsActivity extends AppCompatActivity {

    public static User curUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_functions);
        curUser = new User(this);
    }

    public void doButtonClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.mainAddCardBtt:

                intent = new Intent(this, AddCardActivity.class);
                startActivity(intent);
                break;

            case R.id.mainLogoutBtt:

                super.onBackPressed();
                break;

            case R.id.mainPayBtt:

                intent = new Intent(this, ChooseServiceActivity.class);
                startActivity(intent);
                break;

            case R.id.mainSendDataBtt:

                intent = new Intent(this, SendData.class);
                startActivity(intent);

                break;
        }
    }
}
