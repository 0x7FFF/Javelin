package com.smakhorin.easycodeandroidtask.main.presentation;

import androidx.lifecycle.MutableLiveData;

import com.smakhorin.easycodeandroidtask.core.communication.Communication;

public interface ClickCommunication extends Communication.Mutable<Boolean> {

    class Base extends Communication.UiUpdate<Boolean> implements ClickCommunication {

        public Base(MutableLiveData<Boolean> mutableLiveData) {
            super(mutableLiveData);
        }

        public Base() {
            super(new MutableLiveData<>());
        }
    }
}
