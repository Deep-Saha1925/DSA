class HeapSort:
    def heapify(self, a, n, i):
        lar = i
        l = 2*i + 1
        r = 2*i + 2

        if l < n and a[lar] < a[l]:
            lar = l
        if r < n and a[lar] < a[r]:
            lar = r

        if lar != i:
            a[i], a[lar] = a[lar], a[i]
            self.heapify(a, n, lar)

    def sort(self, a):
        n = len(a)

        # Build HEAP
        for i in range(n//2-1, -1, -1):
            self.heapify(a, n, i)

        # Extract elements
        for i in range(n-1, 0, -1):
            a[0], a[i] = a[i], a[0]
            self.heapify(a, i, 0)

arr = list(map(int, input().split()))
print(arr)
h = HeapSort()
h.sort(arr)

print("Sorted:", arr)