package sorting.VisualSortingAlgorithms.algorithms;

import javafx.scene.chart.XYChart;
import sorting.VisualSortingAlgorithms.Visualiser;

/**
 * Created by jeggy on 10/12/15.10:41 PM
 */
public class MergeSort extends Visualiser {

    public MergeSort(int size, int max, int wait, int[] ar) {
        super(size, max, wait, ar);
        addAxis();
    }

    private void addAxis() {
        XYChart.Series<String, Integer> aSeries = new XYChart.Series();
        aSeries.setName("MergeSort tmp Series");
        for (int i = 0; i < this.size; i++) {
            aSeries.getData().add(new XYChart.Data(Integer.toString(i+1), 0));
        }
        chartList.add(1, aSeries);
    }

    @Override
    public void run() {
        mergeSort(0, size);
        sleep(wait);
        for (int i = 0; i < size; i++) {
            setValue(1, i, 0);
        }
    }

    private void mergeSort(int start, int end) {
        if(end-start < 2){ // Basecase
            return;
        }
        int half = (start+end) >>> 1;

        mergeSort(start, half);
        mergeSort(half, end);
        merge(start, half, end);
        copyArray(start, end);
    }

    private void merge(int start, int half, int end) {
        int tmpStart = start, tmpHalf = half;

        for (int i = start; i < end; i++) {
            sleep(wait/2);
            if(tmpStart<half && (tmpHalf>=end || getValue(tmpStart) <= getValue(tmpHalf))){
                setValue(1, i, getValue(tmpStart));
                tmpStart++;
            }else{
                setValue(1, i, getValue(tmpHalf));
                tmpHalf++;
            }
        }
    }

    private void copyArray(int start, int end){
        for (int i = start; i < end; i++){
            setValue(0, i, getValue(1,i));
        }
    }

}
