public interface LList<T> {
    void addFirst(T value);   //+
    void addLast(T value);    //+
    void print();               //+
    void removeAll(T value);  //+
    void removeFirst(T value);//+
    boolean search(T value);  //+
    boolean isEmpty();          //+
    public T dz();
    public void createLoop(int indexStart);
    public T findLoopStart();
}
