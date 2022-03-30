package com.teamtreehouse.didu8mymuffin;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {
    public static final String TAG = UserInfoActivity.class.getSimpleName();
    private TextView usernameTextView;
    private TextView passwordTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        usernameTextView = findViewById(R.id.usernameTextView);
        passwordTextView = findViewById(R.id.passwordTextView);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(getString(R.string.key_username));
        String password = intent.getStringExtra(getString(R.string.key_password));
        if (userName == null || userName.isEmpty()){
            userName = "user@email.com";
        }
        if (password == null || password.isEmpty()){
            password = "123456";
        }
        usernameTextView.setText(userName);
        passwordTextView.setText(password);
        Log.d(TAG, userName);
        Log.d(TAG, password);
    }
}
