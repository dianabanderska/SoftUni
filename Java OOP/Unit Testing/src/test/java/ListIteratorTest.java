import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] DATA = {"Desi", "Pesho", "Stoyan", "Iliyan", "Vladislav"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(DATA);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParam() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNextAndMove() {
        //0 index:
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        //1 index:
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        //2 index:
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        //3 index:
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        //4 index:
        Assert.assertFalse(listIterator.hasNext());
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyList() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintCorrectly() {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(listIterator.print(), DATA[index++]);
            listIterator.move();
        }
    }
}