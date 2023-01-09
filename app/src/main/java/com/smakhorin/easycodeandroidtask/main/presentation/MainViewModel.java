package com.smakhorin.easycodeandroidtask.main.presentation;

import com.smakhorin.easycodeandroidtask.core.Callback1;
import com.smakhorin.easycodeandroidtask.core.CanGoBack;
import com.smakhorin.easycodeandroidtask.core.presentation.BackPress;
import com.smakhorin.easycodeandroidtask.core.Callback0;
import com.smakhorin.easycodeandroidtask.core.Visibility;
import com.smakhorin.easycodeandroidtask.core.communication.ProgressCommunication;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;
import com.smakhorin.easycodeandroidtask.core.ui.MainUi;
import com.smakhorin.easycodeandroidtask.main.domain.MainInteractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MainViewModel extends BackPress.ViewModel<MainUi> {

    private boolean canGoBack;
    private Callback0 atFinish;

    private Callback1<MainUi> collectResults;
    private final CanGoBack.Callback canGoBackCallback;
    private final MainInteractor interactor;
    private final ProgressCommunication.Update progressCommunication;

    private final AtomicInteger asyncCounter;

    private final CopyOnWriteArrayList<MainUi> mainUiAccumulator;

    private CanGoBack canGoBackCallbackInner = () -> canGoBack;

    public MainViewModel(MainCommunication communication,
                         CanGoBack.Callback canGoBackCallback,
                         MainInteractor interactor,
                         ProgressCommunication.Update progressCommunication
    ) {
        super(canGoBackCallback, communication);
        this.canGoBackCallback = canGoBackCallback;
        this.interactor = interactor;
        this.progressCommunication = progressCommunication;
        asyncCounter = new AtomicInteger(0);
        mainUiAccumulator = new CopyOnWriteArrayList<>();

        int numberOfOperations = 2;

        atFinish = () -> postOnMainThread(() -> {
            progressCommunication.map(new Visibility.Gone());
            canGoBack = true;
        });

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
                postOnMainThread(() -> communication.map(new MainUi.Base(uiList)));
            }
        };

        handle(
            numberOfOperations,
            atFinish,
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
}
