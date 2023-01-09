package com.smakhorin.easycodeandroidtask.core.communication;


import androidx.lifecycle.MutableLiveData;

import com.smakhorin.easycodeandroidtask.core.Visibility;

public interface ProgressCommunication {

    interface Update extends Communication.Update<Visibility> {}

    interface Observe extends Communication.Observe<Visibility> {}

    interface Mutable extends Update, Observe {}

    class Base extends Communication.UiUpdate<Visibility> implements Mutable {

        public Base(MutableLiveData<Visibility> mutableLiveData) {
            super(mutableLiveData);
        }

        public Base() {
            this(new MutableLiveData<Visibility>());
        }
    }
}
