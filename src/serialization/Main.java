package serialization;

import unittests.PojoExample;

import java.util.ArrayList;

/**
 * Created by Jógvan 30/12-2015 16:16.
 */
public class Main {

    public static void main(String[] args) {
        Read<PojoExample> read = new Read<>("Test.dat");

        read.add(new PojoExample("Test", read.getObjects().size()));

        for (PojoExample pojo : read.getObjects()) {
            System.out.println(pojo.getName()+" "+pojo.getNum());
        }
    }

}
