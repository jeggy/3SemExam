package sorting.algorithms;

/**
 * Created by Jógvan 22/12-2015 20:03.
 */
public class BubbleSort implements SortInterface {

    private int[] data;

    public BubbleSort(int[] data) {
        this.data = data;
    }

    public void sort(){
        for (int i = 0; i < data.length-1; i++) {
            for(int j = 0; j< data.length-i-1; j++){
                if(data[j]>data[j+1]) swap(data, j, j+1);
            }
        }
    }

    @Override
    public String getName() {
        return "BubbleSort";
    }

    private void swap(int[] ar, int index, int index2){
        int tmp = ar[index2];
        ar[index2] = ar[index];
        ar[index] = tmp;
    }

}
