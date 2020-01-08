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
## 20191207
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
***


```C
#include <stdio.h>

int main()
{
   /* 我的第一个 C 程序 */
   printf("Hello, World! \n");
   
   char *a;
    a = "absd";
    printf(a);              // print contents of a, namely "absd"
    printf("\n");
    /* don't use %x when printing address.
    In 32bit system, %x and %p maybe the same.
    But in 64bit system, %x print 4 bytes while address is 8 bytes. So the result is partial.
    */
	printf("addr of a: %p\n", &a);             // print address of a, pointer a.
    printf("addr of s: %x\n", a);      // print the address of string, namely "absd"
    printf("addr of s: %p\n", a);      // print the address of string, namely "absd"
    printf("addr of s: %#p\n", a);     // same as %p, but the result contains "0X" or "0"
    printf("%d\n", sizeof(int*));
	
	printf("===== pointer of int ========\n");
	int list[3] = {257,3,65538};
	int *v = list;
	printf("addr of v:\t %p\n", &v);
	printf("addr of list:\t %p\n", v);
	printf("====== 低位存储 =======\n");
	char *t;
	t = (char*)v;
	for (int i = 0; i< 12; i++)
    {
        printf("%d\n", *(t + i));
    }
		 
	return 0;
}
```
## 20191218
from problem 175 switch default language to mysql.

***
## 20191219
### Problem 189 rotate array
solution1, use three reverse operation.
solution2, use a extra array to store the original array.
### Problem 190 reverse bits
Solution 1, transform n to binary list, then reverse the binary list.  
Finally, transform the binary list back to unsigned integer.
This solution is complex.  
Solution 2, use the bit manipulation.  
Use n&1 to get the last element of binary list of n.
Use res<<1 to multiply res by 2.
knowledge point: **bit manipulation**.
### Problem 191 number of 1 bits -- hamming weight
**Solution1:** Use the format function.  
Like '{0: 032b}.format()' returns the 32 bits of binary **string** of number.
The second '0' indicates that the string will be fill in with '0'.  
**Solution2:** Use the bit manipulation.
n&1 gets the last element of binary list of n.

***
## 20191220
### Problem 198 House Robber
How to solve Dynamic Programming?

### Problem 202 Happy Number
Floyd Cycle Detection Algorithm.  
It is use in judging whether there is a loop in linked list, 
recursion method and finite state machine(FSM).  
It can also be used to find the shortest trip in a map.


***
## 20191223
### Problem 234 Palindrome linked list
Reverse the first half or whole list, then compare it with the 
last half.
Notice that assigning instance to temp, any change of temp will
affect the instance. For example:
```python
head = ListNode(3)
t = head
t.val = 4
print(head.val)     # value of head will change to 4.
```

***
## 20200103
### Problem 392 is subsequence
Should try other methods to solve the problem.
Try dynamic programming and binary search.

### Problem 401 binary watch
New method: bin(n: int)

*bin(n: int)* returns the string of binary representation of the integer.
For example:
```python
print(bin(3))  # '0b11'
bin(3) + bin(4)  # '0b110b100'
```
**Discussion:**
Maybe it is complex to show all of the sub list of a list. For example, list [2, 3, 4]. It is easy to calculate the amount of sub list using permutation and combination. But it is complex to show them.

***
## 20200106
### Problem 405 Convert a number to hexadecimal
Use bit manipulation, '&' and '>>'.

### Problem 409 longest palindrome
New knowledge: collections

*collections.Counter().values()*

It is similar to *set()*, which gets the single element of string or list .etc.
```python
s = 'shghgdshdgg'
for v in collections.Counter(s).values():
    print(v)
```

### Problem 437 Path Sum III
Use the recursion. The result contains two path: containing the root node and not containing the root node. 
Maybe it could be solved using dynamic programming.


***
## 20200107
### Problem 448 find all numbers disappeared in an array
If there is no requirement of not using extra space, the problem will be easy but meaningless.

This is an excellent solution:  
Use two circulation. In the first iterate, mark the elements as negative whose indices appeared in the array (regard the item as index).
In the second iterate, find the elements which are still positive. The result is made up of their indices.

### Problem 455 assign cookies
Use two pointers to track the children and cookies respectively.
Is it the Greedy?
### Problem 461 Hamming distance
Use bit opeartion '^'.
'^' returns '1' if the corresponding bit is different, else it returns '0'.

***
## 20200108
### Problem 496 next greater element
Solution 1: you can use the brute force though it may cost a little more time.
Solution 2: Use a stack( actually a list) and a map to restore the element and its next greater element.
You can understand it using the example: nums2 = [4,3,2,1,5].