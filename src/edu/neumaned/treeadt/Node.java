package edu.neumaned.treeadt;
import java.util.*;

/*-
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
	/*-
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
		int total = data;
		if (left != null) {
			total += left.sum();
		}
		if (right != null) {
			total += right.sum();
		}
		return total;
	}

	// TODO 2
	// Returns the number of nodes in this tree. Solve recursively.
	// Ask yourself: how is the number of nodes in the tree related
	// to the number of nodes in each subtree?
	int nodeCount() {
		int count = 1;
		if (left != null) {
			count += left.nodeCount();
		}
		if (right != null) {
			count += right.nodeCount();
		}
		return count;
	}

	// TODO 3
	// Returns the largest value in this tree.
	// Write recursively.
	// Ask yourself: if I know the max in the left subtree, and
	// I know the max in the right subtree, and I know my own data,
	// how can I figure out the max?
	// Careful: the data can be negative.
	int max() {
		int best = data;
		if (left != null) {
			best = Math.max(best, left.max());
		}
		if (right != null) {
			best = Math.max(best, right.max());
		}
		return best;
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
		int left_height = -1;
		int right_height = -1;
		if (left != null) {
			left_height = left.height();
		}
		if (right != null) {
			right_height = right.height();
		}
		return 1 + Math.max(left_height, right_height);
	}

	// TODO 5
	// Returns true if the key appears anywhere in this tree.
	// Write recursively.
	boolean find(int key) {
		if (data == key) {
			return true;
		}
		if (left != null && left.find(key)) {
			return true;
		}
		if (right != null && right.find(key)) {
			return true;
		}
		return false;
	}

	// TODO 6
	// Prints the pre-order traversal of the tree rooted at this node:
	// this node's data, then the left subtree, then the right subtree.
	// Space separated, all on one line.
	// Write recursively.
	void preOrderTraversal() {
		System.out.println(data + " ");
		if (left != null) {
			left.preOrderTraversal();
		}
		if (right != null) {
			right.preOrderTraversal();
		}
	}

	// TODO 7
	// Prints all the nodes in the tree rooted at this node,
	// using post-order traversal: left subtree, right subtree, then this node's data.
	// Space separated, all on one line.
	// Write recursively.
	void postOrderTraversal() {
		if (left != null) {
			left.postOrderTraversal();
		}
		if (right != null) {
			right.postOrderTraversal();
		}
		System.out.println(data + " ");
	}

	// TODO 8
	// Prints the in-order traversal of the tree rooted at this node:
	// left subtree, then this node's data, then the right subtree.
	// Space separated, all on one line.
	// Write recursively.
	void inOrderTraversal() {
		if (left != null) {
			left.inOrderTraversal();
		}
		System.out.println(data + " ");
		if (right != null) {
			right.inOrderTraversal();
		}
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
		String result = "";
		result += data + " ";
		if (left != null) {
			result += left.preOrderTraversalString();
		}
		if (right != null) {
			result += right.preOrderTraversalString();
		}
		return result;
	}
}
