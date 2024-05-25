package com.example.dbdemo.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.example.dbdemo.MainActivity;
import com.example.dbdemo.R;

public class displayContact extends AppCompatActivity {


    TextView nameText, phoneText;
    Button  button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Rname");
        String phone = intent.getStringExtra("Rphone");

        nameText = findViewById(R.id.displayName);
        nameText.setText(name);
        phoneText = findViewById(R.id.displayPhone);
        phoneText.setText(phone);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(displayContact.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }
}