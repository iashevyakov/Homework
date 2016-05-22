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


            sort();
        }

      /*  public static void sortAllFiles() throws FileNotFoundException {
            ArrayList<LinkedList<Human>> arrayList = new ArrayList<LinkedList<Human>>();

            HumansReaderWriter humansReaderWriter = new HumansReaderWriter();

            LinkedList<Human> linkedList = new LinkedList<Human>();

            HumansSorter humansSorter = new HumansSorter();

            arrayList.set(0, new LinkedList<Human>());

            for (int i = 1; i <= 4; i++) {
                if (arrayList.get(i) == null)
                    arrayList.set(i, new LinkedList<Human>());
                linkedList = humansReaderWriter.readHumans("Humans" + i);
                arrayList.set(i, linkedList);
            }
            for (int i = 4; i>=1; i--) {
                if (arrayList.get(i-1)!=null)
                    arrayList.get(i-1).append(arrayList.get(i));
            }

            arrayList.set(1,humansSorter.sort(arrayList.get(1)));

            humansReaderWriter.writeHumans("OutAll",arrayList.get(1));

        }
        */
        public static void sort() throws FileNotFoundException {
            HumansReaderWriter h = new HumansReaderWriter();
            LinkedList<Human> l1 = new LinkedList<Human>();

            LinkedList<Human> l2 = new LinkedList<Human>();

            LinkedList<Human> l3 = new LinkedList<Human>();

            LinkedList<Human> l4 = new LinkedList<Human>();

            l1=h.readHumans("Humans1");

            l1=LinkedList.mergeSort(l1);

            l2=h.readHumans("Humans2");

            l2=LinkedList.mergeSort(l2);

            l3=h.readHumans("Humans3");

            l3=LinkedList.mergeSort(l3);

            l4=h.readHumans("Humans4");

            l4=LinkedList.mergeSort(l4);

            l1=LinkedList.merge(l1,l2);

            l3=LinkedList.merge(l1,l3);

            l4=LinkedList.merge(l3,l4);

            h.writeHumans("OutAll",l4);

        }

}


