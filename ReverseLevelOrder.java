// Print Level order from the last level to first
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder{

	public static void ReverseLevelOrderTraversal(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node current = root;	
		Queue <Node> queue = new LinkedList<Node>();
		if(root != null)
			queue.add(current);
		// put the node into the queue
		// push the same node into the stack
		while(!queue.isEmpty()) {
			current = queue.poll();
			stack.push(current);
			
			// check the right of the current node first 
			// and then to the left 
			if(current.right != null)
				queue.add(current.right);
			if(current.left != null)
				queue.add(current.left);
			
		}
		
		// print out the data in the stack
		while(!stack.isEmpty())
			System.out.println(stack.pop().data);
	}
}
