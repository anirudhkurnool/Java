package DSA;

public class Sll {

    SllNode head, tail;
    int size;

    public Sll(int headData){
        this.head = new SllNode(headData);
        this.tail = this.head;
        this.size = 1;
    }

    public Sll(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(int newElement) {
        if (this.head == null) {
            this.head = new SllNode(newElement);
            this.tail = this.head;
            this.size = 1;
            return;
        }

        this.tail.next = new SllNode(newElement);
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

        SllNode newNode = new SllNode(newElement);

        if (pos == 0) {
            newNode.next = this.head;
            this.head = newNode;
            this.size += 1;
            return;
        }

        int index = 0;
        SllNode start = this.head;
        while (index + 1 < pos) {
            start = start.next;
            index += 1;
        }

        newNode.next = start.next;
        start.next = newNode;
        this.size += 1;
    }

    public void deleteAt(int pos){
        if (pos < 0) {
            throw new IllegalArgumentException("pos cannot be less than or equal to zero : " + pos);
        }

        if (pos >= this.size) {
            throw new IllegalArgumentException("pos cannot be greater than or equal to the size of the list : " + pos);
        }

        if (pos == 0) {
            this.head = this.head.next;
            if (this.head == null) { this.tail = null; }
            this.size -= 1;
        }

        int index = 0;
        SllNode start = this.head;
        while (index + 1 < pos) {
            start = start.next;
            index += 1;
        }

        start.next = start.next.next;
        if (start.next == null) {
            this.tail = start;
        }

        this.size -= 1;
    }

    public int search(int data) throws IllegalAccessException {
        int index = 0;
        SllNode start = this.head;
        while (start != null) {
            if (start.data == data) {
                return index;
            }
            start = start.next;
            index += 1;
        }

        throw new IllegalAccessException("element not present in the list");
    }

    public void delete(int data) throws IllegalAccessException {
        try{
            int index = this.search(data);
            this.delete(index);
        } catch (IllegalAccessException e) {
            throw new IllegalAccessException("element not present in the list");
        }
    }

    
}

class SllNode{
    int data;
    SllNode next;

    public SllNode(int data) {
        this.data = data;
        this.next = null;
    }
}


