package org.ska.datastructures;

import java.util.Map;


public class HashMapEntry<K, V> implements Map.Entry<K,V> {
    private K key;
    private V value;
    private HashMapEntry<K,V> next;
    private int hash;
    private int limit;
    
    public HashMapEntry (int hash, K key, V value, HashMapEntry<K,V> e) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = e;
        this.limit = 9;
    }
    
    @Override
    public K getKey() {
        return key;
    }
    @Override
    public V getValue() {
        return value;
    }
    @Override
    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hash;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((next == null) ? 0 : next.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        HashMapEntry other = (HashMapEntry) obj;
        if (hash != other.hash) {
            return false;
        }
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        if (next == null) {
            if (other.next != null) {
                return false;
            }
        } else if (!next.equals(other.next)) {
            return false;
        }
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }
    public HashMapEntry<K, V> getNext() {
        return next;
    }
    public void setNext(HashMapEntry<K, V> next) {
        this.next = next;
    }
    public int getHash() {
        return hash;
    }
    public void setHash(int hash) {
        this.hash = hash;
    }
    public void setKey(K key) {
        this.key = key;
    }
}
