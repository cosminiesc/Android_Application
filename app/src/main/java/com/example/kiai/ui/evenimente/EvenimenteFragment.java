package com.example.kiai.ui.evenimente;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kiai.R;
import com.example.kiai.ui.profil.ProfilViewModel;

public class EvenimenteFragment extends Fragment {

    private EvenimenteViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                new ViewModelProvider(this).get(EvenimenteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_evenimente, container, false);
        return root;

    }
}