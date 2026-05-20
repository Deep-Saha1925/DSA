class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Queue:
    def __init__(self):
        self.front = None
        self.rear = None

    def enqueue(self, data):
        new_node = Node(data)
        if not self.rear:
            self.front = self.rear = new_node
            return
        self.rear.next = new_node
        self.rear = new_node

    def dequeue(self):
        if not self.front:
            print("Queue is empty")
            return None
        data = self.front.data
        self.front = self.front.next
        if not self.front:
            self.rear = None
        return data

    def display(self):
        if not self.front:
            print("Queue is empty")
            return
        temp = self.front
        while temp:
            print(temp.data, end=' ')
            temp = temp.next
        print()

# Example usage
queue = Queue()
queue.enqueue(10)
queue.enqueue(20)
queue.enqueue(30)
queue.display()  # Output: 10 20 30
queue.dequeue()
queue.display()  # Output: 20 30