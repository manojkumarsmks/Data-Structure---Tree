// Find an algorithm for finding the number of half nodes in the binary tree
import java.util.Stack;

public class FindHalfNodes extends BinaryTree{
	
	public static int HalfNodeCounter(Node root) {
		Node current;
		Stack<Node> stack = new Stack<Node>();
		int counter = 0;
		
		if(root != null) {
			current = root;
			stack.push(current);
		}
		else { 
			return 0;
		}
		
		while(!stack.isEmpty()) {
			current = stack.pop();
			
			System.out.println("Current data "+current.data);
			
			if((current.left == null && current.right != null) || 
					(current.left != null && current.right == null)) {
				System.out.println("Current data is "+current.data);
				counter++;
			}
			if(current.right != null)
				stack.push(current.right);
			if(current.left != null) 
				stack.push(current.left);
		}
		return counter;
	}

	public static void main(String[] args) {
		
		System.out.println(HalfNodeCounter(BinaryTree.BinaryTree2()));

	}

}
