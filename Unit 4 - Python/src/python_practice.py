date_fashion = lambda you, date: 2 if (you >= 8 or date >= 8) else 0 if (you <= 2 or date <= 2) else 1
"""
def date_fashion(you, date):
    if you >= 8 or date >= 8:
        return 2
    elif you <= 2 or date <= 2:
        return 0
    else:
        return 1
"""

caught_speeding = lambda s, b: 0 if (s <= (v := list(map((lambda i: i if not b else i + 5), [60, 61, 80, 81])))[0]) else 1 if (v[1] <= s) and (s <= v[2]) else 2
"""
def caught_speeding(speed, is_bday):
    if (is_bday and s <= 65) or (s <= 60):
        return 0
    elif (is_bday and 66 <= s <= 85) or (61 <= s <= 80): 
        return 1
    else:
        return 2
"""

big_diff = lambda l: max(l) - min(l)
"""
def big_diff(l):
    return max(l) - min(l)
"""

sum13 = lambda l: sum(l) if len((d := [i for i, x in enumerate(l) if x == 13])) == 0 else sum(l[: d[0]])
"""
def sum13(l):
    ret = 0
    for i in l:
        if i == 13:
            break
        ret += i
    return ret
"""


print(date_fashion(5, 10))
print(date_fashion(5, 2))
print(date_fashion(5, 5))
print("-----")
print(caught_speeding(60, False))
print(caught_speeding(65, False))
print(caught_speeding(65, True))
print("-----")
print(big_diff([10, 3, 5, 6]))
print(big_diff([7, 2, 10, 9]))
print(big_diff([2, 10, 7, 2]))
print("-----")
print(sum13([1, 2, 2, 1]))
print(sum13([1, 1]))
print(sum13([1, 2, 2, 1, 13]))
print(sum13([5, 13, 2]))
