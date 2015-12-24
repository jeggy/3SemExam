package adt.lists;

/**
 * Created by Jógvan 23/12-2015 15:11.
 */
public class HashSet<T> {
    private LinkedList<T>[] set = new LinkedList[101];
    private int size = 0;

    public void add(T o){
        int pos = hash(o)%this.set.length;
        if(this.set[pos]==null){
            this.set[pos] = new LinkedList<>();
            this.set[pos].add(o);
        }else{
            for (int i = 0; i < this.set[pos].size(); i++)
                if(hash(o)==hash(this.set[pos].get(i)))
                    return;
            this.set[pos].add(o);
        }
        this.size++;
    }

    public T[] toArray(){
        T[] n = (T[]) new Object[this.size];
        int i = 0;
        for (LinkedList<T> t : set)
            if(t!=null)
                for (int j = 0; j < t.size(); j++)
                    n[i++] = t.get(j);
        return n;
    }

    private int hash(T o) {
        int h = o.hashCode();
        return h<0 ? -h : h;
    }
}
