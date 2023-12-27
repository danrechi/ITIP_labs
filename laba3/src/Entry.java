public class Entry<K, V> {
    K key;
    V value;
    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){return this.key;}
    public V getValue(){return this.value;}
    public void set(V value){this.value=value;}
}
