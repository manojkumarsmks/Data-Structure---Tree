// Find the number of nodes of a binary tree
public class SizeOfATree extends BinaryTree{
	
	public int Size(Node root) {
		
		if(root == null) {
			return 0;
		}
		System.out.println(root.data );
		int leftSize = Size(root.left);
		int rightSize = Size(root.right);
		
		return leftSize + rightSize +1;
				
	}
	
	public static void main(String[] args) {
		SizeOfATree sizeOfATree = new SizeOfATree();
		Node root = sizeOfATree.BinaryTree3();
		System.out.println(sizeOfATree.Size(root));
	}
	
}
