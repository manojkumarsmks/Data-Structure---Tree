import java.util.Stack;

// Find the maximum in a binary tree
public class MaxOfATree extends BinaryTree{

	
	public static int Max(Node root) {
		int max = Integer.MIN_VALUE;
		
		if(root != null) {
			int maxLeft = Max(root.left);
			int maxRight = Max(root.right);
			
			if(maxRight < maxLeft)
				max  = maxLeft;
			if(maxRight >= maxLeft)
				max = maxRight;
		}
		return max;
	}
	
	public static int MaxIteratively(Node root) {
		Node current = root;
		Stack <Node> stack = new Stack<Node>();
		int size =0;
		if(current == null) {
			return size;
		}
		while(true) {
			if(current != null) {
				//System.out.println(current.data);
				if(current.right !=null) {
					stack.add(current.right);
					size++;
				}
				if(current.left != null) {
					current = current.left;
					size++;
				}
				else {
					if(stack.isEmpty()) {
						break;
					}
					current = stack.pop();
				}
			}
		}
		
		return size+1;
	}
	
	
	public static void main(String[] args) {
		MaxOfATree maxOfATree = new MaxOfATree();
		System.out.println(MaxIteratively(maxOfATree.BinaryTree1()));
	}

}
