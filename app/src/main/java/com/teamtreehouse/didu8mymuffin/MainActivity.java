package com.teamtreehouse.didu8mymuffin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button submitButton;
    private EditText usernameField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.submit_button);
        usernameField = findViewById(R.id.editTextEmailAddress);
        passwordField = findViewById(R.id.editTextNumberPassword);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getText() returns the editable datatype, so toString() converts it to regular String.
                String userName = usernameField.getText().toString();
                String password = passwordField.getText().toString();
                //Toast.makeText(MainActivity.this, userName + password , Toast.LENGTH_LONG).show();
                sendCredentials(userName, password);

            }
        });
    }

    private void sendCredentials(String userName, String password) {
        Intent intent = new Intent(this, UserInfoActivity.class);
        Resources resources = getResources();
        String keyUserName = resources.getString(R.string.key_username);
        String keyPassword = resources.getString(R.string.key_password);
        intent.putExtra(keyUserName, userName);
        intent.putExtra(keyPassword, password);
        startActivity(intent);

    }
}