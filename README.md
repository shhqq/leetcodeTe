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
Let pA and pB point to headA and headB, respectively. Then move pA and pB one step backaward. If pA points the tail of A, then let pA point headB. It is the same to pB. If pA is pB, then they are the intersection node. Move at most len(A) + len(B) + 1 times. If there is no intersection node in A and B, return None.
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
Use two pointers to track the children and cookies, respectively.
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

***
## 20200109
### Problem 501 find mode in binary search tree
Use a collections.Counter() to establish a map to store value and its occuring times.

***
## 20200110
### Problem 543 diameter of binary tree
You can define a method in a method.
When you want to use a variable of the external method, you can define the variable as a class variable.
For example:
```python
class Solution(object):
    def external_method(self) -> None:
        self.t = 0

        def internal_method() -> None:
            b = 3
            self.t = max(self.t, b)
        
        internal_method()
        print(self.t)   # t will be 3.

sln = Solution()
sln.external_method()
```

***
## 20200114
### Problem 589 N-array tree preorder traversal
Use a stack to storage the nodes. When popping one node from the tail, append its children to the stack.

*** 
## 20200117
### Problem 705 and 706 design hashset and hashmap
It is interesting to construct the basic data type.
TODO: Complete a hashset and hashmap without using library methods.

### Problem 728 self dividing number
[ knowledge point ]: **for/else** loop. 


It is the first time to use for/else loop.
The for/else loop works like this:
If the *for* loop ends normally namely it doesn't end by the *break* sentence, then the else sentence will be executed. 

For example:
```python
ans = []
for i in range(3, 10):
    for j in range(2, i):
        if i % j == 0: 
            break
    else:
        ans.append(i)
print(ans) # ans=[3,5,7]
```

***
## 20200119
### Problem 733 flood fill
I'm so stupid that I use a hashmap to record grids that have been checked.
Actually, if the *newColor* is equal to the value of image[sr][sc], the image will not change at all.

### Problem 746 min cost climb stairs
Use a stack to record the mimimum cost of n-step stairs which must contain the n-th step.
So the finally result is min(c[-1], c[-2]).
Using recursion can also solve the problem, but this will repreatly calculate intermediate variables.

***
## 20200221
### Problem 874 walking robot simulation
Use **set** to hash the list of obstacles. **Set** is hashable so that it will save much time.

Knowledgement: set.
```python
obstacles = [[1,2], [3,4], [8,2]]
obs_set = set(map(tuple, obstacles))
print(obs_set)
```

### Problem 884 uncommon words from two sentences
Some functions of dictionary.
dict.get(k, d=None)
Return dict[k] if k is in keys of dict. If k is not in keys of dict, then append k: d into dict and return d.
For example:
```python
d = {}
d['apple'] = d.get('apple', 0) + 1
print(d)
```

***
## 20200222
Knowledgement: module: collections
*collections* is a extension of basic data type of python(list, tuple, set and dictionary). *collections* supply some important data type of methods, like *Counter*, *deque*, *defaultdict*, *orderedDict* and *namedtuple*. The usage of them is showen as bellow:
```python
import collections

# Counter can be used to list or string to get elements and their counts stored as a dictionary.
# It has methods like a dictionary.
print('========= Usage of collections.Counter() ============')
nums = [1,2,3,2,4,3,5]
c = collections.Counter(nums)
print(c)
print(c.values())
for k in c.keys():
    print(c[k])

s = 'shgshdgs'
c = collections.Counter(s)
print(c)
for k in c.keys():
    print(c[k])


# deque is extension of list. List is stored linearly. So it's time complexity is large when adding or removing data, especially when the scale of a list is very large. deque is list-like sequence optimized for data accesses near its endpoints.
# a list only provides append() and pop() method from the end, while deque provides appendleft() and popleft() method from the top of it.
print('========= Usage of collections.deque() ============')
d = collections.deque([1,2,3])
d.append(4)
print(d)
d.popleft()
print(d)
d.appendleft(0)
print(d)
```

Knowledgement: enumerate
*enumerate* return an enumerate object. It is an iterator for index and value of iterable
```python
a = [1, 2, 'e', 'rew', 7]
for i, v in enumerate(a):
    print(i, v)
```

## 20200417
switch default language to java.

### 
1. java排序需使用
Arrays.sort()
2. java字符串使用双引号
3. java的原始数据类型（如int）不是对象，没有toString()等属性，请使用Integer。
4. java has two difference types of variables: **primitive** and **objects**. Only objects are **reference types**.

Primitives including int, char, short, long, float, double, boolean and byte are not objects. And they don't have member variables or methods. Thay are just simple values. You cannot do somePrimitive.something(). For example:
```java
public class test{
    public static void main(String[] args){
        int x = 5;
        System.out.println(x.length);       // invalid syntax in Java.
    }
}
```
You should use object *Integer*:
```java
public class test{
    public static void main(String[] args){
        Integer x = 5;
        System.out.println(x.length);
    }
}
```
In Java, objects are always allocated on the heap and the stack contains only a reference. In general, **reference** is an address to some of object/variable, while getting or setting value for that variable you need to **de-reference** that means you need to get to the location where it is actually laying in the memory. So we can say that accessing the state or behaviour of an object using its reference with the help of the dot(.) operator is called **dereferencing**.

[Reference](http://net-informations.com/java/err/dereferenced.htm)

