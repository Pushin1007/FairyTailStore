package com.pd.fairytailstore.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.pd.fairytailstore.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, StoryListFragment.newInstance()).commit();
        }
    }
}