// Basic tree traversals
// PreOrder
// PostOrder
// InOrder
// LevelOrder
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	static Node root = null;
	
	//PreOrder Traversal - Recursion
	public static void PreOrderRecursive(Node root) {
		if(root == null)
			return;
		else {
			System.out.println(root.data);
			PreOrderRecursive(root.left);
			PreOrderRecursive(root.right);
		}			
	}
	
	//PreOrder traversal Iteratively - Using stack
	public static void PreOrderIteratively(Node root) {
		Stack<Node> stack = new Stack<Node>();
		if(root != null)
			stack.push(root);
		
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.println(current.data);
			if(current.right != null)
				stack.push(current.right);
			if(current.left != null)
				stack.push(current.left);
				
		}
	}
	//InOrder Traversal - Recursion
	public static void InOrderRecursively(Node root) {
		if(root == null) {
			return;
		}
		else {
			InOrderRecursively(root.left);
			System.out.println(root.data);
			InOrderRecursively(root.right);
		}
	}
	
	//InOrder Traversal - Using stack something is wrong
	public void InOrderIteratively(Node root) {
		Node current = root;
		Stack <Node> stack = new Stack<Node>();
		if(current != null)
			stack.push(current);
		
		while(current != null) {
			stack.push(current);
			current = current.left;
		}
		
		while(!stack.isEmpty()) {
			current = stack.pop();
			System.out.println(current.data); 
			 
			if(current.right != null) {
				current = current.right;
			}
			
			while(current != null) {
				stack.push(current);
				current = current.left;
			}	
		}
	}
	
	//PostOrder Traversal - Recursion
	public static void PostOrderRecursive(Node root) {
		if(root == null) {
			return;
		}
		else {
			PostOrderRecursive(root.left);
			PostOrderRecursive(root.right);
			System.out.println(root.data);
		}
	}
	
	//PostOrder Traversal  Iteratively - Using stack
	public static void PostOrderIteratively(Node root) {
		Stack <Node> s1 = new Stack<Node>();
		Stack <Node> s2 = new Stack<Node>();
		
		if(root != null)
			s1.push(root);
		
		while(!s1.isEmpty()) {
			
			Node current = s1.pop();
			s2.push(current);		
			
			if(current.left != null)
				s1.push(current.left);
			
			if(current.right != null)
				s1.push(current.right);
		}
		
		while(!s2.isEmpty()) {
			System.out.println(s2.pop().data);
		}
	}
	
	
	// Level Traversal 
	public static void LevelOrderTraversal(Node root) {
		Node current = root;	
		Queue <Node> queue = new LinkedList<Node>();
		if(root != null)
			queue.add(current);
		
		while(!queue.isEmpty()) { 
			current = queue.poll();
			System.out.println(current.data );
			if(current.left != null)
				queue.add(current.left);
			if(current.right != null)
				queue.add(current.right);
		}
	}
	
	// For Testing - Binary Tree 3
	public static Node BinaryTree3() {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.root = new Node(1);
		binaryTree.root.right = new Node(2);
		binaryTree.root.right.right = new Node(5);
		binaryTree.root.right.right.right = new Node(6);
		binaryTree.root.right.right.left = new Node(3);
		binaryTree.root.right.right.left.right = new Node(4);
		
		return BinaryTree.root;
	}
	
	// For Testing - Binary Tree 2
	public static Node BinaryTree2() {
		/*			15
		 * 		   /  \
		 * 		  35    65
		 * 		 / \     \ 
		 *		25  45    75
		 *			/ \
		 *	       87 88  
		 * */
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.root = new Node(15);
		binaryTree.root.left = new Node(35);
		binaryTree.root.right = new Node(65);
		binaryTree.root.left.left = new Node(25);
		binaryTree.root.left.right= new Node(45);
		binaryTree.root.left.right.left = new Node(87);
		binaryTree.root.left.right.right =new Node(88);
		binaryTree.root.right.right = new Node(75);
		
		return BinaryTree.root;
	}
	
	// For Testing - Binary Tree 1
	public static Node BinaryTree1() {
		
		/*			10
		 * 		   /  \
		 * 		  8    12
		 * 		 / \   / \ 
		 *		6   9 11 14
		 *	   /
		 *	  1
		 *		    	 
		 * */
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.root = new Node(10);
		binaryTree.root.left = new Node(8);
		binaryTree.root.right = new Node(12);
		binaryTree.root.left.left = new Node(6);
		binaryTree.root.left.right= new Node(9);
		binaryTree.root.right.left = new Node(11);
		binaryTree.root.right.right =new Node(14);
		
		
		return BinaryTree.root;
		
	}
	
	public static void main(String[] args) { 
		
		BinaryTree binaryTree = new BinaryTree();
		PostOrderIteratively(BinaryTree1());
	}
}

// Structure of a node
class Node {
	Node left = null;
	Node right = null;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
}