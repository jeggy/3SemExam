package sorting.VisualSortingAlgorithms;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import sorting.VisualSortingAlgorithms.algorithms.BubbleSort;
import sorting.VisualSortingAlgorithms.algorithms.InsertionSort;
import sorting.VisualSortingAlgorithms.algorithms.MergeSort;
import sorting.VisualSortingAlgorithms.algorithms.RadixSort;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jeggy on 10/12/15.5:56 PM
 */
public class Controller  implements Initializable {

    @FXML private BarChart<String,Integer> chart;
    @FXML private RadioButton insertionRadio, bubbleRadio, mergeRadio, radixRadio;
    @FXML private TextField itemsField, maxField, waitField;
    @FXML private Button startButton;
    @FXML private ToggleGroup sortingAlgorithm;
    @FXML private Label listAccessedLabel, listSetLabel;

    private Visualiser sorter;

    private int[] numbers;

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void startBtnPressed(ActionEvent actionEvent) {
        setSort(size, max, wait);
        sorter.starts();
    }

    public void pauseBtnPressed(ActionEvent actionEvent) {
        System.out.println("Pause!");
    }

    public void stopBtnPressed(ActionEvent actionEvent) {
        System.out.println("Stop!");
    }

    private int size, max, wait;
    public void generateBtnPressed(ActionEvent actionEvent) {
        try{
            size = Integer.parseInt(this.itemsField.getText());
            max = Integer.parseInt(this.maxField.getText());
            wait = Integer.parseInt(this.waitField.getText());
            this.numbers = new int[size];

            for (int i = 0; i < size; i++) {
                this.numbers[i] = (int)(Math.random()*max);
            }
            setSort(size, max, wait);

        }catch (NumberFormatException e){
            System.out.println("Only whole numbers!");
        }

    }

    private StringProperty ab = new SimpleStringProperty("test");
    private void setSort(int length, int max, int time){


//        this.listAccessedLabel.textProperty().bind(Bindings.convert(this.sorter.getAccessCount()));
//        this.listSetLabel.textProperty().bind(Bindings.convert(this.sorter.getSetCount()));

        RadioButton selected = (RadioButton) sortingAlgorithm.getSelectedToggle();
        switch (selected.getId()){
            case "insertionRadio":
                sorter = new InsertionSort(length, max, time, numbers);
                chart.setTitle("InsertionSort");
                break;
            case "bubbleRadio":
                sorter = new BubbleSort(length, max, time, numbers);
                chart.setTitle("BubbleSort");
                break;
            case "mergeRadio":
                sorter = new MergeSort(length, max, time, numbers);
                chart.setTitle("MergeSort");
                break;
            case "radixRadio":
                sorter = new RadixSort(length, max, time, numbers);
                chart.setTitle("RadixSort");
                break;
            default:
                System.out.println("Error loading which sorter algorithm to use.");
        }

        chart.setAnimated(false); // TODO: this has to be false :/
        chart.setData(sorter.getChart());
        sorter.setAllColors(Visualiser.DEFAULT_COLOR);

        this.listAccessedLabel.textProperty().unbind();
        this.listSetLabel.textProperty().unbind();


        // http://stackoverflow.com/questions/30863205/multi-threading-error-when-binding-a-stringproperty
        this.sorter.getSetCount().addListener((obs, oldValue, newValue) ->
                Platform.runLater(() -> this.listSetLabel.setText(this.sorter.getSetCount().get()+"")));
        this.sorter.getAccessCount().addListener((obs, oldValue, newValue) ->
                Platform.runLater(() -> this.listAccessedLabel.setText(this.sorter.getAccessCount().get()+"")));
    }
}
