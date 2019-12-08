[TOC]
# leetcodeTe
## 20191123
### problem 53
knowledge point: **dynamic programming**
***
## 20191125
### problem 58
a new function: str.strip()
删除字符串首尾的指定字符。
当参数为空时，默认删除空格。
当参数不为空时，表示删除首尾的所有匹配的字符。
```python
s = "www.google.com"
print(s.strip("w.mo") # remove all 'w','.','m','o' from the leading and trailing.
# output: google.c
```
***
### problem 67: Add Binary
使用递归得到，时间比较短，但为什么空间并没有很多？
problem 53 就浪费了很多空间，为什么？
使用我的方法，时间长，长在哪里了？是不停地int和str强制类型转换吗？
***
## 20191203
### Problem 110
When using recursive method, check that if there are repeated operations.
### Problem 111
Recursive method is not always the best. It takes more memory.
Find the first left node from the top to the bottom, and then return the number of layer.
***
## 20191204
### Problem 112 path-sum
Use recursive method to find left and right node and sum is (sum - root.val).
### Problem 118 pascal's triangle
Add extra "0" to the head and tail of the last element and then generate the next element.
You can use "+" opertion to connect two or more lists.
Could we use the symmetry of the triangle to save time?
### Problem 119 pascal's triangle II
Record the last element and use it to generate the next one.
***
## 20191205
### Problem 121 best time to buy and sell stock
Firstly, use traversal. Although it is usually not the best.
Secondly, use other ways like dichotomy method.
Finally, use recursion. Because it needs more memory although it may be easy to complish.
### Problem 122 best time to buy and sell stock II
If next value is bigger than the current value, add the difference to the result.
***
##20191207
### Problem 136 single number
solution1: 2*sum(set(nums)) - sum(nums)
solution2: 使用同或，a^b^a = a^a^b = b
### Problem 141 linked list cycle 
use hash map
### Problem 160 intersection of two linked lists
Let pA and pB point to headA and headB respectively. Then move pA and pB one step backaward. If pA points the tail of A, then let pA point headB. It is the same to pB. If pA is pB, then they are the intersection node. Move at most len(A) + len(B) + 1 times. If there is no intersection node in A and B, return None.
***
## 20191208
### Problem 167 two sum II
Running time and memory cost are usually contradictory, but maybe the running time is more important than memory cost.
### Problem 168 excel sheet column title
Two new method: *chr()* and *ord()*.
*chr(int)* returns the ith element of ASCII.
*ord(char)* returns the index of char in ASCII.
This is not a difficult but a easy to make a mistake problem.