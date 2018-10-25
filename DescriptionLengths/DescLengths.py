length = int(input())
data = []
for x in range(length):
    data.append(int(input()))

lookup = [56, 96, 36, 76, 16, 56]
for d in data:
    if(d == 0):
        print(1)
    elif(d == 1):
        print(66)
    else:
        print(lookup[(d - 2) % 5])

