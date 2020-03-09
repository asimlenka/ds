package com.devglan.hashmap;

public class CustomHashMap<K, V> {

    private int capacity = 16; //Initial default capacity

    private Entry<K, V>[] table; //Array of Entry object

    public CustomHashMap(){
        table = new Entry[capacity];
    }

    public CustomHashMap(int capacity){
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    //For HashMap, it allows one null key and there is a null check for keys, if the key is null then that element will be stored in a zero location in Entry array. We cannot have more than one Null key in HashMap because Keys are unique therefor only one Null key and many Null values are allowed
    public boolean put(K key, V value){
        boolean inserted = false;
        if(key == null){
            if(table[0] != null){
                return false;
            }else {
                Entry entry = new Entry<K, V>(null, value, null);
                table[0] = entry;
                return true;
            }
        }else {
            int index = hash(key);
            Entry newEntry = new Entry(key, value, null);
            if(table[index] == null){
                table[index] = newEntry;
            }else {
                Entry<K,V> previous = null;
                Entry<K, V> currentNode = table[index];
                while(currentNode != null){
                    if(currentNode.getKey().equals(key)){
                        if(previous == null){
                            newEntry.setNext(currentNode.getNext());
                            table[index] = newEntry;
                            return true;
                        }else {

                        }
                    }
                }
            }
        }
    }

    public V get(K key){
        return null;
    }

    public boolean remove(K key){
        return false;
    }

    public void display(){

    }

    private int hash(K key){
        return Math.abs(key.hashCode() % capacity);
    }
}
