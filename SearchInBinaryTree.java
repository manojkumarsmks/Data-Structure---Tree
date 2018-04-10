import java.util.Stack;

//Return true if you find the element in the binary tree
public class SearchInBinaryTree extends BinaryTree{
	
	//Recursively Find the Elements
	public static boolean FindElementRecursive(Node root, int element) {
		if(root != null) {
			if(root.data == element) {
				return true;
			}
			else {
				return FindElementRecursive(root.left, element) || FindElementRecursive(root.right, element);
			}
		}
		return false;
	}
	
	//Find Element Iteratively - using Pre-Order
	public static boolean FindElementsPreOrder(Node root, int element) {
		Node current = root;
		Stack <Node> stack = new Stack<Node>();
		
		if(root == null) {
			return false;
		}
		while(true) {
			if(current.data == element) {
				return true;
			}
			else {
				if(current.right != null) {
					stack.push(current.right);
				}
				if(current.left != null) {
					current = current.left;
				}
				else {
					if(!stack.isEmpty())
						return false;
					current = stack.pop();
				}
			}
		}
	}
	
	//Find Element Iteratively - Using InOrder
	
	
	public static void FindElementsInOrder(Node root, int element) {
		Node current = root;
		Stack<Node> stack = new Stack<Node> ();
		
		while(true) {
			if(current.right != null) {
				stack.push(current.right);
			}
			if(current.left != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				System.out.println(current.data);
			}
		}
	}

	public static void main(String[] args) {
		SearchInBinaryTree searchInBinaryTree = new SearchInBinaryTree();
		//System.out.println(FindElementsPreOrder(searchInBinaryTree.BinaryTree1(), 8));
		FindElementsInOrder(searchInBinaryTree.BinaryTree2(), 10);
	}

}
