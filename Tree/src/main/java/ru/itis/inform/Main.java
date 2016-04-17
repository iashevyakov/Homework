package ru.itis.inform;

/**
 * Created by Иван on 25.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        int array[] = {8, 10, 14, 1, 13, 6, 4, 7, 5};
        int m = array.length;//длина массива
        int n=0;
        int c=1;
        for (int i = 0; i < array.length; i++) {

            if (c<Math.pow(2,n)) {
                tree.insert(array[i],n);
                c++;
            }
            if (c==Math.pow(2,n)) {
                tree.insert(array[i],n);
                n++; c=1;
            }
        }

        tree.show();
        boolean  first = tree.checkTree();
        System.out.println(first);
        tree.setRoot(11);
        tree.show();
        boolean second = tree.checkTree();
        System.out.println(second);
        tree.travelsarWide();
        boolean v = tree.CheckLevelSum();
        System.out.println(v);

    }

}