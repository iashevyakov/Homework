package ru.itis.inform;

/**
 * Created by Иван on 25.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();

        int array[] = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        tree.show();
    }
}