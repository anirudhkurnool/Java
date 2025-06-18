package DSA;

public class DQueue {
    
    DList lst;

    public DQueue() {
        this.lst = new DList();
    }

    public DQueue(int initialCapacity) {
        this.lst = new DList(initialCapacity);
    }

    public int size() { return this.size(); }

    public int capacity() { return this.capacity(); }

    public void enqueue(int newElement) {
        this.lst.add(newElement);
    }

    public int dequeue(){
        if (this.lst.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("queue is empty");
        }
        int res = this.lst.get(0);
        this.lst.deleteAt(0);
        return res;
    }

    public int Peek() {
        if (this.lst.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("queue is empty");
        }
        return this.lst.get(0);
    }


}
