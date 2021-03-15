package com.example.myapplication.Repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.myapplication.models.MEDICAMENTS;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WebServiceRepository {

    MutableLiveData<List<MEDICAMENTS>> myList;

    public WebServiceRepository(Application application) {
        myList = new MutableLiveData<>();
        getListFromServer(application);

    }

    private void getListFromServer(Application application) {
        String url ="http://192.168.43.80/GetAllMedicaments";
        JsonArrayRequest JsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                List<MEDICAMENTS> medicamentslist= new ArrayList<>();
                for (int i=0; i<response.length();i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        String Classe_Therapeutique = jsonObject.getString("Classe_Therapeutique");
                        String Nom_Commercial = jsonObject.getString("Nom_Commercial");
                        String Laboratoire = jsonObject.getString("Laboratoire");
                        String Denominateur_De_Medicament = jsonObject.getString("Denominateur_De_Medicament");
                        String Forme_Pharmaceutique = jsonObject.getString("Forme_Pharmaceutique");
                        String Duree_De_Conservation = jsonObject.getString("Duree_De_Conservation");
                        String Remborsable = jsonObject.getString("Remborsable");
                        String Lot = jsonObject.getString("Lot");
                        String Date_De_Fabrication = jsonObject.getString("Date_De_Fabrication");
                        String Date_Peremption = jsonObject.getString("Date_Peremption");
                        String Description_De_Composant = jsonObject.getString("Description_De_Composant");
                        String Prix = jsonObject.getString("Prix");
                        String Quantite_En_Stock = jsonObject.getString("Quantite_En_Stock");
                        MEDICAMENTS medicamentsC = new MEDICAMENTS(Classe_Therapeutique,Nom_Commercial,Laboratoire,Denominateur_De_Medicament,Forme_Pharmaceutique,Duree_De_Conservation,Lot,Date_De_Fabrication,Date_Peremption,Description_De_Composant,Prix,Quantite_En_Stock);
                        medicamentslist.add(medicamentsC);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                myList.setValue(medicamentslist);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                 //cree l erreur

            }
        });
         MyfileRequeteSingleton.getInstance(application).addToRequestQueue(JsonArrayRequest);
    }

    public MutableLiveData<List<MEDICAMENTS>> getMyList() {
        return myList;
    }
}
