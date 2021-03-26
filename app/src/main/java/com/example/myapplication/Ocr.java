package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Adapter.MedicamentAdapter;
import com.example.myapplication.ui.afficher.NotificationsFragment;
import com.example.myapplication.ui.afficherTous.SearchResults;
import com.example.myapplication.ui.afficherTous.afficher_details;
import com.example.myapplication.viewModel.MedicamentsViewModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;

import java.util.ResourceBundle;

public class Ocr extends AppCompatActivity implements View.OnClickListener {
    private Button b;
    private TextView tv;
    private MedicamentsViewModel medicamentSviewModel;
    private EditText recherche;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr2);
        tv = (TextView) findViewById(R.id.th);
        b = (Button) findViewById(R.id.essai);
        recherche = findViewById(R.id.inputRecherche);


        b.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle=data.getExtras();
        Bitmap image =(Bitmap)bundle.get("data");

        InputImage inputImage= InputImage.fromBitmap(image,0);
        TextRecognizer analyzer= TextRecognition.getClient();
        Task<Text> reslt=analyzer.process(inputImage).addOnSuccessListener(new OnSuccessListener<Text>() {
            @Override
            public void onSuccess(Text text) {
               /* Fragment fragment = new SearchResults();
                String rechercher = text.getText();
                Bundle i = new Bundle();
                i.putString("result", rechercher);
                fragment.setArguments(i);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.con, fragment)
                        .commit();*/


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });    }
    /*
    public void goCamera(View root){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle=data.getExtras();
        Bitmap image =(Bitmap)bundle.get("data");

        InputImage inputImage= InputImage.fromBitmap(image,0);
        TextRecognizer analyzer= TextRecognition.getClient();


        Task<Text> reslt=analyzer.process(inputImage).addOnSuccessListener(new OnSuccessListener<Text>() {
            @Override
            public void onSuccess(Text text) {
                //String result = text.getText();
                tv.setText(text.getText());

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }*/
}