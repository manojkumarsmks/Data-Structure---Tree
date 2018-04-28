// Given two binary Trees, return true if they are structurally identical 
import java.util.Stack;

public class StructuralIdenticalTree extends BinaryTree {

	// Recursive method to check if two trees are Identical
	public static boolean StructurallySameTree(Node rootOne, Node rootTwo) {
		if (rootOne == null && rootTwo == null) {
			return true;
		}
		if ((rootOne == null && rootTwo != null) || (rootOne != null && rootTwo == null)) {
			return false;
		}
		else {
			boolean leftTree = StructurallySameTree(rootOne.left, rootTwo.left);
			boolean rightTree = StructurallySameTree(rootOne.right, rootTwo.right);

			if (rootOne.equals(rootTwo))
				return true;
			else
				return false;
		}
	}

	
	// Iterative method to check if two trees are Identical
	public static boolean StructurallySameIterative(Node rootOne, Node rootTwo) {
		Stack<Node> stackOne = new Stack<Node>();
		Stack<Node> stackTwo = new Stack<Node>();

		if (rootOne == null & rootTwo == null)
			return true;
		if (rootOne.data != rootTwo.data)
			return false;
		if (rootOne != null)
			stackOne.add(rootOne);
		if (rootTwo != null)
			stackTwo.add(rootTwo);

		while ((!stackOne.isEmpty()) && (!stackTwo.isEmpty())) {
			Node currentOne = stackOne.pop();
			Node currentTwo = stackTwo.pop();

			if ((!stackOne.isEmpty() && stackTwo.isEmpty()) || (stackOne.isEmpty() && !stackTwo.isEmpty()))
				return false;
			
			if(((currentOne.left == null) && (currentTwo.left != null)) ||
					((currentOne.left != null) && (currentTwo.left == null)) ||
					((currentOne.right == null) && (currentTwo.right != null)) ||
					((currentOne.right != null) && (currentTwo.right == null))) 
				return false;
			
			if (currentOne.left != null && currentTwo.right != null) {
				if (currentOne.left.data != currentTwo.left.data)
					return false;
				else {
					stackOne.push(currentOne.left);
					stackTwo.push(currentTwo.left);
				}
			}

			if (currentOne.right != null && currentTwo.right != null) {
				if (currentOne.right.data != currentOne.right.data)
					return false;
				else {
					stackOne.push(currentOne.right);
					stackTwo.push(currentTwo.right);
				}
			}
		}
		return true;
	}
}
