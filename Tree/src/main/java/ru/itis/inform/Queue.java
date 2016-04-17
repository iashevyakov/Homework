package ru.itis.inform;

public class Queue  {

    public int count=0;
    public int head=0;
    public int tail=0;
    public Node [] data = new Node [100];
    public void add (Node node)
    {
        data[tail] = node;
        tail++;
        count++;
    }
    public int getCount()
    {
        return count;
    }
    public  Node extract() {
            Node f = data[head];
            if (count==1)
            {
                data[head]=null;
                count--;
                tail--;
                return f;
            }
            for (int i=0; i<count-1;i++)
            {
                data[i]=data[i+1];

            }
            data[count-1]=null;
            count--;
            tail--;
            return f;

     }


  public  boolean isEmpty() {
        return count==0;
    }


}
