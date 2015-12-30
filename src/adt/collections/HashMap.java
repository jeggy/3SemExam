package adt.collections;

import adt.collections.interfaces.Collection;
import adt.collections.interfaces.Map;

import java.util.Iterator;

/**
 * Created by Jógvan 24/12-2015 13:20.
 */
public class HashMap<K, V> implements Collection<V>, Map<K,V>, Iterable<HashMap.Entry<K, V>>{

    private LinkedList<Entry<K,V>>[] map = new LinkedList[101];
    private int size = 0;

    /**
     *
     * @param key
     * @param value
     */
    @Override
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
    @Override
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
     * @return map size
     */
    public int size() {
        return this.size;
    }

    /**
     * Finds if an element exists in the map.
     * Can be slow.
     * @param o Object to be checked if is in map
     * @return true or false based on if it Object 'o' exists
     */
    @Override
    public boolean contains(V o) {
        for (LinkedList<Entry<K, V>> ll : map) {
            for (int i = 0; i < ll.size(); i++) {
                if(ll.get(i).value.equals(o)) return true;
            }
        }
        return false;
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

    public V[] toArray(){
        V[] ar = (V[]) new Object[this.size];
        int i = 0;
        for (LinkedList<Entry<K, V>> m : map) {
            if (m != null) {
                for (int k = 0; k < m.size(); k++) {
                    ar[i++] = m.get(k).value;
                }
            }
        }
        return ar;
    }

    @Override
    public Iterator<HashMap.Entry<K, V>> iterator() {
        Entry<K, V>[] entries = new Entry[this.size];
        int i = 0;
        for (LinkedList<Entry<K, V>> list : map) {
            if(list!=null){
                for (int j = 0; j < list.size(); j++) {
                    entries[i++] = list.get(j);
                }
            }
        }
        return new EntryIterator(entries);
    }

    /* --------------------- Entry ------------------------ */
    public static class Entry<K, V>{
        public K key;
        public V value;

        private int hash;
        Entry(K key, V value, int hash){
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    /* --------------------- Entry Iterator ------------------------ */
    private class EntryIterator<K, V> implements java.util.Iterator<Entry> {

        private Entry<K, V>[] entries;
        private int currentPosition = 0;

        public EntryIterator(Entry<K, V>[] entries) {
            this.entries = entries;
        }


        @Override
        public boolean hasNext() {
            return entries.length>this.currentPosition;
        }

        @Override
        public Entry next() {
            return this.entries[currentPosition++];
        }
    }


}
