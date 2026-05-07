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
            
    