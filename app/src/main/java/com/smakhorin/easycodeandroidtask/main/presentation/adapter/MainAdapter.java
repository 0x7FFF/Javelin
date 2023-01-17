package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import com.smakhorin.easycodeandroidtask.core.ui.adapter.GenericAdapter;
import com.smakhorin.easycodeandroidtask.core.ui.adapter.ViewHolderFactoryChain;

public interface MainAdapter {
    class Base extends GenericAdapter.Base {
        public Base() {
            super(
                new ButtonsViewHolderFactoryChain(
                    new TextViewHolderFactoryChain(
                        new PetViewHolderFactoryChain(
                            new ViewHolderFactoryChain.Exception<>()
                        )
                    )
                )
            );
        }
    }
}
