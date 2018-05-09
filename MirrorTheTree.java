// Convert a tree to its mirror and check weather if two trees are mirror of each other
public class MirrorTheTree extends BinaryTree{
	
	public static Node mirrorTree(Node root) {
		
		if(root != null) {
			mirrorTree(root.left);
			mirrorTree(root.right);
			
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
		
	}
	
	// Check if two trees are mirror of each other
	public static Boolean checkMirror(Node root1, Node root2) {
		
		if(root1 == null && root2 == null)
			return true;
		if(root2 == null && root1 != null)
			return false;
		if(root1.data != root2.data)
			return false;
		
		else 
			return (checkMirror(root1.left, root2.right) 
					&& checkMirror(root1.right, root2.right));
	}
 
	public static void main(String[] args) {
		BinaryTree.PreOrderIteratively(BinaryTree.BinaryTree3());
		System.out.println("----------------");
		Node root = mirrorTree(BinaryTree.BinaryTree3());
		BinaryTree.PreOrderIteratively(root);

	}

}
