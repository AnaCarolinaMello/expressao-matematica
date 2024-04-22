public class Celula<T> {
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