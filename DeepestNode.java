// Algorithm to find the deepest node of the binary tree
// Time Complexity - O(n)
// Space Complexity - O(n)
// Problem 14 
import java.util.LinkedList;
import java.util.Queue;

public class DeepestNode {
	
	public static Node DeepestNode(Node root) {
		Node current, temp = null;
		Queue<Node> queue = new LinkedList<Node>();

		if(root == null) {
			return null;
		}
		current = root;
		queue.add(current);
		// The last element in the queue is the deepest element
		while(!queue.isEmpty()) {
			temp = queue.poll();
			if(temp.left != null) {
				queue.add(temp.left);
			}
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
		return temp;		
	}


	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		System.out.println(DeepestNode(binaryTree.BinaryTree2()).data);

	}

}
