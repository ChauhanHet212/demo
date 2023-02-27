package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.studentinfo.Adapters.InfoAdapter;
import com.example.studentinfo.DataBase.DBHalper;
import com.example.studentinfo.Models.StudentInfo;

import java.util.List;

public class ShowActivity extends AppCompatActivity {

    RecyclerView infoRecycler;
    InfoAdapter infoAdapter;

    DBHalper dbHalper;

    List<StudentInfo> infoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        dbHalper = new DBHalper(ShowActivity.this);
        infoList = dbHalper.getAllInfo();

        infoRecycler = findViewById(R.id.infoRecycler);
        infoRecycler.setLayoutManager(new LinearLayoutManager(ShowActivity.this));
        infoAdapter = new InfoAdapter(ShowActivity.this, infoList);
        infoRecycler.setAdapter(infoAdapter);
    }
}