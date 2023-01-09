package com.smakhorin.easycodeandroidtask.core.communication;

import com.smakhorin.easycodeandroidtask.core.NavigationScreen;

public interface NavigationCommunication {

    interface Update extends Communication.Update<NavigationScreen> {}

    interface Observe extends Communication.Observe<NavigationScreen> {}

    interface Mutable extends Update, Observe {}

    class Base extends Communication.SinglePostUpdate<NavigationScreen> implements Mutable {}

}
