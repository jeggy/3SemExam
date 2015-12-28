package graph;

import adt.collections.HashMap;

/**
 * Created by Jógvan 27/12-2015 16:02.
 */
public class GraphCollection {

    private HashMap<Vertex, HashMap<Vertex, Integer>> vertices = new HashMap<>();

    public void print(){
        for (HashMap.Entry<Vertex, HashMap<Vertex, Integer>> v : vertices) {
            System.out.print(v.key.getName()+": ");
            for (HashMap.Entry<Vertex,Integer> edge : v.value) {
                System.out.print(edge.key.getName()+"("+edge.value+"),  ");
            }
            System.out.println();
        }
    }

    public void addLocation(Vertex v) {
        vertices.put(v, new HashMap<>());
    }

    public void addUndirectedEdge(Vertex v1, Vertex v2, int weight){
        addEdge(v1, v2, weight);
        addEdge(v2, v1, weight);
    }

    public void addEdge(Vertex v1, Vertex v2, int weight){
        vertices.get(v1).put(v2, weight);
    }
}
