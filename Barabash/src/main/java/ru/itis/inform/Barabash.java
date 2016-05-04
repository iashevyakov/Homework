package ru.itis.inform;

import java.util.Random;

public class Barabash {
    private static final  int DEFAULT_SIZE=50;
    private int[][] graph;
    private double[] degv ;

    private int count;

    public Barabash() {
        graph = new int[DEFAULT_SIZE][DEFAULT_SIZE];
        degv=new double[DEFAULT_SIZE];
        graph[0][1]=1;
        graph[1][0]=1;
        count=2;
    }

    public void add() {
       double s =0;
        for (int i=0;i<count;i++) {

            degv[i] = 0;

            for (int j=0; j<count;j++) {

                if(graph[i][j]!=0) {
                    degv[i]++;
                }

            }

            s+= degv[i];
        }
        double k =  Math.random();

        count++;

        for (int i=0; i<count-1;i++) {
            double r = degv[i]/s;

            if (k<=r) {
                graph[count-1][i] = 1;
                graph[i][count-1] = 1;
            }
        }

    }
    public void show()
    {


        for (int i=0;i<count;i++) {
            for(int j=0;j<count;j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
