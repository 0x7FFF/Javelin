package com.smakhorin.easycodeandroidtask.core.communication;

import androidx.lifecycle.MutableLiveData;

public interface GlobalErrorCommunication {

    interface Observe extends Communication.Observe<String> {}

    interface Update extends Communication.Update<String> {}

    interface Mutable extends Communication.Mutable<String>, Observe, Update {}

    class Base extends Communication.SinglePostUpdate<String> implements Mutable {
        public Base(MutableLiveData<String> mutableLiveData) {
            super(mutableLiveData);
        }

        public Base() {}
    }
}
