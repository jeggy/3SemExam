package adt.collections;

/**
 * Created by Jógvan on 27/11-2015 09:43.
 */
public class DoubleHash<K1, K2, V> {

    Entry<K1, K2, V>[] map = new Entry[101];

    public void put(K1 k1, K2 k2, V value){
        int hash = hash(k1, k2);
        Entry<K1, K2, V> entry = new Entry(k1, k2, value, hash);
        int pos = hash % map.length;

        if(map[pos]==null){
            map[pos] = entry;
            return;
        }else{
            Entry tmp = map[pos];
            while(tmp!=null){
                if(tmp.keyHash==entry.keyHash){
                    tmp.obj = entry.obj;
                    return;
                }
                tmp = tmp.next;
            }

            entry.next = map[pos];
            map[pos] = entry;
        }
    }

    public V get(K1 key1, K2 key2){
        int keyHash = hash(key1, key2);
        Entry<K1, K2, V> tmp = map[keyHash% map.length];

        while(tmp!=null){
            if(tmp.keyHash==keyHash)
                return tmp.obj;
            tmp = tmp.next;
        }
        return null;
    }

    private static int hash(Object v1, Object v2){
        int h = v1.hashCode() + v2.hashCode();
        return (h>0) ? h : -h;
    }







    /******************** Entry *******************/

    private static class Entry<K1, K2, V>{
        K1 k1;
        K2 k2;
        V obj;
        int keyHash;
        Entry<K1, K2, V> next;

        Entry(K1 k1, K2 k2, V obj, int hash) {
            this.obj = obj;
            this.k1 = k1;
            this.k2 = k2;
            this.keyHash = hash;
        }
    }
}