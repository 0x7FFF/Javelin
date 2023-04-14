package com.smakhorin.easycodeandroidtask.webscreen;

import android.webkit.WebViewClient;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.smakhorin.easycodeandroidtask.core.CanGoBack;
import com.smakhorin.easycodeandroidtask.core.Visibility;
import com.smakhorin.easycodeandroidtask.core.communication.Communication;
import com.smakhorin.easycodeandroidtask.core.communication.ProgressCommunication;
import com.smakhorin.easycodeandroidtask.core.presentation.BackPress;

public class WebFragmentViewModel extends BackPress.ViewModel<Object> {

    private boolean canGoBack;
    private final CanGoBack.Callback canGoBackCallback;

    private final BaseWebClient webClient;
    private CanGoBack canGoBackCallbackInner = () -> canGoBack;

    private final ProgressCommunication.Observe progressCommunication;

    public WebFragmentViewModel(CanGoBack.Callback canGoBackCallback, Communication.Mutable<Object> communication, BaseWebClient webClient, ProgressCommunication.Observe progressCommunication) {
        super(canGoBackCallback, communication);
        this.canGoBackCallback = canGoBackCallback;
        this.webClient = webClient;
        this.progressCommunication = progressCommunication;

        canGoBack = false;
    }

    WebViewClient obtainWebClient() {
        return webClient;
    }

    @Override
    public void updateCallbacks() {
        canGoBackCallback.updateCallback(canGoBackCallbackInner);
    }

    void observeLoading(LifecycleOwner owner, Observer<Visibility> observer) {
        progressCommunication.observe(owner, observer);
    }

    void enableGoBack() {
        canGoBack = true;
    }
}
