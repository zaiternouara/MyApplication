package com.example.myapplication.ui.ajouter;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Connection.NetworkConnection;
import com.example.myapplication.R;
import com.example.myapplication.models.MEDICAMENTS;
import com.example.myapplication.viewModel.MedicamentsViewModel;

import java.util.List;

public class DashboardFragment extends Fragment implements View.OnClickListener {

   /* public static final int ADD_NOTE_REQUEST = 1;
    private MedicamentsViewModel medicamentSviewModel;
    // public static final int ADD_NOTE_REQUEST = 1;
    private ImageView logo;
    private TextView textView1;
    private  TextView classeTh;
    private TextView  nomM;
    private TextView  labo;
    private TextView  denom;
    private TextView  form;
    private TextView  duree;
    private TextView  lot;
    private TextView  dateF;
    private TextView  dateP;
    private TextView  descr;
    private TextView  prix;
    private TextView  quant;
    private TextView  codeB;
    //private RadioGroup question;private RadioButton rembou;

    private Button ajout;


    private DashboardViewModel dashboardViewModel;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //final TextView textView = root.findViewById(R.id.text_dashboard);
        logo=(ImageView) root.findViewById(R.id.imageView);

        textView1=(TextView) root.findViewById(R.id.textView);
        classeTh = (TextView) root.findViewById(R.id.inputClass);
        nomM = (TextView) root.findViewById(R.id.inputNom);
        labo = (TextView) root.findViewById(R.id.inputLabo);
        denom = (TextView) root.findViewById(R.id.inputDenom);
        form = (TextView) root.findViewById(R.id.inputForm);
        duree = (TextView) root.findViewById(R.id.inputDuree);
        dateF = (TextView) root.findViewById(R.id.inputDateF);
        dateP = (TextView) root.findViewById(R.id.inputDateP);
        descr = (TextView) root.findViewById(R.id.inputDescr);
        prix = (TextView) root.findViewById(R.id.inputPrix);
        quant = (TextView) root.findViewById(R.id.inputQuant);
        codeB = (TextView) root.findViewById(R.id.inputCode);
        //question=(RadioGroup)root.findViewById((R.id.question));
        lot= (TextView) root.findViewById(R.id.inputLot);
        ajout=(Button)root.findViewById(R.id.ajout);

        ajout.setOnClickListener(this);





        /*dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ajout){
            ajouterM();
        }
    }

    private void ajouterM(){
        String NomCommercial = nomM.getText().toString();
        String classTH = classeTh.getText().toString();
        String description = descr.getText().toString();
        String laboratoire = labo.getText().toString();
        String denomination = denom.getText().toString();
        String lots = lot.getText().toString();
        String formePharmaceutique = form.getText().toString();
        String dureee = duree.getText().toString();
        String dateFab = dateF.getText().toString();
        String datePer = dateP.getText().toString();
        String price = prix.getText().toString();
        String quantite = quant.getText().toString();
        String codeBarre = codeB.getText().toString();
       // String rembour = rembou.getText().toString();

        if (NomCommercial.trim().isEmpty() || description.trim().isEmpty()|| classTH.trim().isEmpty()|| laboratoire.trim().isEmpty()|| lots.trim().isEmpty()|| denomination.trim().isEmpty()|| formePharmaceutique.trim().isEmpty()|| dureee.trim().isEmpty()|| dateFab.trim().isEmpty()|| datePer.trim().isEmpty()|| price.trim().isEmpty()|| quantite.trim().isEmpty()|| codeBarre.trim().isEmpty()) {
            Toast.makeText(getContext(), "Entrez tous les champs", Toast.LENGTH_SHORT).show();

        }
        MEDICAMENTS medicaments = new MEDICAMENTS(classTH,NomCommercial, laboratoire,denomination,formePharmaceutique ,dureee,lots,dateFab,datePer ,description,price,quantite);
        medicamentSviewModel.insert(medicaments);
        Toast.makeText(getContext(), "medicament  saved", Toast.LENGTH_SHORT).show();

    }
        /*Intent data = new Intent();

        data.getStringExtra(EXTRA_NomC);
        String classTH = data.getStringExtra(EXTRA_classeTH);
        String labo = data.getStringExtra(EXTRA_Labo);
        String description = data.getStringExtra(EXTRA_DESCRIPTION);
        String denom = data.getStringExtra(EXTRA_Denom);
        String formePH = data.getStringExtra(EXTRA_form);
        String dure = data.getStringExtra(EXTRA_duree);
        String dateF = data.getStringExtra(EXTRA_dateF);
        String dateP = data.getStringExtra(EXTRA_dateP);
        String price = data.getStringExtra(EXTRA_Price);
        String quant = data.getStringExtra(EXTRA_quant);
        String codeB = data.getStringExtra(EXTRA_codeB);
        String oui = data.getStringExtra(EXTRA_oui);
        String non = data.getStringExtra(EXTRA_non);
        String lots = data.getStringExtra(EXTRA_lot);*/


         /*else {
        Toast.makeText(this, "medicament not saved", Toast.LENGTH_SHORT).show();
    }

        /*getActivity().setResult(RESULT_OK, data);
        getActivity().finish();
        medicamentSviewModel.insert(data);
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final ImageView logo;
    private static final TextView textView1;
    private static final  TextView classeTh;
    private static final TextView  nomM;
    private static final TextView  labo;
    private static final TextView  denom;
    private static final TextView  form;
    private static final TextView  duree;
    private static final TextView  lot;
    private static final TextView  dateF;
    private static final TextView  dateP;
    private static final TextView  descr;
    private static final TextView  prix;
    private static final TextView  quant;
    private static final TextView  codeB;
    // TODO: Rename and change types of parameters
    private ImageView mlogo;
    private TextView mtextView1;
    private  TextView mclasseTh;
    private TextView  mnomM;
    private TextView  mlabo;
    private TextView  mdenom;
    private TextView  mform;
    private TextView  mduree;
    private TextView  mlot;
    private TextView  mdateF;
    private TextView  mdateP;
    private TextView  mdescr;
    private TextView  mprix;
    private TextView  mquant;
    private TextView  mcodeB;
    private View userInfoView = null;
    private MedicamentsViewModel userListViewModel;
    public DashboardFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserInfoFragment.

    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String classTH,NomCommercial, laboratoire,denomination,formePharmaceutique ,dureee,lots,dateFab,datePer ,description,price,quantite) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        userListViewModel = ViewModelProviders.of(getActivity()).get(UserListViewModel.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        userInfoView =  inflater.inflate(R.layout.fragment_user_info, container, false);
        initViews(userInfoView);
        return  userInfoView;
    }
    EditText userName,userOccupation;
    Button saveUser;
    private void initViews(View view){
        userName = (EditText) view.findViewById(R.id.user_name);
        userOccupation = (EditText)view.findViewById(R.id.user_occupation);
        saveUser = (Button) view.findViewById(R.id.save_info);
        saveUser.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.save_info){
            saveInfo();
        }
    }
    private void saveInfo(){
        if(!TextUtils.isEmpty(userName.getText().toString()) && !TextUtils.isEmpty(userOccupation.getText().toString())){
            String name = userName.getText().toString();
            String userOccup = userOccupation.getText().toString();
            User user = new User(name,userOccup);
            userListViewModel.insert(user);
            userName.setText("");
            userOccupation.setText("");
        }else{
            Toast.makeText(getActivity(),"Plz Fill Required info...",Toast.LENGTH_LONG).show();
        }
    }

*/

    public static final int ADD_NOTE_REQUEST = 1;

    private ImageView logo;
    private TextView textView1;
    private TextView classeTh;
    private TextView nomM;
    private TextView labo;
    private TextView denom;
    private TextView form;
    private TextView duree;
    private TextView lot;
    private TextView dateF;
    private TextView dateP;
    private TextView descr;
    private TextView prix;
    private TextView quant;
    private TextView codeB;
    private RadioButton boui;
    private RadioButton bnon;
    private Button ajout;


    private MedicamentsViewModel medicamentSviewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //final TextView textView = root.findViewById(R.id.text_dashboard);
        logo = (ImageView) root.findViewById(R.id.imageView);

        textView1 = (TextView) root.findViewById(R.id.textView);
        classeTh = (TextView) root.findViewById(R.id.inputClass);
        nomM = (TextView) root.findViewById(R.id.inputNom);
        labo = (TextView) root.findViewById(R.id.inputLabo);
        denom = (TextView) root.findViewById(R.id.inputDenom);
        form = (TextView) root.findViewById(R.id.inputForm);
        duree = (TextView) root.findViewById(R.id.inputDuree);
        dateF = (TextView) root.findViewById(R.id.inputDateF);
        dateP = (TextView) root.findViewById(R.id.inputDateP);
        descr = (TextView) root.findViewById(R.id.inputDescr);
        prix = (TextView) root.findViewById(R.id.inputPrix);
        quant = (TextView) root.findViewById(R.id.inputQuant);
        codeB = (TextView) root.findViewById(R.id.inputCode);
        lot = (TextView) root.findViewById(R.id.inputLot);


        ajout = (Button) root.findViewById(R.id.ajout);

        ajout.setOnClickListener(this);

        return root;
    }

    private void ajouterM() {

        String NomCommercial = nomM.getText().toString();
        String classTH = classeTh.getText().toString();
        String description = descr.getText().toString();
        String laboratoire = labo.getText().toString();
        String denomination = denom.getText().toString();
        String lots = lot.getText().toString();
        String formePharmaceutique = form.getText().toString();
        String dureee = duree.getText().toString();
        String dateFab = dateF.getText().toString();
        String datePer = dateP.getText().toString();
        String price = prix.getText().toString();
        String quantite = quant.getText().toString();
        String codeBarre = codeB.getText().toString();

        if (NomCommercial.trim().isEmpty() || description.trim().isEmpty() || classTH.trim().isEmpty() || laboratoire.trim().isEmpty() || lots.trim().isEmpty() || denomination.trim().isEmpty() || formePharmaceutique.trim().isEmpty() || dureee.trim().isEmpty() || dateFab.trim().isEmpty() || datePer.trim().isEmpty() || price.trim().isEmpty() || quantite.trim().isEmpty() || codeBarre.trim().isEmpty()) {

            Toast.makeText(getContext(), "Entrez tous les champs", Toast.LENGTH_SHORT).show();

            return;
        }
        MEDICAMENTS medicaments = new MEDICAMENTS(classTH, NomCommercial, laboratoire, denomination, formePharmaceutique, dureee, lots, dateFab, datePer, description, price, quantite);
         medicamentSviewModel = ViewModelProviders.of(this).get(MedicamentsViewModel.class);
         NetworkConnection network = new NetworkConnection(getContext());

        // Check network connection
        /*if (network.isConnected()){
            Toast.makeText(getContext(), "Network connection is available", Toast.LENGTH_SHORT).show();
            medicamentSviewModel.insertWS(medicaments);
        }else{*/
            Toast.makeText(getContext(), "Network connection is not available", Toast.LENGTH_SHORT).show();
            medicamentSviewModel.insert(medicaments);
        //}


        Toast.makeText(getContext(), "medicament saved", Toast.LENGTH_SHORT).show();


        //getActivity().setResult(Activity.RESULT_OK, data);
        //getActivity().finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ajout) {
            ajouterM();
            nomM.setText(null);
            classeTh.setText(null);
            descr.setText(null);
            lot.setText(null);
            labo.setText(null);
            denom.setText(null);
            form.setText(null);
            duree.setText(null);
            dateF.setText(null);
            dateP.setText(null);
            prix.setText(null);
            quant.setText(null);
            codeB.setText(null);


        }
    }
}