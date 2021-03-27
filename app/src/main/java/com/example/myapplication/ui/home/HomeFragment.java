package com.example.myapplication.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.CodeBare.CaptureAct;
import com.example.myapplication.CodeBare.IntentIntegratorClass;
import com.example.myapplication.R;
import com.example.myapplication.ui.afficherTous.SearchCodeBareResults;
import com.example.myapplication.ui.afficherTous.searchByOcr;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class HomeFragment extends Fragment implements View.OnClickListener {

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
        logo = root.findViewById(R.id.imageView);
        backgr = root.findViewById(R.id.imageView2);
        scanner = root.findViewById(R.id.button3);
        appareil = root.findViewById(R.id.button4);
        scanner.setOnClickListener(this);


        Fragment fragment = null;

        appareil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanCode();
            }

        });

        return root;
    }

    private void scanCode() {
        IntentIntegratorClass integrator = new IntentIntegratorClass(getActivity(), this);
        integrator.setCaptureActivity(CaptureAct.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scanning Code");
        integrator.initiateScan();
    }



    public void goCamera() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Bundle bundle = data.getExtras();
            Bitmap image = (Bitmap) bundle.get("data");

            InputImage inputImage = InputImage.fromBitmap(image, 0);
            TextRecognizer analyzer = TextRecognition.getClient();
            Task<Text> reslt = analyzer.process(inputImage).addOnSuccessListener(new OnSuccessListener<Text>() {
                @Override
                public void onSuccess(Text text) {

                    Fragment fragment = new searchByOcr();
                    String rechercher = text.getText();
                    Bundle i = new Bundle();
                    i.putString("result", rechercher);
                    fragment.setArguments(i);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        } else {


            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (result != null) {


                if (result.getContents() != null) {
                    codeBarre(result.getContents());

                    Fragment fragment;
                    fragment = new SearchCodeBareResults();
                    Bundle i = new Bundle();
                    i.putString("result", result.getContents());
                    fragment.setArguments(i);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                    fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,fragment)
                            .commit();



                } else {
                    nofound();                }

            } else {
                //super.onActivityResult(requestCode, resultCode, data);
            }

        }


    }


    @Override
    public void onClick(View v) {
        goCamera();

    }
    public void codeBarre(String S) {

        Snackbar.make(getView(), "Le code est "+S, Snackbar.LENGTH_LONG)
                .setAction("Génial !", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    public void nofound() {

        Snackbar.make(getView(),"Médicament introuvable" , Snackbar.LENGTH_LONG)
                .setAction("Génial !", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }






}