package ru.itis.inform;


public class Node {

    private int key;
    private String value;
    private Node left;
    private Node right;
    private Node parent;
    private boolean isRed;

    public Node(int key, String value)
    {
        this.key=key;
        this.value=value;
    }
    public String getValue()
    {return value;}


    public int getKey() {
        return key;
    }

    public void setKey(int data) {
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
    public void setParent(Node parent)
    {this.parent=parent;}
    public Node getParent()
    {return this.parent;}

    public void setColor(boolean b)
    {
        this.isRed=b;
    }
    public boolean getColor()
    {
        return this.isRed;
    }
}
