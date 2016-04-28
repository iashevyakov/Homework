package ru.itis.inform;

import java.util.*;


public class HashMap<K,V> {

    public int size = 16;
    private final double lf = 0.75;
    public int currentSize=0;
    Entry[] hashmap = new Entry[size];

    public void add(String s, V value)
    {
        currentSize++;

        Entry e = new Entry(s,value);
        if (hashmap[index(s)]==null)
        {hashmap[index(s)]=e;}
        else
        {
            e.setNext(hashmap[index(s)]);
            hashmap[index(s)]=e;
        }
        if(currentSize>=size*lf)
        {increase();}

    }

    public int index(String s)
    {
        int h = s.hashCode();
        return h & (size-1);
    }
    public void increase()
    {
        size*=2;
        Entry[] c = hashmap;
        hashmap = new Entry[size];
        for (int i=0;i<size/2;i++)
        {
            if(c[i]!=null) {
                Entry e = c[i];
                if (hashmap[index(e.getKey())] == null) {
                    hashmap[index(e.getKey())] = e;
                } else {
                    e.setNext(hashmap[index(e.getKey())]);
                    hashmap[index(e.getKey())] = e;
                }
            }
        }
    }
    public void show() {
        for (int i=0;i<size;i++)
        {
            if(hashmap[i]==null)
            {System.out.println("NULL");}
            else
            {
                System.out.println(hashmap[i].getKey());
                Entry n=hashmap[i];
                while (n.hasNext())
                {
                    if(!n.getNext().hasNext())
                    { System.out.println(n.getNext().getKey());}
                    else
                    {System.out.print(n.getNext().getKey()+"  ----->  ");}
                    n=n.getNext();
                }
            }


        }
        System.out.println(size);
    }

}
