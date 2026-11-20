import java.util.*;

/*
 * Binary Tree Lab
 *
 * A node for a binary tree: data, plus references to a left child and a right child.
 * We are using package-level access here to make it easy to code in our tester.
 *
 * YOUR JOB: finish the ten methods marked TODO. Do not change the method headers.
 * Run TreeTester to see your score.
 */
class Node {
	// These are our usual binary node instance variables
	int data;
	Node left, right;

	// Constructs a binary node with the specified data and
	// no children
	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	//////////////////////////////////////////////
	/*
	 * There are a variety of places we could write Node methods. In this case,
	 * we are putting them directly into the Node class. In class we wrote
	 * TreeLab.sum(Node root) as a static method instead, and the syntax was a
	 * little different (look at it: it is in TreeLab.java).
	 *
	 * Note that the methods below exist INSIDE a Node object. That means that the
	 * node ("this") can never be null. It's possible that its children are null
	 * though, and that's something to always be checking for.
	 */
	///////////////////////////////////////////////

	// TODO 1
	// Returns the sum of the data in this tree. Note that
	// because this method exists inside the Node class, it's
	// not possible for it to be null, but its children could be, and
	// so we need to watch for that.
	int sum() {
		return -1;
	}

	// TODO 2
	// Returns the number of nodes in this tree. Solve recursively.
	// Ask yourself: how is the number of nodes in the tree related
	// to the number of nodes in each subtree?
	int nodeCount() {
		return -1;
	}

	// TODO 3
	// Returns the largest value in this tree.
	// Write recursively.
	// Ask yourself: if I know the max in the left subtree, and
	// I know the max in the right subtree, and I know my own data,
	// how can I figure out the max?
	// Careful: the data can be negative.
	int max() {
		return -1;
	}

	// TODO 4
	// Returns the height of this tree: the number of edges from this
	// node down to its farthest leaf. A single node has height 0.
	// Write recursively.
	// If you know the height of the left and right subtrees,
	// how can you use those to find the height of this tree?
	// A tip: Even though it doesn't make sense to talk about
	// the height of a "null" subtree, it can be extremely
	// convenient to think of that height as -1.
	int height() {
		return -1;
	}

	// TODO 5
	// Returns true if the key appears anywhere in this tree.
	// Write recursively.
	boolean find(int key) {
		return false;
	}

	// TODO 6
	// Prints the pre-order traversal of the tree rooted at this node:
	// this node's data, then the left subtree, then the right subtree.
	// Space separated, all on one line.
	// Write recursively.
	void preOrderTraversal() {

	}

	// TODO 7
	// Prints all the nodes in the tree rooted at this node,
	// using post-order traversal: left subtree, right subtree, then this node's data.
	// Space separated, all on one line.
	// Write recursively.
	void postOrderTraversal() {

	}

	// TODO 8
	// Prints the in-order traversal of the tree rooted at this node:
	// left subtree, then this node's data, then the right subtree.
	// Space separated, all on one line.
	// Write recursively.
	void inOrderTraversal() {

	}

	// TODO 9
	// Prints all the nodes in the tree rooted at this node,
	// using level-order traversal: top-to-bottom, left-to-right.
	// Space separated, all on one line.
	// Use a queue and a loop to solve this. Recursion doesn't work
	// well here.
	void levelOrderTraversal() {

	}

	// TODO 10
	// Returns a space-delimited string containing the
	// pre-order traversal, rather than printing it.
	// This method must not print anything.
	// Write recursively.
	String preOrderTraversalString() {
		return "";
	}
}
