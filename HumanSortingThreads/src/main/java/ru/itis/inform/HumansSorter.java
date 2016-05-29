package ru.itis.inform;


import java.io.FileNotFoundException;

public class HumansSorter {

    public LinkedList<Human> sort (LinkedList<Human> humanLinkedList) {

        ArrayList<LinkedList<Human>> arrayList = new ArrayList<LinkedList<Human>>();

        Iterator<Human> humanIterator = humanLinkedList.iterator();

        for (int i = 0; i < arrayList.getSize(); i++) {
            LinkedList<Human> current = arrayList.get(i);
            if (current==null)
                arrayList.set(i,new LinkedList<Human>());
        }

        while (humanIterator.hasNext()) {

            int currentAge = humanIterator.peakNext().getAge();

            arrayList.get(currentAge).add(humanIterator.peakNext());
            humanIterator.next();
        }


        LinkedList<Human> newHumanLinkedList = new LinkedList<Human>();

        for (int i = 99; i >= 1; i--) {
            if (arrayList.get(i).getFirst() != null) {
                arrayList.get(i - 1).append(arrayList.get(i));
                arrayList.set(i, new LinkedList<Human>());
            }
        }

        return arrayList.get(0);
    }
    public static void sortFiles() throws FileNotFoundException {
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