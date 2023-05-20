public class DoubleLinkedList<T> implements LList<T>{
    Node<T> first;
    Node<T> last;
    public DoubleLinkedList()
    {
        first = null;
        last = null;
    }
    @Override
    public boolean isEmpty()
    {
        return (first==null);
    }

    @Override
    public T dz() {
        return null;
    }

    @Override
    public void createLoop(int indexStart) {

    }

    @Override
    public T findLoopStart() {
        return null;
    }





    @Override
     public void addFirst(T value)
     {
         Node<T> n = new Node<T>();
         n.data = value;
         if (isEmpty())
             last = n;
         n.next = first;
         first = n;
     }

    @Override
    public void addLast(T value) // элемент в конец списка
    {
        Node<T> n = new Node<T>(); // Создание нового элемента
        n.data = value;
        if( isEmpty() ) // Если список не содержит элементов,
            first = n; // first --> newLink
        else
        {
            last.next = n; // старое значение last --> newLink
            n.prev = last; // старое значение last <-- newLink
        }
        last = n; // newLink <-- last
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
    public void removeFirst(T value)
    {
        if(isEmpty())
            throw new NullPointerException("СПИСОК ПУСТОЙ");
        Node<T> temp = first; // От начала списка
        while(temp.data != value && temp != null)
        {
            temp = temp.next; // Переход к следующему элементу
            if (temp == null)
                throw new NullPointerException("ЭЛЕМЕНТ НЕ НАЙДЕН!");
        }
        //if (temp == null) throw new NullPointerException("ЭЛЕМЕНТ НЕ НАЙДЕН!");
        if(temp==first) // Ключ найден; это первый элемент?
            first = temp.next; // first --> старое значение next
        else // Не первый элемент
            // старое значение previous --> старое значение next
            temp.prev.next = temp.next;
        if(temp==last) // Последний элемент?
            last = temp.prev; // старое значение previous <-- last
        else // Не последний элемент
            // Старое значение previous <-- старое значение next
            temp.next.prev = temp.prev;
    }

    @Override
    public boolean search(T value) {
        return false;
    }


    public void removeAll(T value) {
        if(isEmpty())
            throw new NullPointerException("СПИСОК ПУСТОЙ");
        Node<T> temp = first;
        while (temp != null)
        {
            if (temp.data == value)
            {
                if (temp == first)
                {
                    first = temp.next;
                    if (first != null)
                        first.prev = null;
                    else
                        last = null;
                }
                else if (temp == last)
                {
                    last = temp.prev;
                    last.next = null;
                    temp.prev.next = null;
                }
                else
                {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
    }
}
