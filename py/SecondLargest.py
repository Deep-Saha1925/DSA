# Find the second largest element in a list
l = [1, 2, 3, 4, 5]
largest = l[0]
second_largest = l[0]

for i in l:
    if i > largest:
        second_largest = largest
        largest = i
    elif i > second_largest and i != largest:
        second_largest = i

print("Second largest value:", second_largest)