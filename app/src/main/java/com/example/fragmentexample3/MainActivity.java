package com.example.fragmentexample3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean twoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if we cannot find the second fragment in the main layout
        // that means we are in portrait

        if(findViewById(R.id.fragContainerView_land_second) != null){
            twoPane = true;
        }

        // loading in 1 or 2 fragments based on the layout
        if(!twoPane){ // port
            loadFragment(new FirstFragment(), R.id.fragContainerView_first);
            Button button = findViewById(R.id.button_Personality);
            Button button1 = findViewById(R.id.button_HouseInfo);
            button.setOnClickListener(v -> launchActivity(v));
            button1.setOnClickListener(v -> launchActivity1(v));
        }

        else{
            loadFragment(new FirstFragment(), R.id.fragContainerView_land_first);
            loadFragment(new SecondFragment(), R.id.fragContainerView_land_second);
            loadFragment(new ThirdFragment(), R.id.fragContainerView_land_third);
        }

    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public void launchActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void launchActivity1(View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}