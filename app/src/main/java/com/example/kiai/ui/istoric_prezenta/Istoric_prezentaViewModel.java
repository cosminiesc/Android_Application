package com.example.kiai.ui.istoric_prezenta;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Istoric_prezentaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Istoric_prezentaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is istoric prezenta fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
