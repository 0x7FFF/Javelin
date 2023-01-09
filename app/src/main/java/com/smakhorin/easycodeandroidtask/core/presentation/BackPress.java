package com.smakhorin.easycodeandroidtask.core.presentation;

import androidx.appcompat.app.AppCompatActivity;

import com.smakhorin.easycodeandroidtask.core.CanGoBack;
import com.smakhorin.easycodeandroidtask.core.UpdateCallbacks;
import com.smakhorin.easycodeandroidtask.core.communication.Communication;

public interface BackPress {

    abstract class Activity<T extends CanGoBack> extends AppCompatActivity {
        protected T viewModel;

        @Override
        public void onBackPressed() {
            if(viewModel.canGoBack()) {
                super.onBackPressed();
            }
        }

        public abstract static class ViewModel<T> extends BaseViewModel<T> implements CanGoBack {
            private final CanGoBack canGoBack;

            public ViewModel(CanGoBack canGoBack, Communication.Mutable<T> communication) {
                super(communication);
                this.canGoBack = canGoBack;
            }

            @Override
            public Boolean canGoBack() {
                return canGoBack.canGoBack();
            }
        }
    }

    abstract class Fragment<C, T extends ViewModel<C>> extends BaseFragment<T> {

        @Override
        public void onResume() {
            super.onResume();
            viewModel.updateCallbacks();
        }

        @Override
        public void onPause() {
            super.onPause();
            viewModel.removeCallbacks();
        }
    }

    abstract class ViewModel<T> extends BaseViewModel<T> implements UpdateCallbacks {
        private final CanGoBack.Callback canGoBackCallback;

        public ViewModel(CanGoBack.Callback canGoBackCallback, Communication.Mutable<T> communication) {
            super(communication);
            this.canGoBackCallback = canGoBackCallback;
        }

        @Override
        public void removeCallbacks() {
            canGoBackCallback.updateCallback(new CanGoBack.Empty());
        }
    }
}
