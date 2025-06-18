package DSA;

public class DList {

    private int[] arr;
    private int capacity, size;

    public int size() { return this.size; }

    public int capacity() { return this.capacity; }
    
    public DList() {
        this.capacity = 3;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    public DList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("intial capacity cannot be less than or equal to zero : " + initialCapacity);
        }
        this.capacity = initialCapacity;
        this.size = 0;
        this.arr = new int[initialCapacity];
    }

    public int get(int index) {
        if (this.size >= this.capacity) {
            this.changeArraySize(true);
        }
        
        if (index < 0) {
            throw new IllegalArgumentException("index cannot be less than or equal to zero : " + index);
        }

        if (index > this.size) {
            throw new IllegalArgumentException("index cannot be greater than the size of the list : " + index);
        }

        return this.arr[index];
    }

    public void changeArraySize(boolean grow) {
        if (grow) {
            this.capacity += this.capacity;
        } else {
            this.capacity = this.size;
        }
        
        int newArr[] = new int[this.capacity];
        for(int i = 0; i < this.size; i++) {
            newArr[i] = this.arr[i];
        } 

        this.arr = newArr;
    }

    public void add(int newElement) {
        if (this.size >= this.capacity) {
            this.changeArraySize(true);
        }

        this.arr[this.size] = newElement;
        this.size += 1;
    }

    public void insert(int pos, int newElement) {
        
        if (this.size >= this.capacity) {
            this.changeArraySize(true);
        }
        
        if (pos < 0) {
            throw new IllegalArgumentException("pos cannot be less than or equal to zero : " + pos);
        }

        if (pos > this.size) {
            throw new IllegalArgumentException("pos cannot be greater than the size of the list : " + pos);
        }

        for(int i = this.size; i > pos; i--){
            this.arr[i] = this.arr[i - 1];
        }

        this.arr[pos] = newElement;
        this.size += 1;
    }

    public void deleteAt(int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException("pos cannot be less than or equal to zero : " + pos);
        }

        if (pos >= this.size) {
            throw new IllegalArgumentException("pos cannot be greater than or equal to the size of the list : " + pos);
        }

        for(int i = pos; i < this.size; i++) {
            this.arr[i] = this.arr[i + 1];
        }

        this.size -= 1;
    }

    public void deleteElement(int element) throws IllegalAccessException{
        for(int i = 0; i < this.size; i++){
            if (this.arr[i] == element) {
                this.deleteAt(i);
                return;
            }
        }

        throw new IllegalAccessException("element not present in the list");
    }
}
