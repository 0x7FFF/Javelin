package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.core.ui.adapter.GenericViewHolder;
import com.smakhorin.easycodeandroidtask.core.ui.adapter.ViewHolderFactoryChain;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;

public class TextViewHolderFactoryChain implements ViewHolderFactoryChain<ItemUi> {

    private final ViewHolderFactoryChain<ItemUi> viewHolderFactoryChain;

    public TextViewHolderFactoryChain(ViewHolderFactoryChain<ItemUi> viewHolderFactoryChain) {
        this.viewHolderFactoryChain = viewHolderFactoryChain;
    }
    @Override
    public GenericViewHolder<ItemUi> viewHolder(ViewGroup parent, Integer viewType) {
        if(viewType == 2) {
            return new TextViewViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.item_office_hours, parent, false)
            );
        }
        return viewHolderFactoryChain.viewHolder(parent, viewType);
    }
}
