import org.junit.Test;
import org.junit.Assert;

public class CollectionTest {

    @Test
    void add() {
        CollectionImpl ci = new CollectionImpl();

        Assert.assertTrue(ci.add("val-1"));
        Assert.assertEquals(1, ci.size());
        Assert.assertEquals("val-1", ci.get(0));

        Assert.assertTrue(ci.add(null));
        Assert.assertEquals(2, ci.size());
        Assert.assertNull(ci.get(1));

        Assert.assertTrue(ci.add(1, "val-2"));
        Assert.assertEquals(3, ci.size());
        Assert.assertEquals("val-2", ci.get(1));

        Assert.assertFalse(ci.add(-5, "val-2"));
        Assert.assertFalse(ci.add(50, "val-2"));

    }

    @Test
    void testAdd() {
    }

    @Test
    void delete() {
        CollectionImpl ci = new CollectionImpl();
        for (int i = 0; i < 5; i++) {
            ci.add(String.valueOf(i + 1));
        }

        Assert.assertTrue(ci.delete("3"));
        Assert.assertEquals(4, ci.size());

        Assert.assertFalse(ci.delete("value"));
    }

    @Test
    void get() {
        CollectionImpl ci = new CollectionImpl();
        for (int i = 0; i < 10; i++) {
            ci.add(String.valueOf(i + 100));
        }

        Assert.assertEquals("105", ci.get(5));
    }

    @Test
    void getNegative() {
        CollectionImpl ci = new CollectionImpl();
        ci.add("q");
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> ci.get(1));
    }

    @Test
    void contain() {
        CollectionImpl ci = new CollectionImpl();
        for (int i = 0; i < 5; i++) {
            ci.add("T" + i);
        }

        String str = "T4";
        Assert.assertTrue(ci.contain(str));

        str = "F";
        Assert.assertFalse(ci.contain(str));
        Assert.assertFalse(ci.contain(null));
    }

    @Test
    void testEquals() {
        CollectionImpl ci = new CollectionImpl();
        String[] testArray1 = {"0", "1", "2", "3", "4"};
        String[] testArray2 = {"0", "1", "2", "3", "5"};
        String[] testArray3 = {"0", "1", "2", "3", "4", "5"};

        for (int i = 0; i < 5; i++) {
            ci.add(String.valueOf(i));
        }

        Assert.assertTrue(ci.equals(testArray1));
        Assert.assertFalse(ci.equals(testArray2));
        Assert.assertFalse(ci.equals(testArray3));
    }

    @Test
    void clear() {
        CollectionImpl ci = new CollectionImpl();
        ci.add("0");
        ci.clear();
        Assert.assertEquals(0, ci.size());
    }

    @Test
    void size() {
        CollectionImpl ci = new CollectionImpl();
        Assert.assertEquals(0, ci.size());
    }
}