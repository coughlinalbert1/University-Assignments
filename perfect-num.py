def isPerfect(n):
    list = [i for i in range(n + 1) if i != 0]
    factor = [i for i in list if n%i == 0]
    #print(factor)
    return sum(factor) == 2 * n


list = [i for i in range(1000) if i != 0]
perfectNum = [i for i in list if isPerfect(i)]
print(perfectNum)
