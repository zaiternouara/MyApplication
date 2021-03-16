package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ImageView logo;
    private FrameLayout backgr;
    private Button scanner;
    private Button appareil;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        logo = (ImageView) root.findViewById(R.id.imageView);
        backgr = (FrameLayout) root.findViewById(R.id.imageView2);
        scanner = (Button) root.findViewById(R.id.button3);
        appareil = (Button) root.findViewById(R.id.button4);


       /* homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            /*public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

}