package com.example.registration;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText FN,LN,email,phn,dob,pswd;
    RadioButton M,F;
    Button reg;
    SharedPreferences SharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        FN=findViewById(R.id.editTextText2);
        LN=findViewById(R.id.editTextText3);
        email=findViewById(R.id.editTextTextEmailAddress);
        phn=findViewById(R.id.editTextPhone);
        dob=findViewById(R.id.editTextDate);
        pswd=findViewById(R.id.editTextTextPassword);
        M=findViewById(R.id.radioButton);
        F=findViewById(R.id.radioButton2);
        reg=findViewById(R.id.button1);
        SharedPreferences=getSharedPreferences("userpref", Context.MODE_PRIVATE);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndRegister();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void validateAndRegister(){
        String fname=FN.getText().toString().trim();
        String lname=LN.getText().toString().trim();
        String enamil=email.getText().toString().trim();
        String password=pswd.getText().toString().trim();
        if (fname.isEmpty()){
            showMessage("First  name required");
            return;
        }
        if (lname.isEmpty()){
            showMessage("Last  required");
            return;
        }
        if (enamil.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            showMessage("Email required");
            return;
        }
        if (password.isEmpty()||password.length()<6){
            showMessage("Password  required");
            return;
        }
        SharedPreferences Editor.editor=SharedPreferences.edit();
    }
}
