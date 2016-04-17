package ru.itis.inform;
import java.io.FileNotFoundException;


public class Main  {
    public static void main(String[] args) throws FileNotFoundException {
        LexReaderWriter textReaderWriter = new LexReaderWriter();
        LinkedList<String> linkedList =  new LinkedList <String>();
        linkedList = textReaderWriter.readHumans();

        LexSorter sorter = new LexSorter();
        linkedList = sorter.sort(linkedList);

        textReaderWriter.writeHumans("SortedWords",linkedList);
    }
}
