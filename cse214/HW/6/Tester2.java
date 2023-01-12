
/**
 * Name: Taehyun Park
 * SBUID: 115242740
 * Do not use any unauthorized packages.
 * For all recursive methods, feel free to use helper methods.
 */
public class Tester2 {

	Node root;

	enum OP {
		PLUS, TIMES, MINUS, DIVIDE
	}; // This is just for your reference. You're not required to use this.

	public Tester2() {
	}

	private class Node {
		Node parent, left, right;
		Object element;
		// Add more necessary fields and methods

		public Node(Object element, Node parent) { // Modify the constructor accordingly
			this.element = element;
			this.parent = parent;
		}
	}

	/*
	 * Build a parse tree, to be pointed by root, that represents 'expression'.
	 * Implement recursively.
	 */

	/*
	 * This method will build tree by decreasing a character from expression and
	 * adding a Node to tree one by one
	 * if input value is parenthesis, build tree for elements inside the parenthesis
	 * and combine them with the original tree
	 * recursion will start with taking one character from the expression and making
	 * leftmost node.
	 * Right node of the parent will be made recursively
	 * Base case is where expression length is zero
	 */
	public void buildTree(String expression) {

		if (expression.length() == 0); // Base case, stop if all the characters are added into tree

		else {

			if (expression.charAt(0) == '(') {

				int count = 1;
				while (expression.charAt(count) != ')'){
					count++;
					if(expression.charAt(count) == '('){

						String sBefore = expression.substring(count);
						buildTree(sBefore);
					}
				}
				String before = expression.substring(1, count); // make new operation with expression inside parenthesis
				if (root != null) { // if root is not null, make small tree first and change root again to the
									// original one.
					Node temp = root;
					root = null;
					buildTree(before);
					temp.right = root;
					root.parent = temp;
					root = temp;
					expression = expression.substring(count + 1);
				} else { // if root is null; if parenthesis comes at first,

					buildTree(before); // just make small tree of it
					expression = expression.substring(count + 1);
				}
			} else if (expression.charAt(0) == ')') {
				expression = expression.substring(1);
				buildTree(expression);
			}

			if (expression.charAt(0) == '*' || expression.charAt(0) == '/') {
				if (root != null) {

					Node hie = new Node(expression.charAt(0), root);
					hie.left = root.right;
					root.right.parent = hie;

					if (expression.charAt(1) != '(') {

						Node right = new Node(expression.charAt(1), hie);// operand next to the operators will
						// become operator's right
						hie.right = right; // left of the operator will be inserted after finish this operation
						// recursively
						buildTree(expression.substring(1));
					} else { // if next char of the operator is parenthesis, just operates again with cutting
								// off the operator
						Node temp = root;
						root = hie;
						buildTree(expression.substring(1));// Then it will be processed in above
						root = temp;
					}
				} else {
					root = new Node(expression.charAt(0), null);

					if (expression.charAt(1) != '(') {

						Node right = new Node(expression.charAt(1), root); // operand next to the operators will
						// become operator's right
						root.right = right; // left of the operator will be inserted after finish this operation
						// recursively
						buildTree(expression.substring(2));
					} else { // if next char of the operator is parenthesis, just operates again with cutting
								// off the operator
						buildTree(expression.substring(1)); // Then it will be processed in above
					}
				}
			}

			if (expression.length() > 0) {
				if (expression.charAt(0) == '+' || expression.charAt(0) == '-') { // dealing with the operators

					if (root == null) {

						root = new Node(expression.charAt(0), null); // if root is null, operator becomes root

						if (expression.charAt(1) != '(') {

							Node right = new Node(expression.charAt(1), root); // operand next to the operators will
																				// become operator's right
							root.right = right; // left of the operator will be inserted after finish this operation
												// recursively
							buildTree(expression.substring(2));
						} else { // if next char of the operator is parenthesis, just operates again with cutting
									// off the operator
							buildTree(expression.substring(1)); // Then it will be processed in above
						}
					} else { // if root is not null, make small tree and combine with tree already existing

						Node temp = root;
						root = null;
						buildTree(expression);
						temp.parent = root;
						root.left = temp;
					}
				}
				else { // if operand, store it as left and make operation with the operator
					
					char temp = expression.charAt(0);
					buildTree(expression.substring(1)); // right will be made above recursively
					Node tempRoot = root;
					while (tempRoot.left != null)
						tempRoot = tempRoot.left;
					Node left = new Node(temp, tempRoot);
					tempRoot.left = left;
				}
			}
			}
		}
	

	public Node findingLeftMost(Node n) {
		if (n.left == null)
			return n;
		return findingLeftMost(n.left);
	}

	/*
	 * Evaluate the expression represented by 'root'.
	 * Implement recursively.
	 */

	/*
	 * This method will simply operates with two operand, left and right.
	 * if the left or right value has a child node, operates them recursively until
	 * that node's element is a number and has no child
	 * Base case will be where root' children both have no child
	 */
	public double eval() {
		double left;
		double right;
		if (root.left == null && root.right == null) // return itself if no child
			return (char) root.element - '0';

		if (root.left == null && root.parent.left != null)
			return (char) root.element - '0';
		else { // if has a child, operates them first
			Node temp = root;
			root = root.left;
			left = eval();
			root = temp;
		}

		if (root.right == null && root.parent.right != null)
			return (char) root.element - '0';
		else {
			Node temp = root;
			root = root.right;
			right = eval();
			root = temp;
		}

		if ((char) root.element == '+')
			return left + right;
		else if ((char) root.element == '-')
			return left - right;
		else if ((char) root.element == '*')
			return left * right;
		// else if((char)root.element == '/') return left/right;
		else
			return left / right;
	}

	/*
	 * Evaluate the expression represented by 'root'.
	 * Implement iteratively.
	 */

	/*
	 * If root's child is operator, makes root's child as root and operates with its
	 * children recursively
	 */
	public double iterativeEval() {
		final Node temp = root;

		while (true) {
			if (root.element instanceof Double)
				break;

			if (root.left.left == null && root.left.right == null && root.right.left == null
					&& root.right.right == null) {

				root.element = helperIterEval(root.left, root.right, root);
				root.left = null;
				root.right = null;
				root = temp;
				continue;
			} else if (root.left.element instanceof Character && (char) root.left.element < 48) {
				root = root.left;
				continue;
			} else {
				root = root.right;
				continue;
			}
		}

		return (double) root.element;
	}

	public double helperIterEval(Node leftN, Node rightN, Node root) {
		double left;
		double right;
		if (leftN.element instanceof Double)
			left = (double) leftN.element;
		else
			left = (char) leftN.element - '0';
		if (rightN.element instanceof Double)
			right = (double) rightN.element;
		else
			right = (char) rightN.element - '0';

		if ((char) root.element == '+')
			return left + right;
		else if ((char) root.element == '-')
			return left - right;
		else if ((char) root.element == '*')
			return left * right;
		// else if((char)root.element == '/') return left/right;
		else
			return left / right;
	}

	/*
	 * Return the original infix notation. You shouldn't just return the stored
	 * input string.
	 * Implement recursively.
	 */

	/*
	 * Recursive in-order traverse and add elements into the output String.
	 * base case is where it reaches right-most Node
	 */
	public String toString() {
		String[] out = { "" };
		traverse(root, out);
		return out[0];
	}

	public void traverse(Node n, String[] out) {
		if (n != null) {
			traverse(n.left, out);
			out[0] += n.element;
			traverse(n.right, out);
		}
	}

	/*
	 * Return the postfix version of the expression.
	 * Implement recursively.
	 */

	/*
	 * Recursive post-order traverse and add elements into the output String.
	 * base case is where it reaches root node
	 */
	public String toPostfixString() {
		String[] out = { "" };
		postTraverse(root, out);
		return out[0];
	}

	public void postTraverse(Node n, String[] out) {
		if (n != null) {
			postTraverse(n.left, out);
			postTraverse(n.right, out);
			out[0] += n.element;
		}
	}

	public static void main(String[] args) {
		Tester2 tree = new Tester2();
		tree.buildTree("2+3*2");
		System.out.println(tree.toString());
		System.out.println(tree.toPostfixString());
		System.out.println(tree.iterativeEval());

	}
}
