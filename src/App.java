import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        while (!s.equals("FIM")) {
            String resp = getPolonesa(s);
            System.out.println(resp);
            s = scanner.nextLine();
        }

        scanner.close();
    }

    public static String getPolonesa(String value) {
        String newValue = "";
        Pilha<Item> pilha = new Pilha<Item>();

        for (int i = 0; i < value.length(); i++) {
            char v = value.charAt(i);
            Item item = new Item(v);

            if (v == ' ') continue;
            else if (v == ')') {
                while (!pilha.empty() && pilha.getTop().getPriority() != 1) {
                    Item top = pilha.remove();
                    newValue += top.getValue() + " ";
                }
                pilha.remove();
            }
            else if (isOperator(v)) {
                while (!pilha.empty() && item.getPriority() <= pilha.getTop().getPriority() && item.getPriority() != 1) {
                    Item top = pilha.remove();
                    newValue += top.getValue() + " ";
                }
                pilha.add(item);
            }
            else newValue += v + " ";

        }

        while (!pilha.empty()) {
            Item top = pilha.remove();
            newValue += top.getValue() + " ";

        }

        return newValue.trim();
    }

    public static boolean isOperator(char v) {
        return v == '(' || v == '+' || v == '-' || v == '*' || v == '/';
    }

    public static class Item {
        private final int priority;
        private final char value;

        public Item(char value) {
            this.value = value;
            this.priority = checkPriority(value);
        }

        private int checkPriority(char value) {
            if (value == '(')
                return 1;
            else if (value == '+' || value == '-')
                return 2;
            return 3;

        }

        public int getPriority() {
            return this.priority;
        }

        public char getValue() {
            return this.value;
        }

    }

    public static class Pilha<T> {
        private Celula<T> start;
        private Celula<T> top;

        public Pilha() {
            Celula<T> head = new Celula<T>();
            this.top = head;
            this.start = head;
        }

        public boolean empty() {
            return top == start;
        }

        public void add(T item) {
            Celula<T> newTop = new Celula<T>(item, top);
            top = newTop;
        }

        public T remove() {
            T item = getTop();
            top = top.getNext();
            return item;
        }

        public T getTop() {
            if (empty())
                throw new NoSuchElementException();

            return top.getItem();
        }
    }

    public static class Celula<T> {
        private final T item;
        private Celula<T> next;

        public Celula() {
            this.item = null;
            this.next = null;
        }

        public Celula(T item) {
            this.item = item;
            this.next = null;
        }

        public Celula(T item, Celula<T> next) {
            this.item = item;
            this.next = next;
        }

        public T getItem() {
            return this.item;
        }

        public Celula<T> getNext() {
            return this.next;
        }

        public void setNext(Celula<T> next) {
            this.next = next;
        }
    }
}
