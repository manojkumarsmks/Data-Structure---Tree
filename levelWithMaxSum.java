import java.util.LinkedList;
import java.util.Queue;

// Finding the level that has the maximum sum in the binary tree
public class levelWithMaxSum extends BinaryTree{

	
	public static int findLevelWithMaxSum(Node root) {
		Node current = root;
		Queue<Node> queue = new LinkedList<Node>();
		int level = 0, levelSum = current.data, currentSum = current.data;
		if(current == null)
			return 0;
		else {
			queue.offer(current);
			queue.offer(null);
		}
		
		
		while(!queue.isEmpty()) {
			
			current = queue.poll();
			System.out.println(current.data);
			
			if(queue.isEmpty())
				break;
			if(current == null) {	
				level++;
				queue.offer(null);
			}
			else {
				
				currentSum = currentSum + current.data;
				
				if(current.left != null)
					queue.add(current.left);
				if(current.right != null)
					queue.add(current.right);
			}
		}
		return levelSum;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
