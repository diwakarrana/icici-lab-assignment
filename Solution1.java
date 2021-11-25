

import java.util.*;
import java.lang.*;
import java.io.*;

//structure of Node used in in binary search tree
class Node {
    int leftCount;						//number of nodes present in left subtree 
    int val;									//value of node
    Node left;							//pointing to left child
    Node right;							//pointing to right child
    public Node(int val){
        this.val = val;
        this.leftCount = 0;
        this.left = null;
        this.right = null;
    }
}

class Solution1
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Driver code Here. One Arraylist having some data value
	   ArrayList<Integer> list = new ArrayList<>();
	   list.add(1);
	   list.add(1);
	   list.add(1);
	   list.add(1);
	   list.add(1);
	   list.add(1);
	   Node root = buildBst(list);     // this method is used to build tree;
	   int n = search(root, 7);			  // FIRST PARAM: root of tree, SECOND PARAM: number BY which smaller element count is to found
	   System.out.println(n);
	   //printTree(root);
	}

	//1:Utility method to print preOrder traversel of tree
	public static void printTree(Node root){
	    if(root == null)
	    return;
	    System.out.print(root.val+" ");
	    printTree(root.left);
	    printTree(root.right);
	}

	//2: Method that returns number of element smaller than passed data as second argument
	// I choose iterative approach to avoid stack space, So more memory efficient
	public static int search(Node root, int data){
	    int smaller = 0;
	    if(root==null)
	    return smaller;
	    
	    while(true){

			if(root == null){
	            System.out.print("this data is not present but smaller than this data numbers are"+" ");
	            return smaller;
	        }

	        if(root.val < data){
	            smaller += (root.leftCount+1);
	            root = root.right;
	        }else if(root.val > data){
	            root = root.left;
	        }else{
	            smaller += root.leftCount;
	            break;
	        }
	    }
	    return smaller;
	}//end of searchSmaller

	//3: Method to build tree
	public static Node buildBst(ArrayList<Integer> list){
	    Node root = null;
	    for(int x : list){
	        Node temp = new Node(x);
	        root = insert(root, temp);
	    }
	    return root;
	}

	//4: Method to insert data
	public static Node insert(Node root, Node temp){
	    if(root == null)
	    return temp;
	    Node curr = root;

	    while(true){
			if(curr.val == temp.val){         // if duplicate data is coming no need to insert
	            return root;
	        }
	        if(curr.val > temp.val && curr.left != null){
	            curr.leftCount++;
	            curr = curr.left;
	        }
	        else if(curr.val > temp.val && curr.left == null){
	            curr.leftCount++;
	            curr.left = temp;
	            break;
	        }
	        else if(curr.val < temp.val && curr.right != null){
	            curr = curr.right;
	        }
	        else if(curr.val < temp.val && curr.right == null){
	            curr.right = temp;
	            break;
	        }
	    }
	    return root;
		}//end of insert method
}//end of sullution1 class

// Time complexity::
// Let's say, n is number of disticnt value that is used to build tree
// BuildTree complexity: n*logn
// Search complexity : logn 
// Ovderall = n*logn + logn = nlogn

// Space compleaxity :
//it's constant because no Auxiliary space is used. there might be chance in search function if I could use recursive approach but 
//here i used iterative Approach

//Note Drawback: 
//if data is coming in increasing or decreasing order than binary search tree will become right skewed or left skewed.
//In this case all operation of binary search tree will become O(n) and overall time complexity will become O(n2)

//Solution:: height balancing binary Search tree must be used