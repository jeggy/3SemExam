package unittests;

import java.io.Serializable;

/**
 * Created by Jógvan 28/12-2015 20:16.
 */
public class PojoExample implements Serializable{

    private String name;
    private int num;

    public PojoExample(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
