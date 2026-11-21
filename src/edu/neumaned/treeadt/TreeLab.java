package edu.neumaned.treeadt;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Binary Tree Lab: tree-building methods and a place to experiment.
 * You do not hand this file in, but use it to try your Node methods on
 * different trees before you run TreeTester.
 */
public class TreeLab {

	public static void main(String[] args) {
		// Make a tree, and then call some of its methods.
		// You can make a tree manually, or call one of the methods below that
		// builds some useful trees.
		Node tree = sampleTree();
		System.out.println("static sum, written in class: " + sum(tree));   // 60
		System.out.println("your Node.sum():              " + tree.sum()); // 60 when TODO 1 is done
	}

	// Computes the sum of all the nodes in the tree with the given root.
	// Visits all the nodes recursively. Note that the root could be null
	// and so our solution needs to take that into account.
	// (We wrote this one together in class. Your Node methods do the same
	// kind of thing, but from INSIDE a node, so they check the children
	// for null instead of checking the root.)
	public static int sum(Node root) {
		if (root == null) {
			return 0;
		}
		return root.data + sum(root.left) + sum(root.right);
	}

	// You should also be testing your code with edge cases.
	// For example, does the method work with:
	// a root with no children?
	// a root with a left child but not a right child?
	// a root with a right child but not a left child?

	// This builds the sample binary tree we built in class
	public static Node sampleTree() {
		Node root = new Node(10); // root

		// Build left subtree:
		Node leftST = new Node(11);
		leftST.left = new Node(7);

		// Build right subtree:
		Node rightST = new Node(9);
		rightST.left = new Node(15);
		rightST.right = new Node(8);

		root.left = leftST;
		root.right = rightST;

		return root;
	}

	// Same structure as the sample tree, but with repeats
	// in the data
	public static Node manyRepeats() {
		Node root = new Node(10); // root

		// Build left subtree:
		Node leftST = new Node(11);
		leftST.left = new Node(10);

		// Build right subtree:
		Node rightST = new Node(9);
		rightST.left = new Node(10);
		rightST.right = new Node(11);

		root.left = leftST;
		root.right = rightST;

		return root;
	}

	// Builds a tree that only branches to the right
	public static Node rightsOnly(int n) {
		Node root = new Node(n);

		for (int i = n - 1; i >= 1; i--) {
			Node temp = new Node(i);
			temp.right = root;
			root = temp;
		}

		return root;
	}

	// Builds a tree that only branches to the left
	public static Node leftsOnly(int n) {
		Node root = new Node(n);

		for (int i = n - 1; i >= 1; i--) {
			Node temp = new Node(i);
			temp.left = root;
			root = temp;
		}

		return root;
	}

	// A zig-zagging binary tree, with 1 at the top, 2 to the right of 1
	// 3 to the left of 2, etc.
	public static Node zigZag(int n) {
		Node root = new Node(1);
		Node curr = root;

		for (int i = 2; i <= n; i++) {
			Node temp = new Node(i);
			if (i % 2 == 0)
				curr.right = temp;
			else
				curr.left = temp;
			curr = temp;
		}

		return root;
	}

	// A complete binary tree, with level-order traversal
	// producing 1, 2, 3, 4, 5, 6, ... , n.
	// Assumes n >= 1
	public static Node completeTree(int n) {
		Node root = new Node(1);

		// Nodes get in line to have children attached
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		int i = 2;

		while (i <= n) {
			Node temp = new Node(i);
			Node front = q.peek();
			if (front.left == null)
				front.left = temp;
			else {
				front.right = temp;
				q.remove();
				q.add(front.left);
				q.add(front.right);
			}
			i++;
		}

		return root;
	}

	// A full tree is just a complete tree with the bottom level full.
	// fullTree(3) would give a complete tree with 15 nodes numbered
	// 1, 2, 3, 4, 5, ... , 15.
	public static Node fullTree(int height) {
		int n = (int) Math.pow(2, height + 1) - 1;

		return completeTree(n);
	}

}
