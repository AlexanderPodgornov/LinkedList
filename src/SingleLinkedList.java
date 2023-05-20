public class SingleLinkedList<T> implements LList<T>{
    Node<T> first;

    public SingleLinkedList()
    {
        first = null;
    }
    public boolean isEmpty() // true, если список пуст
    {
        return (first==null);
    }
    @Override
    public void addFirst(T value)
    {
        Node<T> n = new Node<T>();
        n.setData((T) value);
        if (first != null)
            n.setNext(first);
        first = n;
    }

    @Override
    public void addLast(T value)
    {
        Node<T> n = new Node<T>();
        n.setData(value);
        Node<T> temp = first;
        if (temp != null)
        {
            while(temp.getNext() != null)
            {
                temp = temp.getNext();
            }
            temp.setNext(n);
        }
        else
            addFirst(value);
    }
    @Override
    public void removeFirst(T value) {
        if (isEmpty())
            throw new NullPointerException("СПИСОК ПУСТОЙ!");
        Node<T> temp = first;
        Node<T> prev = first;
        while (temp != null && temp.getData()!=value)
        {
            prev = temp;
            temp = temp.getNext();
        }
        if (temp == null) throw new NullPointerException("ЭЛЕМЕНТ НЕ НАЙДЕН!");
        else if (temp == first) first = first.getNext();
        else prev.setNext(temp.getNext());
    }

    @Override
    public void removeAll(T value) {
        if (isEmpty())
            throw new NullPointerException("СПИСОК ПУСТОЙ!");
        Node<T> temp = first;
        Node<T> prev = first;
        while (temp != null)
        {
            if (temp.getData() == value)
            {
                if (temp == first) first = first.getNext();
                else if (temp.getNext() == null)
                {
                    prev.setNext(null);
                    break;
                }
                else
                {
                    temp.setData(temp.getNext().getData());
                    prev.setNext(temp.getNext());
                }
            }
            else prev = temp;
            temp = temp.getNext();
        }
    }

    @Override
    public boolean search(T value) {
        Node<T> temp = first;
        while (temp != null)
        {
            if (temp.getData() == value)
                return true;
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public void print() {
        Node<T> temp = first;
        while(temp!=null)
        {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
    @Override
    public T dz()
    {
        int size = 0, counter = 0;
        Node<T> temp = first;
        while (temp != null)
        {
            size++;
            temp = temp.getNext();
        }
        if (size < 5)
            throw new NullPointerException("В списке недостаточно элементов");
        Node<T> tmp = first;
        while (tmp != null)
        {
            if (counter == (size - 5))
            {
               return tmp.getData();
            }
            counter++;
            tmp = tmp.getNext();
        }
        return null;
    }
    public void createLoop(int indexStart) {
        Node<T> temp = first;
        Node<T> loopNode = null;
        int count = 0;

        while (temp.next != null) {
            if (count == indexStart) {
                loopNode = temp;
            }
            temp = temp.next;
            count++;
        }

        temp.next = loopNode;
    }

    public T findLoopStart() {
        Node<T> slow = first;
        Node<T> fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = first;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.getData();
    }

}
//линейный однонаправленный список: найти 5 с конца элемент