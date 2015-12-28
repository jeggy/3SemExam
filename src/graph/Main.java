package graph;


import adt.collections.HashMap;

import java.io.*;

/**
 * Created by Jógvan 27/12-2015 16:00.
 */
public class Main{

    public static void main(String[] args) {
        GraphCollection gc = new GraphCollection();

        loadGraphData(gc, new File("res/graph_data.txt"));

        gc.print();

    }

    private static void loadGraphData(GraphCollection gg, File file) {
        HashMap<String, Vertex> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for(String line; (line = br.readLine()) != null; ) {
                String[] data = line.split(",");
                map.put(data[0], new Vertex(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                gg.addLocation(map.get(data[0]));
            }

            // Read file again.
            br = new BufferedReader(new FileReader(file));
            for(String line; (line = br.readLine()) != null; ) {
                String[] data = line.split(",");
                for (String e : data[3].split("-")) {
                    Vertex v1 = map.get(data[0]);
                    Vertex v2 = map.get(e);

                    int weight = (int) Math.sqrt(Math.pow(v2.getY()-v1.getY(),2)+Math.pow(v2.getY()-v1.getY(),2));

                    gg.addEdge(v1, v2, weight);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
