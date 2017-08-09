/**
 * implementation of the binary tree interface
 * 
 * @author Nada-Al-Thawr
 *
 * @param <T>
 */
public class DefaultBinaryTree<T> implements BinaryTree<T> {

	LinkedList<T> inOrderTraversal = new LinkedList<T>();
	LinkedList<T> preOrderTraversal = new LinkedList<T>();
	LinkedList<T> postOrderTraversal = new LinkedList<T>();
	// create an instance of binary tree node
	protected BinaryTreeNode<T> root;
	// create a new instance of linked list
	LinkedList<T> treeList = new LinkedList<T>();
	// creating an instance of binary tree
	private static BinarySearchTree<String> dwarfTree = new DefaultBinarySearchTree<>();

	/**
	 * Gets the root if it's not empty
	 * 
	 * @return root
	 */
	public BinaryTreeNode<T> getRoot() {
		// if the root is empty
		// return null
		if (root == null)
			return null;

		else
			// else return the root
			return root;
	}

	/**
	 * @param root
	 *            sets the root for this tree
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		// set this root as the root of the tree
		this.root = root;

	}

	/**
	 * checks if the tree is empty
	 */
	public boolean isEmpty() {
		// if the root is empty
		if (getRoot() == null)
			// return true to isEmpty
			return true;

		else
			// esle return false
			return false;
	}

	/**
	 * Get the data of this tree using inorder traversal.
	 * 
	 * @return inorder List.
	 */
	public LinkedList<T> inorderTraversal() {

		inorderTraversal(root, inOrderTraversal);
		return inOrderTraversal;
	}

	/**
	 * Get the data of this tree using preorder traversal.
	 * 
	 * @return preorder List.
	 */
	public LinkedList<T> preorderTraversal() {

		inorderTraversal(root, preOrderTraversal);
		return preOrderTraversal;
	}

	/**
	 * Get the data of this tree using postorder traversal.
	 * 
	 * @return postorder List.
	 */
	public LinkedList<T> postorderTraversal() {

		inorderTraversal(root, postOrderTraversal);
		return postOrderTraversal;
	}

	/**
	 * traverses the node
	 * 
	 * @param node
	 * @param traversal
	 */
	private void inorderTraversal(BinaryTreeNode<T> node,
			LinkedList<T> traversal) {
		// base case
		// if node is leaf
		if (node.isLeaf()) {
			return;
		}

		// recursive case
		// if node has a left child
		if (node.getLeftChild() != null) {
			// call in order traversal
			inorderTraversal(node.getLeftChild(), traversal);
		}

		// create a temp linekd list node
		LinkedListNode<T> temp = new LinkedListNode<T>(node.getData());
		// call insert last
		traversal.insertLast(temp, node.getData());
		// if the node has a right child
		if (node.getRightChild() != null) {
			// call in order traversal
			inorderTraversal(node.getRightChild(), traversal);
		}
	}

	/**
	 * traverses the node
	 * 
	 * @param node
	 * @param traversal
	 */
	private void preorderTraversal(BinaryTreeNode<T> node,
			LinkedList<T> traversal) {
		// base case
		// if the node is leaf
		if (node.isLeaf()) {
			return;
		}

		// recursive case
		// create a temp linked list
		LinkedListNode<T> temp = new LinkedListNode<T>(node.getData());
		// call insert last using the temp linked list
		traversal.insertLast(temp, node.getData());
		// if node has a ledt child
		if (node.getLeftChild() != null) {
			// call preorder traversal on left child
			preorderTraversal(node.getLeftChild(), traversal);
		}
		// if node has right child
		if (node.getRightChild() != null) {
			// call preorder traversal on right child
			preorderTraversal(node.getRightChild(), traversal);
		}
	}

	/**
	 * traverses the node
	 *
	 * @param node
	 * @param traversal
	 */
	private void postorderTraversal(BinaryTreeNode<T> node,
			LinkedList<T> traversal) {
		// base case
		// if node is leaf
		if (node.isLeaf()) {
			return;
		}
		// create a temp linked list
		LinkedListNode<T> temp = new LinkedListNode<T>(node.getData());
		// call insert last
		traversal.insertLast(temp, node.getData());

		// recursive case
		// if node has left child
		if (node.getLeftChild() != null) {
			// call inorder traversal on left child
			inorderTraversal(node.getLeftChild(), traversal);
		}
		// if it has right child
		if (node.getRightChild() != null) {
			// call in order traveral on right child
			inorderTraversal(node.getRightChild(), traversal);
		}

	}

	public static void main(String[] args) {

		// create the seven dwarves instances
		// type String - binary tree node
		DefaultBinaryTreeNode<String> happy = new DefaultBinaryTreeNode<String>();
		happy.setData("happy");
		DefaultBinaryTreeNode<String> sleepy = new DefaultBinaryTreeNode<String>();
		sleepy.setData("sleepy");
		DefaultBinaryTreeNode<String> sneezy = new DefaultBinaryTreeNode<String>();
		sneezy.setData("sneezy");
		DefaultBinaryTreeNode<String> bashful = new DefaultBinaryTreeNode<String>();
		bashful.setData("bashful");
		DefaultBinaryTreeNode<String> doc = new DefaultBinaryTreeNode<String>();
		doc.setData("doc");
		DefaultBinaryTreeNode<String> dopey = new DefaultBinaryTreeNode<String>();
		dopey.setData("dopey");
		DefaultBinaryTreeNode<String> grumpy = new DefaultBinaryTreeNode<String>();
		grumpy.setData("grumpy");

		// set the root
		dwarfTree.setRoot(happy);
		// set all the children
		happy.setLeftChild(doc);
		happy.setRightChild(sleepy);
		// set the children of the children
		sleepy.setLeftChild(sneezy);
		sleepy.setRightChild(dopey);
		// set the children of the children of the children
		doc.setLeftChild(bashful);
		doc.setRightChild(grumpy);

	}

}
