# Doubly LL
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None
        
class DoublyLinkedList:
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
            newNode.prev = current
            
    def insert_at_beginning(self, data):
        new_node = Node(data)
        if self.head is not None:
            self.head.prev = new_node
        new_node.next = self.head
        self.head = new_node
    
    def insert_at_position(self, data, position):
        new_node = Node(data)
        if position == 0:
            self.insert_at_beginning(data)
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
        new_node.prev = current
        
        if current.next is not None:
            current.next.prev = new_node
            
        current.next = new_node
        
    def traverse(self):
        current = self.head
        while current:
            print(current.data, end=' <-> ')
            current = current.next
        print("None")
        
    
dl = DoublyLinkedList()
dl.insert_at_end(10)
dl.insert_at_end(20)
dl.insert_at_beginning(5)
dl.traverse()
            
    