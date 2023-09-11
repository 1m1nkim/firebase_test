package com.example.firebase_test.firebase_test;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase_test.R;

public class MainScreen_Activity extends AppCompatActivity {
    Dialog change_password;
    Dialog change_password_success;
    Button cal_title_btn;
    Button logout_btn;
    Button call_btn;
    Button bus_btn;
    Button web_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Button logout_btn = (Button) findViewById(R.id.logout_btn) ;
        TextView warning_text = (TextView) findViewById(R.id.change_pass_warning);


        change_password = new Dialog(MainScreen_Activity.this);
        change_password.requestWindowFeature(Window.FEATURE_NO_TITLE);
        change_password.setContentView(R.layout.main_change_password);

        change_password_success = new Dialog(MainScreen_Activity.this);
        change_password_success.requestWindowFeature(Window.FEATURE_NO_TITLE);
        change_password_success.setContentView(R.layout.main_change_password);
        call_btn = (Button) findViewById(R.id.call_btn);
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CallActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        logout_btn = (Button) findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
        cal_title_btn = (Button) findViewById(R.id.cal_title_btn);
        cal_title_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScheduleActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                System.out.println("----------------------------------------");

            }
        });
        //warning_text.setVisibility(View.INVISIBLE);



        bus_btn = (Button) findViewById(R.id.bus_btn);
        bus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShuttleActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        web_btn = (Button) findViewById(R.id.web_btn);
        web_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WebsiteActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}