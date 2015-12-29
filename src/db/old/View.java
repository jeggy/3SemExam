package db.old;

import unittests.PojoExample;

/**
 * Created by Jógvan 28/12-2015 22:06.
 */
public class View {

    public static void main(String[] args) {
        new View(new MySQLModel());
    }

    MySQLModel db;

    public View(MySQLModel db) {
        this.db = db;
    }

    public void runStuff(){
        drawAll();

        PojoExample e = loadPojo(1);
        e.setName("New Name!");
        save(e);
    }

    public void drawAll(){
        for (PojoExample pojo : loadPojos()) {
            System.out.println(pojo.getName()+" - "+pojo.getNum());
        }
    }

    public PojoExample[] loadPojos(){
        return db.loadAll();
    }

    public PojoExample loadPojo(int id){
        PojoExample l = db.load(id);
        if(l==null) {
            // TODO: use other Exception instead of IndexOutOfBoundsException
            throw new IndexOutOfBoundsException("Not loaded successfully");
        }
        return db.load(id);
    }

    public boolean save(PojoExample pojo){
        return db.save(pojo);
    }
}
