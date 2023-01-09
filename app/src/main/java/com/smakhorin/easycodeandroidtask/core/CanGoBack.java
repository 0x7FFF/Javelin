package com.smakhorin.easycodeandroidtask.core;

import androidx.annotation.NonNull;

public interface CanGoBack {
    Boolean canGoBack();

    class Empty implements CanGoBack {

        @Override
        public Boolean canGoBack() {
            return true;
        }
    }

    interface Callback extends CanGoBack {

        void updateCallback(CanGoBack canGoBack);

        class Base implements Callback {

            CanGoBack canGoBack = new Empty();

            @Override
            public Boolean canGoBack() {
                return canGoBack.canGoBack();
            }

            @Override
            public void updateCallback(@NonNull CanGoBack canGoBack) {
                this.canGoBack = canGoBack;
            }
        }
    }
}
