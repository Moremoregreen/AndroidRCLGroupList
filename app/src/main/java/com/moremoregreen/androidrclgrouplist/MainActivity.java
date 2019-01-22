package com.moremoregreen.androidrclgrouplist;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.moremoregreen.androidrclgrouplist.Adapter.PersonAdapter;
import com.moremoregreen.androidrclgrouplist.Common.Common;
import com.moremoregreen.androidrclgrouplist.Common.LinearLayoutManagerWithSmoothScroller;
import com.moremoregreen.androidrclgrouplist.Model.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler_person;
    LinearLayoutManager layoutManager;
    ArrayList<Person> people = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_person = findViewById(R.id.recycler_person);
        layoutManager= new LinearLayoutManagerWithSmoothScroller(this);
        recycler_person.setLayoutManager(layoutManager);
        recycler_person.addItemDecoration(new DividerItemDecoration(this,layoutManager.getOrientation()));

        creatPersonList();
        PersonAdapter adapter = new PersonAdapter(this,people);
        recycler_person.setAdapter(adapter);

    }

    //Because in PersonAdapter wc calling startActivityForResult to start AlphabetActivity
    //And in AlphaActivity we have go back with value
    //So here we need override onActivityResult


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == Common.RESULT_CODE){
            if (resultCode == Activity.RESULT_OK){
                String group_character_clicked = data.getStringExtra("result");
                int position = Common.findPositionWithName(group_character_clicked,people);
                recycler_person.smoothScrollToPosition(position);
            }
        }
    }

    private void creatPersonList() {
        people = Common.genPeopleGroup();
        people = Common.sortList(people); //Sort
        people = Common.addAlphabets(people); //Add alphabet header


    }
}
