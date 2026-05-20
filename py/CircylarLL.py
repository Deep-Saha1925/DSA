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

    def delete(self, key):
        if not self.head:
            print("List is empty")
            return
        temp = self.head
        prev = None
        while True:
            if temp.data == key:
                if prev:
                    prev.next = temp.next
                else:
                    # Deleting the head node
                    if temp.next == self.head:  # Only one node in the list
                        self.head = None
                    else:
                        # Find the last node to update its next pointer
                        last_node = self.head
                        while last_node.next != self.head:
                            last_node = last_node.next
                        last_node.next = temp.next
                        self.head = temp.next
                return
            prev = temp
            temp = temp.next
            if temp == self.head:
                break
        print(f"Node with data {key} not found")

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