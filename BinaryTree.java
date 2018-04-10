import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	static Node root = null;
	
	
	public static void PreOrderRecursive(Node root) {
		if(root == null)
			return;
		else {
			System.out.println(root.data);
			PreOrderRecursive(root.left);
			PreOrderRecursive(root.right);
		}			
	}
	
	public static void PreOrderIterative(Node root) {
		Node current = root;
		Stack <Node> stack = new Stack <Node>(); 
		stack.push(current);
		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.println(temp.data);
			
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
	
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
	
	public static void InOrderIterative(Node root) {
		Node current = root;
		Stack <Node> stack = new Stack<Node>();
		while(true) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				if(stack.isEmpty())
					break;
				else {
					current = stack.pop();
					System.out.println(current.data);
					current = current.right;
				}
			}
		}
	}
	
	public static void LevelOrderTraversal(Node root) {
		Node current = root;		
	}
	
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
	
	public static void SizeBinaryTree(Node root, int count) {
		if(root == null) {
			return;
		}
		else {
			SizeBinaryTree(root.left, count );

			count++;
			System.out.println(root.data + " "  +count);
			
			SizeBinaryTree(root.right, count);
		}
	}
	
	public static Node BinaryTree1() {
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
	
	public static Node BinaryTree2() {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.root = new Node(19);
		binaryTree.root.left = new Node(17);
		binaryTree.root.right = new Node(25);
		binaryTree.root.left.left = new Node(15);
		binaryTree.root.left.right= new Node(18);
		binaryTree.root.left.left.left = new Node(14);
		binaryTree.root.right.left =new Node(22);
		binaryTree.root.right.left.left = new Node(20);
		binaryTree.root.right.left.right = new Node(23);
		
		return BinaryTree.root;
	}
	
	
	public static void main(String[] args) {
		
		/*			10
		 * 		   /  \
		 * 		  8    12
		 * 		 / \   / \ 
		 *		6   9 11 14
		 * */
		
		BinaryTree binaryTree = new BinaryTree();
		SizeBinaryTree(BinaryTree3(), 0);
		
		
		
		
	}
}

class Node {
	Node left = null;
	Node right = null;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
}