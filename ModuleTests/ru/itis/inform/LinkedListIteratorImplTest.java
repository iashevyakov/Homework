import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class LinkedListIteratorImplTest {
    private LinkedList<Integer> list;
    private Iterator<Integer> it;

    @Before
    public void setUp() {
        this.list = new LinkedList<Integer>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        this.it = list.iterator();
    }



    @Test
    public void testHasNext() throws Exception {
        assertTrue(it.hasNext());
        for (int i = 0; i < 10; i++) {
            it.next();
        }
        assertFalse(it.hasNext());
    }

    @Test
    public void testNext() throws Exception {
        assertEquals(it.next(), (Integer) 9);
        assertEquals(it.next(), (Integer) 8);
    }

    @Test
    public void testPrevious() throws Exception {
        it.next();
        it.next();
        assertEquals(it.previous(), (Integer) 7);
        assertEquals(it.previous(), (Integer) 8);
    }

    @Test
    public void testPeakNext() throws Exception {
        assertEquals(it.peakNext(), (Integer) 8);
        assertEquals(it.next(), (Integer) 9);
    }

    @Test
    public void testPeakPrevious() throws Exception {
        it.next();
        assertEquals(it.peakPrevious(), (Integer) 9);
        assertEquals(it.previous(), (Integer) 8);
    }

    @Test
    public void testInsert() throws Exception {
        it.next();
        it.insert(100);
        assertEquals(it.next(), (Integer) 8);
        assertEquals(it.previous(), (Integer) 7);
        assertEquals(it.peakPrevious(), (Integer) 100);
        it.previous();
        assertEquals(it.peakPrevious(), (Integer) 9);
    }
}