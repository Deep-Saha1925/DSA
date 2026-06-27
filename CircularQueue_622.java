class MyCircularQueue {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node tail;

    int size;
    int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        size = 0;
        head = null;
        tail = null;
    }

    public boolean enQueue(int value) {

        if (isFull())
            return false;

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
        return true;
    }

    public boolean deQueue() {

        if (isEmpty())
            return false;

        head = head.next;
        size--;

        if (head == null)
            tail = null;

        return true;
    }

    public int Front() {

        if (isEmpty())
            return -1;

        return head.val;
    }

    public int Rear() {

        if (isEmpty())
            return -1;

        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}