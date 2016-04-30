package ru.itis.inform;

/**
 * Created by Иван on 19.04.2016.
 */
public class Main {
    public static void main(String[] args)
    {
        int n=5;
        int [][] g = new int[n][n];
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n-1; j++)
            {
                g[i][j]=(int) (Math.random()*10);
                System.out.print(g[i][j]+" ");
            }
            g[i][n-1] = (int) (Math.random()*10);
            System.out.println(g[i][n-1]);
        }
        Dijkstra d=new Dijkstra(n,g);
        int [] dist = new int[n];
        dist = d.dijkstra(0);
        for (int i=0; i<n; i++)
        {
            System.out.println(dist[i]);
        }


    }
}
