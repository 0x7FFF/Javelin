package com.smakhorin.easycodeandroidtask.core.communication;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.smakhorin.easycodeandroidtask.core.Mapper;
import com.smakhorin.easycodeandroidtask.core.SingleLiveEvent;

public interface Communication {

    interface Observe<T> {
        void observe(LifecycleOwner owner, Observer<T> observer);
    }

    interface Update<T> extends Mapper.Unit<T> {}

    interface Mutable<T> extends Observe<T>, Update<T> {}

    abstract class Abstract<T> implements Mutable<T> {

        MutableLiveData<T> mutableLiveData;

        public Abstract(MutableLiveData<T> mutableLiveData) {
            this.mutableLiveData = mutableLiveData;
        }

        public Abstract() {
            new MutableLiveData<>();
        }

        @Override
        public void observe(LifecycleOwner owner, Observer<T> observer) {
            mutableLiveData.observe(owner, observer);
        }
    }

    abstract class UiUpdate<T> extends Abstract<T> {

        public UiUpdate(MutableLiveData<T> mutableLiveData) {
            super(mutableLiveData);
        }

        @Override
        public Void map(T data) {
            mutableLiveData.setValue(data);
            return null;
        }
    }

    abstract class PostUpdate<T> extends Abstract<T> {

        public PostUpdate(MutableLiveData<T> mutableLiveData) {
            super(mutableLiveData);
        }

        public PostUpdate() {
            this(new MutableLiveData());
        }

        @Override
        public Void map(T data) {
            mutableLiveData.postValue(data);
            return null;
        }
    }

    abstract class SingleUiUpdate<T> extends UiUpdate<T> {

        public SingleUiUpdate(MutableLiveData<T> mutableLiveData) {
            super(new SingleLiveEvent<T>());
        }
    }

    abstract class SinglePostUpdate<T> extends PostUpdate<T> {

        public SinglePostUpdate(MutableLiveData<T> mutableLiveData) {
            super(new SingleLiveEvent<T>());
        }

        public SinglePostUpdate() {
            this(new MutableLiveData());
        }
    }

    class Empty<T> implements Mutable<T> {

        @Override
        public void observe(LifecycleOwner owner, Observer<T> observer) {
            return;
        }

        @Override
        public Void map(T data) {
            return null;
        }
    }

}
