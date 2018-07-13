// Find the Height of the tree
//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/#
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class HeightOfTheTree extends BinaryTree{
	
	// Height of the tree - Recursively
	public static int heightRecursively(BinaryTreeNode root) {
		int height = 0;
		if(root != null) {
			int leftHeight = heightIteratively(root.left);
			int rightHeight = heightIteratively(root.right);
			
			height = Math.max(leftHeight, rightHeight) +1;
		}
		return height;
		
	}
		
	
	// Height of the tree Iteratively
	public static int heightIteratively(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		// Level Order Traversal
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		int counter = 0;
		
		// Using null as a separator of the levels
		if(current != null) {
			queue.add(current);
			queue.add(null);
		}
		
		
		while(true) {
			current = queue.poll();
	
			// Add a null to the queue when encountered with a null
			if(current == null) {
				counter++;
				if(queue.isEmpty())
					break;
				current = queue.poll();
				queue.offer(null);
			}
			
			if(current.left != null)
				queue.add(current.left);
			if(current.right != null)
				queue.add(current.right);

		}
		return counter;
	}
	
	// Height of the tree using stack - yet to be done 
	public static int heightIterativeUsingStack(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		Stack <BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		int heightCounter = 0;
		
		if(root != null) {
			current = root;
			stack.add(current);
			stack.add(null);
		}
		return heightCounter;
		
	}
	

	public static void main(String[] args) {
		HeightOfTheTree heightOfTheTree = new HeightOfTheTree();
		heightOfTheTree.setRoot(new BinaryTreeNode(1));
		System.out.println(heightRecursively(heightOfTheTree.treeExample1()));
	}

}
