import java.util.Arrays;
import java.util.Objects;

public class MyHashMap <K, V>{

    public static class Node<K, V> {
        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    private int size;
    private int DEFAULT_CAPACITY = 1;
    private Node<K, V>[] values = new Node[DEFAULT_CAPACITY];

    public MyHashMap() {
        this.values = values;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (values[i] != null) {
                if (values[i].getKey().equals(key)) {
                    return values[i].getValue();
                }
            }
        }
        return null;
    }

    public void put(K key, V value) {
        boolean insert = true;
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                values[i].setValue(value);
                insert = false;
            }
        }
        if (insert) {
            ensureCap();
            values[size++] = new Node<K, V>(key, value);
        }
    }

    private void ensureCap() {
        if (size == values.length) {
            int newSize = values.length * 2;
            values = Arrays.copyOf(values, newSize);
        }
    }

    public int size() {
        return size;
    }

    public void remove(K key) {
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                values[i] = null;
                size--;
                condenseArray(i);
            }
        }
    }

    private void condenseArray(int start) {
        for (int i = start; i < size; i++) {
            values[i] = values[i + 1];
        }
    }
    public void clear() {
        Node<K,V>[] tab = new Node[0];
        size++;
        if (tab != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyHashMap<?, ?> myHashMap = (MyHashMap<?, ?>) o;
        return size == myHashMap.size && DEFAULT_CAPACITY == myHashMap.DEFAULT_CAPACITY && Arrays.equals(values, myHashMap.values);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, DEFAULT_CAPACITY);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> seasons = new MyHashMap<>();
        seasons.put(1, "Winter");
        seasons.put(2, "Spring");
        seasons.put(3, "Summer");
        seasons.put(4, "Autumn");
        System.out.println(seasons);

        System.out.println("seasons.size = " + seasons.size);

        System.out.println("seasons.get(3) = " + seasons.get(3));
    }
}