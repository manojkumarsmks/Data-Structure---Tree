// Find the number of nodes of a binary tree	
// Problem 6 and 7
import java.util.LinkedList;
import java.util.Queue;

public class SizeOfATree extends BinaryTree{
	
	
	// Recursive approach
	public int Size(Node root) {	
		if(root == null) {
			return 0;
		}
		int leftSize = Size(root.left);
		int rightSize = Size(root.right);
		
		return leftSize + rightSize +1;		
	}
	
	// Iterative method to count the size of the tree
	public int SizeInterativel(Node root) {
		Node current = root;
		Queue<Node> queue = new LinkedList<Node>();
		int counter = 0;
		if(current != null) {
			queue.add(current);
		}
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			counter++;
			if(current.left != null)
				queue.add(current.left);
			if(current.right !=  null) 
				queue.add(current.right);
		}
		
		return counter;
	}
	
	public static void main(String[] args) {
		SizeOfATree sizeOfATree = new SizeOfATree();
		Node root = sizeOfATree.BinaryTree2();
		System.out.println(sizeOfATree.Size(root));
	}
	
}
