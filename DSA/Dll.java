package DSA;

class DllNode {
    int data;
    DllNode prev;
    DllNode next;

    DllNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Dll {

    DllNode head;
    DllNode tail;
    int size; 
    
    Dll(int headData) {
        this.head = new DllNode(headData);
        this.tail = this.head;
        this.size = 1;
    }

    Dll() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(int newElement) {
        if (this.head == null){
            this.head = new DllNode(newElement);
            this.tail = this.head;
            this.size = 1;
            return;
        }

        this.tail.next = new DllNode(newElement);
        this.tail.next.prev = this.tail;
        this.tail = this.tail.next;
        this.size += 1;
    }

    public void insert(int pos, int newElement) {
        if (pos < 0) {
            throw new IllegalArgumentException("pos cannot be less than or equal to zero : " + pos);
        }

        if (pos > this.size) {
            throw new IllegalArgumentException("pos cannot be greater than the size of the list : " + pos);
        }

        DllNode newNode = new DllNode(newElement);

        if (pos == 0) {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
            this.size += 1;
        }

        int index = 0;
        DllNode start = this.head;
        while (index < pos){
            start = start.next;
            index += 1;
        } 

        newNode.prev = start.prev;
        newNode.next = start;
        newNode.prev.next = newNode;
        this.size += 1;
    }

    public void deleteAt(int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException("pos cannot be less than or equal to zero : " + pos);
        }

        if (pos >= this.size) {
            throw new IllegalArgumentException("pos cannot be greater than the size of the list : " + pos);
        }

        if (pos == 0){
            this.head = this.head.next;
            this.head.prev = null;
            this.size -= 1;
        }

        int index = 0;
        DllNode start = this.head;

        while (index < pos){
            index += 1;
            start = start.next;
        }

        start.prev.next = start.next;
        start.next.prev = start.prev;
        this.size -= 1;
    }

    public int search(int data) throws IllegalAccessException{
        int index = 0;
        DllNode start = this.head;

        while (start != null){
            if (start.data == data) {
                return index;
            }
            index += 1;
            start = start.next;
        }

        throw new IllegalAccessException("data not present in this list");
    }

    public void delete(int element) throws IllegalAccessException {
        try{
            int index = this.search(element);
            this.deleteAt(index);
        } catch (IllegalAccessException e) {
            throw new IllegalAccessException("data not present in this list");
        }
    }
}

