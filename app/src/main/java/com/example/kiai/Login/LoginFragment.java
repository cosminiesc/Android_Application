package com.example.kiai.Login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiai.DataBase;
import com.example.kiai.MainActivity;
import com.example.kiai.R;
import com.example.kiai.ui.profil.ProfilFragment;

public class LoginFragment extends Fragment {

    private Button butttonRegister,btnLogin;
    private TextView txtWarnEmail,txtWarnPass;
    private EditText edTxtEmail,edTxtPass;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle bundle){
        initViews();

        butttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_login_main,new RegisterFragment()).addToBackStack("loginbackstack").commit();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validateData()){

                    if(validateLogin()) {

                       /* ProfilFragment profilFragment=new ProfilFragment();
                        Bundle args=new Bundle();
                        args.putString("email",edTxtEmail.getText().toString());
                        profilFragment.setArguments(args);*/

                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        getActivity().startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(getContext(),"You need to complete all the fields",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void initViews(){
        txtWarnEmail=getView().findViewById(R.id.txtWarnEmail);
        txtWarnPass=getView().findViewById(R.id.txtWarnPass);
        edTxtEmail=getView().findViewById(R.id.editTextTextEmailAddress);
        edTxtPass=getView().findViewById(R.id.editTextTextPassword);
        butttonRegister=getView().findViewById(R.id.buttonRegister);
        btnLogin=getView().findViewById(R.id.btnLogin);
    }

    public boolean validateData(){
        if(edTxtEmail.getText().toString().equals("")){
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Enter your email");
            if(!edTxtPass.getText().toString().isEmpty()){
                txtWarnPass.setVisibility(View.GONE);
            }
            return false;
        }

        if(edTxtPass.getText().toString().equals("")){
            txtWarnPass.setVisibility(View.VISIBLE);
            txtWarnPass.setText("Enter your password");
            if(!edTxtEmail.getText().toString().isEmpty()){
                txtWarnEmail.setVisibility(View.GONE);
            }
            return false;
        }

        return true;
    }

    public boolean validateLogin(){
        DataBase database=new DataBase(getActivity());
        if(database.hasObject(edTxtEmail.getText().toString(),Integer.parseInt(edTxtPass.getText().toString()))){
            return true;
        }
        return false;
    }

}