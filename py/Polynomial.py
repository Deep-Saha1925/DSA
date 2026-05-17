class Node:
    def __init__(self, coeff, exp):
        self.coeff = coeff
        self.exp = exp
        self.next = None

class Polynomial:
    def __init__(self):
        self.head = None

    def insert_item(self, coeff, exp):
        new_node = Node(coeff, exp)
        if self.head is None or self.head.exp < exp:
            new_node.next = self.head
            self.head = new_node
        else:
            current = self.head
            while current.next is not None and current.next.exp > exp:
                current = current.next
            if current.exp == exp:
                current.coeff += coeff
            else:
                new_node.next = current.next
                current.next = new_node

    def display(self):
        current = self.head
        result = []
        while current is not None:
            if current.coeff != 0:
                result.append(f"{current.coeff}x^{current.exp}")
            current = current.next
        print(" + ".join(result))

poly = Polynomial()
poly.insert_item(3, 2)
poly.insert_item(5, 1)
poly.insert_item(2, 0)
poly.insert_item(4, 2)
poly.display()