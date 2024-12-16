package com.sorted;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortedExample {
    public static void main(String[]arguments){
        String[] myExamples={"kelvin","joseph","moshi"};
        Stream<String> data=Stream.of(myExamples);

        data.sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
}
