import org.junit.Test;

import static org.junit.Assert.*;

public class FareyListTest {

    private RationalNumber[] getResult() {
        RationalNumber[] result = new RationalNumber[100];
        result[0] = new RationalNumber(0, 1);
        result[1] = new RationalNumber(1, 3);
        result[2] = new RationalNumber(1, 2);
        result[3] = new RationalNumber(2, 3);
        result[4] = new RationalNumber(1, 1);
        return result;
    }

    @Test
    public void testRunFarey() throws Exception {
        FareyArrayImpl sequence = new FareyArrayImpl(3, 100);
        sequence.runFarey();

        RationalNumber[] result = getResult();
        assertArrayEquals(result, sequence.getArray());
    }
}