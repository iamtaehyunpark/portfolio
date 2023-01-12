
/*
Taehyun Park 115242740
 * Do not import anything else.
 * You may add other methods and classes as needed, but do not alter what's given.
 */
import java.util.*; // You can use other classes in this package, but only the ones we learned in class.

public class Huffman {

	private Queueable<Node> pq;
	private Node root;

	public Huffman() {
		pq = new PQ();
	}

	/*
	 * Perform a Huffman encoding of 'msg', and return a String containing 0s and 1s
	 * that
	 * encodes 'msg'. You MUST use a priority queue-based algorithm for this
	 * assignment, unlike I did.
	 * 'msg' is guaranteed to consist only of ASCII values (0 - 255). See
	 * https://www.asciitable.com/
	 */
	/*
	 * Method encode will encode the input string.
	 * first make all the characters into Node,
	 * Node is originally implemented to operate as tree's Node.
	 *  Node's left and right will first temporarily operates as LinkedList's left and right, 
	 * while operating as linkedlist, the characters that already have existing node will not create new Node but just increase its weight(int).
	 * 
	 * After creating Nodes for all the characters, they will be sent to enqueue method and create heap
	 * and then creates huffman tree by taking(dequeue) two nodes from heap at a time.
	 * two node will make new node that combines each weight. New one is also sent to the heap and repeats the same process above.
	 * 
	 * Finds the node that represents certain character of the string will be found by traverse method.
	 * After spotted, decide 0 or 1 by comparing whether it is placed left or right of its parent.
	 * 0 or 1 is added to output string
	 * 
	 * time complexity will O(n^2) where n is the number of characters. 
	 * The most complex loop of this method is for(while()+recursion))-loop that all operates as much as the number of the characters. (in worst cases)
	 * space complexity will O(n) where n is the number of characters since there will be n times of operations of the nodes.
	 */
	public String encode(String msg) {
		int count = 0;
		Node head = new Node(msg.charAt(count), null); //first node of the linked list 
		head.parent = head; //node's parent field will operate as linkedlist's 'first', temporarily.
		count++;

		while (count != msg.length()) { //while all the characters of the string are checked
			Node temp = head;
			while (temp != null) { // until checking all the existing node
				if (temp.element == msg.charAt(count)) { //if identical elements, just increase weight instead of creating new one
					temp.weight++;
					break;
				} else if (temp.right == null) { //if not, creates new
					Node newn = new Node(msg.charAt(count), head);
					newn.left = temp;
					temp.right = newn;
					break;
				}
				temp = temp.right;
			}
			count++;
		}

		Node temp = head.parent;
		while (temp != null) {
			Node temptemp = temp.right;
			temp.left = null; //clears every field of the nodes since it won't operates as linkedlist no longer
			temp.right = null;
			temp.parent = null;
			pq.enqueue(temp); //send all nodes to heap
			temp = temptemp;
		}

		while (true) {
			Node left = pq.dequeue(); //dequeue two of heap and make a single parent node whose weight is sum of two
			Node right = pq.dequeue();
			if (right == null){ //stop operating if there's one node left.
				if(left.left == null){ //if heap has only one character, make dummy huffman tree structure to operates well
					root = new Node((char)0, null);
					left.parent = root;
					root.left = left;
				}
				break;
			}

			Node parent = new Node((char)0, null);
			parent.weight = left.weight + right.weight;
			left.parent = parent;
			right.parent = parent;
			parent.left = left;
			parent.right = right;
			root = parent;

			pq.enqueue(parent);
		}

		String out = "";
		for(int j = 0; j<msg.length();j++){
			char finding = msg.charAt(j);
			Node findingNode = traverse(root, finding); //spots the exact node that represent certain character by traversing

			Node tempParent = findingNode.parent;

			String reversedOut = "";
			while(tempParent != null){
				if(tempParent.left.equals(findingNode)) reversedOut+='0'; //if the node located left of its parents, add 0 to output
				else reversedOut+='1'; //otherwise 1
				findingNode = tempParent;
				tempParent = tempParent.parent;
			}
			for(int k = reversedOut.length()-1; k>=0; k--) out += reversedOut.charAt(k);
		}

		return out;
	}

	public Node traverse(Node k, char finding) { //traversing and find the node that represents the character
		Node out = null;
		if (k != null) {
			out = traverse(k.left, finding);
			if(out != null) return out;
			if(k.element == finding){
				return out = k;
			}
			out = traverse(k.right, finding);
			if(out != null) return out;
		}
		return out;
	}

	/*
	 * Perform decoding of the binary string 'code' using the Huffman tree
	 * represented by 'this.head'.
	 * This method should return a null in case the given code cannot be decoded.
	 * (e.g., error in code, or Huffman tree doesn't exist)
	 */

	 /*
	  * moves the chosen nodes by following 0 or 1 (left if 0)
	  *if reaches leaves, add the element of the node into output string
	  *loop until all the numbers are read
	  *
	  *time complexity will O(n) where n is the number of the numbers in String code
	  * since there's only one for-loop that takes the characters of input string
	  *space complexity will O(1) there isn't any creations except for output string
	  */
	public String decode(String code) {
		String out = "";
		Node charict = root;
		if(root.left == null && root.right == null) return ""+root.element;
		for(int i = 0; i<code.length();i++){
			if(code.charAt(i) == '0'){
				charict = charict.left; //keep moving
				if(charict.element != 0){  //if it reaches the node that has actual elements, add it into output
					out+=charict.element;
					charict = root; //loop again
				}
			}else{ //move right if the read number is 1
				charict = charict.right;
				if(charict.element != 0){ 
					out+=charict.element;
					charict = root;
				}
			}
		}
		return out;
	}

	/*
	 * This is just for testing purposes, and you do not have to use it in your
	 * implementation.
	 * You can use this method to see what the binary representation of the original
	 * string looks like.
	 * It's probably useless in this assignment, but just in case you're curious....
	 */
	public String toBinary(String s) {
		String ret = "";
		for (int i = 0; i < s.length(); i++)
			ret = toBinary(s.charAt(i)) + ret;
		return ret;
	}

	private String toBinary(int ch) {
		ch = 0xFFFF & ch; // Just want to deal with char's
		String ret = "";
		for (int i = 0; i < 16; i++) {
			ret = (ch & 1) + ret;
			ch = ch >> 1;
		}
		return ret;
	}

	public static void main(String[] args) {
		Huffman h = new Huffman();
		String msg = "a b c d fklasjd;lfkjal;sdjfklajsdlk kkjflkjelk3lkjrlk2jlk3jvc9";
		//String msg = "There is a pleasure in philosophy, and a lure even in the mirages of metaphysics, which every student feels until the coarse necessities of physical existence drag him from the heights of thought into the mart of economic strife and gain.";
		//String msg = "She sells sea shells by the sea shore.\nThe shells she sells are seashells, I\'m sure.\nAnd if she sells seashells on the seashore\nThen I\'m sure she sells seashells.";
		//String msg = "And I shall have some peace there, for peace comes dropping slow, Dropping from the veils of the morning to where the cricket sings; There midnight\'s all a glimmer, and noon a purple glow, And evening full of the linnet\'s wings.";
		//String msg = "Paying anything to roll the dice, just one more time. Some will win, some will lose, some are born to sing the blues. Oh the movie never ends it goes on and on and on and on.";
		//String msg = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		//String msg = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaazzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		//String msg = "azazazazazazazazazazazazazazazazazazazazazazazazazazazazazazazazaz";
		//System.out.println(h.toBinary(msg).length());
		String code = h.encode(msg);
		assert (h.decode(code).equals(msg)); // Original message should be reconstructed.
		assert (code.length() < msg.length() * 16); // Code should be compressed.
	}
}

/*
 * Priority queue implementation.
 */
interface Queueable<E extends Comparable<E>> {
	public void enqueue(E obj);

	public E dequeue();
}

class PQ implements Queueable<Node> {
	Node[] ary = new Node[255];
	int size = 0;

	public void enqueue(Node obj) {
		size++;
		int count = 0;
		while (count != ary.length) { //add to last and percolate up operation
			if (ary[count] == null) {
				ary[count] = obj;
				break;
			}
			count++;
		}
		checkParent(count);
	}

	public void checkParent(int index) { //percolate up
		if (index == 0)
			return;
		int parentIndex = (int) ((index - 1) / 2);
		if (ary[index].compareTo(ary[parentIndex]) < 0) {
			Node temp = ary[index];
			ary[index] = ary[parentIndex];
			ary[parentIndex] = temp;

			checkParent(parentIndex);
			checkParent(index);
		}
	}

	public Node dequeue() { //change the location between root(smallest one) and the last elements and percolate down operation
		if (size == 0)
			return null;
		Node out = ary[0];
		ary[0] = ary[size - 1];
		ary[size - 1] = null;
		checkChild(0);
		size--;
		return out;
	}

	public void checkChild(int index) { //percolate down
		if (index == size - 1)
			return;
		int childIndexL = 2 * index + 1;
		int childIndexR = 2 * index + 2;

		if (ary[childIndexR] != null && ary[index].compareTo(ary[childIndexR]) > 0) {
			Node temp = ary[index];
			ary[index] = ary[childIndexR];
			ary[childIndexR] = temp;

			checkChild(childIndexR);
			checkChild(childIndexL);
			checkChild(index);
		} else if (ary[childIndexL] != null && ary[index].compareTo(ary[childIndexL]) > 0) {
			Node temp = ary[index];
			ary[index] = ary[childIndexL];
			ary[childIndexL] = temp;

			checkChild(childIndexL);
			checkChild(childIndexR);
			checkChild(index);
		}
	}
}

class Node implements Comparable<Node> {
	char element;
	int weight;
	Node parent;
	Node left;
	Node right;

	public Node(char element, Node parent) {
		this.element = element;
		this.parent = parent;
		weight = 1;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}

	public boolean equals(Node comp){
		return (this.element == comp.element && this.weight == comp.weight && this == comp);
	}
}
