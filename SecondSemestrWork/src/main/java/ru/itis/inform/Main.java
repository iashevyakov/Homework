package ru.itis.inform;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        RandomGenerator generator = new RandomGenerator();
        Integer a[];


       for (int i = 0; i < generator.getCountOfArrays(); i++) {


            String filename = "s"+i;
            SmoothSort sorting = new SmoothSort();
            a=Reader.readNumbers(filename);

            long first = System.currentTimeMillis();

            sorting.sort(a);

            long last = System.currentTimeMillis();

            System.out.print(last - first+" ms ");
           System.out.println(sorting.getK());

        }
        System.out.println(generator.getSize(0));

      /*  Integer [] c = Reader.readNumbers("s0");
        SmoothSort s = new SmoothSort();
        s.sort(c);
        for (int i=0; i<generator.getSize(0);i++)
        {
            System.out.println(c[i]);
        }
        System.out.println(s.getK());
*/



    }
}
