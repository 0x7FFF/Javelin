package com.smakhorin.easycodeandroidtask.main.data;


public interface StringSplitter {
    String[] splitAfterFirstSpace(String input);

    String[] splitUsingSymbol(String input, String symbol);

    class Base implements StringSplitter {

        @Override
        public String[] splitAfterFirstSpace(String input) {
            return input.split("\\s+", 2);
        }

        @Override
        public String[] splitUsingSymbol(String input, String symbol) {
            return input.split(symbol);
        }
    }
}
