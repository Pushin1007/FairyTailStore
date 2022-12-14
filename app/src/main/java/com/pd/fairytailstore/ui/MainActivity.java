package com.pd.fairytailstore.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.pd.fairytailstore.Navigation;
import com.pd.fairytailstore.R;


public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    private Navigation navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = new Navigation(getSupportFragmentManager());
        if (savedInstanceState == null) {
            navigation.addFragment(StoryListFragment.newInstance(), false);
            getSupportFragmentManager().addOnBackStackChangedListener(this);
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, StoryListFragment.newInstance()).commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    @Override
    public void onBackStackChanged() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

}