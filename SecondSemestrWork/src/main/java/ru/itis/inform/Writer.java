package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {
    public void write(ArrayList<Integer> words, String nameOfFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("C:\\Users\\Иван\\Desktop\\Projects\\SecondSemestrWork\\src\\main\\resources\\"+ nameOfFile+".txt"));
        for (int i = 0; i <words.size() ; i++) {
            writer.print(words.get(i)+" ");
        }
        writer.close();
    }
}
