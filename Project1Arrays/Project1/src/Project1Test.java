/**
 * Test file for Project1Arrays.
 * This test class tests the functionality for the ITSC 2214 project 1 array wrapper class.
 *
 * @author  Adrian Khlim
 * @version Jan 22, 2025
 */

import itsc2214.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Class Project1Test.
 */

public class Project1Test {

    /**
     * Declared variables for testing and initializing test objects
     * in the setup() method below.
     */
    Project1 runner;
    Project1 runner2;

    
    /**
     * setup() method, runs before each test method below.
     * Used to create objects needed for testing your classes.
     */
    @Before
    public void setup() {
        runner = new Project1(5);
        runner2 = new Project1(3);
        runner2.addValue(2);
        runner2.addValue(5);
        runner2.addValue(3);

    }
     
    /**
     * Testing the size() method.
     */
    @Test
    public void testSize() {
        assertEquals(0, runner.size());
        assertEquals(3, runner2.size());
    }

    /**
     * Testing the capacity() method.
     */
    @Test
    public void testCapacity() {
        assertEquals(5, runner.capacity());
        assertEquals(3, runner2.capacity());
        runner2.addValue(3);
        assertEquals(6, runner2.capacity());
    }

    /**
     * Testing the getCapacity() method.
     */
    @Test
    public void testGetCapacity() {
        assertEquals(5, runner.getCapacity());
        assertEquals(3, runner2.getCapacity());
        runner2.addValue(3);
        //Tests the addValue method.
        assertEquals(6, runner2.getCapacity());
    }

    /**
     * Testing the addValue() method.
     */
    @Test
    public void testAddValue() {
        runner.addValue(3);
        assertEquals(1, runner.size());
    }

    /**
     * Testing the getValue() method.
     */
    @Test
    public void testGetValue() {
        assertEquals(3, runner2.getValue(2));
        boolean run = true;
        while (run) {
            try {
                runner2.getValue(3);
                run = false;
            }

            catch (IndexOutOfBoundsException e) {
                assertTrue(e instanceof IndexOutOfBoundsException);
                runner2.addValue(6);
            }
            assertEquals(6, runner2.getValue(3));
        }

        run = true;
        int num = -3;
        while (run) {
            try {
                runner2.getValue(num);
                run = false;
            }

            catch (IndexOutOfBoundsException e) {
                assertTrue(e instanceof IndexOutOfBoundsException);
                runner2.addValue(6);
                num = 3;
            }
            assertEquals(6, runner2.getValue(3));
        }
    }

    /**
     * Testing the setValue() method.
     */
    @Test
    public void testSetValue() {
        assertEquals(8, runner2.setValue(1, 8));
        boolean run = true;
        while (run) {
            try {
                runner.setValue(2, 9);
                run = false;
            }

            catch (IndexOutOfBoundsException e) {
                assertTrue(e instanceof IndexOutOfBoundsException);
                runner.addValue(4);
                runner.addValue(2);
                runner.addValue(8);
            }
        }


    }
   
    /**
     * Testing the addRandom() method.
     */
    @Test
    public void testAddRandom() {
        runner.addRandom(3);
        assertEquals(3, runner.size());
    }

    /**
     * Testing the removeValue() method.
     */
    @Test
    public void testRemoveValue() {
        runner2.removeValueAt(0);
        assertEquals(2, runner2.size());
        assertEquals(5, runner2.getValue(0));
    }

    /**
     * Testing isEmpty() method.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(runner.isEmpty());
        assertFalse(runner2.isEmpty());
    }

    /**
     * Testing isFull() method.
     */
    @Test
    public void testIsFull() {
        assertTrue(runner2.isFull());
        assertFalse(runner.isFull());
    }

    /**
     * Testing hasDuplicates method.
     */
    @Test
    public void testHasDuplicates() {
        assertFalse(runner2.hasDuplicates());
        assertFalse(runner.hasDuplicates());
        runner2.addValue(5);
        assertTrue(runner2.hasDuplicates());
    }

    /**
     * Testing getMininmum() method.
     */
    @Test
    public void testGetMinimum() {
        assertEquals(2, runner2.getMinimum());
        assertEquals(Integer.MIN_VALUE, runner.getMinimum());
        runner2.addValue(0);
        assertEquals(0, runner2.getMinimum());

    }

    /**
     * Testing getMaximum() method.
     */
    @Test
    public void testGetMaximum() {
        assertEquals(5, runner2.getMaximum());
        assertEquals(Integer.MAX_VALUE, runner.getMaximum());
        runner2.addValue(45);
        assertEquals(45, runner2.getMaximum());
    }

    /**
     * Testing getAverage() method.
     */
    @Test
    public void testGetAverage() {
        assertEquals(10/3, runner2.getAverage(), .5);
        assertEquals(0, runner.getAverage(), .5);
        runner2.addValue(6);
        assertEquals(4, runner2.getAverage(), .5);
    }

    /**
     * Testing getRange() method.
     */
    @Test
    public void testGetRange() {
        assertEquals(3, runner2.getRange());
        assertEquals(Integer.MAX_VALUE - Integer.MIN_VALUE, runner.getRange());
    }
}