package db.old;

import unittests.PojoExample;

/**
 * Created by Jógvan 28/12-2015 22:01.
 */
public class MySQLModel extends DBModel {

    public boolean save(PojoExample objectToSave){
        System.out.println(" *** Object saved to DB");
        return objectToSave != null;
    }

    public PojoExample[] loadAll(){
        System.out.println(" *** All objects loaded from DB");
        return new PojoExample[]{new PojoExample("Hello", 1), new PojoExample("Ola", 2),
                new PojoExample("Hey", 3), new PojoExample("Hej", 4)};
    }

    public PojoExample load(int objectId){
        System.out.println(" *** Object loaded from DB");
        return objectId>0 ? new PojoExample("Pojo Object", objectId) : null;
    }

}
