# Find unique no. without using sum function from list 0 to n
arr=[0,1,2,4,5]
x=0
for i in range(len(arr)+1):
    x^=i
for i in arr:
    x^=i
print(x)