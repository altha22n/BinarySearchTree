/**
 * 
 * @author Nada-Al-Thawr
 *
 * @param <T>
 */
public class DefaultBinarySearchTree<T extends Comparable<T>> extends
		DefaultBinaryTree<T> implements BinarySearchTree<T> {
	/**
	 * insert method
	 * 
	 * @param data
	 */
	@Override
	public void insert(T data) {
		// create a new instance of BinaryTreeNode
		BinaryTreeNode<T> theNode = new DefaultBinaryTreeNode<T>();
		// and set the data
		theNode.setData(data);
		// create another temp node
		BinaryTreeNode<T> tempNode = getRoot();

		while (true) {
			// if the root is null
			if (getRoot() == null) {
				// set the node as the root
				setRoot(theNode);
				return;
			}

			// if comparing the data to the temp node is smaller than 0
			if (data.compareTo(tempNode.getData()) < 0) {
				// and if the left child of temp node is empty
				if (tempNode.getLeftChild() == null) {
					// then set the node as the left child
					tempNode.setLeftChild(theNode);

					return;
				}

				// keep updating it as you go
				tempNode = tempNode.getLeftChild();
			} else {
				// else if the right child of the temp node is empty
				if (tempNode.getRightChild() == null) {
					// then set the node as the right child
					tempNode.setRightChild(theNode);

					return;
				}
				// keep updating as you go
				tempNode = tempNode.getRightChild();
			}
		}

	}

	/**
	 * Search for data in the tree, finding the node containing it, or null if
	 * the data is not present in the tree.
	 * 
	 * @param data
	 * @return the node containing data or null if none exists.
	 */
	@Override
	public BinaryTreeNode<T> search(T data) {
		// create the temp node as the root
		BinaryTreeNode<T> tempNode = root;

		while (true) {
			// if the temp node is empty, return null
			if (tempNode == null) {
				return null;
			}
			// if comparing the data to the temp node is equal 0
			if (data.compareTo(tempNode.getData()) == 0) {
				// return tempNode
				return tempNode;
			}
			// if comparing data to temp node is smaller than 0
			if (data.compareTo(tempNode.getData()) < 0) {
				// then temp node becomes the left child
				tempNode = tempNode.getLeftChild();
			} else {
				// else temp node is the right child
				tempNode = tempNode.getRightChild();
			}
		}
	}

	/**
	 * Find the minimum element in the tree.
	 */
	@Override
	public T minElement() {
		// create the tempnode as the root
		BinaryTreeNode<T> tempNode = root;
		// while the left child of the temp node is not empty
		while (tempNode.getLeftChild() != null) {
			// temp node beceoms the left child
			tempNode = tempNode.getLeftChild();
		}
		// return the data of the temp node
		return tempNode.getData();
	}

	/**
	 * Find the minimum element in the tree.
	 */
	@Override
	public T maxElement() {
		// create the temp node as the root
		BinaryTreeNode<T> tempNode = root;
		// while the right child of the temp node is not empty
		while (tempNode.getRightChild() != null) {
			// temp node becomes the right child
			tempNode = tempNode.getRightChild();
		}
		// return the data of the temp node
		return tempNode.getData();
	}
}