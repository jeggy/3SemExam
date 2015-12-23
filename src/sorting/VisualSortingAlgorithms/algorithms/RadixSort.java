package sorting.VisualSortingAlgorithms.algorithms;

import javafx.scene.chart.XYChart;
import sorting.VisualSortingAlgorithms.Visualiser;

/**
 * Created by jeggy on 10/13/15.11:06 AM
 */
public class RadixSort extends Visualiser {

    public RadixSort(int size, int max, int wait, int[] ar) {
        super(size, max, wait, ar);
        addAxis();
    }

    private void addAxis() {
        XYChart.Series<String, Integer> aSeries = new XYChart.Series();
        aSeries.setName("RadixSort tmp Series");
        for (int i = 0; i < this.size; i++) {
            aSeries.getData().add(new XYChart.Data(Integer.toString(i+1), 0));
        }
        chartList.add(1, aSeries);
    }

    @Override
    public void run() {
        radixSort(0);
        for (int i = 0; i < size; i++) {
            setValue(1, i, 0);
        }
    }

    private void radixSort(int indexFromRight){
        if(Math.pow(10,indexFromRight)>this.max) return; // Basecase

        int[] count = new int[10];

        for (int i = 0; i < this.size; i++) {
            int t = nthNumber(getValue(i), indexFromRight);
            count[t] = count[t]+1;
        }

        for (int i = 0; i < 9; i++) {
            count[i+1] = count[i]+count[i+1];
        }

        for (int i = this.size-1; i >= 0; i--) {
            int t = nthNumber(getValue(i), indexFromRight);
            int b = count[t] = count[t]-1;
            setValue(1, b, getValue(0, i));
        }
        copyArray(0, this.size);
        radixSort(indexFromRight + 1);
    }

    private void copyArray(int start, int end){
        for (int i = start; i < end; i++){
            setValue(0, i, getValue(1, i));
        }
    }

    private int nthNumber(int num, int index){
        return ((int)(num / Math.pow(10, index)) % 10);
    }
}
