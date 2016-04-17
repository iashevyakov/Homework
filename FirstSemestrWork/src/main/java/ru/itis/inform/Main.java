package ru.itis.inform;

import java.io.FileNotFoundException;

/**
 * Created by Иван on 29.03.2016.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GraphicPic<Segment> g = new GraphicPic<Segment>("Segments");
      //  g.angleList().show();
       // g.sort();
        //g.show();
        GraphicPic<Segment> gp = new GraphicPic<Segment>();
        gp = g.lengthList(0,5);
       // gp.show();
        gp.sort();
        gp.show();

        //g.lengthList(0,10).show();
        //g.sort();
       // g.show();
        //Segment f= new Segment(50,50,0,0);
       // g.insert(f);


      //  g.show();

    }
}