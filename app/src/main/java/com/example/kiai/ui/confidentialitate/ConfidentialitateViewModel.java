package com.example.kiai.ui.confidentialitate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConfidentialitateViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ConfidentialitateViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
