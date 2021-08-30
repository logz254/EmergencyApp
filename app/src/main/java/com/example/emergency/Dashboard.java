package com.example.emergency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    BottomNavigationView navigationView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //this line hide action bar

      //  getSupportActionBar().hide();


        navigationView=findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);

        navigationView.setOnNavigationItemSelectedListener(item -> {

            Fragment fragment=null;
            switch(item.getItemId()){
                case R.id.nav_home:
                    fragment=new HomeFragment();
                    break;

                case R.id.nav_search:
                    fragment=new SearchFragment();
                    break;

                case R.id.about:
                    fragment=new AboutFragment();
                    break;

                case R.id.profile:
                    fragment=new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.body_container,fragment).commit();

            return false;
        });

    }
}