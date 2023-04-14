package com.smakhorin.easycodeandroidtask.main.presentation;

import android.os.Bundle;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.smakhorin.easycodeandroidtask.core.callback.Callback1;
import com.smakhorin.easycodeandroidtask.core.CanGoBack;
import com.smakhorin.easycodeandroidtask.core.communication.NavigationCommunication;
import com.smakhorin.easycodeandroidtask.core.presentation.BackPress;
import com.smakhorin.easycodeandroidtask.core.Visibility;
import com.smakhorin.easycodeandroidtask.core.communication.ProgressCommunication;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;
import com.smakhorin.easycodeandroidtask.core.ui.MainFragmentUi;
import com.smakhorin.easycodeandroidtask.main.domain.MainInteractor;
import com.smakhorin.easycodeandroidtask.webscreen.WebScreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MainFragmentViewModel extends BackPress.ViewModel<MainFragmentUi> {

    private boolean canGoBack;
    private Callback1<MainFragmentUi> collectResults;
    private final CanGoBack.Callback canGoBackCallback;
    private final MainInteractor interactor;
    private final ProgressCommunication.Update progressCommunication;

    private final AtomicInteger asyncCounter;

    private final ClickCommunication clickCommunication;

    private final CopyOnWriteArrayList<MainFragmentUi> mainUiAccumulator;

    private final NavigationCommunication.Mutable navigationCommunication;

    private CanGoBack canGoBackCallbackInner = () -> canGoBack;

    public MainFragmentViewModel(MainFragmentCommunication communication,
                                 ClickCommunication clickCommunication,
                                 CanGoBack.Callback canGoBackCallback,
                                 MainInteractor interactor,
                                 ProgressCommunication.Update progressCommunication,
                                 NavigationCommunication.Mutable navigationCommunication
    ) {
        super(canGoBackCallback, communication);
        this.clickCommunication = clickCommunication;
        this.navigationCommunication = navigationCommunication;
        this.canGoBackCallback = canGoBackCallback;
        this.interactor = interactor;
        this.progressCommunication = progressCommunication;
        asyncCounter = new AtomicInteger(0);
        mainUiAccumulator = new CopyOnWriteArrayList<>();

        int numberOfOperations = 2;

        canGoBack = false;
        progressCommunication.map(new Visibility.Visible());

        collectResults = result -> {
            mainUiAccumulator.add(result);
            if(asyncCounter.incrementAndGet() == numberOfOperations) {
                List<ItemUi> uiList = new ArrayList<>();
                for (int i = 0; i < mainUiAccumulator.size(); i++) {
                    uiList.addAll(mainUiAccumulator.get(i).getList());
                }
                Collections.sort(uiList, (o1, o2) -> Integer.compare(o1.type(), o2.type()));
                postOnMainThread(() -> communication.map(new MainFragmentUi.Base(uiList)));
            }
        };

        handle(
            numberOfOperations,
            () -> postOnMainThread(() -> {
                progressCommunication.map(new Visibility.Gone());
                canGoBack = true;
            }),
            () -> interactor.localSettings(
                collectResults),
            () -> interactor.localPets(
                collectResults)
        );
    }

    @Override
    public void updateCallbacks() {
        canGoBackCallback.updateCallback(canGoBackCallbackInner);
    }

    public void observeClick(LifecycleOwner owner, Observer<Boolean> observer) {
        clickCommunication.observe(owner, observer);
    }

    public void displayPetDetails(String content) {
        Bundle args = new Bundle();
        args.putString(new WebScreen.Args().ARG_CONTENT_URL, content);
        navigationCommunication.map(
            new WebScreen(args)
        );
    }
}
