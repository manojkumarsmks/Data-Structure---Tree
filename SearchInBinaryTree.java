//Return true if you find the element in the binary tree
import java.util.Stack;

public class SearchInBinaryTree extends BinaryTree{
	
	//Recursively Find the Elements
	public static boolean FindElementRecursive(Node root, int element) {
		if(root != null) {
			if(root.data == element) {
				return true;
			}
			else {
				return FindElementRecursive(root.left, element) || FindElementRecursive(root.right, element);
			}
		}
		return false;
	}
	
	//Find Element Iteratively - using PreOrder
	public static boolean FindElementsPreOrder(Node root, int element) {
		Node current = root;
		Stack <Node> stack = new Stack<Node>();
		
		if(root == null) {
			return false;
		}
		else {
			stack.add(current);
		}
		
		while(!stack.isEmpty()) {
			current = stack.pop();
			
			if(current.data == element)
				return true;
			if(current.right!= null) {
				stack.push(current.right);
			}
			if(current.left != null) {
				stack.push(current.left);
			}
		}
		
		return false;
	}
	
	// Find Element Iteratively - using InOrder
	public static boolean FindElementsInOrder(Node root, int element) {
		Node current = root;
		Stack<Node> stack = new Stack<Node> ();
		int max = Integer.MIN_VALUE;
		
		while(true) {
			if(current!= null) {
				if(current.data == element)
					return true;
				stack.push(current);
				current = current.left;
			}
			else {
				if(stack.isEmpty())
					break;
				else {
					current = stack.pop();
					System.out.println("Current data "+current.data);
					current = current.right;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		SearchInBinaryTree searchInBinaryTree = new SearchInBinaryTree();
		//System.out.println(FindElementsPreOrder(searchInBinaryTree.BinaryTree1(), 8));
		System.out.println(FindElementsPreOrder(searchInBinaryTree.BinaryTree2(), 145));
	}

}
