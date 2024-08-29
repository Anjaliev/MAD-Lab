package com.example.facebook_login_btclick;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //private static final String FACEBOOK_LOGIN_URL = "https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button facebookLoginButton = findViewById(R.id.button);
        facebookLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebookLoginPage();
            }
        });
    }

    private void openFacebookLoginPage() {
        String FACEBOOK_LOGIN_URL = "https://www.facebook.com";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK_LOGIN_URL));
        startActivity(browserIntent);
    }
}
