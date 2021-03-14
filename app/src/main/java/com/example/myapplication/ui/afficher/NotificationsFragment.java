package com.example.myapplication.ui.afficher;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

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
import com.example.myapplication.ui.afficherTous.SearchResults;
import com.example.myapplication.ui.afficherTous.afficheTousLab;
import com.example.myapplication.ui.afficherTous.afficherTousMedoc;
import com.example.myapplication.ui.home.HomeFragment;

public class NotificationsFragment extends Fragment implements View.OnClickListener {
    private Button affiT;
    private Button affiL;
    private Button affiR;
    private EditText recherche;
    private Button rButton;

    private NotificationsViewModel notificationsViewModel;
    DataPassListener mCallback;

    public interface DataPassListener{
        public void passData(String data);
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        affiT = root.findViewById(R.id.button5);
        affiL = root.findViewById(R.id.pLabo);
        affiR = root.findViewById(R.id.expire);

        recherche=root.findViewById(R.id.inputRecherche);
        rButton=root.findViewById(R.id.button);


        affiT.setOnClickListener(this);
        affiL.setOnClickListener(this);
        affiR.setOnClickListener(this);
        rButton.setOnClickListener(this);


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
                fragment = new afficheTousLab();
                replaceFragment(fragment);
                break;

        }
        switch (v.getId()) {
            case R.id.expire:
                fragment = new afficherTousMedoc();
                mCallback.passData("Text to pass FragmentB");
                replaceFragment(fragment);
                break;

        }

        switch (v.getId()) {
            case R.id.button:
                fragment = new SearchResults();

                String rechercher = recherche.getText().toString();
                //String oui = boui.getText().toString();
                //String non = bnon.getText().toString();
                if (rechercher.trim().isEmpty() ) {

                    Toast.makeText(getContext(), "Entrez le champs", Toast.LENGTH_SHORT).show();

                    return;
                }
                Bundle i = new Bundle();
                i.putString("result", rechercher);


                fragment.setArguments(i);
                System.out.println(fragment);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.afficher
                                , fragment)
                        .commit();


                break;

        }


    }




    public void replaceFragment(Fragment someFragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.setReorderingAllowed(true);
        transaction.replace(R.id.afficher, someFragment);
        transaction.addToBackStack(null);
        //transaction.remove(new NotificationsFragment());
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        //
        // transaction.addToBackStack(null);
        transaction.commit();
    }
}
