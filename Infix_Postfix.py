class Stack:
    def __init__(self):
        self.stack = []

    def is_empty(self):
        return len(self.stack) == 0

    def push(self, item):
        self.stack.append(item)

    def pop(self):
        if self.is_empty():
            return None
        return self.stack.pop()

    def peek(self):
        if self.is_empty():
            return None
        return self.stack[-1]


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

# starting bracket
s.push('(')

l = []
while True:
    val = input("Enter character: ").lower()
    if val == 'x':
        break
    l.append(val)

# Add closing parenthesis
l.append(')')

# Your input
# l = ['A', '+', 'B', '(', 'C', '*', 'D', '+', 'F', ')', ')']

for val in l:
    if val.isalpha():
        exp += val

    elif val == '(':
        s.push(val)

    elif val == ')':
        while s.peek() != '(':
            exp += s.pop()
        s.pop()  # remove '('

    else:
        # keep popping until condition satisfied
        while (not s.is_empty()) and precedence(val) <= precedence(s.peek()):
            exp += s.pop()
        s.push(val)

print("Postfix:", exp)