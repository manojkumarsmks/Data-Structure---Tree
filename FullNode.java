// Find the number of full nodes in the binary tree
// Problem 17
import java.util.LinkedList;
import java.util.Queue;

public class FullNode {

	
	// Iterative method to get the number of full nodes
	public static int NumberOfNodes(Node root) {
		Node current = null;
		int count = 0;
		Queue<Node> queue = new LinkedList<Node>();
		if(root != null)
			queue.add(root);
		while(!queue.isEmpty()) {
			current = queue.poll();
			
			if((current.left != null) && (current.right != null)) {
				count++;
				queue.add(current.left);
				queue.add(current.right);
			}
			else {
				if(current.left != null)
					queue.add(current.left);
				if(current.right != null)
					queue.add(current.right);
			}
		}
		
		return count;
	}
	
	// Recursive method to get hte number of full nodes
	public static int NumberOfNodesRecursively(Node root) {
		if((root.left != null) && (root.right != null)) {
			return 1 + NumberOfNodes(root.left) + NumberOfNodes(root.right);
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		BinaryTree binaryTree = new BinaryTree();
		
		System.out.println(NumberOfNodesRecursively(binaryTree.BinaryTree3()));

	}

}
