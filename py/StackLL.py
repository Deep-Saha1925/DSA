class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Stack:
    def __init__(self):
        self.top = None

    def push(self, data):
        new_node = Node(data)
        new_node.next = self.top
        self.top = new_node

    def pop(self):
        if not self.top:
            print("Stack is empty")
            return None
        data = self.top.data
        self.top = self.top.next
        return data

    def display(self):
        if not self.top:
            print("Stack is empty")
            return
        temp = self.top
        while temp:
            print(temp.data, end=' ')
            temp = temp.next
        print()

# Example usage
stack = Stack()
stack.push(10)
stack.push(20)
stack.display()  # Output: 20 10