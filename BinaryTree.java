import java.util.Stack;

// Basic tree traversal
public class BinaryTree {
	
	private BinaryTreeNode root;
	
	// constructor
	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}
	// setter and getter
	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	public BinaryTreeNode getRoot() {
		return root;
	}
	
	// Pre-order traversal recursive
	public void preOrderTraversal(BinaryTreeNode root) {
		if(root != null) {
			System.out.println(root.value);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	// Pre-order traversal iteratively
	public void preOrderIterative(BinaryTreeNode root) {
		if(root == null)
			return;
		BinaryTreeNode rootTemp = root;
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(rootTemp);
		
		while(!stack.isEmpty()) {
			BinaryTreeNode temp = stack.pop();
			System.out.println(temp.value);
			
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
	}
	
	public BinaryTreeNode treeExample() {
		BinaryTreeNode temp = getRoot();
		temp.value = 1;
		temp.left = new BinaryTreeNode(2);
		temp.right = new BinaryTreeNode(3);
		temp.left.left = new BinaryTreeNode(4);
		temp.left.right = new BinaryTreeNode(5);
		temp.right.left = new BinaryTreeNode(6);
		temp.right.right = new BinaryTreeNode(7);
		return temp;
	}

	
	public static void main(String[] args) {
		BinaryTreeNode temp = new BinaryTreeNode(1);
		BinaryTree binaryTree = new BinaryTree(temp);
		System.out.println("Pre Order Traversal");
		binaryTree.preOrderTraversal(binaryTree.treeExample());
		System.out.println("Pre Order Traversal Iteratively");
		binaryTree.preOrderIterative(binaryTree.treeExample());
		
	}
}

// Binary Tree Nodes class
class BinaryTreeNode {
	public int value;
	public  BinaryTreeNode left;
	public BinaryTreeNode right;
	
	public BinaryTreeNode(int value) {
		this.value = value;
	}

}
