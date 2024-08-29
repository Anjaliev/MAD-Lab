package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String username="admin";
    String password="admin";
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText t1=(EditText)findViewById(R.id.et1);
        EditText t2=(EditText)findViewById(R.id.et2);
        Button b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=t1.getText().toString();
                String pswd=t2.getText().toString();
                if(username.equals(uname)&&password.equals(pswd)){
                    //Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("username",uname);
                    intent.putExtra("password",pswd);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Login Faile",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}