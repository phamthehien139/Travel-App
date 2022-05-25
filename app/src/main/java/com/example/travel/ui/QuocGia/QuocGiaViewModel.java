package com.example.travel.ui.QuocGia;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuocGiaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QuocGiaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is country fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}