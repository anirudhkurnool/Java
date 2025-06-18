package DSA;

public class DStack {
    
    DList lst;
    int size, capacity;

    public DStack(int initialCapacity) {
        this.lst = new DList(initialCapacity);
    }

    public DStack(){
        this.lst = new DList();
    }

    public int size() { return this.size(); }

    public int capacity() { return this.capacity(); }

    public void push(int newElement) {
        this.lst.add(newElement);
    }

    public int pop() {
        if (this.lst.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("stack is empty");
        }
        int index = this.lst.size();
        int res = this.lst.get(index - 1);
        this.lst.deleteAt(index - 1);
        return res;
    } 

    public int peek() {
        if (this.lst.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("stack is empty");
        }
        return this.lst.get(this.size - 1);
    }

}
