package com.example.myapplication.CodeBare;

import android.app.Activity;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.google.zxing.integration.android.IntentIntegrator;

public final class IntentIntegratorClass extends IntentIntegrator {

    private final Fragment fragment;

    public IntentIntegratorClass(Activity activity, Fragment fragment) {
        super(activity);
        this.fragment = fragment;
    }

    @Override
    protected void startActivityForResult(Intent intent, int code) {
        fragment.startActivityForResult(intent, code);
    }
}