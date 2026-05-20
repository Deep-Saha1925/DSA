class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class Tree:
    def __init__(self):
        self.root = None

    def insert(self, data):
        if not self.root:
            self.root = Node(data)
            return
        self.insert_recursively(self.root, data)

    def insert_recursively(self, node, data):
        ch = input(f"Insert {data} to the left or right of {node.data}? (l/r): ").lower()
        if ch == 'l':
            if node.left is None:
                node.left = Node(data)
            else:
                self.insert_recursively(node.left, data)
        elif ch == 'r':
            if node.right is None:
                node.right = Node(data)
            else:
                self.insert_recursively(node.right, data)
        else:
            print("Invalid choice. Please enter 'l' for left or 'r' for right.")
            self.insert_recursively(node, data)

    def display(self):
        if not self.root:
            print("Tree is empty")
            return
        self.display_recursively(self.root, 0)

    def display_recursively(self, node, level):
        if node is not None:
            self.display_recursively(node.right, level + 1)
            print(' ' * 4 * level + '-> ' + str(node.data))
            self.display_recursively(node.left, level + 1)


tree = Tree()
# Taking input from user
while True:
    data = input("Enter a value to insert into the tree (or 'q' to quit): ")
    if data.lower() == 'q':
        break
    tree.insert(data)

tree.display()
tree.prettyDisplay()