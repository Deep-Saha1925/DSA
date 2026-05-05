def partition(a, p, q):
    pivot = a[p]
    i = p + 1
    j = q

    while True :
        while i <= q and a[i] <= pivot:
            i += 1

        while a[j] > pivot:
            j -= 1

        if i < j:
            temp = a[i]
            a[i] = a[j]
            a[j] = temp
        else:
            break
    
    temp = a[p]
    a[p] = a[j]
    a[j] = temp
    
    return j

def quickSort(l, i, j):
    if i < j:
        p = partition(l, i, j)
        quickSort(l, i, p-1)
        quickSort(l, p+1, j)




l = [0, 17, -3, 90, -14, 0, 1, 100]
quickSort(l, 0, len(l)-1)
print(l)