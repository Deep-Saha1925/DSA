arr=[1,2,3,4,5,1,2,3]
unique_arr=[]

for i in arr:
    if i not in unique_arr:
        unique_arr.append(i)
print(unique_arr)