public class Queue<T> implements SQ<T> {
    Node<T> first;
    Node<T> last;
    public Queue()
    {
        first = null;
        last = null;
    }
    @Override
    public void push(T value)
    {

        Node<T> n = new Node<T>();
        n.data = value;
        if (isEmpty())
            last = n;
        else
            first.prev = n;
        n.next = first;
        first = n;
    }

    @Override
    public void pop()
    {
        if(isEmpty())
            throw new NullPointerException("СПИСОК ПУСТОЙ");
        if(first.next == null)
            first = null;
        else
            last.prev.next = null;
        last = last.prev;


    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new NullPointerException("СПИСОК ПУСТОЙ");
        return (T) last.getData();
    }

    @Override
    public void print() {
        Node<T> temp = first;
        while(temp != null)
        {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
    @Override
    public boolean isEmpty() {
        return (first == null);
    }
}
