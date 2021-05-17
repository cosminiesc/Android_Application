package com.example.kiai.ui.orar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.kiai.R;

public class OrarFragment extends Fragment {

    private OrarViewModel orarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        orarViewModel = new ViewModelProvider(this).get(OrarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_orar, container, false);

        return root;
    }
}