package com.moremoregreen.androidrclgrouplist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.moremoregreen.androidrclgrouplist.Adapter.AlphabetAdapter;
import com.moremoregreen.androidrclgrouplist.Interface.IOnAlphabetClickListener;

public class AlphabetActivity extends AppCompatActivity {
    RecyclerView recycler_alphabet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        recycler_alphabet = findViewById(R.id.recycler_alphabet);
        AlphabetAdapter alphabetAdapter = new AlphabetAdapter();
        alphabetAdapter.setiOnAlphabetClickListener(new IOnAlphabetClickListener() {
            @Override
            public void onAlphabetClickListener(String alphabet, int position) {
                if (position!=-1){
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result",alphabet);
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }
            }
        });
        recycler_alphabet.setLayoutManager(new GridLayoutManager(this,4));
        recycler_alphabet.setAdapter(alphabetAdapter);

    }
}
