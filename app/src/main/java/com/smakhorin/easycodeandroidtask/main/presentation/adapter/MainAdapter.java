package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import android.view.View;

import com.smakhorin.easycodeandroidtask.core.ui.adapter.GenericAdapter;
import com.smakhorin.easycodeandroidtask.core.ui.adapter.ViewHolderFactoryChain;

public interface MainAdapter {
    class Base extends GenericAdapter.Base {
        public Base(OnPetClick onPetClick) {
            super(
                new ButtonsViewHolderFactoryChain(
                    new TextViewHolderFactoryChain(
                        new PetViewHolderFactoryChain(
                            onPetClick, new ViewHolderFactoryChain.Exception<>()
                        )
                    )
                )
            );
        }
    }
}
