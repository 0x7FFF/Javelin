package com.smakhorin.easycodeandroidtask.webscreen;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.core.Visibility;
import com.smakhorin.easycodeandroidtask.core.presentation.BaseFragment;

public class WebFragment extends BaseFragment<WebFragmentViewModel> {

    private String contentUrl = null;

    @Override
    protected Class<WebFragmentViewModel> viewModelClass() {
        return WebFragmentViewModel.class;
    }

    @Override
    protected Integer getLayoutResId() {
        return R.layout.fragment_web;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            contentUrl = args.getString(new WebScreen.Args().ARG_CONTENT_URL);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView webView = view.findViewById(R.id.webView);

        webView.setWebViewClient(viewModel.obtainWebClient());

        webView.loadUrl(contentUrl);

        viewModel.observeLoading(this, visibility -> {
            if (visibility instanceof Visibility.Gone) {
                viewModel.enableGoBack();
            }
        });
    }
}
