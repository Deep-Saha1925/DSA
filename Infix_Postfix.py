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


def precedence(op):
    if op in ('^', '$'):
        return 3
    if op in ('*', '/', '%'):
        return 2
    if op in ('+', '-'):
        return 1
    return 0

# s = Stack()
# exp = ""

# # starting bracket
# s.push('(')

# l = []
# while True:
#     val = input("Enter character: ").lower()
#     if val == 'x':
#         break
#     l.append(val)

# # Add closing parenthesis
# l.append(')')

# # Your input
# # l = ['A', '+', 'B', '(', 'C', '*', 'D', '+', 'F', ')', ')']

# for val in l:
#     if val.isalpha():
#         exp += val

#     elif val == '(':
#         s.push(val)

#     elif val == ')':
#         while s.peek() != '(':
#             exp += s.pop()
#         s.pop()  # remove '('

#     else:
#         # keep popping until condition satisfied
#         while (not s.is_empty()) and precedence(val) <= precedence(s.peek()):
#             exp += s.pop()
#         s.push(val)

# print("Postfix:", exp)


# ====================================================================================================================================



# EVALUATE USING VALUE

# 🔹 TAKE INPUT CHARACTER BY CHARACTER
print("Enter expression character by character (press x to stop):")

tokens = []
num = ""

while True:
    ch = input("Enter: ")

    if ch == 'x':
        break

    if ch.isdigit():
        num += ch
    else:
        if num:
            tokens.append(num)
            num = ""
        tokens.append(ch)

# last number
if num:
    tokens.append(num)


# INFIX → POSTFIX
s = Stack()
postfix = []

s.push('(')
tokens.append(')')

for token in tokens:
    if token.isdigit():
        postfix.append(token)

    elif token == '(':
        s.push(token)

    elif token == ')':
        while s.peek() != '(':
            postfix.append(s.pop())
        s.pop()

    else:
        while precedence(token) <= precedence(s.peek()):
            postfix.append(s.pop())
        s.push(token)

print("Postfix:", " ".join(postfix))


# 🔹 EVALUATE
s2 = Stack()

for token in postfix:
    if token.isdigit():
        s2.push(int(token))
    else:
        b = s2.pop()
        a = s2.pop()

        if token == '+':
            s2.push(a + b)
        elif token == '-':
            s2.push(a - b)
        elif token == '*':
            s2.push(a * b)
        elif token == '/':
            s2.push(a / b)
        elif token == '%':
            s2.push(a % b)
        elif token == '^':
            s2.push(a ** b)

print("Result:", s2.pop())