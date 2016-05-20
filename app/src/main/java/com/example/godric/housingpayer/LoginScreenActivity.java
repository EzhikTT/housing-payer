package com.example.godric.housingpayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.godric.housingpayer.data.MyUserDataSource;

public class LoginScreenActivity extends AppCompatActivity {

    MyUserDataSource curUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        curUser = new MyUserDataSource(this);
    }

    /** Called when the user clicks the OK button */
    public void doButtonClick(View view) {
        EditText useredit = (EditText) findViewById(R.id.userEdit);
        EditText passedit = (EditText) findViewById(R.id.passEdit);
        Button okButton = (Button) findViewById(R.id.loginButton);

        String user = useredit.getText().toString();
        String pass = passedit.getText().toString();

        switch (view.getId()) {
            case R.id.loginButton:
                if (curUser.isLoginAccept(user, pass)) {
                    Intent intent = new Intent(this, MainFunctionsActivity.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Login failed!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            case R.id.createAccButton:
                Intent intent = new Intent(this, AddAccountActivity.class);
                startActivity(intent);
                break;
        }
        System.out.println("----------------------- heere ");
    }
}