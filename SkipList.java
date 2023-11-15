package Lab8;


public abstract class SkipList<T extends Comparable<T>> {
    /** Static class to contain the data and the links */
    static class SkipListNode<T> {
        T value;
        SkipListNode<T>[] forward;

        public SkipListNode(T value, int level) {
            this.value = value;
            this.forward = (SkipListNode<T>[]) new SkipListNode[level];
        }
    }
    private static final int MAX_LEVEL = 3; // Number of levels in the skip list
    private int level; // Current level of the skip list
    private SkipListNode<T> header; // Header node

    public SkipList() {
        this.level = 1;
        this.header = new SkipListNode<>(null, MAX_LEVEL);
    }

    
    public abstract void insert(T value);
    public abstract boolean contains(T value);
    public abstract boolean delete(T value);

}
