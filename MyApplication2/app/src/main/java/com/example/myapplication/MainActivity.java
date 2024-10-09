package com.example.registration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    RadioGroup radioGroup;
    EditText email;
    EditText phone;
    EditText password;
    EditText dob;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.editTextText);
        lastName = findViewById(R.id.editTextText7);
        radioGroup = findViewById(R.id.radioGroup3);
        email = findViewById(R.id.editTextTextEmailAddress2);
        phone = findViewById(R.id.editTextText4);
        password = findViewById(R.id.editTextText5);
        dob = findViewById(R.id.editTextDate2);
        submit = findViewById(R.id.button);

        submit.setOnClickListener(v -> {
            String fname = firstName.getText().toString().trim();
            String lname = lastName.getText().toString().trim();
            int rg = radioGroup.getCheckedRadioButtonId();
            String em = email.getText().toString().trim();
            String ph = phone.getText().toString().trim();
            String psw = password.getText().toString().trim();
            String date = dob.getText().toString().trim();

            if (validateInput(fname, lname, em, ph, psw, date, rg)) {
                // Save to SharedPreferences
                String gender = ((RadioButton) findViewById(rg)).getText().toString();
                saveToSharedPreferences(fname, lname, em, ph, psw, date, gender);

                // Start SecondActivity
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private void saveToSharedPreferences(String fname, String lname, String email, String phone, String password, String dob, String gender) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("firstName", fname);
        editor.putString("lastName", lname);
        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("password", password); // Storing plain passwords is not recommended
        editor.putString("dob", dob);
        editor.putString("gender", gender);
        editor.apply();
    }
}