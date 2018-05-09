//Given an element insert the element into the binary tree and return the root of the tree
public class InsertIntoBinaryTree extends BinaryTree {

	public static Node InsertIteratively(Node root, int element) {
		Node current = null;

		// If there is no tree, than new element is the root
		if (root == null) {
			current = new Node(element);
			return current;
		} else {
			current = root;
		}

		// Find the position in the tree where the new Node fits
		while (true) {
			// traverse left if the new element is less than the current one
			if (current.data < element) {
				if (current.right != null)
					current = current.right;
				else
					break;
			}
			// traverse right if the new element is greater that the current one
			else if (current.data > element) {
				if (current.left != null)
					current = current.left;
				else
					break;
			}
		}

		// Current represent the parent of the new element
		if (current.data > element)
			current.left = new Node(element);
		else
			current.right = new Node(element);

		// return the root
		return root;
	}

	public static Node InsertRecursively(Node root, int element) {
		
		if(root == null) {
			root = new Node(element);
			return root;
			
		}
		if(root.data < element)
			return InsertRecursively(root.left, element);
//		if(root.data > element)
		else
			return InsertIteratively(root.right, element);
	}
	
	public static void main(String[] args) {
		InsertRecursively(BinaryTree1(), 200);
	}
}
