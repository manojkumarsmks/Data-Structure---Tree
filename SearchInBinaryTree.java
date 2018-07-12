import java.util.Stack;

//Return true if you find the element in the binary tree
public class SearchInBinaryTree extends BinaryTree{
	
	// Recursive 
	public boolean searchRecursively(BinaryTreeNode root, int data) {
		if(root != null) {
			
			if(root.value == data) 
				return true;
			
			boolean left = searchRecursively(root.left, data);
			boolean right = searchRecursively(root.right, data);
			
			return left || right;
		}
		return false;
			
	}
	
	// PreOrder Search
	public boolean searchPreOrderItr(BinaryTreeNode root, int data) {
		if(root == null)
			return false;
		
		BinaryTreeNode current = root;
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(current);
		
		while(!stack.isEmpty()) {
			current =stack.pop();
			if(current.value == data)
				return true;
			
			if(current.right != null)
				stack.push(current.right);
			if(current.left != null)
				stack.push(current.left);
			
		}
		return false;

	}

	public static void main(String[] args) {
		SearchInBinaryTree searchInBinaryTree = new SearchInBinaryTree();
		searchInBinaryTree.setRoot(new BinaryTreeNode(1));
		System.out.println(searchInBinaryTree.searchPreOrderItr(searchInBinaryTree.treeExample(), 7));
		System.out.println(searchInBinaryTree.searchRecursively(searchInBinaryTree.treeExample(), 17));
	}

}
