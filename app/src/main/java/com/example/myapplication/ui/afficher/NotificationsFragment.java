package com.example.myapplication.ui.afficher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.ui.afficherTous.afficherTousMedoc;
import com.example.myapplication.ui.home.HomeFragment;

public class NotificationsFragment extends Fragment implements View.OnClickListener {
    private Button affiT;
    private Button affiL;
    private Button affiR;

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        affiT = root.findViewById(R.id.button5);
        affiL = root.findViewById(R.id.pLabo);
        affiR = root.findViewById(R.id.expire);
        affiT.setOnClickListener(this);




        return root;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.button5:
                fragment = new afficherTousMedoc();
                replaceFragment(fragment);
                break;

        }
        switch (v.getId()) {
            case R.id.pLabo:
                fragment = new afficherTousMedoc();
                replaceFragment(fragment);
                break;

        }
        switch (v.getId()) {
            case R.id.expire:
                fragment = new afficherTousMedoc();
                replaceFragment(fragment);
                break;

        }

    }

    public void replaceFragment(Fragment someFragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.setReorderingAllowed(true);
        transaction.replace(R.id.HOI, someFragment);
        transaction.addToBackStack(null);
        //transaction.remove(new NotificationsFragment());
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        //
        // transaction.addToBackStack(null);
        transaction.commit();
    }
}
