l = [1, 2, 3, 4, 5]

min_val = l[0]
max_val = l[0]

for i in l:
    if i < min_val:
        min_val = i
    elif i > max_val:
        max_val = i

print("Minimum value:", min_val)
print("Maximum value:", max_val)