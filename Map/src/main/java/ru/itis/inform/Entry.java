package ru.itis.inform;


public class Entry<K,V> {
    String  key;
    V value;
    int hash;
    Entry next;
    public Entry (String key, V value)
    {
        this.key=key;
        this.value=value;
    }
    public String getKey()
    {return this.key;}
    public Entry setNext(Entry e)
    {return this.next=e;}
    public Entry getNext()
    {return this.next;}
    public boolean hasNext()
    {return this.next!=null;}

}
