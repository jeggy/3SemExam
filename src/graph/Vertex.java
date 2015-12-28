package graph;

import adt.collections.HashMap;

/**
 * Created by Jógvan 27/12-2015 16:02.
 */
public class Vertex implements Comparable<Vertex>{

    private String name;
    private int x;
    private int y;

    private int fromStart = Integer.MAX_VALUE;
    private HashMap<Vertex, Integer> routes = new HashMap<>();

    public Vertex(String name) {
        this.name = name;
    }

    public Vertex(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Vertex o) {
        if(this.fromStart < o.fromStart)
            return -1;
        else if(this.fromStart > o.fromStart)
            return 1;
        return 0;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }
}
