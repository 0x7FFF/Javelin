package com.smakhorin.easycodeandroidtask.core.ui.adapter;

import android.view.ViewGroup;

import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;

public interface ViewHolderFactoryChain<T extends ItemUi> {
    GenericViewHolder<T> viewHolder(ViewGroup parent, Integer viewType);

    class Exception<T extends ItemUi> implements ViewHolderFactoryChain<T> {

        @Override
        public GenericViewHolder<T> viewHolder(ViewGroup parent, Integer viewType) {
            throw new IllegalStateException("unknown viewType " + viewType);
        }
    }
}
