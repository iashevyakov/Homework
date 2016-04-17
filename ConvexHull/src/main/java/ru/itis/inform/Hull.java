package ru.itis.inform;


public class Hull<T> {
    public static Point[] points = new Point[100];
    private static  int count=0;
    private static int index;
    private  int indexL;
    private  int indexR;
    private int countHull=2;
    Point[] hull = new Point[100];
    Point[] up = new Point[100];


    public void AddPoint(int x,int y)
    {

        this.count++;
        points[count-1] = new Point(x,y);

    }

    public void buildHull()
    {
        hull[0]=Hull.FindStartPoint();
        hull[1]=Hull.FindSecondPoint(hull[0]);
        double mincos=1;
        double cos;
        Point vector1;
        Point vector2;
        int next=-1;
        int j=1;
        while (hull[j].getX()!=hull[0].getX() && hull[j].getY()!=hull[0].getY()){
            j++;
            for (int i = 0; i < count; i++) {
                vector1 = new Point(points[i].getX() - hull[j-1].getX(), points[i].getY() - hull[j-1].getY());
                vector2 = new Point(hull[j-2].getX()-hull[j-1].getX(), hull[j-2].getY()-hull[j-1].getY());
                cos=calculateCos(vector1,vector2);
                if (cos<=mincos)
                {
                    mincos=cos;
                    next = i;
                }

            }
            mincos =1;
            hull[j]=points[next];


        }

        countHull=j+1;
    }
    public static  double calculateCos(Point v1, Point v2)
    {
        double l1 = Math.sqrt(v1.getX() * v1.getX() + v1.getY() * v1.getY());
        double l2 = Math.sqrt(v2.getX() * v2.getX() + v2.getY() * v2.getY());
        double p = v1.getX() * v2.getX() + v1.getY() * v2.getY();
        double c = p/(l1*l2);
        return c;
    }
    public static Point FindStartPoint() {
        int minX = points[0].getX();
        int minY = points[0].getY();

        for (int i = 1; i < count; i++) {
            if(points[i].getY()<minY)
            {
                minY=points[i].getY();
                minX=points[i].getX();
                index=i;
            }
        }
        for (int i=1;i<count;i++)
        {
            if(minY==points[i].getY() && points[i].getX()<minX && index!=i)
            {
                minY=points[i].getY();
                minX=points[i].getX();
                index=i;
            }
        }


        Point point = points[index];
      //  for(int i=index;i<count-1; i++)
        //{
          //  points[i]=points[i+1];
        //}
        //points[count-1]=null;
        //count--;
        return point;

    }
    public static Point FindSecondPoint(Point point)
    {
        int v=-1;
        double maxcos=-2;
        double cos;
        Point vector1=new Point(1,0);
        Point vector2;
        for (int i=0; i<count; i++)
        {
            vector2=new Point (points[i].getX()-point.getX(),points[i].getY()-point.getY());
            cos=calculateCos(vector2,vector1);
            if (cos>maxcos)
            {
                maxcos=cos;
                v=i;

            }

        }
        Point p = points[v];
        //for (int i=v; i<count-1; i++)
        //{
          //  points[i]=points[i+1];
        //}
        //points[count-1]=null;
        //count--;
        return p;
    }
    public void showConvexHull()
    {
      for(int i=0;i<this.countHull;i++)
      {
          System.out.println(hull[i].toString());

      }

    }
    public void showStartPoint()
    {
        System.out.println(points[index].getX());
        System.out.println(points[index].getY());
    }
    public  Point FindLeft(LinkedList<T> list)
    {

        int minX = points[0].getX();
        int in=0;
        for (int i=1; i<count;i++)
        {
            if (points[i].getX()<minX)
            {
                minX=points[i].getX();
                in=i;
            }
        }
        list.push((T) points[in]);

        return points[in];


    }
    public static int getIndexL()
    {
        int minX = points[0].getX();
        int indexL=-1;
        for (int i=1; i<count;i++)
        {
            if (points[i].getX()<minX)
            {
                minX=points[i].getX();
                indexL=i;
            }
        }
        return indexL;
    }
    public static int getIndexR()
    {
        int maxX = points[0].getX();
        int in=-1;
        for (int i=1; i<count;i++)
        {
            if (points[i].getX()>maxX)
            {
                maxX=points[i].getX();
                in=i;
            }
        }
        return in;
    }
    public  Point FindRight(LinkedList<T> list)
    {
        int maxX = points[0].getX();
        int in=0;
        for (int i=1; i<count;i++)
        {
            if (points[i].getX()>maxX)
            {
                maxX=points[i].getX();
                in=i;
            }
        }
       list.push((T) points[in]);
        return points[in];

    }
    public void buildQuickHullTop(Point p1,Point p2,LinkedList<T> list)
    {

        Point line = new Point(p2.getX()-p1.getX(),p2.getY()-p1.getY());
        double len=Math.sqrt(line.getX()*line.getX()+line.getY()*line.getY());
        double S;
        double maxS=-1;
        int index=-1;
        for (int i=0; i<count; i++)
        {
            if (points[i].getY()>p1.getY()+(points[i].getX()-p1.getX())*(p2.getY()-p1.getY())/(p2.getX()-p1.getX()))
            {
                Point vector = new Point (points[i].getX()-p1.getX(),points[i].getY()-p1.getY());
                double cos = calculateCos(line,vector);
                double sin2=1-cos*cos;
                double sin = Math.sqrt(sin2);
                double len2=Math.sqrt(vector.getX()*vector.getX()+vector.getY()+vector.getY());
                S=len*len2*sin/2;
                if (S>maxS)
                {
                    maxS=S;
                    index=i;
                }
            }
        }
            if(maxS!=-1) {
                list.push((T) points[index]);

                buildQuickHullTop(p1, points[index], list);
                buildQuickHullTop(points[index], p2, list);
            }
            else {
                for (int i=0; i<count; i++) {
                    if (points[i].getY() == p1.getY() + (points[i].getX() - p1.getX()) * (p2.getY() - p1.getY()) / (p2.getX() - p1.getX())&& points[i]!=p1 && points[i]!=p2) {
                        list.push((T)points[i]);
                    }
                }
            }
    }
    public void buildQuickHullLow(Point p1,Point p2,LinkedList<T> list)
    {

        Point line = new Point(p2.getX()-p1.getX(),p2.getY()-p1.getY());
        double len=Math.sqrt(line.getX()*line.getX()+line.getY()*line.getY());
        double S;
        double maxS=-1;
        int index=-1;
        for (int i=0; i<count; i++)
        {
            if (points[i].getY()<p1.getY()+(points[i].getX()-p1.getX())*(p2.getY()-p1.getY())/(p2.getX()-p1.getX()))
            {
                Point vector = new Point (points[i].getX()-p1.getX(),points[i].getY()-p1.getY());
                double cos = calculateCos(line,vector);
                double sin2=1-cos*cos;
                double sin = Math.sqrt(sin2);
                double len2=Math.sqrt(vector.getX()*vector.getX()+vector.getY()+vector.getY());
                S=len*len2*sin/2;
                if (S>maxS)
                {
                    maxS=S;
                    index=i;
                }
            }
        }

        if(maxS!=-1) {
            list.push((T) points[index]);

            buildQuickHullLow(p1, points[index], list);
            buildQuickHullLow(points[index], p2, list);
        }
        else {
            for (int i=0; i<count; i++) {
                if (points[i].getY() == p1.getY() + (points[i].getX() - p1.getX()) * (p2.getY() - p1.getY()) / (p2.getX() - p1.getX())&& points[i]!=p1 && points[i]!=p2) {
                    list.push((T)points[i]);
                }
            }
        }
    }



}
