# Single LinkedList
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        
class LinkedList:
    def __init__(self):
        self.head = None
    
    def insert_at_end(self, data):
        newNode = Node(data)
        if self.head == None:
            self.head = newNode
        else:
            current = self.head
            while current.next != None:
                current = current.next
            current.next = newNode
            
    def insert_at_beginning(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node
            
    def traverse(self):
        current = self.head
        while current:
            print(current.data, end=' ->')
            current = current.next
        print("None")
        
    def insert_at_position(self, data, position):
        new_node = Node(data)
        if position == 0:
            new_node.next = self.head
            self.head = new_node
            return
        
        if position < 0:
            print("Position must be a non-negative integer.")
            return
        
        current = self.head
        current_position = 0
        while current != None and current_position < position - 1:
            current = current.next
            current_position += 1
            
        if current is None:
            print("Position out of bounds.")
            return
        
        new_node.next = current.next
        current.next = new_node
       
    def delete_at_position(self, position):
        if self.head == None:
            print("List is empty.")
            return
        
        if position == 0:
            self.head = self.head.next
            return
        
        current = self.head
        current_position = 0
        while current.next != None and current_position < position - 1:
            current = current.next
            current_position += 1
            
        if current.next == None:
            print("Position out of bounds.")
            return
        
        current.next = current.next.next
        
    def insert_after_value(self, data, value):
        newNode = Node(data)
        current = self.head
        while current != None:
            if current.data == value:
                newNode.next = current.next
                current.next = newNode
                return
            current = current.next
        print(f"Value {value} not found in the list.")
    
ll = LinkedList()
ll.insert_at_end(10)
ll.insert_at_end(20)
ll.insert_at_end(30)

print("Linked List contents:")
ll.traverse()

# ll.insert_at_beginning(5)
# print("Linked List after inserting at the beginning:")
# ll.traverse()

# ll.insert_at_position(15, 2)
# print("\nLinked List after inserting 15 at position 1:")
# ll.traverse()

# ll.delete_at_position(1)
# print("\nLinked List after deleting node at position 1:")
# ll.traverse()

ll.insert_after_value(25, 2555)
print("\nLinked List after inserting 25 after value 20:")
ll.traverse()