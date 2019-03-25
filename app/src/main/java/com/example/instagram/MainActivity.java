package com.example.instagram;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.instagram.Fragment.HomeFragment;
import com.example.instagram.Fragment.NotificationFragment;
import com.example.instagram.Fragment.ProfileFragment;
import com.example.instagram.Fragment.SearchFragment;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragmet = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        Bundle intent = getIntent().getExtras();
        if(intent != null){
            String publisher = intent.getString("publisherid");

            SharedPreferences.Editor editor = getSharedPreferences("PREFS",MODE_PRIVATE).edit();
            editor.putString("profileid",publisher);
            editor.apply();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,new ProfileFragment()).commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,new HomeFragment()).commit();

        }



    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragmet = new HomeFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragmet = new SearchFragment();
                            break;
                        case R.id.nav_add:
                            selectedFragmet = null;
                            startActivity(new Intent(MainActivity.this,PostActivity.class));
                            break;
                        case R.id.nav_heart:
                            selectedFragmet = new NotificationFragment();
                            break;
                        case R.id.nav_profile:
                            SharedPreferences.Editor editor = getSharedPreferences("PREFS",MODE_PRIVATE).edit();
                            editor.putString("profileid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                            editor.apply();
                            selectedFragmet = new ProfileFragment();
                            break;

                    }
                    if(selectedFragmet != null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragmet).commit();
                    }
                    return true;
                }
            };
}
