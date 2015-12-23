package sorting.VisualSortingAlgorithms;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 * Created by jeggy on 10/12/15.9:10 PM
 */
public abstract class Visualiser extends Thread {

    protected ObservableList<XYChart.Series<String, Integer>> chartList;

    protected final int size;
    protected final int max;
    protected final int wait;
    protected final int[] numbers;

    private IntegerProperty accessCount = new SimpleIntegerProperty(0);
    private IntegerProperty setCount = new SimpleIntegerProperty(0);

    public static final String DEFAULT_COLOR = "#33cc00";
    public static final String SET_COLOR = "#71f9a4";
    public static final String CHECK_COLOR = "#119944";

    public Visualiser(int size, int max, int wait, int[] numbers) {
        this.size = size;
        this.max = max;
        this.wait = wait;
        this.numbers = numbers;
        makeChartData();
    }

    public ObservableList<XYChart.Series<String, Integer>> getChart(){
        return chartList;
    }

    public int[] getAll(){
        int[] all = new int[size];
        for (int i = 0; i < size; i++) {
            all[i] = getValue(i);
        }
        return all;
    }

    public void starts(){
        this.start();
    }

    private void makeChartData(){
        chartList = FXCollections.observableArrayList();
        XYChart.Series<String, Integer> aSeries = new XYChart.Series();
        aSeries.setName("Default Series");

        for (int i = 0; i < this.size; i++) {
            aSeries.getData().add(new XYChart.Data(Integer.toString(i+1), this.numbers[i]));
        }
        chartList.add(0, aSeries);
    }

    public void setAllColors(String hex){
        for (int i = 0; i < size; i++) {
            color(i, hex);
        }
    }

    protected void setValue(int index, int value){
        setValue(0, index, value);
    }

    protected int getValue(int index){
        this.accessCount.setValue(this.accessCount.get()+1);
        color(index, CHECK_COLOR);
        sleep(wait);
        color(index, DEFAULT_COLOR);
        return getValue(0, index);
    }

    protected void setValue(int categoryIndex, int index, int value){
        this.setCount.setValue(this.setCount.get() + 1);
        chartList.get(categoryIndex).getData().get(index).setYValue(value);
        color(index, SET_COLOR);
        sleep(wait);
        color(index, DEFAULT_COLOR);
    }

    protected int getValue(int categoryIndex, int index) {
        return chartList.get(categoryIndex).getData().get(index).getYValue();
    }

    protected void swap(int index, int index2){
        int tmp = getValue(index2);
        setValue(index2, getValue(index));
        setValue(index, tmp);
    }

    protected void color(int index, String hex){
        chartList.get(0).getData().get(index).getNode().setStyle("-fx-background-color: "+hex);
    }

    protected void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public IntegerProperty getAccessCount(){
        return this.accessCount;
    }

    public IntegerProperty getSetCount(){
        return this.setCount;
    }

    public abstract void run();
}
