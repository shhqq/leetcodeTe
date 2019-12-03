[TOC]
# leetcodeTe
## 20191123
### problem 53
knowledge point: **dynamic programming**
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
### problem 67: Add Binary
使用递归得到，时间比较短，但为什么空间并没有很多？
problem 53 就浪费了很多空间，为什么？
使用我的方法，时间长，长在哪里了？是不停地int和str强制类型转换吗？
## 20191203
### Problem 110
When using recursive method, check that if there are repeated operations.
### Problem 111
Recursive method is not allways the best. It takes more memory.
Find the first left node from the top to the bottom, and then return the number of layer.