package sorting.algorithms;

import tools.Tools;

/**
 * Created by Jógvan 22/12-2015 20:15.
 */
public class RadixSort implements SortInterface {

    private int[] data;
    private int highest;

    public RadixSort(int[] data) {
        this.data = data;

        // TODO: find a better way to get highest number.
        for (int i : data) highest = highest <i ? i : highest;
    }

    private void radixSort(int indexFromRight){
        if(highest -1<indexFromRight) return; // Basecase

        // Temp arrays
        int[] tmpAr = new int[data.length];
        int[] count = new int[10];


        // count digits into a bucket
        for (int i : data) {
            int t = Tools.nthNumber(i, indexFromRight);
            count[t] = count[t] + 1;
        }

        //
        for (int i = 0; i < 9; i++) {
            count[i+1] = count[i]+count[i+1];
        }

        for (int i = data.length-1; i >= 0; i--) {
            int t = Tools.nthNumber(data[i], indexFromRight);
            int b = count[t] = count[t]-1;
            tmpAr[b] = data[i];
        }

        Tools.copyArray(tmpAr, 0, tmpAr.length, data);
        radixSort(indexFromRight + 1);
    }


    @Override
    public void sort() {
        radixSort(0);
    }

    @Override
    public String getName() {
        return "RadixSort";
    }
}
