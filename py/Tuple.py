# t = tuple(input("Enter elements of tuple separated by space:").split())
t = (1, 2, 3, 4, 5, 1, 2, 3)

duplicate_t = [i for i in t if t.count(i) > 1]
unique_t = [i for i in t if t.count(i) == 1]

# second largest and second smallest
sorted_t = sorted(unique_t)
second_largest = sorted_t[-2]
second_smallest = sorted_t[1]

new_t = (tuple(duplicate_t), tuple(unique_t), second_largest, second_smallest)
freq = {a: t.count(a) for a in set(t)}

print(new_t)
print(freq)