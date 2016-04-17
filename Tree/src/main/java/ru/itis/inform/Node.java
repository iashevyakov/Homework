package ru.itis.inform;

public class Node {

    private int data;
    private Node left;
    private Node right;
    private int level;

    public Node(int data, int level) {
        this.data = data;
        this.level = level;
    }
    public int getLevel()
    {
        return level;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}