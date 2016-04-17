package ru.itis.inform;

class LinkedListIteratorImpl<T> implements Iterator<T> {

    Node<T> current;

    public LinkedListIteratorImpl(Node<T> first) {
        this.current = first;
    }


    public boolean hasNext() {
        return current != null;
    }


     public boolean hasPrevious() {
        return this.current.getPrevious() != null;
    }



    public T next() {
        T value = current.getValue();
        current = current.getNext();
        return value;
    }
    

    public T peakNext() {
        return current.getValue();
    }


    public T peakPrevious() {
        return current.getPrevious().getValue();
    }


    public T previous() {
        if (hasPrevious()) {
            T value = this.current.getValue();
            this.current = current.getPrevious();
            return value;
        } else throw new NullPointerException();
    }

    public void insert(T element) {
        Node<T> newNode = new Node<T>(element);

        newNode.setNext(current);
        newNode.setPrevious(current.getPrevious());

        current.getPrevious().setNext(newNode);
        current.setPrevious(newNode);

    }
}