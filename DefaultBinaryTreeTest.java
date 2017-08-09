import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A class to test the implementations of the binary trees
 * 
 * @author Nada-Al-Thawr
 *
 */
public class DefaultBinaryTreeTest {
	BinarySearchTree<String> testTree = new DefaultBinarySearchTree<String>();

	@Before
	// add to the list
	public void createTestList() {
		testTree.insert("t");
		testTree.insert("e");
		testTree.insert("a");
	}

	@Test
	public void testpreOrderTraversalFunction() {

		LinkedList<String> preorderTraversal = testTree.preorderTraversal();
		// test preOrderTraversal
		assertEquals("TestTree is in preOrderTraversal: ", true,
				isOrdered(preorderTraversal));
	}

	@Test
	public void testpostOrderTraversalFunction() {

		LinkedList<String> postorderTraversal = testTree.postorderTraversal();

		// test postOrderTraversal
		assertEquals("TestTree is in postOrderTraversal: ", true,
				isOrdered(postorderTraversal));
	}

	@Test
	public void testinOrderTraversalFunction() {

		LinkedList<String> inorderTraversal = testTree.inorderTraversal();

		// test inOrderTraversal
		assertEquals("TestTree is in inOrderTraversal: ", true,
				isOrdered(inorderTraversal));
	}

	/**
	 * 
	 * @param inorderTraversal
	 * @return
	 */
	private boolean isOrdered(LinkedList<String> inorderTraversal) {
		// create a temp linked list node that get the first node
		LinkedListNode<String> tempNode = inorderTraversal.getFirstNode();
		// if the next node is empty
		if (tempNode.getNext() == null) {
			// then it's ordered
			return true;
		} else {
			// create a next node that gets the next node
			LinkedListNode<String> nextNode = tempNode.getNext();
			// while the next node is not empty
			while (tempNode.getNext() != null) {
				// compare temp node to the next node
				// if they're less than 0, return false
				if (tempNode.getData().compareTo(nextNode.getData()) > 0)
					return false;
				// esle update both nodes, by getting the next
				tempNode = tempNode.getNext();
				nextNode = nextNode.getNext();
			}

			// else it is ordered
			return true;

		}
	}

	@Test
	public void testMinElement() {
		// test min element
		assertEquals("Testing Min in BinaryTree: ", testTree.minElement(), "a");
	}

	@Test
	public void testMaxElement() {
		// test max elements
		assertEquals("Testing Max in BinaryTree: ", testTree.maxElement(), "t");
	}

	@Test
	public void testInsert() {
		// test insert
		assertEquals("Testing for t: ",
				testTree.getRoot().getData().toString(), "t");

	}

	@Test
	public void testSearchElement() {
		// test search elements
		assertEquals("Testing search", "t", testTree.search("t").getData());
		assertEquals("Testing search", "e", testTree.search("e").getData());
		assertEquals("Testing search", "a", testTree.search("a").getData());

	}
}
