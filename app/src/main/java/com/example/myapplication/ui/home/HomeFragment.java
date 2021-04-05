package com.example.myapplication.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.CodeBare.CaptureAct;
import com.example.myapplication.CodeBare.IntentIntegratorClass;
import com.example.myapplication.Connection.NetworkConnection;
import com.example.myapplication.R;
import com.example.myapplication.ui.afficherTous.SearchCodeBareResults;
import com.example.myapplication.ui.afficherTous.searchByOcr;
import com.example.myapplication.viewModel.MedicamentsViewModel;
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

    private static LifecycleRegistry lifecycleRegistry;
    Fragment fragment = null;
    private HomeViewModel homeViewModel;
    private ImageView logo;
    private Button scanner;
    private Button CodeBare;
    private Button sync;
    private NetworkConnection connection;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        logo = root.findViewById(R.id.imageView);
        scanner = root.findViewById(R.id.button3);
        CodeBare = root.findViewById(R.id.button4);
        sync = root.findViewById(R.id.sync);

        sync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pull();
            }
        });

        scanner.setOnClickListener(this);


        CodeBare.setOnClickListener(new View.OnClickListener() {
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
        integrator.setPrompt("Le code en cours de scanne");
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

                    fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment)
                            .commit();


                } else {
                    nofound();
                }

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

        Snackbar.make(getView(), "Le code est " + S, Snackbar.LENGTH_LONG)
                .setAction("Génial !", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    public void nofound() {

        Snackbar.make(getView(), "Médicament introuvable", Snackbar.LENGTH_LONG)
                .setAction("Génial !", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    public void pull() {
        connection = new NetworkConnection(getContext());
        if (connection.isConnected() == true) {
            Toast.makeText(getContext(), "Internet is available ", Toast.LENGTH_SHORT).show();
            lifecycleRegistry = new LifecycleRegistry(this);
            lifecycleRegistry.markState(Lifecycle.State.CREATED);
            MedicamentsViewModel medicamentSviewModel = new ViewModelProvider(this).get(MedicamentsViewModel.class);
            medicamentSviewModel.pull(this);
            Toast.makeText(getContext(), "Les données ont été mis au serveur ", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "Internet is not available", Toast.LENGTH_SHORT).show();
        }
    }


}