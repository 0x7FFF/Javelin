package com.smakhorin.easycodeandroidtask.sl;

import com.smakhorin.easycodeandroidtask.core.communication.Communication;
import com.smakhorin.easycodeandroidtask.core.module.Module;
import com.smakhorin.easycodeandroidtask.webscreen.BaseWebClient;
import com.smakhorin.easycodeandroidtask.webscreen.WebFragmentViewModel;

public class WebModule implements Module<WebFragmentViewModel> {
    private final CoreModule coreModule;

    public WebModule(CoreModule coreModule) {
        this.coreModule = coreModule;
    }

    @Override
    public WebFragmentViewModel viewModel() {
        return new WebFragmentViewModel(
            coreModule.provideCanGoBack(),
            new Communication.Abstract<Object>() {
                @Override
                public Void map(Object data) {
                    return null;
                }
            },
            new BaseWebClient(coreModule.provideProgressCommunication()),
            coreModule.provideProgressCommunication()
        );
    }
}
