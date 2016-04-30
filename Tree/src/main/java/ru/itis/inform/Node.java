package ru.itis.inform;

public class Node {

    private int key;
    private String value;
    private Node left;
    private Node right;
    private Node parent;
    private boolean isRed;
    private int level;

    public Node(int data) {
        this.key = data;
        this.level = level;
    }
    public int getLevel()
    {
        return level;
    }

    public int getData() {
        return key;
    }

    public void setData(int data) {
        this.key = data;
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