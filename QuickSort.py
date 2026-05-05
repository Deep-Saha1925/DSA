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

count=0
def quick(a, l, r):
    p = l
    left = l+1
    right = r
    
    while True:
        while a[p] <= a[right] and right >= left:
            right -= 1
        
        if a[p] > a[right]:
            a[p], a[right] = a[right], a[p]
            p = right
            right -= 1
            
        if right < left:
            return p
        
        while a[p] >= a[left] and right >= left:
            left += 1
            
        if a[p] < a[left]:
            a[p], a[left] = a[left], a[p]
            p = left
            left += 1
            
        if right < left:
            return p            

def quickSort2(l, i, j):
    if i < j:
        p = quick(l, i, j)
        quickSort2(l, i, p-1)
        quickSort2(l, p+1, j)
        count+=1

l = [9,4,12,7,1]
print(l)
quickSort2(l, 0, len(l)-1)
print(l)
print(count)