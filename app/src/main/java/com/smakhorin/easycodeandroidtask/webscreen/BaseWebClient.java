package com.smakhorin.easycodeandroidtask.webscreen;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.smakhorin.easycodeandroidtask.core.Visibility;
import com.smakhorin.easycodeandroidtask.core.communication.ProgressCommunication;

public class BaseWebClient extends WebViewClient {

    private final ProgressCommunication.Update progressCommunication;

    public BaseWebClient(ProgressCommunication.Update progressCommunication) {
        this.progressCommunication = progressCommunication;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        progressCommunication.map(new Visibility.Visible());
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        progressCommunication.map(new Visibility.Gone());
    }
}
