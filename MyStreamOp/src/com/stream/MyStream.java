package com.stream;

import java.util.Arrays;
import java.util.stream.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MyStream {
    public static void main(String[] args){
        List<String> words=new ArrayList<>();
        Scanner in=new Scanner(System.in);
        System.out.println("fill you details");
        String[]myDetails={"First name: ","Sir name: ","Living area: "};
        for(int i=0;i<3;i++){
            System.out.print(myDetails[i]);
            words.add(in.nextLine());
        }

        /*create normal stream which hold string objects and then drop those
        * which start with letter k and then consume it
        * */
        Stream<String> myStream=Stream.of("kelvin","joseph","moshi");
        myStream.dropWhile(name->name.startsWith("k"))
                .forEach(System.out::print);

        /* let's assume we have a data source as list object
        * since a stream api provide a functional programming style then we can
        * process data without modifying original data source.
        * so lets us create a normal stream from our data source
        * */
        Stream<String> dsStream=words.stream();
        /*let's check if I try uses a single consumed stream on two terminal operation
          so the solution is that after a stream being consumed and since a stream implement auto closable then
        * by default a stream get closed when consumed that is why when you use a terminal operation then you are required
        * to create another stream for other operations
        * */
        System.out.println();
        dsStream.map(String::toUpperCase)
                .dropWhile(input->input.startsWith("K"))
                .forEach(System.out::println);

        //stream for array
        Stream<String> frArray= Arrays.stream(myDetails);
        frArray.forEach(System.out::println);

    }
}
