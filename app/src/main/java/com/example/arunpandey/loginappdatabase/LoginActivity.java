package com.example.arunpandey.loginappdatabase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    String id,password;
    EditText mail;
    EditText pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail = findViewById(R.id.editText5);

        pass = findViewById(R.id.editText6);

        login = findViewById(R.id.button4);

       final  SharedPreferences sharedPreferences = this.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = preferences.edit();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id = mail.getText().toString();
                password = pass.getText().toString();

                String actual_pass = sharedPreferences.getString(id, "");

                if(password.compareTo(actual_pass) == 0) {

                    Intent intent = new Intent(getApplicationContext(), Welcome.class);
                    intent.putExtra("id", id);
                   mail.setText("");
                    pass.setText("");
                    startActivity(intent);
                }else {
                   Toast.makeText(getApplicationContext(),"Inavlid Email or password",Toast.LENGTH_LONG).show();
                }





            }

        });
    }
}
