package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;
import com.smakhorin.easycodeandroidtask.core.ui.adapter.GenericViewHolder;
import com.smakhorin.easycodeandroidtask.core.ui.adapter.ViewHolderFactoryChain;

public class PetViewHolderFactoryChain implements ViewHolderFactoryChain<ItemUi> {

    private final OnPetClick onPetClick;
    private final ViewHolderFactoryChain<ItemUi> viewHolderFactoryChain;

    public PetViewHolderFactoryChain(OnPetClick onPetClick, ViewHolderFactoryChain<ItemUi> viewHolderFactoryChain) {
        this.onPetClick = onPetClick;
        this.viewHolderFactoryChain = viewHolderFactoryChain;
    }


    @Override
    public GenericViewHolder<ItemUi> viewHolder(ViewGroup parent, Integer viewType) {
        if(viewType == 3) {
            return new PetViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.item_pet, parent, false),
                    onPetClick
            );
        }
        return viewHolderFactoryChain.viewHolder(parent, viewType);
    }
}
