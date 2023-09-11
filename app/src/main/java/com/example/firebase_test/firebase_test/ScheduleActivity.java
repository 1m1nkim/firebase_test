package com.example.firebase_test.firebase_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase_test.R;

public class ScheduleActivity extends AppCompatActivity {
    Button march_btn;
    Button april_btn;
    Button may_btn;
    Button june_btn;
    Button july_btn;
    Button august_btn;
    Button sep_btn;
    Button octo_btn;
    Button novem_btn;
    Button decem_btn;
    Button back_btn_han;
    Button left_btn_sche;
    Button right_btn_sche;
    Button left_btn_sche_two;
    Button right_btn_sche_two;
    TextView month_text;
    TextView text_sche;
    RelativeLayout sche_one;
    RelativeLayout sche_two;
    boolean laycheck = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_one);

        march_btn = (Button) findViewById(R.id.march_btn);
        april_btn = (Button) findViewById(R.id.april_btn);
        may_btn = (Button) findViewById(R.id.may_btn);
        june_btn = (Button) findViewById(R.id.june_btn);
        july_btn = (Button) findViewById(R.id.july_btn);
        august_btn = (Button) findViewById(R.id.august_btn);
        sep_btn = (Button) findViewById(R.id.sep_btn);
        octo_btn = (Button) findViewById(R.id.octo_btn);
        novem_btn = (Button) findViewById(R.id.novem_btn);
        decem_btn = (Button) findViewById(R.id.decem_btn);
        back_btn_han = (Button) findViewById(R.id.back_btn_han);
        left_btn_sche = (Button) findViewById(R.id.left_btn_sche);
        right_btn_sche = (Button) findViewById(R.id.right_btn_sche);
        left_btn_sche_two = (Button) findViewById(R.id.left_btn_sche_two);
        right_btn_sche_two = (Button) findViewById(R.id.right_btn_sche_two);
        month_text = (TextView) findViewById(R.id.month_text);
        text_sche = (TextView) findViewById(R.id.text_sche);
        sche_one = (RelativeLayout) findViewById(R.id.sche_one);
        sche_two = (RelativeLayout) findViewById(R.id.sche_two);

        march_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 3월";
            @Override
            public void onClick(View view) {
                month_text.setText("3월");
                text_sche.setText("안녕하세요");
            }
        });
        april_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 4월";
            @Override
            public void onClick(View view) {
                month_text.setText("4월");
                text_sche.setText("감사해요");
            }
        });
        may_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 5월";
            @Override
            public void onClick(View view) {
                month_text.setText("5월");
                text_sche.setText("잘있어요");
            }
        });
        june_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 6월";
            @Override
            public void onClick(View view) {
                month_text.setText("6월");
                text_sche.setText("다시만나요");
            }
        });
        july_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 7월";
            @Override
            public void onClick(View view) {
                month_text.setText("7월");
                text_sche.setText("아침해가뜨면");
            }
        });
        august_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 8월";
            @Override
            public void onClick(View view) {
                month_text.setText("8월");
                text_sche.setText("아침해가뜨면 ~ ");
            }
        });
        sep_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 9월";
            @Override
            public void onClick(View view) {
                month_text.setText("9월");
                text_sche.setText("매일 같은 사람들과 ~ ");
            }
        });
        octo_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 10월";
            @Override
            public void onClick(View view) {
                month_text.setText("10월");
                text_sche.setText("또 다시 새로운 ~ ");
            }
        });
        novem_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 11월";
            @Override
            public void onClick(View view) {
                month_text.setText("11월");
                text_sche.setText("하루 일을 시작해 ~ ");
            }
        });
        decem_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 12월";
            @Override
            public void onClick(View view) {
                month_text.setText("12월");
                text_sche.setText("가는거야 ~ ");
            }
        });
        back_btn_han.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainScreen_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
        left_btn_sche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(laycheck){
                    sche_one.setVisibility(View.INVISIBLE);
                    sche_two.setVisibility(View.VISIBLE);
                    laycheck = false;
                }else if(laycheck == false){
                    sche_one.setVisibility(View.VISIBLE);
                    sche_two.setVisibility(View.INVISIBLE);
                    laycheck = true;
                }
            }
        });
        right_btn_sche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(laycheck){
                        sche_one.setVisibility(View.INVISIBLE);
                        sche_two.setVisibility(View.VISIBLE);
                        laycheck = false;
                    }else if(laycheck == false){
                        sche_one.setVisibility(View.VISIBLE);
                        sche_two.setVisibility(View.INVISIBLE);
                        laycheck = true;
                    }
                }
            });
        left_btn_sche_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(laycheck){
                    sche_one.setVisibility(View.INVISIBLE);
                    sche_two.setVisibility(View.VISIBLE);
                    laycheck = false;
                }else if(laycheck == false){
                    sche_one.setVisibility(View.VISIBLE);
                    sche_two.setVisibility(View.INVISIBLE);
                    laycheck = true;
                }
            }
        });
        right_btn_sche_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(laycheck){
                    sche_one.setVisibility(View.INVISIBLE);
                    sche_two.setVisibility(View.VISIBLE);
                    laycheck = false;
                }else if(laycheck == false){
                    sche_one.setVisibility(View.VISIBLE);
                    sche_two.setVisibility(View.INVISIBLE);
                    laycheck = true;
                }
            }
        });
        /*
            for or while 사용, 데이터베이스[i]값이 null이 아닐때
            String text = "";

            while(데이터베이스[i] != null){
                text += 데이터베이스[i] + "/n";
                ~.setText(데이터베이스[i]);
                i++;
            }
         */
    }
}
