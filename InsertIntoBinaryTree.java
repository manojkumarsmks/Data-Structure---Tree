//Given an element insert the element into the binary tree and return the root of the tree
public class InsertIntoBinaryTree{
	
	public static Node Insert(Node root, int element) {
		Node newNode = new Node(element);
		Node temp = root;
		
		//If the root is null, no tree at all
		if(root == null) {
			root = newNode;
			return root;
		}
		
		while(true) {
			//Go left if the node to be inserted is less than the current one
			if(temp.data > element) {
				if(temp.left != null)
					temp = temp.left;
				else
					break;
			}
			//Go right if the node to be inserted is more than the current one
			else {
				if(temp.right != null)
					temp = temp.right;
				else
					break;
			}
		}
		
		// Insert the Node based on th value
		if(temp.data > element) 
			temp.left = newNode;
		else
			temp.right = newNode;
		
		return root;		
	}

}
