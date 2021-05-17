package com.example.kiai.Login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.LongDef;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.EventLogTags;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiai.CustomerModel;
import com.example.kiai.DataBase;
import com.example.kiai.MainActivity;
import com.example.kiai.R;
import com.google.android.material.snackbar.Snackbar;


public class RegisterFragment extends Fragment  {

    private static final String TAG="RegisterFragment";

    private Button btnfinishRegister;
    private EditText edTxtFirstName,edTxtLastName,edTxtEmail,edTxtPassword,edTxtPassRepeat;
    private TextView txtWarnFirstName,txtWarnLastName,txtWarnEmail,txtWarnPass,txtWarnPassRepeat;
    private Spinner spinnerCountry;
    private RadioGroup rgGender;
    private CheckBox agreementCheck;
    private ConstraintLayout parent;


    public RegisterFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle bundle){

        initViews();

        btnfinishRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomerModel customerModel;

                if(validateDate()) {
                    if (agreementCheck.isChecked()) {

                        customerModel = new CustomerModel(-1, edTxtFirstName.getText().toString(), edTxtLastName.getText().toString(), edTxtEmail.getText().toString(), Integer.parseInt(edTxtPassword.getText().toString()));

                        Toast.makeText(getActivity(),"User registered",Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(intent);
                    } else {
                        customerModel = new CustomerModel(-1, "error", "error", "error", 0);
                        Toast.makeText(getActivity(), "You need to agree the license agreement", Toast.LENGTH_LONG).show();

                    }

                    DataBase dataBase=new DataBase(getActivity());
                    boolean success= dataBase.addOne(customerModel);
                }


            }
        });

    }

    private void initViews(){
        Log.d(TAG, "initViews: Started");
         edTxtFirstName= getView().findViewById(R.id.edTxtFirstName);
         edTxtLastName= getView().findViewById(R.id.edTxtLastName);
         edTxtEmail= getView().findViewById(R.id.edTxtEmail);
         edTxtPassword=getView().findViewById(R.id.edTxtPassword);
         edTxtPassRepeat=getView().findViewById(R.id.edTxtPassRepeat);

         btnfinishRegister=getView().findViewById(R.id.btnFinishRegister);

         txtWarnFirstName=getView().findViewById(R.id.txtWarnFirstName);
         txtWarnLastName=getView().findViewById(R.id.txtWarnLastName);
         txtWarnEmail=getView().findViewById(R.id.txtWarnEmail);
         txtWarnPass=getView().findViewById(R.id.txtWarnPass);
         txtWarnPassRepeat=getView().findViewById(R.id.txtWarnPassRepeat);

         spinnerCountry=getView().findViewById(R.id.spinnerCountry);
         rgGender=getView().findViewById(R.id.rgGender);
         agreementCheck=getView().findViewById(R.id.agreementCheck);
         parent=getView().findViewById(R.id.parent);

    }

    private boolean validateDate() {
        Log.d(TAG, "validateDate: Started");

        if(edTxtFirstName.getText().toString().equals("")){
            txtWarnFirstName.setVisibility(View.VISIBLE);
            txtWarnFirstName.setText("Enter your First Name");

            if(!edTxtLastName.getText().toString().isEmpty()){
                txtWarnLastName.setVisibility(View.GONE);
            }
            if(!edTxtEmail.getText().toString().isEmpty()){
                txtWarnEmail.setVisibility(View.GONE);
            }
            if(!edTxtPassword.getText().toString().isEmpty()){
                txtWarnPass.setVisibility(View.GONE);
            }
            if(!edTxtPassRepeat.getText().toString().isEmpty()){
                txtWarnPassRepeat.setVisibility(View.GONE);
            }
            return false;
        }

        if(edTxtLastName.getText().toString().equals("")){
            txtWarnLastName.setVisibility(View.VISIBLE);
            txtWarnLastName.setText("Enter you Last Name");

            if(!edTxtFirstName.getText().toString().isEmpty()){
                txtWarnFirstName.setVisibility(View.GONE);
            }
            if(!edTxtEmail.getText().toString().isEmpty()){
                txtWarnEmail.setVisibility(View.GONE);
            }
            if(!edTxtPassword.getText().toString().isEmpty()){
                txtWarnPass.setVisibility(View.GONE);
            }
            if(!edTxtPassRepeat.getText().toString().isEmpty()){
                txtWarnPassRepeat.setVisibility(View.GONE);
            }

            return false;
        }

        if(edTxtEmail.getText().toString().equals("")){
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Enter your Email");

            if(!edTxtFirstName.getText().toString().isEmpty()){
                txtWarnFirstName.setVisibility(View.GONE);
            }
            if(!edTxtLastName.getText().toString().isEmpty()){
                txtWarnLastName.setVisibility(View.GONE);
            }
            if(!edTxtPassword.getText().toString().isEmpty()){
                txtWarnPass.setVisibility(View.GONE);
            }
            if(!edTxtPassRepeat.getText().toString().isEmpty()){
                txtWarnPassRepeat.setVisibility(View.GONE);
            }

            return false;
        }

        if(edTxtPassword.getText().toString().equals("")){
            txtWarnPass.setVisibility(View.VISIBLE);
            txtWarnPass.setText("Enter you Password");

            if(!edTxtFirstName.getText().toString().isEmpty()){
                txtWarnFirstName.setVisibility(View.GONE);
            }
            if(!edTxtLastName.getText().toString().isEmpty()){
                txtWarnLastName.setVisibility(View.GONE);
            }
            if(!edTxtEmail.getText().toString().isEmpty()){
                txtWarnEmail.setVisibility(View.GONE);
            }
            if(!edTxtPassRepeat.getText().toString().isEmpty()){
                txtWarnPassRepeat.setVisibility(View.GONE);
            }
            return false;
        }

        if(edTxtPassRepeat.getText().toString().equals("")){
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText(" Re-enter your Password");

            if(!edTxtFirstName.getText().toString().isEmpty()){
                txtWarnFirstName.setVisibility(View.GONE);
            }
            if(!edTxtLastName.getText().toString().isEmpty()){
                txtWarnLastName.setVisibility(View.GONE);
            }
            if(!edTxtEmail.getText().toString().isEmpty()){
                txtWarnEmail.setVisibility(View.GONE);
            }
            if(!edTxtPassword.getText().toString().isEmpty()){
                txtWarnPass.setVisibility(View.GONE);
            }

            return false;
        }

        if(!edTxtPassword.getText().toString().equals(edTxtPassRepeat.getText().toString())){
         txtWarnPassRepeat.setVisibility(View.VISIBLE);
         txtWarnPassRepeat.setText("Password does not match!");
         return false;
        }

        return true;

    }


}