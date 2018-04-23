// Find the Height of the tree
import java.util.LinkedList;
import java.util.Queue;


public class HeightOfTheTree extends BinaryTree{
	
	// Height of the tree - Recursively
	public static int heightRecursively(Node root) {
		if(root != null) {
			//Get the height of the left tree
			int leftHeight = heightRecursively(root.left);
			//Get the height of the right tree
			int rightHeight = heightRecursively(root.right);
			
			//Return the one that's larger
			return Math.max(leftHeight, rightHeight) + 1;
		}
		return 0;
	}
	
	// Height of the tree Iteratively
	public static int heightIteratively(Node root) {
		Node current = root;
		// Level Order Traversal
		Queue<Node> queue = new LinkedList<Node>();
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

	public static void main(String[] args) {
		System.out.println(heightIteratively(BinaryTree2()));
	}

}
