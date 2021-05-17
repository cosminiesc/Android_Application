package com.example.kiai.ui.confidentialitate;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kiai.R;
import com.example.kiai.ui.orar.OrarViewModel;

public class ConfidentialitateFragment extends Fragment {

    private ConfidentialitateViewModel confidentialitateViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        confidentialitateViewModel =
                new ViewModelProvider(this).get(ConfidentialitateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_confidentialitate, container, false);

        return root;
    }
}