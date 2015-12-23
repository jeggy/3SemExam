package sorting.VisualSortingAlgorithms.test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class JavaFXMultiColumnChart extends Application {

    ObservableList<XYChart.Series<String, Double>> chartList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        makeChartData();
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart barChart = new BarChart(xAxis, yAxis);
        barChart.setData(chartList);
        barChart.setTitle("A");
        primaryStage.setTitle("BarChart example");

        StackPane root = new StackPane();

        Button btn = new Button("test");
        btn.setOnAction(event -> test());

        root.getChildren().addAll(barChart, btn);
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }

    private void makeChartData() {
        chartList = FXCollections.observableArrayList();

        XYChart.Series<String, Double> aSeries = new XYChart.Series<String, Double>();
        aSeries.setName("a");

        for (int i = 0; i < 15; i++) {
            aSeries.getData().add(new XYChart.Data(Integer.toString(i), i));

        }
        chartList.addAll(aSeries);
    }

    private void test(){
        chartList.get(0).getData().get(0).setYValue(2.0);
    }


}
