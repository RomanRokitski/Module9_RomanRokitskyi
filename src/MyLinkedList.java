public class MyLinkedList<E> {
    private Node<E> head;

    int size;

    public MyLinkedList() {
        this.head = null;
    }

    public class Node<E> {
        protected E value;
        protected Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }

    public void add(E value) {
        if (head == null) head = new Node<E>(value);
        else {
            Node<E> temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = new Node<E>(value);
        }
        size++;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public E get(int index) {
        int i = -1;
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index > size()) {
            return null;
        }
        Node<E> p = head;
        while (p != null) {
            i++;
            if (i == index) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E remove(int index) {
        size--;
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index > size()) {
            return null;
        }
        Node<E> p = head, p1 = null;
        int i = -1;
        while (p != null) {
            i++;
            if (i == index) {
                if (p1 == null) {
                    head = head.next;
                } else {
                    p1.next = p.next;
                }
                return p.value;
            }
            p1 = p;
            p = p.next;
        }
        return null;
    }

    @Override
    public String toString() {
        if (head == null) {
            return null;
        }
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.value.toString() + " ");
            temp = temp.next;
        }
        return "";
    }

    public static void main(String[] args) {
        MyLinkedList<String> seasons = new MyLinkedList<>();
        seasons.add("Winter");
        seasons.add("Spring");
        seasons.add("Summer");
        seasons.add("Autumn");
        System.out.println(seasons);

        System.out.println(seasons.size);

        System.out.println("seasons.get(2) = " + seasons.get(2));

        seasons.remove(3);

        System.out.println(seasons.size);

        seasons.clear();
        System.out.println(seasons);
    }
}