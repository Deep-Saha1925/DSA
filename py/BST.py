class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BST:
    def __init__(self):
        self.root = None

    def insert(self, data):
        if not self.root:
            self.root = Node(data)
            return
        self._insert_recursively(self.root, data)

    def _insert_recursively(self, node, data):
        if data < node.data:
            if node.left is None:
                node.left = Node(data)
            else:
                self._insert_recursively(node.left, data)
        else:
            if node.right is None:
                node.right = Node(data)
            else:
                self._insert_recursively(node.right, data)
    
    def inorder_traversal(self):
        return self._inorder_recursively(self.root)
    
    def _inorder_recursively(self, node):
        if node is None:
            return []
        return self._inorder_recursively(node.left) + [node.data] + self._inorder_recursively(node.right)

    def preorder_traversal(self):
        return self._preorder_recursively(self.root)
    
    def _preorder_recursively(self, node):
        if node is None:
            return []
        return [node.data] + self._preorder_recursively(node.left) + self._preorder_recursively(node.right)
    
    def postorder_traversal(self):
        return self._postorder_recursively(self.root)
    
    def _postorder_recursively(self, node):
        if node is None:
            return []
        return self._postorder_recursively(node.left) + self._postorder_recursively(node.right) + [node.data]
    
    def display(self):
        if not self.root:
            print("Tree is empty")
            return
        self._display_recursively(self.root, 0)

    def _display_recursively(self, node, level):
        if node is not None:
            self._display_recursively(node.right, level + 1)
            print(' ' * 4 * level + '-> ' + str(node.data))
            self._display_recursively(node.left, level + 1)


# Example usage
tree = BST()
# Taking input from user
n = int(input("Enter the number of nodes: "))
for _ in range(n):
    data = int(input("Enter node data: "))
    tree.insert(data)

tree.display()
print("Inorder Traversal:", tree.inorder_traversal())
print("Preorder Traversal:", tree.preorder_traversal())
print("Postorder Traversal:", tree.postorder_traversal())