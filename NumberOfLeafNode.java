import java.util.LinkedList;
import java.util.Queue;

// Find the number of leaves in the binary tree
public class NumberOfLeafNode extends BinaryTree{

	public static void main(String[] args) {
		System.out.println(noOfLeafNodesRecursively(BinaryTree3()));
	}
	
	// Number of Leaf Nodes - Iteratively
	public static int noOfLeafNodes(Node root) {
		Node current = null;
		Queue<Node> queue= new LinkedList<Node>();
		int leafCounter = 0;
		if(root == null)
			return 0;
		else {
			current = root;
			queue.add(current);
		}
		
		// Leave Order traversal
		while(!queue.isEmpty()) {
			current = queue.poll();
			// Counter for leaf nodes
			if((current.left == null) && (current.right == null))
				leafCounter++;
			
			if(current.left != null)
				queue.add(current.left);
			if(current.right != null)
				queue.add(current.right);
			
		}
		return leafCounter;
	}
	
	// Number of Leaf Nodes  - Recursively
	public static int noOfLeafNodesRecursively(Node root) {
		if(root == null)
			return 0;
		// counter for the leaf nodes
		if(root.left == null && root.right == null)
			return 1;
		else  {
			int left = noOfLeafNodesRecursively(root.left);
			int right = noOfLeafNodesRecursively(root.right);
			
			return left+right;
		}
	}

}
