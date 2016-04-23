package ru.itis.inform;


public class Main {
    public static void main(String[] args) {
        RBtree tree = new RBtree();

        int array[] = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }

        tree.show();


        //tree.isSearchTreePrint();
        //tree.runIsLevelSum();
    }
}
