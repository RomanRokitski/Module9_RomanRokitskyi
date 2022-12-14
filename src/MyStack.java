import java.util.Arrays;

public class MyStack {
    private Object[] arrays;

    public MyStack(String[] arrays) {
        this.arrays = arrays;
    }

    public boolean push(Object item) {
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

    public Object remove(int index) {
        Object result = arrays[index];
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

    public Object peek() {
        return arrays[arrays.length - 1];
    }

    public Object pop() {

        System.out.println(arrays[arrays.length - 1]);
        Object result = arrays[arrays.length - 1];
        int index2 = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != arrays[arrays.length - 1]) arrays[index2++] = arrays[i];
        }
        arrays = Arrays.copyOf(arrays, index2);
        return result;
    }

    public void clear() {
        arrays = new Object[]{};
    }

    @Override
    public String toString() {
        return Arrays.toString(arrays);
    }

    public static void main(String[] args) {
        MyStack seasons = new MyStack(new String[]{"Winter", "Spring", "Summer", "Autumn"});
        System.out.println(seasons);

        seasons.push("FifthSeason");
        System.out.println(seasons);

        seasons.remove(4);
        System.out.println(seasons);

        System.out.println("seasons = " + seasons.size());

        System.out.println("seasons.peek() = " + seasons.peek());

        seasons.pop();
        System.out.println(seasons);

        seasons.clear();
        System.out.println(seasons);
    }
}