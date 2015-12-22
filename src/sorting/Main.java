package sorting;

import sorting.algorithms.BubbleSort;
import sorting.algorithms.RadixSort;
import sorting.algorithms.SortInterface;

import java.util.Arrays;

/**
 * Created by Jógvan 22/12-2015 19:58.
 */
public class Main {

    public static final int SIZE = 150;
    public static final int MAX_NUMBER = 1250;

    public static final boolean PRINT_NUMBERS = true;

    public static void main(String[] args) {
        int[] b1 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            b1[i] = (int) (Math.random()*MAX_NUMBER);
        }


        SortInterface sort = new RadixSort(b1);

        if(PRINT_NUMBERS)System.out.println(sort.getName()+": " + Arrays.toString(b1));
        long start = System.nanoTime();
        sort.sort();
        long end = System.nanoTime();
        if(PRINT_NUMBERS)System.out.println(sort.getName()+": "+Arrays.toString(b1));
        System.out.println(sort.getName()+" Time(nano): "+(end-start));




    }

}
