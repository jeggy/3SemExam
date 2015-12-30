package adt.collections.interfaces;

/**
 * Created by Jógvan 30/12-2015 18:04.
 */
public interface Map<K, V> {

    void put(K key, V value);
    V get(K key);

}
