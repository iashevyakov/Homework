package ru.itis.inform;


public class Main {
    public static void main(String[] args) {
        RBtree tree = new RBtree();

        int array[] = {2, 4, 7, 8, 10, 13, 21, 34};
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }

        tree.show();
    }
}
