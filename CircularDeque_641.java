class MyCircularDeque {

    class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node tail;

    int size;
    int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
    }

    public boolean insertFront(int value) {

        if (isFull())
            return false;

        Node node = new Node(value);

        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        size++;
        return true;
    }

    public boolean insertLast(int value) {

        if (isFull())
            return false;

        Node node = new Node(value);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        size++;
        return true;
    }

    public boolean deleteFront() {

        if (isEmpty())
            return false;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return true;
    }

    public boolean deleteLast() {

        if (isEmpty())
            return false;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : head.val;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}