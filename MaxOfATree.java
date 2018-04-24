// Find the maximum in a binary tree
import java.util.Stack;

public class MaxOfATree extends BinaryTree{
	
	// Max - Recursively
	public static int MaxRecursively(Node root) {
		int max = Integer.MIN_VALUE;
		if(root != null) {
			int left = MaxRecursively(root.left);
			int right = MaxRecursively(root.right);
			
			if(left > right)
				max = left;
			if(right > left)
				max = right;
			if(root.data > max)
				max = root.data;
		}
		
		return max;
	}
	
	// InOrder Traversal for Maximum Tree
	// InOrder method
	public static int MaxInterativelyInOrder(Node root) {
		Node current = null;
		int max = Integer.MIN_VALUE;
		Stack<Node> stack = new Stack<Node>();
		if(root != null)
			current = root;
		else 
			return max;
		
		while(true) {
			
			if(current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				if(stack.isEmpty())
					break;
				current = stack.pop();
				if(current.data > max)
					max = current.data;
				current = current.right;
			}
		}
		return max;
	}
	
	

	// Traverse the tree, keep replacing the max value
	// PreOrder method
	public static int MaxIterativelyPreOrder(Node root) {
		int max = Integer.MIN_VALUE;
		Node current = null;
		Stack<Node> stack = new Stack<Node>();
		if(root != null) {
			current = root;
			stack.add(current);
		}
		else {
			return max;
		}
		while(!stack.isEmpty()) {
			current = stack.pop();
			if(current.data > max)
				max = current.data;
			if(current.right != null)
				stack.add(current.right);
			if(current.left != null)
				stack.add(current.left);		
		}
		
		return max;
	}
	
	public static void main(String[] args) {
			System.out.println(MaxInterativelyInOrder(BinaryTree.BinaryTree3()));
	}
}
