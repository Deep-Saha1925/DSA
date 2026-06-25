class BrowserHistory {

    class Node {
        String url;
        Node prev;
        Node next;

        Node(String url) {
            this.url = url;
        }
    }

    Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {

        Node newNode = new Node(url);

        current.next = newNode;
        newNode.prev = current;

        current = newNode;
    }

    public String back(int steps) {

        while (current.prev != null && steps > 0) {
            current = current.prev;
            steps--;
        }

        return current.url;
    }

    public String forward(int steps) {

        while (current.next != null && steps > 0) {
            current = current.next;
            steps--;
        }

        return current.url;
    }
}