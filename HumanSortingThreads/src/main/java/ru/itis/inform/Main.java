package ru.itis.inform;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

            HumanThreads h1 = new HumanThreads("Humans1", "HumansOut1");

            HumanThreads h2 = new HumanThreads("Humans2", "HumansOut2");

            HumanThreads h3 = new HumanThreads("Humans3", "HumansOut3");

            HumanThreads h4 = new HumanThreads("Humans4", "HumansOut4");


            Thread t1 = new Thread(h1);

            Thread t2 = new Thread(h2);

            Thread t3 = new Thread(h3);

            Thread t4 = new Thread(h4);

            t1.start();

            t2.start();

            t3.start();

            t4.start();


            HumansSorter.sortFiles();
        }

}


