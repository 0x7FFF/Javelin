package com.smakhorin.easycodeandroidtask.main.data;

public interface StringConcatenator {

    String[] concatPairs(String... input);


    class Base implements StringConcatenator {

        @Override
        public String[] concatPairs(String... input) {
            String[] result = new String[input.length/2];
            for (int i = 0; i < input.length; i+=2) {
                if (i + 1 < input.length) {
                    result[i/2] = input[i] + " " + input[i+1];
                }
            }
            return result;
        }
    }
}
