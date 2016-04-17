package ru.itis.inform;


public class HumansSorter {

    public LinkedList<Human> sort (LinkedList<Human> humanLinkedList) {

        ArrayList<LinkedList<Human>> arrayList = new ArrayList<>();

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
}