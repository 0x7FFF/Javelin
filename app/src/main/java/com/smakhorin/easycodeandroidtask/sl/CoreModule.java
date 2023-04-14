package com.smakhorin.easycodeandroidtask.sl;

import android.content.Context;

import androidx.annotation.NonNull;

import com.smakhorin.easycodeandroidtask.core.CanGoBack;
import com.smakhorin.easycodeandroidtask.core.ResourceManager;
import com.smakhorin.easycodeandroidtask.core.communication.GlobalErrorCommunication;
import com.smakhorin.easycodeandroidtask.core.communication.NavigationCommunication;
import com.smakhorin.easycodeandroidtask.core.communication.ProgressCommunication;
import com.smakhorin.easycodeandroidtask.main.data.FileReader;

import java.io.InputStream;

public interface CoreModule extends ResourceManager, ProvideBackHandler, ProvideProgressCommunication, ProvideGlobalErrorCommunication, ProvideJsonReader, ProvideNavigationCommunication {

    class Base implements CoreModule {

        private final Context context;

        private final ResourceManager resourceManager;

        private final CanGoBack.Callback backHandler;

        private final GlobalErrorCommunication.Base communication;

        private final ProgressCommunication.Base progress;

        private final FileReader.Json jsonReader;

        private final NavigationCommunication.Mutable navigationCommunication;

        public Base(@NonNull Context context) {
            this.context = context;

            resourceManager = new ResourceManager.Base(this.context);
            backHandler = new CanGoBack.Callback.Base();
            communication = new GlobalErrorCommunication.Base();
            progress = new ProgressCommunication.Base();
            navigationCommunication = new NavigationCommunication.Base();
            jsonReader = new FileReader.Json(resourceManager);
        }

        @Override
        public String string(int id) {
            return resourceManager.string(id);
        }

        @Override
        public InputStream rawFile(int id) {
            return resourceManager.rawFile(id);
        }

        @Override
        public CanGoBack.Callback provideCanGoBack() {
            return backHandler;
        }

        @Override
        public GlobalErrorCommunication.Mutable provideGlobalErrorCommunication() {
            return communication;
        }

        @Override
        public ProgressCommunication.Mutable provideProgressCommunication() {
            return progress;
        }

        @Override
        public FileReader.Json provideJsonReader() {
            return jsonReader;
        }

        @Override
        public NavigationCommunication.Mutable provideNavigationCommunication() {
            return navigationCommunication;
        }
    }
}

interface ProvideBackHandler {
    CanGoBack.Callback provideCanGoBack();
}

interface ProvideGlobalErrorCommunication {
    GlobalErrorCommunication.Mutable provideGlobalErrorCommunication();
}

interface ProvideProgressCommunication {
    ProgressCommunication.Mutable provideProgressCommunication();
}

interface ProvideJsonReader {
    FileReader.Json provideJsonReader();
}

interface ProvideNavigationCommunication {
    NavigationCommunication.Mutable provideNavigationCommunication();
}
