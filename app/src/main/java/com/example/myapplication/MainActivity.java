package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.ui.afficher.NotificationsFragment;
import com.example.myapplication.ui.afficherTous.afficherTousMedoc;
import com.example.myapplication.ui.ajouter.DashboardFragment;
import com.example.myapplication.ui.home.HomeFragment;
import com.example.myapplication.ui.modifier.ModifierFragment;
import com.example.myapplication.viewModel.MedicamentsViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navView = findViewById(R.id.nav_view);
       navView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeFragment()).commit();



        }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod= new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment =null;
                    switch (menuItem.getItemId())
                    {
                        case R.id.navigation_home:
                            fragment=new HomeFragment();
                            break;

                        case R.id.navigation_dashboard:
                            fragment=new DashboardFragment();
                            break;

                        case R.id.navigation_notifications:
                            fragment=new NotificationsFragment();
                            break;
                        case R.id.navigation_modifier:
                            fragment=new ModifierFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment,fragment).commit();

                    return true;
                }
            };

    }

