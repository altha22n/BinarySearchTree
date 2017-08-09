/**
 * A class that implements the BinaryTreeNode<T> interface
 * @author Nada-Al-Thawr
 *
 * @param <T>
 */
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {

	// creating instances of T
	private T data;
	// create an instance of binary tree node for left child
	private BinaryTreeNode<T> leftChild;
	// create an instance of binary tree node for right child
	private BinaryTreeNode<T> rightChild;

	/**
	 * Get the data stored at this node.
	 * 
	 * @return Object data.
	 */
	public T getData() {

		return data;
	}

	/**
	 * Set the data stored at this node.
	 */
	public void setData(T data) {
		this.data = data;

	}

	/**
	 * Get the left child.
	 * 
	 * @return BinaryTreeNode that is left child, or null if no child.
	 */
	public BinaryTreeNode<T> getLeftChild() {

		if (leftChild == null)
			return null;

		else
			return leftChild;
	}

	/**
	 * Get the right child.
	 * 
	 * @return BinaryTreeNode that is right child, or null if no child.
	 */
	public BinaryTreeNode<T> getRightChild() {

		if (rightChild == null)
			return null;

		return rightChild;
	}

	/**
	 * set the left child
	 */
	public void setLeftChild(BinaryTreeNode<T> left) {
		leftChild = left;

	}

	/**
	 * set the right child
	 */
	public void setRightChild(BinaryTreeNode<T> right) {

		rightChild = right;

	}

	/**
	 * Tests if this node is a leaf (has no children).
	 * 
	 * @return true if leaf node.
	 */
	public boolean isLeaf() {

		if (getLeftChild() != null && getRightChild() != null) {
			return true;
		}

		else
			return false;
	}

}
