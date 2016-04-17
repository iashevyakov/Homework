package ru.itis.inform;

public class Node<T> {

    private T value;
    private Node<T> next;
    private Node<T> previous;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }
    public T getValue() {
        return value;
    }



    public void setNext(Node next) {
        this.next  = next;
    }



    public void setPrevious(Node previous) {
        this.previous = previous;
    }



    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }


}