import itsc2214.*;
import itsc2214.ArrayInt;
import java.util.Random;

/**
 * Class Project1.
 */
public class Project1 implements ArrayInt {

    private int size;
    private int[] arr;

    /**
     * Constructor.
     * @param capacity an int the length of the initial array.
     */
    public Project1(int capacity) {
        this.arr = new int[capacity];
        size = 0;
    }

    /**
     * This method returns the size, or number of elements in the array.
     * @return int size, the int number of elements in the array.
     */
    public int size() {
        return this.size;
    }

    /**
     * This method returns the size or capacity of the array.
     * @return int arr.length, the capacity of the array.
     */
    public int capacity() {
        return arr.length;
    }

    /**
     * This method adds a value to the array.
     * @param value an integer to add to the array.
     */
    public void addValue(int value) throws IllegalStateException {
        if (this.size() == this.capacity()) {
            throw new IllegalStateException();
        }
        arr[this.size()] = value;
        size++;
    }

    /**
     * This method returns the size or capacity of the array.
     * @return int arr.length, the capacity of the array.
     */
    public int getCapacity() {
        return arr.length;
    }

    /**
     * This method returns the element at a given index.
     * @param index the integer index to access.
     * @return int arr[index], the integer accessed.
     */
    public int getValue(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    /**
     * This method sets the value at a specified index.
     * @param index the int index number whose element should be changed.
     * @param value the int value to change the original element to.
     * @return int, the new element.
     */
    public int setValue(int index, int value) throws IndexOutOfBoundsException {
        //should not grow the array
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        arr[index] = value;
        return arr[index];
    }

    /**
     * This method adds n amount of random integers.
     * @param n the int number of times a random integer should be added
     */
    public void addRandom(int n) throws IllegalStateException {
        if (this.size() == this.capacity()) {
            throw new IllegalStateException();
        }
        //What should be the max int for the random number?
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            addValue(rand.nextInt());
        }
    }

    /**
     * This method removes a value at a given index.
     * @param index the int index of the value to be removed.
     */
    public void removeValueAt(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < this.size() - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
        size--;
    }

    /**
     * This method returns if the array is empty or not.
     * @return true if the array is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }

        return false;
    }

    /**
     * This method returns if the array is full or not.
     * @return true if the array is full, false otherwise.
     */
    public boolean isFull() {
        if (this.size() == this.capacity()) {
            return true;
        }

        return false;
    }

    /**
     * This method returns if the array has duplicate elements or not.
     * @return true if there are duplicate elements, false otherwise.
     */
    public boolean hasDuplicates() {
        for (int i = 0; i < this.size(); i++) {
            for (int j = i + 1; j < this.size(); j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method returns the smallest element in the array.
     * @return int smallest, the smallest element in the array.
     */
    public int getMinimum() {
        if (this.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int smallest = this.arr[0];

        for (int i = 0; i < this.size(); i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        return smallest;
    }

    /**
     * This method returns the largest element in the array.
     * @return int max, the largest element in the array.
     */
    public int getMaximum() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        int max = arr[0];

        for (int i = 0; i < size(); i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    /**
     * This method returns the average of all the numbers in the array.
     * @return int average, the average of the numbers in the array.
     */
    public double getAverage() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        double sum = 0;
        for (int i = 0; i < this.size(); i++) {
            sum += arr[i];
        }

        return sum / this.size();
    }

    /**
     * This method returns the difference between the largest and smallest elements.
     * @return int max - min, the difference between the max and minimum elements.
     */
    public int getRange() {
        return getMaximum() - getMinimum();
    }
}
