// Basic tree traversal
import java.util.Stack;

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
			System.out.print(root.value + " ");
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
			System.out.print(temp.value + " ");
			
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
	}
	
	// In order Traversal
	public void inOrderTraversal(BinaryTreeNode root) {
		if(root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.value + " ");
			inOrderTraversal(root.right);
		}
	}
	
	// In Order Iterative
	public void inOrder(BinaryTreeNode root) {
		if(root == null)
			return;
		BinaryTreeNode temp = root;
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(temp);
		
		while(true) {
			if(temp.left != null) {
				stack.push(temp.left);
				temp = temp.left;
			}
			else {
				if(stack.isEmpty())
					break;
				else {
					System.out.print(stack.pop().value + " ");
					temp = temp.right;
				}
			}
		}
	}
	
	// Post Order Traversal
	public void postOrderTraversal(BinaryTreeNode root) {
		if(root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.value + " ");
		}
	}
	
	public void postOrderI(BinaryTreeNode root) {
		if(root == null)
			return;
		BinaryTreeNode current = root;
		Stack<BinaryTreeNode> stackOne = new Stack<>();
		Stack<BinaryTreeNode> stackTwo = new Stack<>();
		stackOne.push(root);
		
		while(!stackOne.isEmpty()) {
			current = stackOne.pop();
			stackTwo.push(current);
			if(current.left != null)
				stackOne.push(current);
			if(current.right != null)
				stackTwo.push(current);
		}
		
		while(!stackTwo.isEmpty())
			System.out.println(stackTwo.pop().value);
		
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
		System.out.println();
		System.out.println("Pre Order Traversal Iteratively");
		binaryTree.preOrderIterative(binaryTree.treeExample());
		System.out.println();
		System.out.println("In Order Traversal");
		binaryTree.inOrderTraversal(binaryTree.treeExample());
		System.out.println();
		System.out.println("In Order Traversal Iteratively");
		binaryTree.inOrderTraversal(binaryTree.treeExample());
		System.out.println();
		System.out.println("Post Order Traversal");
		binaryTree.postOrderTraversal(binaryTree.treeExample());
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
