	// Give an algorithm to delete the tree
public class DeleteTheTree extends BinaryTree{
	
	// Recursive approach
	public static void DeleteTree(Node root) {
		
		if(root != null) {
			DeleteTree(root.left);
			DeleteTree(root.right);
			
			root = null;
		}
	}
	
}
