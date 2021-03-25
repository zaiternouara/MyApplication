package com.example.myapplication.ui.home;

import android.app.Activity;
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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Ocr;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;

public class HomeFragment extends Fragment  implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    private ImageView logo;
    private FrameLayout backgr;
    private Button scanner;
    private Button appareil;
    private TextView tv;
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
        tv = (TextView) root.findViewById(R.id.textView2);
        scanner.setOnClickListener(this);


       /* homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            /*public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    private void moveToNewActivity () {

        Intent i = new Intent(getActivity(), Ocr.class);
        startActivity(i);
        ((Activity) getActivity()).overridePendingTransition(0, 0);

    }

    /*public void goCamera(View root){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle=data.getExtras();
        Bitmap image =(Bitmap)bundle.get("data");

        InputImage inputImage= InputImage.fromBitmap(image,0);
        TextRecognizer analyzer= TextRecognition.getClient();

        Task <Text> reslt=analyzer.process(inputImage).addOnSuccessListener(new OnSuccessListener<Text>() {
            @Override
            public void onSuccess(Text text) {
            tv.setText(text.getText());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }*/

    @Override
    public void onClick(View v) {

        moveToNewActivity ();
    }
}