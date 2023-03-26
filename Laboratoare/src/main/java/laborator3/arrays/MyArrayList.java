package main.java.laborator3.arrays;

public class MyArrayList {
    public float[] array;

    public MyArrayList() {
        array = new float[10];
    }

    public MyArrayList(int size) {
        array = new float[size];
    }

    public int firstAvailableIndex() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                return i;
            }
        }
        return array.length;
    }

    void resize() {
        float[] newArray = new float[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void add(float value) {
        int index = firstAvailableIndex();
        if (index == array.length) {
            this.resize();
        }

        array[index] = value;
    }

    public boolean contains (float value) {
        for (float v : array) {
            if (v == value) {
                return true;
            }
        }
        return false;
    }

    public String remove (int index) {
        if (index < 0 || index >= array.length) {
            return "Index out of bounds";
        }
        if (array [index] == 0) {
            return "Element already removed";
        }
        array[index] = 0;
        return "Element removed";
    }

    public float get (int index) {
        if (index < 0 || index >= array.length) {
            return -1;
        }

        return array[index];
    }

    public int size () {
        int count = 0;
        for (float v : array) {
            if (v != 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        result.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            result.append(", ").append(array[i]);
        }
        return result.toString();
    }
}
