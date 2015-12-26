package adt.lists;

/**
 * Created by Jógvan 24/12-2015 13:20.
 */
public class HashMap<K, V> {

    private LinkedList<Entry<K,V>>[] map = new LinkedList[101];
    private int size = 0;

    /**
     *
     * @param key
     * @param value
     */
    public void put(K key, V value){
        int hash = hash(key);
        int pos = hash%this.map.length;
        Entry<K, V> newEntry = new Entry<>(key, value, hash);

        if(this.map[pos]==null){
            LinkedList<Entry<K,V>> lle = new LinkedList<>();
            lle.add(newEntry);
            this.map[pos] = lle;
        }else{
            for (int i = 0; i < this.map[pos].size(); i++) {
                if(this.map[pos]==null || this.map[pos].get(i).hash == hash){
                    this.map[pos].set(newEntry, i);
                }
            }
            this.map[pos].add(newEntry);
        }
        this.size++;
    }

    /**
     *
     * @param key
     * @return
     */
    public V get(K key){
        int hash = hash(key);
        int pos = hash%this.map.length;
        LinkedList<Entry<K, V>> list = this.map[pos];
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).hash==hash){
                return list.get(i).value;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     *
     * @param obj
     * @return
     */
    private int hash(Object obj){
        int h = obj.hashCode();
        return h>0 ? h : -h;
    }

    private static class Entry<K, V>{
        K key;
        V value;
        int hash;
        Entry(K key, V value, int hash){
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }
}
