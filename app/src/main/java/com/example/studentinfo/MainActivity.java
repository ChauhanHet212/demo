package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.studentinfo.DataBase.DBHalper;
import com.example.studentinfo.Models.StudentInfo;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText nameEdt;
    TextView dobEdt, adtimeEdt;
    Spinner courseSpin;
    RadioButton maleRb, femaleRb;
    CheckBox cCb, cplusCb, javaCb;
    Button submitBtn, showBtn;

    DBHalper dbHalper;

    String[] course = {"Android Development", "Flutter", "ISO", "Web Development", "Web Design", "UI/UX Design", "Full Stack"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdt = findViewById(R.id.nameEdt);
        dobEdt = findViewById(R.id.dobEdt);
        adtimeEdt = findViewById(R.id.adtimeEdt);
        courseSpin = findViewById(R.id.courseSpin);
        maleRb = findViewById(R.id.maleRb);
        femaleRb = findViewById(R.id.femaleRb);
        cCb = findViewById(R.id.cCb);
        cplusCb = findViewById(R.id.cplusCb);
        javaCb = findViewById(R.id.javaCb);
        submitBtn = findViewById(R.id.submitBtn);
        showBtn = findViewById(R.id.showBtn);

        dbHalper = new DBHalper(MainActivity.this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, course);
        courseSpin.setAdapter(adapter);

        Calendar calendar = Calendar.getInstance();
        dobEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        dobEdt.setText(day + "/" + (month+1) + "/" + year);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
        adtimeEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        String str;
                        if (hour > 12){
                            hour -= 12;
                            str = "PM";
                        } else {
                            str = "AM";
                        }
                        adtimeEdt.setText(hour + ":" + minute + " " + str);
                    }
                }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), false);
                dialog.show();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdt.getText().toString();
                String dob = dobEdt.getText().toString();
                String adTime = adtimeEdt.getText().toString();
                String course = courseSpin.getSelectedItem().toString();
                String gender;
                if (maleRb.isChecked()){
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                String language = "";
                if (cCb.isChecked()){
                    language += "C Language  ";
                }
                if (cplusCb.isChecked()){
                    language += "C ++  ";
                }
                if (javaCb.isChecked()){
                    language += "Java  ";
                }
                if (language.isEmpty()){
                    language = "none";
                }

                if (!name.isEmpty() && !dob.isEmpty() && !adTime.isEmpty()){
                    dbHalper.addInfo(new StudentInfo(name, course, dob, adTime, gender, language));
                    nameEdt.setText("");
                    adtimeEdt.setText("");
                    dobEdt.setText("");
                }
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShowActivity.class));
            }
        });
    }
}