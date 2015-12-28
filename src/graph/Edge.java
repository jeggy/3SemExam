package graph;

/**
 * Created by Jógvan 27/12-2015 16:09.
 */
public class Edge {

    public Vertex from, to;
    public int weight;

    public Edge(Vertex from, Vertex to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

}
