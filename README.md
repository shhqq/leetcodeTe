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

## 20200424
比较容易出错的点：
1. 关于链表问题，next有可能会丢
2. 关于回文问题，老是考虑不全。

## 20200506     problem 55 jump game
### 动态规划
#### Naming
We call a position in the array a "good index" if starting at that position, we can reach the last index. Otherwise, that index is called a "bad index". The problem then reduces to whether or not index 0 is a "good index".
#### Solution
This is a dynamic programming[1] question. Usually, solving and fully understanding a dynamic programming problem is a 4 step process:

1. Start with the recursive backtracking solution
2. Optimize by using a memoization table (top-down[2] dynamic programming)
3. Remove the need for recursion (bottom-up dynamic programming)
4. Apply final tricks to reduce the time / memory complexity

All solutions presented below produce the correct result, but they differ in run time and memory requirements.

**Approach 1: Backtracking**

This is the inefficient solution where we try every single jump pattern that takes us from the first position to the last. We start from the first position and jump to every index that is reachable. We repeat the process until last index is reached. When stuck, backtrack.

```java
public class Solution {
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
}
```

One quick optimization we can do for the code above is to check the nextPosition from right to left. The theoretical worst case performance is the same, but in practice, for silly examples, the code might run faster. Intuitively, this means we always try to make the biggest jump such that we reach the end as soon as possible

The change required is:

```java
// Old
for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++)
// New
for (int nextPosition = furthestJump; nextPosition > position; nextPosition--)
``` 


For instance, in the example below, if we start from index 0, jump as far as possible and reach 1, jump as far as possible and reach 6. By doing so, we determine that 0 is a GOOD index in 3 steps.
|||||||||
--|--|--|--|--|--|--|--|--
Index	|0|	1|	2|	3|	4|	5|	6
nums	|1|	5|	2|	1|	0|	2|	0
|||||||

To illustrate the worst case, where this optimization has no effect, take the example below. Index 6 cannot be reached from any position, but all combinations will be tried.

|||||||||
--|--|--|--|--|--|--|--|--
Index	|0|	1|	2|	3|	4|	5|	6
nums	|5|	4|	3|	2|	1|	0|	0
|||||||

The first few steps of the backtracking algorithm for the example above are: 0 -> 4 -> 5 -> 4 -> 0 -> 3 -> 5 -> 3 -> 4 -> 5 -> etc.

Complexity Analysis

* Time complexity : O(2^n). There are 2^n(upper bound) ways of jumping from the first position to the last, where *n* is the length of array **nums**. For a complete proof, please refer to Appendix A.

* Space complexity : O(n). Recursion requires additional memory for the stack frames.

***
**Approach 2: Dynamic Programming Top-down**

Top-down Dynamic Programming can be thought of as optimized backtracking. It relies on the observation that once we determine that a certain index is good / bad, this result will never change. This means that we can store the result and not need to recompute it every time.

Therefore, for each position in the array, we remember whether the index is good or bad. Let's call this array memo and let its values be either one of: GOOD, BAD, UNKNOWN. This technique is called memoization[3].

An example of a memoization table for input array nums = [2, 4, 2, 1, 0, 2, 0] can be seen in the diagram below. We write **G** for a *GOOD* position and **B** for a BAD one. We can see that we cannot start from indices 2, 3 or 4 and eventually reach last index (6), but we can do that from indices 0, 1, 5 and (trivially) 6.

||||||||||
--|--|--|--|--|--|--|--|--
Index	|0|	1|	2|	3|	4|	5|	6|
nums	|2|	4|	4|	1|	0|	2|	0
memo    |G| G|  B|  B|  B|  G|  G
|||||||

**Steps**

1. Initially, all elements of the memo table are *UNKNOWN*, except for the last one, which is (trivially) GOOD (it can reach itself)
2. Modify the backtracking algorithm such that the recursive step first checks if the index is known (GOOD / BAD)
    1. If it is known then return True / False
    2. Otherwise perform the backtracking steps as before
3. Once we determine the value of the current index, we store it in the memo table

```java
enum Index {
    GOOD, BAD, UNKNOWN
}

public class Solution {
    Index[] memo;

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }
}
```

**Complexity Analysis**

* Time complexity : O(n^2). For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a *GOOD* index. nums[i] can be at most *n*, where *n* is the length of array nums.

* Space complexity : O(2n) = O(n). First *n* originates from recursion. Second *n* comes from the usage of the memo table.

***
**Approach 3: Dynamic Programming Bottom-up**

Top-down to bottom-up conversion is done by eliminating recursion. In practice, this achieves better performance as we no longer have the method stack overhead and might even benefit from some caching. More importantly, this step opens up possibilities for future optimization. The recursion is usually eliminated by trying to reverse the order of the steps from the top-down approach.

The observation to make here is that we only ever jump to the right. This means that if we start from the right of the array, every time we will query a position to our right, that position has already be determined as being GOOD or BAD. This means we don't need to recurse anymore, as we will always hit the memo table.

```java
enum Index {
    GOOD, BAD, UNKNOWN
}

public class Solution {
    public boolean canJump(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }
}
```

**Complexity Analysis**

* Time complexity : O(n^2). For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index. nums[i] can be at most *n*, where *n* is the length of array nums.

* Space complexity : O(n). This comes from the usage of the memo table.

***
**Approach 4: Greedy**
Once we have our code in the bottom-up state, we can make one final, important observation. From a given position, when we try to see if we can jump to a GOOD position, we only ever use one - the first one (see the break statement). In other words, the left-most one. If we keep track of this left-most GOOD position as a separate variable, we can avoid searching for it in the array. Not only that, but we can stop using the array altogether.

Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index (currPosition + nums[currPosition] >= leftmostGoodIndex). If we can reach a GOOD index, then our position is itself GOOD. Also, this new GOOD position will be the new leftmost GOOD index. Iteration continues until the beginning of the array. If first position is a GOOD index then we can reach the last index from the first position.

To illustrate this scenario, we will use the diagram below, for input array nums = [9, 4, 2, 1, 0, 2, 0]. We write **G** for *GOOD*, **B** for *BAD* and **U** for *UNKNOWN*. Let's assume we have iterated all the way to position 0 and we need to decide if index 0 is GOOD. Since index 1 was determined to be GOOD, it is enough to jump there and then be sure we can eventually reach index 6. It does not matter that nums[0] is big enough to jump all the way to the last index. All we need is one way.
|||||||||
--|--|--|--|--|--|--|--
Index|	0|	1|	2|	3|	4|	5|	6
nums|	9|	4|	2|	1|	0|	2|	0
memo|	U|	G|	B|	B|	B|	G|	G
||||||||

```java
public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
```

**Complexity Analysis**

* Time complexity : O(n). We are doing a single pass through the nums array, hence *n* steps, where *n* is the length of array nums.

* Space complexity : O(1). We are not using any extra memory.

**Conclusion**

The question left unanswered is how should one approach such a question in an interview scenario. I would say "it depends". The perfect solution is cleaner and shorter than all the other versions, but it might not be so straightforward to figure out.

The (recursive) backtracking is the easiest to figure out, so it is worth mentioning it verbally while warming up for the tougher challenge. It might be that your interviewer actually wants to see that solution, but if not, mention that there might be a dynamic programming solution and try to think how could you use a memoization table. If you figure it out and the interviewer wants you to go for the top-down approach, it will not generally be time to think of the bottom-up version, but I would always mention the advantages of this technique as a final thought in the interview.

Most people are stuck when converting from top-down Dynamic Programming (expressed naturally in recursion) to bottom-up. Practicing similar problems will help bridge this gap.

[Reference](https://leetcode.com/problems/jump-game/solution/)

#### 总结

使用递归将耗费较多时间，什么样的递归可以避免？
如果是中间结果可以保存的，那么可能可以避免使用递归，例如斐波那契数列，可以使用一个数组来保存中间值，这样不需要每次递归都重复计算中间值。本例也是，可以使用一个数组记录中间结果，避免过多的重复计算。

## 20200519

### Problem 94 Binary Tree Inorder Traversal

不使用递归，进行二叉树的中序遍历。
使用一个栈存储父节点，如果有左节点，将左节点入栈，如果没有左节点就打印该节点值，然后判断右节点。
1. 当前节点如果不为空，则入栈，否则弹栈（栈不为空时），前往3。
2. 指向左节点，返回1
3. 打印当前值，然后指向右节点，返回1

### problem 105
根据前序和中序遍历构建树结构。
- 使用迭代，分别构建左子树，右子树。
- 不使用迭代

### problem 137

1. 这种问题，一般可以使用位操作，bit manipulation。相同的问题还有
136 Single Number [easy]
260 Single Number III [Medium]

2. 对于136 和 137

第一种思路是，除一个数字外，其他数字都出现k次，那么就想办法用位操作，将出现1次，2次，...， k次都记录下来，其中k次后要归零，那么最终会得到只出现了一次的数字；

如果是只有一个数字出现n次，其他出现k次，因为出现1次，2次，...， k次都记录下来了，所以只要找到n次的记录就行。不同的是，如果n=1，那么只要找到1次的记录那个数字，但是n！=1时，记录的那个数字是经过运算后的，如何获取原始的数据？

第二种思路是：因为int是32bit的，所以使用一个32个元素的数组，用每个元素用来记录对应bit位置的1出现的次数，再用最后的除以k，如果不能整除，那么一定是只出现了一次的数字引起的。
==这个思路可以找到出现n次。==

3. 第260题，有两个数字出现1次，其余数字都出现2次。

思路是拆成两个数组，将出现1的两个数字分别放到一个数组中，这样就可以分别找到。

如何将两个数字分别放到一个数组呢？记为a，b。

因为不同数字的二进制不同，那么可以利用这一点，只要找到a和b某一个bit不同的位置（其中一个为0，另一个为1），用这个位置来区分所有的数字，这一bit为0的为一组，为1的为另一组，就可以将这两个数字放到两个数组中。同时出现两次的数字一定位于同一组。

首先将所有的数字都异或起来，那么除a和b外，出现2次的都异或为0，最终的数字就是a and b异或的结果，记为diff，这个diff一定有某些bit是1，也就是a和b的二进制中不同的位置。

取出某一个1的bit位，得到一个数字，记为d，用d与上所有的数字，结果要么是0，要么是d，就将原来的数组分成了两组。

[reference1](https://www.cnblogs.com/grandyang/p/4741122.html)
[reference2](https://www.cnblogs.com/grandyang/p/4263927.html)
[reference3](https://hanfeng.ink/post/bitwise/)


### Problem 139 word break
使用递归当然可以完成这个题，但是递归的时间太长。

如同Problem 55一样，递归有时候可以用一个数组记录中间量避免递归，如斐波那契数列；另一种是本题，使用一个数组可以避免递归，这里的递归是因为递归深度太深，因为有个测试用例是一长串a加一个b：aaaa...aaab。此时递归深度太深导致超时。

因此==递归可能有两个弊端==：
1. 递归有一些重复计算
2. 递归过深，耗时太长

