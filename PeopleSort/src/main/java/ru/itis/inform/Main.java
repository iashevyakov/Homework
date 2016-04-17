package ru.itis.inform;
import java.io.FileNotFoundException;
import java.io.IOException;



public class Main {
    public static void main (String[] args) throws FileNotFoundException
    {
        HumansReaderWriter humansReaderWriter = new HumansReaderWriter();

        LinkedList<Human> first = humansReaderWriter.readHumans("ListMerge1");
        LinkedList<Human> second = humansReaderWriter.readHumans("ListMerge2");
        LinkedList<Human> third = humansReaderWriter.readHumans("ListMerge3");



        HumansSorter humansSorter = new HumansSorter();

        first = humansSorter.sort(first);
        second = humansSorter.sort(second);

        LinkedList<Human> result = new LinkedList<>();
        result = LinkedList.merge(first,second);

        LinkedList<Human> mergeresult = new LinkedList<>();
        mergeresult = LinkedList.mergeSort(third);


        humansReaderWriter.writeHumans("MergeOut",result);
        humansReaderWriter.writeHumans("MergeSortOut",mergeresult);

    }

}
