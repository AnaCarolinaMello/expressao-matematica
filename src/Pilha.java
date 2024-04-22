import java.util.NoSuchElementException;

public class Pilha<T> {
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