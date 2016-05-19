package com.example.godric.housingpayer;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAccountActivity extends AppCompatActivity {

    DBHelper dbHelper;
    public MyUser curUser;

    Button okBtt;
    Button cancelBtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_account);

        dbHelper = new DBHelper(this);
        curUser = new MyUser(this);

        okBtt = (Button) findViewById(R.id.addAccOkBtt);
        cancelBtt = (Button) findViewById(R.id.addAccCancelBtt);
    }

    public void doButtonClick(View view) {
        switch (view.getId()) {
        case R.id.addAccOkBtt:
            EditText username = (EditText) findViewById(R.id.addAccNameTE);
            EditText password = (EditText) findViewById(R.id.addAccPassTE);
            String user = username.getText().toString();
            String pass = password.getText().toString();
            if (curUser.addUser(user, pass)) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Account created!", Toast.LENGTH_SHORT);
                toast.show();
                super.onBackPressed();
            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Account existed!", Toast.LENGTH_SHORT);
                toast.show();
            }
            break;
        case R.id.addAccCancelBtt:
            super.onBackPressed();
            break;
        }
    }

}
