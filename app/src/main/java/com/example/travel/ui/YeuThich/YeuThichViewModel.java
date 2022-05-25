package com.example.travel.ui.YeuThich;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class YeuThichViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public YeuThichViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is favourites fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}