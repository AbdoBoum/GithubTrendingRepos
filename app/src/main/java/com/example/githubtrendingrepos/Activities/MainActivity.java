package com.example.githubtrendingrepos.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.githubtrendingrepos.Fragements.SettingsFragmenet;
import com.example.githubtrendingrepos.Fragements.TrendingFragment;
import com.example.githubtrendingrepos.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.bottom_nav)
    BottomNavigationView bottomNavigationView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListner);
        navigateTo(TrendingFragment.newInstance());
    }

    public void navigateTo(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.addToBackStack(fragment.getClass().toString());
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragmenet = null;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_trending:
                            selectedFragmenet = TrendingFragment.newInstance();
                            toolbar.setTitle("Trending Repos");
                            break;
                        case R.id.nav_settings:
                            selectedFragmenet = SettingsFragmenet.newInstance();
                            toolbar.setTitle("Settings");
                            break;
                    }
                    navigateTo(selectedFragmenet);
                    return true;
                }
            };


}
