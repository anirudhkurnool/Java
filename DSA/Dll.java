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
}

