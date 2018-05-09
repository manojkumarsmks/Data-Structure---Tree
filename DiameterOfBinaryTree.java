// Find the diameter of a binary tree
public class DiameterOfBinaryTree extends BinaryTree{
	
	
	public int DiameterOfBinaryTree(Node root) {
		
		int leftDepth = 0, rightDepth = 0;
		if(root == null)
			return 0;
		else {
			Node current = root;
			
			if(current.left == null && current.right == null)
				return 1;
			while(true) {
				if(current.left == null)
					current = current.right;
				else {
					leftDepth = heightOfBinaryTree(current.left);
					break;
				}
			}
			while(true) {
				if(current.right == null)
					current = current.left;
				else {
					rightDepth = heightOfBinaryTree(current.right);
					break;
				}
			}
		}
		
		return leftDepth +rightDepth;
		
	}
	
	
	public int heightOfBinaryTree(Node root) {
		
		if(root == null)
			return 0;
		else {
			int heightLeft = heightOfBinaryTree(root.left);
			int heightRight = heightOfBinaryTree(root.right);
			
			return Math.max(heightLeft, heightRight) +1;
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
