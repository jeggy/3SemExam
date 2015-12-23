package sorting.VisualSortingAlgorithms.algorithms;

import sorting.VisualSortingAlgorithms.Visualiser;

/**
 * Created by jeggy on 10/12/15.10:13 PM
 */
public class BubbleSort extends Visualiser {

    public BubbleSort(int size, int max, int wait, int[] ar) {
        super(size, max, wait, ar);
    }

    @Override
    public void run() {
        for (int i = 0; i < size-1; i++) {
            for(int j = 0; j< size-i-1; j++){
                if(getValue(j)>getValue(j+1)){
                    swap(j, j + 1);
                }
            }
        }
    }
}
