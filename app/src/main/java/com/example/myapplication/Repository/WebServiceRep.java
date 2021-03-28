package com.example.myapplication.Repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.myapplication.models.MEDICAMENTS;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WebServiceRep implements GlobaleRepository {
    MutableLiveData<List<MEDICAMENTS>> myList;
    MutableLiveData<List<MEDICAMENTS>> myListLaboratoire;
    MutableLiveData<List<MEDICAMENTS>> myListSearch;
    MutableLiveData<List<MEDICAMENTS>> myListSearchByCodeBare;
    MutableLiveData<List<MEDICAMENTS>> myListExpire;
    String search;
    Application application;

    public WebServiceRep(Application application) {
        myList = new MutableLiveData<>();
        myListLaboratoire = new MutableLiveData<>();
        myListExpire = new MutableLiveData<>();
        myListSearch = new MutableLiveData<>();
        myListSearchByCodeBare = new MutableLiveData<>();

        getListFromServer(application);
        getListLaboratoireFromServer(application);
        getListOfExpireFromServer(application);
        getListOfSearchFromServer(application, search);
        getListOfSearchByCodeBareFromServer(application, search);

        this.application = application;

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
        deleteMe(application, medicament);

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
    public MutableLiveData<List<MEDICAMENTS>> getAllExpire() {
        return myListExpire;
    }

    @Override
    public MutableLiveData<List<MEDICAMENTS>> getSearchMedicamemts(String search) {
        return myListSearch;
    }

    @Override
    public LiveData<List<MEDICAMENTS>> getSearchMedicamemtsByCodeBare(String search) {
        return null;
    }


    @Override
    public MutableLiveData<List<MEDICAMENTS>> getSearchMedicamemts(Application application, String search) {
        return getListOfSearchFromServer(application, search);
    }

    @Override
    public MutableLiveData<List<MEDICAMENTS>> getSearchMedicamemtsByCodeBare(Application application, String search) {
        return getListOfSearchByCodeBareFromServer(application, search);
    }


    private void getListFromServer(Application application) {
        String url = "http://192.168.1.3/WebService/public/GetAllMedicaments";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                List<MEDICAMENTS> medicamentslist = new ArrayList<>();
                try {

                    JSONArray jsonArray = null;
                    String k = null;
                    jsonArray = response.getJSONArray("medicament");
                    k = response.getString("error");
                    if (k == "false") {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

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
                                MEDICAMENTS medicamentsC = new MEDICAMENTS(Classe_Therapeutique, Nom_Commercial, Laboratoire, Denominateur_De_Medicament, Forme_Pharmaceutique, Duree_De_Conservation, Lot, Remborsable, Date_De_Fabrication, Date_Peremption, Description_De_Composant, Prix, Quantite_En_Stock, Code_a_Bare);
                                medicamentslist.add(medicamentsC);
                                //Log.d("Success", response.toString());

                            } catch (JSONException e) {
                                //e.printStackTrace();
                            }
                        }
                    }
                } catch (JSONException e) {
                    // e.printStackTrace();
                }

                myList.setValue(medicamentslist);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.d("Error", error.toString());
                //Toast.makeText(application, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MyfileRequeteSingleton.getInstance(application).addToRequestQueue(jsonObjectRequest);
    }

    private void getListLaboratoireFromServer(Application application) {
        String url = "http://192.168.1.3/WebService/public/GetAllLaboratoire";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                List<MEDICAMENTS> medicamentslist = new ArrayList<>();

                try {

                    JSONArray jsonArray = null;
                    String k = null;
                    jsonArray = response.getJSONArray("medicament");
                    k = response.getString("error");
                    if (k == "false") {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

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
                                MEDICAMENTS medicamentsC = new MEDICAMENTS(Classe_Therapeutique, Nom_Commercial, Laboratoire, Denominateur_De_Medicament, Forme_Pharmaceutique, Duree_De_Conservation, Lot, Remborsable, Date_De_Fabrication, Date_Peremption, Description_De_Composant, Prix, Quantite_En_Stock, Code_a_Bare);
                                medicamentslist.add(medicamentsC);
                                //Log.d("Success", response.toString());

                            } catch (JSONException e) {
                                // e.printStackTrace();
                            }
                        }
                    }
                } catch (JSONException e) {
                    //e.printStackTrace();
                }
                myListLaboratoire.setValue(medicamentslist);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //cree l erreur

            }
        });
        MyfileRequeteSingleton.getInstance(application).addToRequestQueue(jsonObjectRequest);
    }

    private void getListOfExpireFromServer(Application application) {
        String url = "http://192.168.1.3/WebService/public/GetAllExpire";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                List<MEDICAMENTS> medicamentslist = new ArrayList<>();
                try {

                    JSONArray jsonArray = null;
                    String k = null;
                    jsonArray = response.getJSONArray("medicament");
                    k = response.getString("error");
                    if (k == "false") {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

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
                                MEDICAMENTS medicamentsC = new MEDICAMENTS(Classe_Therapeutique, Nom_Commercial, Laboratoire, Denominateur_De_Medicament, Forme_Pharmaceutique, Duree_De_Conservation, Lot, Remborsable, Date_De_Fabrication, Date_Peremption, Description_De_Composant, Prix, Quantite_En_Stock, Code_a_Bare);
                                medicamentslist.add(medicamentsC);
                                //Log.d("Success", response.toString());

                            } catch (JSONException e) {
                                //e.printStackTrace();
                            }
                        }
                    }
                } catch (JSONException e) {
                    // e.printStackTrace();
                }

                myListExpire.setValue(medicamentslist);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.d("Error", error.toString());
                //Toast.makeText(application, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MyfileRequeteSingleton.getInstance(application).addToRequestQueue(jsonObjectRequest);
    }

    private MutableLiveData<List<MEDICAMENTS>> getListOfSearchFromServer(Application application, String search) {
        String url = "http://192.168.1.3/WebService/public/Search";

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("a", search);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                List<MEDICAMENTS> medicamentslist = new ArrayList<>();
                try {

                    JSONArray jsonArray = null;
                    String k = null;
                    jsonArray = response.getJSONArray("medicament");
                    k = response.getString("error");
                    if (k == "false") {


                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

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
                                MEDICAMENTS medicamentsC = new MEDICAMENTS(Classe_Therapeutique, Nom_Commercial, Laboratoire, Denominateur_De_Medicament, Forme_Pharmaceutique, Duree_De_Conservation, Lot, Remborsable, Date_De_Fabrication, Date_Peremption, Description_De_Composant, Prix, Quantite_En_Stock, Code_a_Bare);
                                medicamentslist.add(medicamentsC);
                                //Log.d("Success", response.toString());

                            } catch (JSONException e) {
                                //e.printStackTrace();
                            }
                        }
                    }

                } catch (JSONException e) {
                    //e.printStackTrace();
                }
                myListSearch.setValue(medicamentslist);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //cree l erreur

            }
        });

        MyfileRequeteSingleton.getInstance(application).addToRequestQueue(jsonObjectRequest);

        return myListSearch;
    }

    private MutableLiveData<List<MEDICAMENTS>> getListOfSearchByCodeBareFromServer(Application application, String search) {
        String url = "http://192.168.1.3/WebService/public/SearchByCodeBare";

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("a", search);

        } catch (JSONException e) {
            //e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                List<MEDICAMENTS> medicamentslist = new ArrayList<>();
                try {

                    JSONArray jsonArray = null;
                    String k = null;
                    jsonArray = response.getJSONArray("medicament");
                    k = response.getString("error");
                    if (k == "false") {


                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

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
                                MEDICAMENTS medicamentsC = new MEDICAMENTS(Classe_Therapeutique, Nom_Commercial, Laboratoire, Denominateur_De_Medicament, Forme_Pharmaceutique, Duree_De_Conservation, Lot, Remborsable, Date_De_Fabrication, Date_Peremption, Description_De_Composant, Prix, Quantite_En_Stock, Code_a_Bare);
                                medicamentslist.add(medicamentsC);
                                //Log.d("Success", response.toString());

                            } catch (JSONException e) {
                                //e.printStackTrace();
                            }
                        }
                    }

                } catch (JSONException e) {
                    //e.printStackTrace();
                }
                myListSearchByCodeBare.setValue(medicamentslist);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //cree l erreur

            }
        });

        MyfileRequeteSingleton.getInstance(application).addToRequestQueue(jsonObjectRequest);

        return myListSearchByCodeBare;
    }

    public void AddMedicament(MEDICAMENTS medicaments) {
        String url = "http://192.168.1.3/WebService/public/createmedicament";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Classe_Therapeutique", medicaments.getClasse_Therapeutique());
            jsonObject.put("Nom_Commercial", medicaments.getNom_Commercial());
            jsonObject.put("Laboratoire", medicaments.getLaboratoire());
            jsonObject.put("Denominateur_De_Medicament", medicaments.getDenominateur_De_Medicament());
            jsonObject.put("Forme_Pharmaceutique", medicaments.getForme_Pharmaceutique());
            jsonObject.put("Duree_De_Conservation", medicaments.getDuree_De_Conservation());
            jsonObject.put("Remborsable", medicaments.getRemboursable());
            jsonObject.put("Lot", medicaments.getLot());
            jsonObject.put("Date_De_Fabrication", medicaments.getDate_De_Fabrication());
            jsonObject.put("Date_Peremption", medicaments.getDate_Peremption());
            jsonObject.put("Description_De_Composant", medicaments.getDescription_De_Composant());
            jsonObject.put("Prix", medicaments.getPrix());
            jsonObject.put("Quantite_En_Stock", medicaments.getQuantite_En_Stock());
            jsonObject.put("Code_a_Bare", medicaments.getCodeB());

        } catch (JSONException e) {
            //e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    String message = response.getString("message");
                    Toast.makeText(application, message, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    //e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MyfileRequeteSingleton.getInstance(application).addToRequestQueue(jsonObjectRequest);

    }

    public void deleteMe(Application application, MEDICAMENTS medicaments) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Nom_Commercial", medicaments.getNom_Commercial());
        } catch (JSONException e) {
            //e.printStackTrace();
        }

        String url = "http://192.168.1.3/WebService/public/deletMedicament";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                url,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            String message = response.getString("message");
                            Toast.makeText(application, message, Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            //e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MyfileRequeteSingleton.getInstance(application).addToRequestQueue(request);

    }


}
