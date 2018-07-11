// Basic tree traversal
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
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
	// Level Order Traversal
	public void levelOrder(BinaryTreeNode root) {
		
		if(root == null)
			return;
		
		BinaryTreeNode current = root;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(current);
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(current.value + " ");
			if(current.left != null)
				queue.add(current.left);
			if(current.right != null)
				queue.add(current.right);
				
		}
	}
	
	// Vertical Order Traversal
	public void vertialOrder(BinaryTreeNode root) {
		if(root == null)
			return;
		Queue<BinaryTreeNode> nodes = new LinkedList<>();
		Queue<Integer> horizontalDist = new LinkedList<>();
		
		Map<Integer, ArrayList<BinaryTreeNode>> map = new HashMap<>();
		nodes.add(root); 
		horizontalDist.add(0);
		
		while(!nodes.isEmpty()) {
			BinaryTreeNode current = nodes.poll();
			Integer hd = horizontalDist.poll();
			
			if(map.containsKey(hd)){
				ArrayList<BinaryTreeNode> temp = map.get(hd);
				temp.add(current);
				map.put(hd, temp);
			}
			else {
				ArrayList<BinaryTreeNode> temp = new ArrayList<>();
				temp.add(current);
				map.put(hd, temp);
			}

			if(current.left != null) {
				nodes.add(current.left);
				horizontalDist.add(hd-1);
			}
			if(current.right != null) {
				nodes.add(current.right);
				horizontalDist.add(hd+1);
			}
		}
		
	
		Set<Integer> set = map.keySet();
		List<Integer> list = new LinkedList<>();
		list.addAll(set);
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		for(Integer integer:list) {
			ArrayList<BinaryTreeNode> temp = map.get(integer);
			System.out.print(temp.get(0).value+" ");
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
	
	public BinaryTreeNode treeExample1() {
		BinaryTreeNode temp = getRoot();
		temp.value = 1;
		temp.left = new BinaryTreeNode(2);
		temp.right = new BinaryTreeNode(3);
		temp.left.left = new BinaryTreeNode(4);
		temp.left.right = new BinaryTreeNode(5);
		temp.right.left = new BinaryTreeNode(6);
		temp.right.right = new BinaryTreeNode(7);
		temp.right.left.right = new BinaryTreeNode(8);
		temp.right.right.right = new BinaryTreeNode(9);
		return temp;
		
	}
	
	public BinaryTreeNode treeExample2() {
		BinaryTreeNode temp = getRoot();
		temp.value = 1;
		temp.right = new BinaryTreeNode(2);
		temp.right.right = new BinaryTreeNode(5);
		temp.right.right.right = new BinaryTreeNode(6);
		temp.right.right.left = new BinaryTreeNode(3);
		temp.right.right.left.right = new BinaryTreeNode(4); 
		return temp;
	}

	
	public static void main(String[] args) {
		BinaryTreeNode temp = new BinaryTreeNode(1);
		BinaryTree binaryTree = new BinaryTree(temp);
		/*System.out.println("Pre Order Traversal");
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
		System.out.println();
		System.out.println("Level Order Traversal");
		binaryTree.levelOrder(binaryTree.treeExample());
		System.out.println();*/
		System.out.println("Vertical Order Traversal");
		binaryTree.vertialOrder(binaryTree.treeExample2());
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
