package com.smakhorin.easycodeandroidtask.main.presentation;

public interface DisplayDialog {

    void show(Boolean isWithinWorkingHours);

    class Base implements DisplayDialog {

        private final ClickCommunication clickCommunication;


        public Base(ClickCommunication clickCommunication) {
            this.clickCommunication = clickCommunication;
        }

        @Override
        public void show(Boolean isWithinWorkingHours) {
            clickCommunication.map(isWithinWorkingHours);
        }
    }
}
