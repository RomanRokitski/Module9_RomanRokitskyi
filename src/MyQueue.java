import java.util.Arrays;

public class MyQueue<T> {

    private T[] arrays;

    public MyQueue(T[] arrays) {
        this.arrays = arrays;
    }

    public boolean add(T item) {
        int i = 0;
        for (; i < arrays.length; i++) {
            if (item == null) {
                return false;
            }
            if (arrays[i] == null) {
                arrays[i] = item;
                break;
            }
        }
        if (arrays.length > 1 && arrays[i - 1] != item) {
            arrays = Arrays.copyOf(arrays, arrays.length + 1);
            arrays[i] = item;
        }
        if (arrays.length == 1 && arrays[i - 1] != item) {
            arrays = Arrays.copyOf(arrays, arrays.length + 1);
            arrays[i] = item;
        }
        if (arrays.length == 0) {
            arrays = Arrays.copyOf(arrays, 1);
            if (arrays[i] != item) {
                arrays[i] = item;
            }
        }
        return true;
    }

    public T poll() {

        System.out.println(arrays[0]);
        T result = (T) arrays[0];
        int index2 = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != arrays[0]) arrays[index2++] = arrays[i];
        }
        arrays = Arrays.copyOf(arrays, index2);
        return result;
    }

    public int size() {
        return arrays.length;
    }

    public T peek() {
        return arrays[0];
    }

    public void clear() {
        arrays = (T[]) new Object[]{};
    }

    @Override
    public String toString() {
        return Arrays.toString(arrays);
    }

    public static void main(String[] args) {
        MyQueue<String> seasons = new MyQueue<>(new String[]{"Winter", "Spring", "Summer", "Autumn"});
        System.out.println(seasons);

        seasons.add("FifthSeason");
        System.out.println(seasons);

        System.out.println(seasons.size());

        System.out.println(seasons.peek());

        seasons.poll();
        System.out.println(seasons);

        seasons.clear();
        System.out.println(seasons);
    }
}

