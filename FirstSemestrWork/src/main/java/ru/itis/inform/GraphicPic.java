package ru.itis.inform;
import com.sun.javafx.runtime.async.AbstractRemoteResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GraphicPic<T extends Comparable<T>> {


    private LinkedList<Segment> list = new LinkedList<Segment>();

    public LinkedList<Segment> getList() {
        return list;
    }

    public GraphicPic (String filename)
    {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("C:\\Users\\Иван\\Desktop\\Projects\\FirstSemestrWork\\src\\main\\resources\\"+filename+".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Segment segment;
        while (sc.hasNext()) {

            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2= sc.nextDouble();
            double y2 = sc.nextDouble();
            segment = new Segment(x1,y1,x2,y2);

            list.push(segment);
        }
    }
    public GraphicPic(){}
    public void show()
    {
        Iterator<Segment> iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.peakNext().toString());
            iterator.next();
        }

    }
    public void sort()
    {
        list=LinkedList.mergeSort(list);
    }


    public GraphicPic lengthList(int a, int b) {
        GraphicPic<Segment> gp = new GraphicPic<Segment>();
        Iterator<Segment> iterator = list.iterator();

        while(iterator.hasNext())
        {
            if (iterator.peakNext().getLength()>=a && iterator.peakNext().getLength()<=b)
            {gp.getList().push(iterator.peakNext());}
            iterator.next();
        }

        return gp;
    }

    public GraphicPic angleList()  {
        GraphicPic<Segment> gp = new GraphicPic<Segment>();
        Iterator<Segment> iterator = list.iterator();

        while(iterator.hasNext())
        {
            double vectorX = iterator.peakNext().getX2()-iterator.peakNext().getX1();
            double vectorY = iterator.peakNext().getY2()-iterator.peakNext().getY1();
            double len = Math.sqrt(vectorX*vectorX+vectorY*vectorY);
            double cos = Math.abs(vectorX/len);
            double cos1=Math.cos(Math.toRadians(45));
            double r1 = cos-cos1;
            double cos2=Math.cos(Math.toRadians(30));
            double r2 = cos-cos2;

            if (Math.abs(r1)<0.00001 || Math.abs(r2)<0.00001)
            {gp.getList().push(iterator.peakNext());}
            iterator.next();
        }
        return gp;

    }
    public void insert (Segment f) {
        boolean b = true;
        Iterator<Segment> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (f.getX1() == iterator.peakNext().getX1() && f.getY2() == iterator.peakNext().getY2() && f.getY1() == iterator.peakNext().getY1() && f.getX2() == iterator.peakNext().getX2()) {
                b &= false;
            }
            iterator.next();


        }
        if (b) {
            list.push(f);
        }
    }


}
