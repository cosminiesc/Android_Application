package com.example.kiai.ui.istoric_prezenta;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kiai.R;
import com.example.kiai.ui.profil.ProfilViewModel;


public class Istoric_prezentaFragment extends Fragment {

    private Istoric_prezentaViewModel istoric_prezentaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        istoric_prezentaViewModel =
                new ViewModelProvider(this).get(Istoric_prezentaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_istoric_prezenta, container, false);
        return root;

    }
}