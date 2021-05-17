package com.example.kiai.ui.profil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.kiai.CustomerModel;
import com.example.kiai.DataBase;
import com.example.kiai.R;

public class ProfilFragment extends Fragment {

    private ProfilViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                new ViewModelProvider(this).get(ProfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profil, container, false);

      //  txtMyEmail=getView().findViewById(R.id.txtMyEmail);

        /*Bundle bundle=getArguments();
        if(bundle!=null){
        String email=bundle.getString("email");

        txtMyEmail.setVisibility(View.VISIBLE);
        txtMyEmail.setText(email);
        }*/

       return root;
    }


}