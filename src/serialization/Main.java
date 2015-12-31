package serialization;

import unittests.PojoExample;

/**
 * Created by Jógvan 30/12-2015 16:16.
 */
public class Main {

    public static void main(String[] args) {
        ReadData<PojoExample> read = new ReadData<>("Test.dat");

        read.add(new PojoExample("Test", read.getObjects().size()));

        for (PojoExample pojo : read.getObjects()) {
            System.out.println(pojo.getName()+" "+pojo.getNum());
        }
    }

}
