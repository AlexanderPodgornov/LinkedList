public class Node<T> {
    Node<T> next;

    Node<T> prev;
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
