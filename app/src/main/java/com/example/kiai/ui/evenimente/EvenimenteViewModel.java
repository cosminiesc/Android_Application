package com.example.kiai.ui.evenimente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EvenimenteViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public EvenimenteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is evenimente fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
