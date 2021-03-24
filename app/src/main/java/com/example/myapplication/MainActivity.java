package com.example.myapplication;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Connection.BroadcastReceiverNetwork;
import com.example.myapplication.Connection.NetworkConnection;
import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.ui.afficher.NotificationsFragment;
import com.example.myapplication.ui.ajouter.DashboardFragment;
import com.example.myapplication.ui.home.HomeFragment;
import com.example.myapplication.ui.modifier.ModifierFragment;
import com.example.myapplication.viewModel.MedicamentsViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiverNetwork networkReceiver;
    private final BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_home:
                            fragment = new HomeFragment();
                            break;

                        case R.id.navigation_dashboard:
                            fragment = new DashboardFragment();
                            break;

                        case R.id.navigation_notifications:
                            fragment = new NotificationsFragment();
                            break;
                        case R.id.navigation_modifier:
                            fragment = new ModifierFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, fragment).commit();

                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        NetworkConnection network = new NetworkConnection(getApplicationContext());
        LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        if (network.isConnected()) {

            //Toast.makeText(getApplicationContext(), "Is Connected", Toast.LENGTH_SHORT).show();
            //MedicamentsViewModel medicamentSviewModel = new ViewModelProvider(this).get(MedicamentsViewModel.class);
            //medicamentSviewModel.pull(this);

        } else {
            //Toast.makeText(getApplicationContext(), "Is not connected", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onPause() {
        super.onPause();
        if (networkReceiver != null) {
            unregisterReceiver(networkReceiver);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkReceiver, intentFilter);
    }


}

