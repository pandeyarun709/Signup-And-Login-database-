package com.example.arunpandey.loginappdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Bundle extras = getIntent().getExtras();
        String id = extras.getString("id");
        TextView message = findViewById(R.id.textView4);
        message.setText("Welcome " + id);
    }
}
