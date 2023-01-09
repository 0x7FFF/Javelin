package com.smakhorin.easycodeandroidtask.main.presentation;

import androidx.lifecycle.MutableLiveData;

import com.smakhorin.easycodeandroidtask.core.communication.Communication;
import com.smakhorin.easycodeandroidtask.core.ui.MainUi;

public interface MainCommunication extends Communication.Mutable<MainUi> {

    class Base extends Communication.UiUpdate<MainUi> implements MainCommunication {
        public Base(MutableLiveData<MainUi> mutableLiveData) {
            super(mutableLiveData);
        }

        public Base() {
            super(new MutableLiveData<>());
        }
    }
}
