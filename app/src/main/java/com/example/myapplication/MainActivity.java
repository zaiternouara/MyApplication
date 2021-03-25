package com.example.myapplication;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Connection.BroadcastReceiverNetwork;
import com.example.myapplication.Connection.NetworkConnection;
import com.example.myapplication.ui.afficher.NotificationsFragment;
import com.example.myapplication.ui.ajouter.DashboardFragment;
import com.example.myapplication.ui.home.HomeFragment;
import com.example.myapplication.ui.modifier.ModifierFragment;
import com.example.myapplication.viewModel.MedicamentsViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static LifecycleRegistry lifecycleRegistry;
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
    private BroadcastReceiverNetwork networkReceiver;
    private NetworkConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).commit();
        networkReceiver = new BroadcastReceiverNetwork(); 

        /*LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        //connection = new NetworkConnection(this);

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkReceiver, intentFilter);
        /*if (connection.isConnected() == true) {
            MedicamentsViewModel medicamentSviewModel = new ViewModelProvider(this).get(MedicamentsViewModel.class);
            medicamentSviewModel.pull(this);

        }*/

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
        /*Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        if (connection.isConnected() == true) {
             MedicamentsViewModel medicamentSviewModel = new ViewModelProvider(this).get(MedicamentsViewModel.class);
            medicamentSviewModel.pull(this);

        }*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (networkReceiver != null) {
            unregisterReceiver(networkReceiver);

        }

    }

    public void pull() {
        connection = new NetworkConnection(this);
        if (connection.isConnected() == true) {
            lifecycleRegistry = new LifecycleRegistry(this);
            lifecycleRegistry.markState(Lifecycle.State.CREATED);
            MedicamentsViewModel medicamentSviewModel = new ViewModelProvider(this).get(MedicamentsViewModel.class);
            medicamentSviewModel.pull(this);
        }
    }
}

