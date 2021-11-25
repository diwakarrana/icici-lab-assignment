# icici-lab-assignment
this repository contains solution of following question

Question: Paul has a set of unique numbers. He wants to store numbers in a binary tree such that 
whenever a number is given, he can exactly tell how many numbers are less than the given 
number. 
 
Help Paul by coding the logic in your language of choice without using any libraries for tree 
implementation.

Explanation:
Algorithm I have used:
step 1: construct binary search tree.
      a) With every insertion maintain if moving to left I increment leftCount. It means in left Subtree number of element is going to increase by one.
      b) if moving to right no need to increment of leftCount because not participating in number of elements in leftsubtree.
step 2: search the required data
      a) while searching if moving to right, It means number of greater than all left subtree element and current node also. So increment smaller count by 
      leftCount + 1;
      b) if moving to left need not to increment smaller counter 
      c) return smaller count;
Time complexity::
Let's say, n is number of disticnt value that is used to build tree
BuildTree complexity: n*logn
Search complexity : logn 
Ovderall = n*logn + logn = nlogn

Space compleaxity :
it's constant because no Auxiliary space is used. there might be chance in search function if I could use recursive approach but 
here i used iterative Approach

Note Drawback: 
if data is coming in increasing or decreasing order than binary search tree will become right skewed or left skewed.
In this case all operation of binary search tree will become O(n) and overall time complexity will become O(n2)

Solution:: height balancing binary Search tree must be used
