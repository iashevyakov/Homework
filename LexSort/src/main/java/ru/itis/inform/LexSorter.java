package ru.itis.inform;

public class LexSorter {
    public LinkedList<String> sort(LinkedList<String> linkedList) {

        ArrayList<LinkedList<String>> arrayList = new ArrayList<LinkedList<String>>(30);


        for (int i = 0; i <= 26; i++) {
            if (arrayList.get(i) == null) {
                arrayList.set(i, new LinkedList<String>());
            }
        }

        for (int i = linkedList.getFirst().getValue().length() - 1; i >= 0; i--) {
            for (int j = 90; j >= 65; j--) {
                Iterator<String> iterator = linkedList.iterator();
                while (iterator.hasNext()) {

                    if (iterator.peakNext().charAt(i) == (char) j) {
                        arrayList.get(j - 65).add(iterator.peakNext());
                        iterator.next();
                    } else {
                        iterator.next();
                    }
                }
            }
            Boolean f = false;
            for (int a = 25; a >= 1; a--) {
                if (arrayList.get(a).getFirst() != null) {
                    f = true;
                    arrayList.get(a - 1).append(arrayList.get(a));
                    arrayList.set(a, new LinkedList<String>());
                }
            }
            if (f) {
                linkedList = arrayList.get(0);
                arrayList.set(0, new LinkedList<String>());
            }
        }
        return linkedList;
    }
}
