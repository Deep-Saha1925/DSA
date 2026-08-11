# Count elements are gerater than avg
l = [1, 2, 3, 4, 5]
avg = sum(l) / len(l)
count = 0
for i in l:
    if i > avg:
        count += 1

print("Count of elements greater than average:", count)