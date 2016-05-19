package com.example.godric.housingpayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    public MyUser curUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        dbHelper = new DBHelper(this);
        curUser = new MyUser(this);
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
                    Intent intent = new Intent(this, MainFunctions.class);
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