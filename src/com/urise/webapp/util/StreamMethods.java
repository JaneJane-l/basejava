package com.urise.webapp.util;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {

    public static int minValue(int[] values){
        String result = Arrays.stream(values)
                .distinct()
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
        int intResult = Integer.parseInt(result);
        int r = Arrays.stream(values).sum();




        return  intResult;
    }

    public static int sumValue(int[] values){
        int r = Arrays.stream(values).sum();
        return r;
    }

    public static void main(String[] args) {
        int[] values = {1, 4, 3, 2, 3, 3};

        System.out.println(minValue(values));
        System.out.println(sumValue(values));
    }
}
