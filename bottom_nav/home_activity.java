package com.example.policeapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import static com.example.policeapp.R.id.home;
import static com.example.policeapp.R.id.hp;

public class HomeActivity extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        chipNavigationBar=(ChipNavigationBar)findViewById(R.id.chnv);

        chipNavigationBar.setItemSelected(home,true);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new complain_fragment()).commit();
        bottomMenu();
    }

    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override

            public void onItemSelected(int i) {
                Fragment fragment=null;
                switch (i){
                    case home:
                        fragment=new complain_fragment();
                        break;

                    case R.id.explore:
                        fragment=new report_un();
                        break;


                    case hp:
                        fragment=new help_other_fragment();
                        break;
                    case R.id.profile:
                        fragment=new profile();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
            }
        });

    }

}
