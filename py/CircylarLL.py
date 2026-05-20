class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class CircularLL:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            new_node.next = self.head
            return
        temp = self.head
        while temp.next != self.head:
            temp = temp.next
        temp.next = new_node
        new_node.next = self.head

    def display(self):
        if not self.head:
            print("List is empty")
            return
        temp = self.head
        while True:
            print(temp.data, end=' ')
            temp = temp.next
            if temp == self.head:
                break
        print()

# Example usage
circular_list = CircularLL()
circular_list.append(1)
circular_list.append(2)
circular_list.append(3)
circular_list.display()  # Output: 1 2 3