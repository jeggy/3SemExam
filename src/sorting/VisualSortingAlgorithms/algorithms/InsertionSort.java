package sorting.VisualSortingAlgorithms.algorithms;

import sorting.VisualSortingAlgorithms.Visualiser;

/**
 * Created by jeggy on 10/12/15.6:15 PM
 */
public class InsertionSort extends Visualiser {


    public InsertionSort(int size, int max, int wait, int[] ar) {
        super(size, max, wait, ar);
    }

    @Override
    public void run(){
        for(int i = 1; i<size; i++){
            int tmp = i;
            while(tmp>0&&getValue(tmp)<getValue(tmp-1)){
                swap(tmp, tmp - 1);
                tmp--;
            }
        }
    }


}
