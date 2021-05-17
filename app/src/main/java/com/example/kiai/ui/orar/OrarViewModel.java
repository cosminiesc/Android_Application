package com.example.kiai.ui.orar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OrarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is orar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}