package week_10_demo.generics_topic11;

import java.util.Comparator;

public class Pair <K extends Comparable, V> implements Comparable<Pair<K,V>>{
    K key;
    V value;
    public Pair() {
    }
    public Pair(K k, V v){
        key = k;
        value = v;
    }
    @Override
    public int compareTo(Pair<K, V> o) {
        return key.compareTo(o.key);
    }
    @Override
    public String toString(){
        return key.toString()+" "+ value.toString();
    }

}
