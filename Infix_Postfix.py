class Stack:
    def __init__(self):
        self.stack = []

    def is_empty(self):
        return len(self.stack) == 0

    def push(self, item):
        self.stack.append(item)

    def pop(self):
        if self.is_empty():
            return "Stack is empty"
        return self.stack.pop()

    def size(self):
        return len(self.stack)

    def peek(self):
        if self.is_empty():
            return -1
        return self.stack[-1]

    def display(self):
        print(self.stack)


def precedence(e):
    if e == '$' or e == '^':
        return 3
    if e == '%' or e == '/' or e == '*':
        return 2
    if e == '+' or e == '-':
        return 1
    return 0


s = Stack()
exp = ""

print("Enter character by character, press x to exit")

l = []
while True:
    val = input("Enter character: ").lower()
    if val == 'x':
        break
    l.append(val)

# Add closing parenthesis
l.append(')')

# Example input (already in your code)
# l = ['A', '+', 'B', '(', 'C', '*', 'D', '+', 'F', ')', ')']

for val in l:
    if val.isalpha():
        exp = exp + val
    else:
        if val == '(':
            s.push(val)
        elif val == ')':
            while s.peek() != '(':
                exp = exp + s.pop()
            s.pop()
        else:
            cp = precedence(val)
            tp = precedence(s.peek())

            if cp > tp:
                s.push(val)
            else:
                exp = exp + s.pop()
                s.push(val)

print(exp)