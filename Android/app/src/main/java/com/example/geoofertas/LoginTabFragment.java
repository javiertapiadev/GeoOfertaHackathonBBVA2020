package com.example.geoofertas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.formulario_login, container, false);
        return  root;
    }
}
