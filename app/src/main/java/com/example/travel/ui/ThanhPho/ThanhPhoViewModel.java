package com.example.travel.ui.ThanhPho;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThanhPhoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ThanhPhoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is city fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}