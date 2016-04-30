package ru.itis.inform;

import java.util.*;


public class HashMap<K,V> {

    public int size = 16;
    private final double L_F = 0.75;
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
        if(currentSize>=size*L_F)
        {reSize();}

    }

    public int index(String s)
    {
        int h = s.hashCode();
        return h & (size-1);
    }
    public void reSize()
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
            {System.out.println(i+") NULL");}
            else
            {   System.out.print(i+") ");
                Entry n = hashmap[i];
                System.out.print(n.getKey()+ " ");
                boolean b = false;
                if(!n.hasNext())
                {b=true;}
                while(n.hasNext())
                {
                    System.out.print(n.getNext().getKey() + " ");
                    n = n.getNext();
                    if(!n.hasNext())
                    {b=true;}
                }
                if (b)
                {System.out.println(" ");}

            }
        }
        System.out.println(size);
    }

}
