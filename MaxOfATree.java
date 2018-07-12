import java.util.Stack;

// Find the maximum in a binary tree

public class MaxOfATree extends BinaryTree{
	
	// Recursively 
	public int maxOfBST(BinaryTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if(root != null) {
			int leftMax = maxOfBST(root.left);
			int rightMax = maxOfBST(root.right);
			if(leftMax > rightMax)
				maxValue = leftMax;
			else if(leftMax < rightMax)
				maxValue = rightMax;
			
			if(root.value > maxValue)
				maxValue = root.value;
		}
		return maxValue;
	}
	
	// Iterative 
	public int maxOfBSTItr(BinaryTreeNode root) {
		if(root == null)
			return -1;
		
		Stack<BinaryTreeNode> stackOne = new Stack<>();
		Stack<BinaryTreeNode> stackTwo = new Stack<>();
		BinaryTreeNode current = root;
		stackOne.push(current);
		
		while(!stackOne.isEmpty()) {
			current = stackOne.pop();
			stackTwo.push(current);
			if(current.left != null)
				stackOne.push(current.left);
			if(current.right != null)
				stackOne.push(current.right);
		}
		int max = stackTwo.pop().value;
		while(!stackTwo.isEmpty()) {
			current = stackTwo.pop();
			if(max < current.value)
				max = current.value;
		}
		
		return max;
		
	}
	
	public static void main(String[] args) {
		MaxOfATree maxOfATree = new MaxOfATree();
		maxOfATree.setRoot(new BinaryTreeNode(1));
		System.out.println(maxOfATree.maxOfBST(maxOfATree.treeExample()));
		System.out.println(maxOfATree.maxOfBSTItr(maxOfATree.treeExample1()));
	}

}


