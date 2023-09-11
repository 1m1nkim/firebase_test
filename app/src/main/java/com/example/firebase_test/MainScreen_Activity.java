package com.example.firebase_test;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainScreen_Activity extends AppCompatActivity {
    Date currentDate = new Date();
    Dialog change_password;
    Dialog change_password_success;
    Button cal_title_btn;
    Button logout_btn;
    Button call_btn;
    Button bus_btn;
    Button web_btn;
    TextView top_info;
    Button ann_title_btn;
    TextView caf_date_text;
    TextView first_caf;
    TextView second_caf;
    String now_date;
    String lunch;
    String dinner;
    String date;
    private FirebaseDatabase database;
    private DatabaseReference menuReference;

    ArrayList<Menu> menulist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        database = FirebaseDatabase.getInstance();
        menuReference = database.getReference("menu");
        top_info = (TextView) findViewById(R.id.top_info);
        top_info.setText(MainActivity.name_num);
        Button logout_btn = (Button) findViewById(R.id.logout_btn) ;
        TextView warning_text = (TextView) findViewById(R.id.change_pass_warning);

        caf_date_text = (TextView) findViewById(R.id.caf_date_text);
        first_caf = (TextView) findViewById(R.id.first_caf);
        second_caf = (TextView) findViewById(R.id.second_caf);

        change_password = new Dialog(MainScreen_Activity.this);
        change_password.requestWindowFeature(Window.FEATURE_NO_TITLE);
        change_password.setContentView(R.layout.main_change_password);

        change_password_success = new Dialog(MainScreen_Activity.this);
        change_password_success.requestWindowFeature(Window.FEATURE_NO_TITLE);
        change_password_success.setContentView(R.layout.main_change_password);


        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");

        String dayString = dayFormat.format(currentDate);
        String monthString = monthFormat.format(currentDate);
        now_date = monthString + dayString ;

        call_btn = (Button) findViewById(R.id.call_btn);
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.firebase_test.CallActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                System.out.println(now_date + "---------------------------------------------------");
            }
        });
        ann_title_btn = (Button)findViewById(R.id.ann_title_btn);
        ann_title_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Notice.class);
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
                Intent intent = new Intent(getApplicationContext(), com.example.firebase_test.ScheduleActivity.class);
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
        String desiredDate = now_date; // 가져오고 싶은 날짜

        menuReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                menulist.clear();
                // 데이터 가져오기 성공
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Menu menu = snapshot.getValue(Menu.class);
                    menulist.add(menu);
                }
                for(int i=0; i<menulist.size(); i++){
                    date = menulist.get(i).getDate();
                    lunch = menulist.get(i).getLunch();
                    dinner = menulist.get(i).getDinner();
                    if(desiredDate.equals(date)){
                        caf_date_text.setText(now_date);
                        first_caf.setText(lunch);
                        second_caf.setText(dinner);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}