package ru.itis.inform;
public class Main {
    public static void main (String[] args)
    {
        Hull<Point> hull = new Hull<Point>();
        LinkedList<Point> list = new LinkedList<Point>();
        hull.AddPoint(20,-20);
        hull.AddPoint(-20,0);
        hull.AddPoint(-19,1);
        hull.AddPoint(-10,-30);
        hull.AddPoint(-8,40);
        hull.AddPoint(-10,-50);
        hull.AddPoint(-90,-50);
        hull.AddPoint(-7,-8);
        hull.AddPoint(-15,-50);
        hull.AddPoint(-20,40);
        hull.AddPoint(-15,1);
        hull.AddPoint(-30,10);
        hull.AddPoint(-50,-25);
        hull.AddPoint(15,30);
        hull.AddPoint(5,20);
        hull.AddPoint(-40,-100);
        hull.AddPoint(15,-95);
        hull.AddPoint(-75,35);
        Point p1=hull.FindLeft(list);
        Point p2=hull.FindRight(list);
        hull.buildQuickHullTop(p1,p2,list);
        hull.buildQuickHullLow(p1,p2,list);
        Iterator<Point> iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.peakNext().toString());
            iterator.next();
        }

    }

}
