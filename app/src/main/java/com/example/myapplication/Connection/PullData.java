package com.example.myapplication.Connection;

import androidx.lifecycle.LifecycleOwner;

import com.example.myapplication.viewModel.MedicamentsViewModel;

public class PullData {
     LifecycleOwner lifecyrcle;
    MedicamentsViewModel medicamentSviewModel;
    public PullData(LifecycleOwner lifecyrcle,  MedicamentsViewModel medicamentSviewModel){
         this.lifecyrcle=lifecyrcle;
        this.medicamentSviewModel=medicamentSviewModel;
    }
    public void pulltoserver(){

        medicamentSviewModel.pull(lifecyrcle);

    }
}

