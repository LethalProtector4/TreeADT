package edu.neumaned.treeadt;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import edu.neumaned.treeadt.Node;
import edu.neumaned.treeadt.TreeLab;

/*
 * Binary Tree Lab: the tester. Given to you. Do not change it.
 *
 * Run this file. It calls your ten Node methods on several trees and prints
 * PASS or FAIL for each check, then your score out of 100.
 * Each method has 5 checks worth 2 points each.
 */
public class TreeTester {

	private static final PrintStream SCREEN = System.out;
	private static int total = 0;
	private static int groupPoints = 0;
	private static String groupName = "";

	public static void main(String[] args) {
		// ---------------------------------------------------------------- 1
		start("1. sum");
		checkInt("sample tree", () -> TreeLab.sampleTree().sum(), 60);
		checkInt("one node (45)", () -> new Node(45).sum(), 45);
		checkInt("rightsOnly(5)", () -> TreeLab.rightsOnly(5).sum(), 15);
		checkInt("tree of negative numbers", () -> negatives().sum(), -26);
		checkInt("fullTree(3)", () -> TreeLab.fullTree(3).sum(), 120);
		finish();

		// ---------------------------------------------------------------- 2
		start("2. nodeCount");
		checkInt("sample tree", () -> TreeLab.sampleTree().nodeCount(), 6);
		checkInt("one node", () -> new Node(45).nodeCount(), 1);
		checkInt("root with only a left child", () -> rootAndLeft().nodeCount(), 2);
		checkInt("leftsOnly(5)", () -> TreeLab.leftsOnly(5).nodeCount(), 5);
		checkInt("fullTree(3)", () -> TreeLab.fullTree(3).nodeCount(), 15);
		finish();

		// ---------------------------------------------------------------- 3
		start("3. max");
		checkInt("sample tree", () -> TreeLab.sampleTree().max(), 15);
		checkInt("one node (45)", () -> new Node(45).max(), 45);
		checkInt("tree of negative numbers", () -> negatives().max(), -2);
		checkInt("leftsOnly(5): the max is at the bottom", () -> TreeLab.leftsOnly(5).max(), 5);
		checkInt("zigZag(6)", () -> TreeLab.zigZag(6).max(), 6);
		finish();

		// ---------------------------------------------------------------- 4
		start("4. height");
		checkInt("sample tree", () -> TreeLab.sampleTree().height(), 2);
		checkInt("one node", () -> new Node(45).height(), 0);
		checkInt("root with only a right child", () -> rootAndRight().height(), 1);
		checkInt("rightsOnly(5)", () -> TreeLab.rightsOnly(5).height(), 4);
		checkInt("fullTree(3)", () -> TreeLab.fullTree(3).height(), 3);
		finish();

		// ---------------------------------------------------------------- 5
		start("5. find");
		checkFind("sample tree", TreeLab.sampleTree(), new int[] { 10, 7, 15, 8 }, new int[] { 99, 0 });
		checkFind("one node (45)", new Node(45), new int[] { 45 }, new int[] { 44 });
		checkFind("leftsOnly(5)", TreeLab.leftsOnly(5), new int[] { 1, 5 }, new int[] { 6 });
		checkFind("tree of negative numbers", negatives(), new int[] { -9, -3 }, new int[] { 3 });
		checkFind("manyRepeats", TreeLab.manyRepeats(), new int[] { 9, 11 }, new int[] { 12 });
		finish();

		// ---------------------------------------------------------------- 6
		start("6. preOrderTraversal");
		checkPrint("sample tree", () -> TreeLab.sampleTree().preOrderTraversal(), "10 11 7 9 15 8");
		checkPrint("one node (45)", () -> new Node(45).preOrderTraversal(), "45");
		checkPrint("rightsOnly(4)", () -> TreeLab.rightsOnly(4).preOrderTraversal(), "1 2 3 4");
		checkPrint("zigZag(5)", () -> TreeLab.zigZag(5).preOrderTraversal(), "1 2 3 4 5");
		checkPrint("completeTree(6)", () -> TreeLab.completeTree(6).preOrderTraversal(), "1 2 4 5 3 6");
		finish();

		// ---------------------------------------------------------------- 7
		start("7. postOrderTraversal");
		checkPrint("sample tree", () -> TreeLab.sampleTree().postOrderTraversal(), "7 11 15 8 9 10");
		checkPrint("one node (45)", () -> new Node(45).postOrderTraversal(), "45");
		checkPrint("rightsOnly(4)", () -> TreeLab.rightsOnly(4).postOrderTraversal(), "4 3 2 1");
		checkPrint("zigZag(5)", () -> TreeLab.zigZag(5).postOrderTraversal(), "5 4 3 2 1");
		checkPrint("completeTree(6)", () -> TreeLab.completeTree(6).postOrderTraversal(), "4 5 2 6 3 1");
		finish();

		// ---------------------------------------------------------------- 8
		start("8. inOrderTraversal");
		checkPrint("sample tree", () -> TreeLab.sampleTree().inOrderTraversal(), "7 11 10 15 9 8");
		checkPrint("one node (45)", () -> new Node(45).inOrderTraversal(), "45");
		checkPrint("leftsOnly(4)", () -> TreeLab.leftsOnly(4).inOrderTraversal(), "4 3 2 1");
		checkPrint("zigZag(5)", () -> TreeLab.zigZag(5).inOrderTraversal(), "1 3 5 4 2");
		checkPrint("completeTree(6)", () -> TreeLab.completeTree(6).inOrderTraversal(), "4 2 5 1 6 3");
		finish();

		// ---------------------------------------------------------------- 9
		start("9. levelOrderTraversal");
		checkPrint("sample tree", () -> TreeLab.sampleTree().levelOrderTraversal(), "10 11 9 7 15 8");
		checkPrint("one node (45)", () -> new Node(45).levelOrderTraversal(), "45");
		checkPrint("zigZag(5)", () -> TreeLab.zigZag(5).levelOrderTraversal(), "1 2 3 4 5");
		checkPrint("completeTree(7)", () -> TreeLab.completeTree(7).levelOrderTraversal(), "1 2 3 4 5 6 7");
		checkPrint("tree of negative numbers", () -> negatives().levelOrderTraversal(), "-5 -2 -7 -9 -3");
		finish();

		// ---------------------------------------------------------------- 10
		start("10. preOrderTraversalString");
		checkString("sample tree", () -> TreeLab.sampleTree().preOrderTraversalString(), "10 11 7 9 15 8");
		checkString("one node (45)", () -> new Node(45).preOrderTraversalString(), "45");
		checkString("completeTree(6)", () -> TreeLab.completeTree(6).preOrderTraversalString(), "1 2 4 5 3 6");
		checkString("tree of negative numbers", () -> negatives().preOrderTraversalString(), "-5 -2 -9 -7 -3");
		checkPrintsNothing("returns the string and prints nothing",
				() -> TreeLab.sampleTree().preOrderTraversalString(), "10 11 7 9 15 8");
		finish();

		SCREEN.println();
		SCREEN.println("Total: " + total + " / 100");
	}

	// ====================================================================
	// Extra trees used by the checks
	// ====================================================================

	//        -5
	//       /  \
	//     -2    -7
	//     /       \
	//   -9         -3
	private static Node negatives() {
		Node root = new Node(-5);
		root.left = new Node(-2);
		root.left.left = new Node(-9);
		root.right = new Node(-7);
		root.right.right = new Node(-3);
		return root;
	}

	private static Node rootAndLeft() {
		Node root = new Node(5);
		root.left = new Node(3);
		return root;
	}

	private static Node rootAndRight() {
		Node root = new Node(5);
		root.right = new Node(8);
		return root;
	}

	// ====================================================================
	// Checking machinery (you do not need to read below this line)
	// ====================================================================

	private static final int POINTS_PER_CHECK = 2;
	private static final int SECONDS_ALLOWED = 3;

	private static void start(String name) {
		groupName = name;
		groupPoints = 0;
		SCREEN.println();
		SCREEN.println(name + " (10 points)");
	}

	private static void finish() {
		SCREEN.println("   " + groupName.substring(groupName.indexOf(' ') + 1) + ": " + groupPoints + " / 10");
	}

	private static void report(String label, boolean pass, String expected, String got) {
		if (pass) {
			groupPoints += POINTS_PER_CHECK;
			total += POINTS_PER_CHECK;
			SCREEN.println("   PASS  " + label);
		} else {
			SCREEN.println("   FAIL  " + label + ": expected " + expected + ", got " + got);
		}
	}

	private static void checkInt(String label, Callable<Integer> call, int expected) {
		String got;
		boolean pass = false;
		try {
			int value = (Integer) run(call);
			got = String.valueOf(value);
			pass = (value == expected);
		} catch (Throwable problem) {
			got = describe(problem);
		}
		report(label, pass, String.valueOf(expected), got);
	}

	private static void checkFind(String label, Node tree, int[] present, int[] absent) {
		String expected = "";
		String got = "";
		boolean pass = true;
		try {
			for (int key : present) {
				boolean answer = (Boolean) run(() -> tree.find(key));
				expected += "find(" + key + ")=true ";
				got += "find(" + key + ")=" + answer + " ";
				pass = pass && answer;
			}
			for (int key : absent) {
				boolean answer = (Boolean) run(() -> tree.find(key));
				expected += "find(" + key + ")=false ";
				got += "find(" + key + ")=" + answer + " ";
				pass = pass && !answer;
			}
		} catch (Throwable problem) {
			pass = false;
			got = describe(problem);
		}
		report(label, pass, expected.trim(), got.trim());
	}

	private interface Action {
		void go();
	}

	// Runs a method that prints, and compares what it printed (extra spaces
	// and line breaks do not matter).
	private static void checkPrint(String label, Action action, String expected) {
		String got;
		boolean pass = false;
		ByteArrayOutputStream captured = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captured));
		try {
			run(() -> {
				action.go();
				return null;
			});
			System.out.flush();
			got = tidy(captured.toString());
			pass = got.equals(expected);
			got = "\"" + got + "\"";
		} catch (Throwable problem) {
			got = describe(problem);
		} finally {
			System.setOut(SCREEN);
		}
		report(label, pass, "\"" + expected + "\"", got);
	}

	private static void checkString(String label, Callable<String> call, String expected) {
		String got;
		boolean pass = false;
		ByteArrayOutputStream captured = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captured));
		try {
			String value = (String) run(call);
			got = (value == null) ? "null" : "\"" + tidy(value) + "\"";
			pass = (value != null) && tidy(value).equals(expected);
		} catch (Throwable problem) {
			got = describe(problem);
		} finally {
			System.setOut(SCREEN);
		}
		report(label, pass, "\"" + expected + "\"", got);
	}

	private static void checkPrintsNothing(String label, Callable<String> call, String expected) {
		String got;
		boolean pass = false;
		ByteArrayOutputStream captured = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captured));
		try {
			String value = (String) run(call);
			System.out.flush();
			String printed = tidy(captured.toString());
			boolean rightString = (value != null) && tidy(value).equals(expected);
			pass = rightString && printed.isEmpty();
			if (!rightString) {
				got = "returned " + ((value == null) ? "null" : "\"" + tidy(value) + "\"");
			} else {
				got = "the right string, but it also printed \"" + printed + "\"";
			}
		} catch (Throwable problem) {
			got = describe(problem);
		} finally {
			System.setOut(SCREEN);
		}
		report(label, pass, "\"" + expected + "\" returned and nothing printed", got);
	}

	private static String tidy(String text) {
		return text.trim().replaceAll("\\s+", " ");
	}

	private static String describe(Throwable problem) {
		if (problem instanceof StackOverflowError) {
			return "a crash: StackOverflowError (does the recursion ever stop?)";
		}
		if (problem instanceof NullPointerException) {
			return "a crash: NullPointerException (did you check a child for null before using it?)";
		}
		return "a crash: " + problem.getClass().getSimpleName();
	}

	// Runs one call on its own thread so that a loop that never ends cannot
	// freeze the tester.
	private static Object run(Callable<?> call) throws Throwable {
		FutureTask<Object> task = new FutureTask<>(() -> call.call());
		Thread worker = new Thread(null, task, "check", 1 << 22);
		worker.setDaemon(true);
		worker.start();
		try {
			return task.get(SECONDS_ALLOWED, TimeUnit.SECONDS);
		} catch (ExecutionException wrapped) {
			throw wrapped.getCause();
		} catch (TimeoutException tooSlow) {
			System.setOut(SCREEN);
			SCREEN.println("   FAIL  a check in \"" + groupName + "\" ran for more than " + SECONDS_ALLOWED
					+ " seconds (a loop or recursion that never ends?)");
			SCREEN.println();
			SCREEN.println("Stopped early. Fix that method, then run the tester again.");
			SCREEN.println("Total so far: " + total + " / 100");
			System.exit(0);
			return null;
		}
	}
}
