import java.util.Arrays;

public class MyArrayList<T> {
    private T[] arrays;

    public MyArrayList(T[] arrays) {
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

    public T remove(int index) {
        T result = (T) arrays[index];
        int index2 = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != arrays[index]) arrays[index2++] = arrays[i];
        }
        arrays = Arrays.copyOf(arrays, index2);
        return result;
    }

    public int size() {
        return arrays.length;
    }

    public T get(int index) {
        if (arrays.length <= index) {
            return null;
        }
        return arrays[index];
    }

    public void clear() {
        arrays = (T[]) new Object[]{};
    }

    @Override
    public String toString() {
        return Arrays.toString(arrays);
    }

    public static void main(String[] args) {
        MyArrayList<String> seasons = new MyArrayList<>(new String[]{"Winter", "Spring", "Summer", "Autumn"});
        System.out.println(seasons);

        seasons.add("FifthSeason");
        System.out.println(seasons);

        seasons.remove(4);
        System.out.println(seasons);

        System.out.println("seasons = " + seasons.size());

        System.out.println("seasons.get(2) = " + seasons.get(2));

        seasons.clear();
        System.out.println(seasons);
    }
}