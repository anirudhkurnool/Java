package DSA;

//currently min heap
public class Heap {
    DList arr;

    public Heap() {
        arr = new DList();
    }

    public int size() { return this.size(); }

    public int capacity() { return this.capacity(); }

    public int bubbleUp(int pos) {
        int parentIndex, curr = pos;
        while (true) {
            parentIndex = ((curr - 1) / 2);
            if (this.arr.get(parentIndex) > this.arr.get(curr)) {
                this.arr.swap(parentIndex, curr);
            } else {
                break;
            }

            curr = parentIndex;
        }

        return curr;
    }

    public void add(int newElement) {
        this.arr.add(newElement);
        this.bubbleUp(this.arr.size() - 1);
    }

    public void bubbleDown(int pos) {
        int curr, leftChild, rightChild, smallest;
        curr = pos;
        int size = this.arr.size(); 
        while (true) {
            leftChild = 2*curr + 1;
            rightChild = 2*curr + 2;
            smallest = curr;
            if (leftChild < size && this.arr.get(leftChild) < this.arr.get(curr)){
                smallest = leftChild;
            }

            if (rightChild < size && this.arr.get(rightChild) < this.arr.get(curr)){
                smallest = rightChild;
            }

            if (curr != smallest){
                this.arr.swap(curr, smallest);
                curr = smallest;
            } else{
                break;
            }
        }
    }

    public int extractMin() {
        int pos = this.arr.size() - 1;
        this.arr.swap(0, this.arr.size() - 1);
        int res = this.arr.get(pos);
        this.arr.deleteAt(pos);
        return res;
    }

    public void delete(int pos) {
        this.arr.swap(pos, this.arr.size() - 1);
        this.arr.deleteAt(this.arr.size() - 1);
        int curr = this.bubbleUp(pos);
        this.bubbleDown(curr);
    }

}
