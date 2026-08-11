# Replace negative numbers with zero
l = [1, 2, 3, 4, -3, 6, -2, 5]
nL = []

for i in l:
    if i < 0:
        nL.append(0)
    else:
        nL.append(i)

print(nL)