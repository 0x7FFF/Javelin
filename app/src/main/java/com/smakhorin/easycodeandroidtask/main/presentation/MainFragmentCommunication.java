package com.smakhorin.easycodeandroidtask.main.presentation;

import androidx.lifecycle.MutableLiveData;

import com.smakhorin.easycodeandroidtask.core.communication.Communication;
import com.smakhorin.easycodeandroidtask.core.ui.MainFragmentUi;

public interface MainFragmentCommunication extends Communication.Mutable<MainFragmentUi> {

    class Base extends Communication.UiUpdate<MainFragmentUi> implements MainFragmentCommunication {
        public Base(MutableLiveData<MainFragmentUi> mutableLiveData) {
            super(mutableLiveData);
        }

        public Base() {
            super(new MutableLiveData<>());
        }
    }
}
