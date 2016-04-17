package ru.itis.inform;

/**
 * Created by Иван on 29.03.2016.
 */
public class Segment implements Comparable<Segment> {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double length;
    public Segment(double x1, double y1, double x2, double y2)
    {
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.length=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
    public double getX1()
    {return x1;}
    public double getX2()
    {return x2;}
    public double getY1()
    {return y1;}
    public double getY2()
    {return y2;}
    @Override
    public String toString()
    {
        return "("+this.x1+","+this.y1+") - ("+this.x2+","+this.y2+") length: "+this.length;
    }
    public double getLength()
    {
        return length;
    }

    public int compareTo(Segment second) {

        double value = this.length - second.getLength();

        if (value > 0) {
            return 1;
        } else if (value < 0) {
            return -1;
        } else {
            return 0;
        }
    }



}
