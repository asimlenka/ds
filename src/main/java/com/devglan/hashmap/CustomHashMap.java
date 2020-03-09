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
    public void put(K key, V value){
        int index = index(key);
        Entry newEntry = new Entry(key, value, null);
        if(table[index] == null){
            table[index] = newEntry;
        }else {
            Entry<K, V> currentNode = table[index];
            while(currentNode.getNext() != null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setValue(value);
                    break;
                }
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newEntry);
            }
    }

    public V get(K key){
        V value = null;
        int index = index(key);
        Entry<K, V> entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = entry.getNext();
        }
        return value;
    }

    public void remove(K key){
        int index = index(key);
        Entry previous = null;
        Entry entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)){
                if(previous == null){
                    entry = entry.getNext();
                    table[index] = entry;
                    return;
                }else {
                    previous.setNext(entry.getNext());
                    return;
                }
            }
            previous = entry;
            entry = entry.getNext();
        }

    }

    public void display(){
        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                Entry<K, V> currentNode = table[i];
                while (currentNode != null){
                    System.out.println(String.format("Key is %s and value is %s", currentNode.getKey(), currentNode.getValue()));
                    currentNode = currentNode.getNext();
                }
            }
        }
    }

    private int index(K key){
        if(key == null){
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }
}
