package ru.itis.inform;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Иван on 20.03.2016.
 */
public class HullTest {

    @Before
    public void setUp() throws Exception {
        Hull<Point> hull = new Hull<Point>();


        hull.AddPoint(-7,0);
        hull.AddPoint(-2,5);
        hull.AddPoint(20,-20);
        hull.AddPoint(-10,0);
        hull.AddPoint(-15,0);
        hull.AddPoint(-9,0);
        //hull.AddPoint(-3,4);
        hull.AddPoint(-20,0);
        hull.AddPoint(-19,1);
        hull.buildHull();
        hull.showConvexHull();
    }

    @Test
    public void testBuildHull() throws Exception {

    }
}