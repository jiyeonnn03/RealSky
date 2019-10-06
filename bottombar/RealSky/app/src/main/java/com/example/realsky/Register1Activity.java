package com.example.realsky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import android.widget.ImageButton;
import android.widget.Toast;

public class Register1Activity extends AppCompatActivity {
    CheckBox allCheckBox;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        allCheckBox = findViewById(R.id.allCheckBox);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);

        Button btn = (Button) findViewById(R.id.nextButton1);
//        ImageButton Img_btn = (ImageButton) findViewById(R.id.imageButton1);

        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox1.isChecked()&& checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), Register2Activity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "모든 이용약관에 동의해야 넘어갈 수 있습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        allCheckBox.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allCheckBox.isChecked()) {
                    checkBox1.setChecked(true);
                    checkBox2.setChecked(true);
                    checkBox3.setChecked(true);
                    checkBox4.setChecked(true);
                }
                else {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                }
            }
        });
    }


//    public void exitOnClick(View view) {
//        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(intent2);
//    }

    public void dontNext(View view) {
        allCheckBox = findViewById(R.id.allCheckBox);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        if(!checkBox1.isChecked() || !checkBox2.isChecked() || !checkBox3.isChecked() || !checkBox4.isChecked()) {
            allCheckBox.setChecked(false);
        }
        else {
            allCheckBox.setChecked(true);
        }
    }

}