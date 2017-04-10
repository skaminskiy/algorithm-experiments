package org.ska.datastructures;

import java.util.Arrays;

public class MyHashMap<K,V> {
    
    private static final HashMapEntry<?,?>[] EMPTY_TABLE = {};
    public HashMapEntry<K, V>[] table = (HashMapEntry<K,V>[])EMPTY_TABLE;
    private int size = 0;
    final float loadFactor = 0.75f;
    int threshold;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    
    public V get(Object key) {
        if (key == null)
             return getForNullKey();
        HashMapEntry<K,V> entry = getEntry(key);
 
        return null == entry ? null : entry.getValue();
    }
    
    private V getForNullKey() {
         if (size == 0) {
             return null;
         }
         for (HashMapEntry<K,V> e = table[0]; e != null; e = e.getNext()) {
             if (e.getKey() == null)
                 return e.getValue();
         }
         return null;
    }
    
    final HashMapEntry<K,V> getEntry(Object key) {
         if (size == 0) {
             return null;
         }
 
         int hash = (key == null) ? 0 : key.hashCode();
         for (HashMapEntry<K,V> e = table[indexFor(hash, table.length)];
              e != null;
              e = e.getNext()) {
             Object k;
             if (e.getHash() == hash &&
                 ((k = e.getKey()) == key || (key != null && key.equals(k))))
                 return e;
         }
         return null;
    }
    
    public V put(K key, V value) {
        if (table == EMPTY_TABLE) {
             inflateTable(threshold);
         }
         if (key == null)
             return putForNullKey(value);
         int hash = key.hashCode();
         int i = indexFor(hash, table.length);
         for (HashMapEntry<K,V> e = table[i]; e != null; e = e.getNext()) {
             Object k;
             if (e.getHash() == hash && ((k = e.getKey()) == key || key.equals(k))) {
                 V oldValue = e.getValue();
                 e.setValue(value);
                 //e.recordAccess(this);
                 return oldValue;
             }
         }
 
         addEntry(hash, key, value, i);
         return null;
    }
    
    private V putForNullKey(V value) {
         for (HashMapEntry<K,V> e = table[0]; e != null; e = e.getNext()) {
             if (e.getKey() == null) {
                 V oldValue = e.getValue();
                 e.setValue(value);
                 return oldValue;
             }
         }
         addEntry(0, null, value, 0);
         return null;
    }
    
    private void inflateTable(int toSize) {
         // Find a power of 2 >= toSize
         int capacity = roundUpToPowerOf2(toSize);
 
         threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
         table = new HashMapEntry[capacity];
    }
    

     private static int roundUpToPowerOf2(int number) {
         // assert number >= 0 : "number must be non-negative";
         int rounded = number >= MAXIMUM_CAPACITY
                 ? MAXIMUM_CAPACITY
                 : (rounded = Integer.highestOneBit(number)) != 0
                     ? (Integer.bitCount(number) > 1) ? rounded << 1 : rounded
                     : 1;
 
         return rounded;
     }
    
    void addEntry(int hash, K key, V value, int bucketIndex) {
         if ((size >= threshold) && (null != table[bucketIndex])) {
             resize(2 * table.length);
             hash = (null != key) ? key.hashCode() : 0;
             bucketIndex = indexFor(hash, table.length);
         }
 
         createEntry(hash, key, value, bucketIndex);
    }
    
    void createEntry(int hash, K key, V value, int bucketIndex) {
        HashMapEntry<K,V> e = table[bucketIndex];
         table[bucketIndex] = new HashMapEntry<>(hash, key, value, e);
         size++;
    }
    
    public V remove(Object key) {
        HashMapEntry<K,V> e = removeEntryForKey(key);
        return (e == null ? null : e.getValue());
    }
    
    static int indexFor(int h, int length) {
        return h & (length-1);
    }
    
    void resize(int newCapacity) {
        HashMapEntry[] oldTable = table;
         int oldCapacity = oldTable.length;
         if (oldCapacity == MAXIMUM_CAPACITY) {
             threshold = Integer.MAX_VALUE;
             return;
         }
 
         HashMapEntry[] newTable = new HashMapEntry[newCapacity];
         transfer(newTable, true);
         table = newTable;
         threshold = (int)Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
    }
    
    void transfer(HashMapEntry[] newTable, boolean rehash) {
         int newCapacity = newTable.length;
         for (HashMapEntry<K,V> e : table) {
             while(null != e) {
                 HashMapEntry<K,V> next = e.getNext();
                 if (rehash) {
                     e.setHash(null == e.getKey() ? 0 : e.getKey().hashCode());
                 }
                 int i = indexFor(e.getHash(), newCapacity);
                 e.setNext(newTable[i]);
                 newTable[i] = e;
                 e = next;
             }
         }
    }
    
    final HashMapEntry<K,V> removeEntryForKey(Object key) {
         if (size == 0) {
             return null;
         }
         int hash = (key == null) ? 0 : key.hashCode();
         int i = indexFor(hash, table.length);
         HashMapEntry<K,V> prev = table[i];
         HashMapEntry<K,V> e = prev;
 
         while (e != null) {
             HashMapEntry<K,V> next = e.getNext();
             Object k;
             if (e.getHash() == hash &&
                 ((k = e.getKey()) == key || (key != null && key.equals(k)))) {
                 size--;
                 if (prev == e)
                     table[i] = next;
                 else
                     prev.setNext(next);
                 return e;
             }
             prev = e;
             e = next;
         }
 
         return e;
    }
}
