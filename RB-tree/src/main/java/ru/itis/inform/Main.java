package ru.itis.inform;

/**
 * Created by Иван on 22.04.2016.
 */
public class Main {
    public static void main (String [] args)
    {
        RBtree r = new RBtree();
        r.insert(10,"10");
        r.insert(9,"9");
        r.insert(8,"8");
        r.show();
    }
}
