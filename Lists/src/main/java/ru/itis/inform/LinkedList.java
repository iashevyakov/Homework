package ru.itis.inform;

public class LinkedList<T> implements List<T> {

    private Node<T> first;
    private int count;
    private Node<T> last;

    public LinkedList() {
        this.first = null;
        this.count = 0;
    }
    public Node<T> getFirst()
    {
        return this.first;
    }

    // Когда добавляете, учтите, что еще есть previous
    public void add(T element) {
        Node newNode = new Node<T>(element);
        newNode.setPrevious(null);
        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            first.setPrevious(newNode);
            first = newNode;
        }
        this.count++;
    }
    public int getCount() {
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }


    @SuppressWarnings("unchecked")
    public static <T extends Comparable> LinkedList<T> merge(LinkedList<T> a, LinkedList<T> b) {
        Iterator<T> iteratorA = a.iterator();
        Iterator<T> iteratorB = b.iterator();

        LinkedList<T> result = new LinkedList<T>();

        while (iteratorA.hasNext() && iteratorB.hasNext()) {
            int compare = iteratorA.peakNext().compareTo(iteratorB.peakNext());

            switch (compare) {
                case 1: {
                    result.push(iteratorB.peakNext());
                    iteratorB.next();
                    break;
                }

                case -1: {
                    result.push(iteratorA.peakNext());
                    iteratorA.next();
                    break;
                }

                case 0: {
                    result.push(iteratorA.peakNext());
                    result.push(iteratorB.peakNext());
                    iteratorA.next();
                    iteratorB.next();
                    break;
                }
            }
        }

        while (iteratorA.hasNext()) {
            result.push(iteratorA.next());
        }

        while (iteratorB.hasNext()) {
            result.push(iteratorB.next());
        }

        return result;
    }
    public void push(T element) {
        Node<T> newNode = new Node<T>(element);

        if (this.first == null) {
            this.first = newNode;
        } else {
            Node<T> r = first;
            while (r.getNext() != null) {
                r = r.getNext();
            }
            r.setNext(newNode);
            newNode.setPrevious(r);
            newNode.setNext(last);
        }
        this.count++;
    }


    public static <T extends Comparable> LinkedList<T> mergeSort(LinkedList<T> linkedList) {
        ArrayList<LinkedList<T>> arrayList = new ArrayList<LinkedList<T>>();

        for (int i = 0; i <= linkedList.getCount(); i++) {
            arrayList.set(i, new LinkedList<T>());
        }

        Iterator<T> iterator = linkedList.iterator();

        arrayList.get(0).push(iterator.next());
        int i = 1;
        while (iterator.hasNext()) {
            while (arrayList.get(i).getFirst() != null) {
                i++;
            }
            arrayList.get(i).push(iterator.next());
            for (int j = linkedList.getCount() - 1; j > 0; j--) {
                if (arrayList.get(j).getCount() == arrayList.get(j - 1).getCount() && arrayList.get(j - 1).getCount() != 0) {
                    LinkedList<T> list = new LinkedList<T>();
                    list.mergeCellsOfArray(arrayList,j);
                    i--;

                }
            }
        }

        for (int j = linkedList.getCount() - 1; j > 0; j--) {
            if (arrayList.get(j - 1).getCount() != 0) {
                LinkedList<T> list = new LinkedList<T>();
                list.mergeCellsOfArray(arrayList,j);
                i--;
            }
        }

        return arrayList.get(0);
    }

    public <T extends Comparable>void mergeCellsOfArray(ArrayList<LinkedList<T>> arrayList, int j) {
        LinkedList<T> newLinkedList = new LinkedList<T>();
        newLinkedList = LinkedList.merge(arrayList.get(j), arrayList.get(j - 1));
        newLinkedList.setCount(arrayList.get(j).getCount() + arrayList.get(j - 1).getCount());
        arrayList.set(j - 1, newLinkedList);
        arrayList.set(j, new LinkedList<T>());
    }


    public static <T extends Comparable> LinkedList<T> Msort (LinkedList<T> sortlist) {
        Iterator<T> iterator = sortlist.iterator();
        LinkedList<T>[] stack = new LinkedList[32];
        for (int i = 0; i < 32; i++) {
            stack[i] = new LinkedList<T>();
        }
        int stackPos = 0;

        while (iterator.hasNext()) {
            stack[stackPos].add(iterator.peakNext());
            iterator.next();
            stackPos++;

            while (stackPos > 1 && stack[stackPos - 1].getCount() == stack[stackPos - 2].getCount()) {
                stack[stackPos - 2] = merge(stack[stackPos - 1], stack[stackPos - 2]);
                stack[stackPos - 1].clear();
                stackPos--;
            }
        }
        while (stackPos > 1) {
            stack[stackPos - 2] = merge(stack[stackPos - 1], stack[stackPos - 2]);
            stackPos--;
        }
        if (stackPos > 0) {
            return stack[0];
        } else {
            return null;
        }
    }
    public void clear()
    {
        this.first = null;
        this.count = 0;
    }


    public void remove(T element) {

          Node<T> node = first;

        for (int i = 0; i < count - 1; i++) {
            if ((i == 0) && (node.getValue() == element)) {
                first = node.getNext();
                count--;
                break;
            } else if (node.getNext().getValue() == element) {
                node.setNext(node.getNext().getNext());
                count--;
            }
            node = node.getNext();
        }

    }
    @SuppressWarnings("unchecked") public void append(LinkedList<T> secondList) {

        if (this.first == null) {
            Node<T> nodeSecondList = secondList.getFirst();

            this.first = nodeSecondList;
            Node<T> r = this.first;
            nodeSecondList = nodeSecondList.getNext();

            while (nodeSecondList != null) {
                r.setNext(nodeSecondList);
                nodeSecondList.setPrevious(r);
                r = r.getNext();
                nodeSecondList = nodeSecondList.getNext();
            }

        } else {
            Node<T> r  = this.first;

            while (r.getNext() != null)
                r = r.getNext();

            Node<T> t = secondList.getFirst();

            while (t!=null) {
                r.setNext(t);
                t.setPrevious(r);
                r = r.getNext();
                t = t.getNext();
            }
        }
    }



 public Iterator<T> iterator() {
        return new LinkedListIteratorImpl<T>(this.first);
    }
}
