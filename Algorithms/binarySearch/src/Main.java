import java.lang.Math;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
    private static boolean iterativeBinarySearch(int[] data, int key) {
        int left = 0;
        int right = data.length;

        while (right > left + 1) {
            int mid = (int) Math.ceil((double) (left+right)/2);
            if (data[mid] > key) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return data[left] == key;
    }

    private static int[] initRandom(int size, int range) {
        //returns an array of random integers with no duplicates
        HashSet<Integer> set = new HashSet<Integer>();
        Random random = new Random();
        assert(range > 0); //the range passed to the .nextInt() method must be positive
        while (set.size() < size) { //keep adding, or trying to add in the case where the int to be added was duplicate, ints to the set until it reaches required size
            set.add(random.nextInt(range)); //if the set already contains the random int, the call to .add() will leave the set unchanged
        }

        //now convert set of ints to array of ints
        int[] randArr = new int[size]; //int array
        int i = 0; //iterator
        for (Integer integer : set) { //copy elements from set to int array
            randArr[i] = integer;
            i++; //increment iterator
        }
        return randArr;
    }

    public static void main(String[] args) {
        final int SIZE = 20;
        final int RANGE = 100;
        
        int[] testArr = initRandom(SIZE, RANGE);
        Random random = new Random();
        int testKey = random.nextInt(RANGE);
        
        boolean found = iterativeBinarySearch(testArr, testKey);
        System.out.println("Searching the test array: " + Arrays.toString(testArr));
        System.out.println("For the test key: " + testKey);
        if (found) {
            System.out.println("Found.");
        } else {
            System.out.println("Not Found.");
        }
    }
}
