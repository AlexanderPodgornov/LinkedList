public class STACK<T> implements SQ<T> {
    Node<T> first;
    public STACK()
    {
        first = null;
    }
    @Override
    public boolean isEmpty()
    {
        return (first == null);
    }
    @Override
    public void print() {
        Node<T> temp = first;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public void push(T value)
    {
        Node<T> n = new Node<T>();
        n.setData((T) value);
        Node<T> temp = first;
        if (temp != null)
        {
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = n;
        }
        else
        {
            if (first != null)
                n.next = first;
            first = n;
        }
    }



    @Override
    public void pop()
    {
        if(isEmpty())
            throw new NullPointerException("СПИСОК ПУСТОЙ");
        Node<T> temp = first;
        if (temp.next == null)
            first = first.next;
        else {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    @Override
    public T peek()
    {
        if(isEmpty())
            throw new NullPointerException("СПИСОК ПУСТОЙ");
        return (T) first.getData();
    }
}
