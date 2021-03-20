package com.example.myapplication.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.myapplication.models.MEDICAMENTS;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebServiceRep implements GlobaleRepository {
    MutableLiveData<List<MEDICAMENTS>> myList;
    MutableLiveData<List<MEDICAMENTS>> myListLaboratoire;
    MutableLiveData<List<MEDICAMENTS>> myListSearch;
    String search;

    public WebServiceRep(Application application) {
        myList = new MutableLiveData<>();
        myListLaboratoire = new MutableLiveData<>();
        myListSearch = new MutableLiveData<>();
        getListFromServer(application);
        getListLaboratoireFromServer(application);
        getListOfSearchFromServer(application, search);

    }

    @Override
    public void insert(MEDICAMENTS medicament) {
        AddMedicament(medicament);
    }

    @Override
    public void update(MEDICAMENTS medicament) {


    }

    @Override
    public void delete(MEDICAMENTS medicament) {
        deleteMe(medicament);

    }

    @Override
    public void deleteAllMedicaments() {

    }

    @Override
    public MutableLiveData<List<MEDICAMENTS>> getAllMedicaments() {
        return myList;
    }

    @Override
    public MutableLiveData<List<MEDICAMENTS>> getAllaboratoires() {
        return myListLaboratoire;
    }

    @Override
    public MutableLiveData<List<MEDICAMENTS>> getSearchMedicamemts(String search) {
        return null;
    }

    @Override
    public MutableLiveData<List<MEDICAMENTS>> getSearchMedicamemts(Application application, String search) {
            return getListOfSearchFromServer(application, search);
        }



    @Override
    public LiveData<List<MEDICAMENTS>> getAllMedicamentsPeremptions() {
        return null;
    }





    private void getListFromServer(Application application) {
        String url = "http://172.20.10.2/GetAllMedicaments";
        JsonArrayRequest JsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                List<MEDICAMENTS> medicamentslist = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
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
                        String Code_a_Bare = jsonObject.getString("Code_a_Bare");
                        MEDICAMENTS medicamentsC = new MEDICAMENTS(Classe_Therapeutique, Nom_Commercial, Laboratoire, Denominateur_De_Medicament, Forme_Pharmaceutique, Duree_De_Conservation, Lot,Remborsable,Date_De_Fabrication, Date_Peremption, Description_De_Composant, Prix, Quantite_En_Stock,Code_a_Bare);
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

    private void getListLaboratoireFromServer(Application application) {
        String url = "http://172.20.10.2/GetAllLaboratoire";
        JsonArrayRequest JsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                List<MEDICAMENTS> medicamentslist = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
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
                        String Code_a_Bare = jsonObject.getString("Code_a_Bare");
                        MEDICAMENTS medicamentsC = new MEDICAMENTS(Classe_Therapeutique, Nom_Commercial, Laboratoire, Denominateur_De_Medicament, Forme_Pharmaceutique, Duree_De_Conservation, Lot,Remborsable,Date_De_Fabrication, Date_Peremption, Description_De_Composant, Prix, Quantite_En_Stock,Code_a_Bare);
                        medicamentslist.add(medicamentsC);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                myListLaboratoire.setValue(medicamentslist);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //cree l erreur

            }
        });
        MyfileRequeteSingleton.getInstance(application).addToRequestQueue(JsonArrayRequest);
    }

    private MutableLiveData<List<MEDICAMENTS>> getListOfSearchFromServer(Application application, String search) {
        String url = "http://172.20.10.2/Search";
        JsonArrayRequest JsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                List<MEDICAMENTS> medicamentslist = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
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
                        String Code_a_Bare = jsonObject.getString("Code_a_Bare");
                        MEDICAMENTS medicamentsC = new MEDICAMENTS(Classe_Therapeutique, Nom_Commercial, Laboratoire, Denominateur_De_Medicament, Forme_Pharmaceutique, Duree_De_Conservation, Lot,Remborsable,Date_De_Fabrication, Date_Peremption, Description_De_Composant, Prix, Quantite_En_Stock,Code_a_Bare);
                        medicamentslist.add(medicamentsC);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                myListSearch.setValue(medicamentslist);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //cree l erreur

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("a", search);

                return params;
            }
        };
        MyfileRequeteSingleton.getInstance(application).addToRequestQueue(JsonArrayRequest);
        return myListSearch;
    }

    public void AddMedicament(MEDICAMENTS medicaments) {
        String url = "http://172.20.10.2/createmedicament";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map medico = new HashMap();
                medico.put("Classe_Therapeutique", medicaments.getClasse_Therapeutique());
                medico.put("Nom_Commercial", medicaments.getNom_Commercial());
                medico.put("Laboratoire", medicaments.getLaboratoire());
                medico.put("Denominateur_De_Medicament", medicaments.getDenominateur_De_Medicament());
                medico.put("Forme_Pharmaceutique", medicaments.getForme_Pharmaceutique());
                medico.put("Duree_De_Conservation", medicaments.getDuree_De_Conservation());
                //medico.put("Remborsable",medicaments.get);
                medico.put("Lot", medicaments.getLot());
                medico.put("Date_De_Fabrication", medicaments.getDate_De_Fabrication());
                medico.put("Date_Peremption", medicaments.getDate_Peremption());
                medico.put("Description_De_Composant", medicaments.getDescription_De_Composant());
                medico.put("Prix", medicaments.getPrix());
                medico.put("Quantite_En_Stock", medicaments.getQuantite_En_Stock());
                //medico.put("Code_a_Bare", medicaments.getCode_a_Bare());

                return super.getParams();
            }
        };

    }

    public void deleteMe (MEDICAMENTS medicaments) {
        String url = "http://192.168.43.80//deletMedicament//{medicaments.getNom_Commercial()}";
        StringRequest request = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map medico = new HashMap();
                 medico.put("Nom_Commercial", medicaments.getNom_Commercial());

                return super.getParams();
            }
        };

    }


}
