package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;
import com.smakhorin.easycodeandroidtask.core.ui.adapter.GenericViewHolder;
import com.smakhorin.easycodeandroidtask.core.ui.adapter.ViewHolderFactoryChain;

public class PetViewHolderFactoryChain implements ViewHolderFactoryChain<ItemUi> {

    private final ViewHolderFactoryChain<ItemUi> viewHolderFactoryChain;

    public PetViewHolderFactoryChain(ViewHolderFactoryChain<ItemUi> viewHolderFactoryChain) {
        this.viewHolderFactoryChain = viewHolderFactoryChain;
    }


    @Override
    public GenericViewHolder<ItemUi> viewHolder(ViewGroup parent, Integer viewType) {
        if(viewType == 3) {
            return new PetViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.item_pet, parent, false)
            );
        }
        return viewHolderFactoryChain.viewHolder(parent, viewType);
    }
}
