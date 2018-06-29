package com.example.arunpandey.loginappdatabase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
   // final SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("userDB",MODE_PRIVATE,null);
    String id,password;
    EditText mail;
    EditText pass;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.editText5);

        pass = findViewById(R.id.editText6);

         signUp = findViewById(R.id.button4);

         mail.setText("");
         pass.setText("");

        final SharedPreferences sharedPreferences = this.getSharedPreferences("prefs", Context.MODE_PRIVATE);

     //   editor = sharedPreferences.edit();
       signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id = mail.getText().toString();
                password = pass.getText().toString();

               if(id.compareTo(" ") == 0 && password.compareTo(" ")==0)
               {
                   Toast.makeText(getApplicationContext(),"Enter your Details",Toast.LENGTH_LONG).show();
               }
               else{
                   sharedPreferences.edit().putString(id, password).commit();
                   Log.d("ButtonClicked","Intent switch");


                   Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                   // intent.putExtra("db", sqLiteDatabase);
                   mail.setText("");
                   pass.setText("");
                   startActivity(intent);
               }
            }

        });
       Button signIn = findViewById(R.id.button5);

       signIn.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, LoginActivity.class);
               // intent.putExtra("db", sqLiteDatabase);
               startActivity(intent);
           }
       });
    }
}
