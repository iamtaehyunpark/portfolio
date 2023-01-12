import java.util.*;

/**
 * 
 * Name: Taehyun Park
 * SBUID: 115242740
 * TODO: Fill in the class HW9. You are free to add any imports from Java
 * Collections.
 * (as long as we learned about it in class)
 */

public class HW9d<E> implements Connectable<E> {
	HashMap<E, Node> domain;
	int numEdges = 0;

	public HW9d() {
		domain = new HashMap<>();
	}

	//nodeSet() will return the set of added nodes in the domain
	//This takes O(n) where n is the number of nodes in total
	//since keySey() has a for-loop that takes all the objects in the map
	//Time and Space complexity are O(1) since it does not have any loop and operates static operation
	public Set<E> nodeSet() {
		return (Set<E>) domain.keySet();
	}// return the set of nodes

	//nodeSet() will return the set of neighbor nodes of the certain node
	//This takes O(n) where n is the number of neighbor nodes of the certain node
	//since keySey() has a for-loop that takes all the objects in the map
	//Time and Space complexity are O(1) since it does not have any loop and operates static operation
	public Set<E> getNeighbors(E node) {
		return ((Node) node).neighbors.keySet();
	} // return the set of neighbors connected to 'node'

	//This Iterator operates in the order of bfs.
	//It will add all the neighbors of the node into the output, and then add all the neighbors of node's neighbors.
	//It will take O(n) where n is the number of the nodes in domain.
	//Although this method has double while-loop but inner loop will only operates a few times depend on the number of certain node's neighbors.
	//And the outer while-loop takes all the nodes in the domain by increasing check list itself
	//Space complexity will be O(n) where n is the number of nodes
	public Iterator<E> breadthFirstIterator() {

		Node first = domain.values().iterator().next(); //designate starting node(will have lowest element in hash)
		ArrayList<Node> lineup = new ArrayList<Node>(); // output

		lineup.add(first);

		int index = 0;
		int size = lineup.size();

		while (index < size) { //until check entire neighbors of all the nodes in the domain
			Node temp = lineup.get(index);
			Set<Node> list2put = (Set<Node>) getNeighbors((E) temp);

			Iterator<Node> it = list2put.iterator();
			while (it.hasNext()) { // check all the neighbors
				Node tempe = it.next();
				if (!lineup.contains(tempe)) { //if already in the output, skip
					lineup.add(tempe);
				}
			}
			index++;
			size = lineup.size();
		}

		return (Iterator<E>) lineup.iterator();
	} // return the iterator on nodes in a breadth-first manner

	//This Iterator operates in the order of dfs.
	//It will add all the neighbors of the node into the stack, and then pop one, and again add all the neighbors of it into stack.
	//One popped is added to the output.
	//Operations will be repeated until all the nodes are once put to the stack and popped into the output.
	//It will take O(n) where n is the number of the nodes in domain.
	//Although this method has double while-loop but inner loop will only operates a few times depend on the number of certain node's neighbors.
	//And the outer while-loop takes all the nodes in the domain by increasing check list itself
	//Space complexity will be O(n) where n is the number of nodes
	public Iterator<E> depthFirstIterator() {

		Node first = domain.values().iterator().next();
		ArrayList<Node> lineup = new ArrayList<Node>();
		Stack stack = new Stack<Node>();

		stack.push(first);

		while (!stack.empty()) {
			Node temp = (Node) stack.pop();
			if (!lineup.contains(temp)) {
				lineup.add(temp);
			}
			Set<Node> list2put = (Set<Node>) getNeighbors((E) temp);
			Iterator<Node> it = list2put.iterator();
			while (it.hasNext()) {
				Node tempNode = it.next();
				if (!lineup.contains(tempNode))
					stack.push(tempNode);
			}
		}

		return (Iterator<E>) lineup.iterator();
	}

	//Create new node that has E node as element
	//Time and Space complexity are O(1) since it does not have any loop and operates static operation
	public void addNode(E node) {
		Node newNode = new Node<E>(node);
		domain.put(node, newNode);
	}

	//Link two nodes with assigning weight.
	//Each node is added to the set of the other's 'neighbors' map;
	//The key of the map is Node, and the value is the weight.
	//Time and Space complexity are O(1) since it does not have any loop and operates static operation
	public boolean addEdge(E source, E target, double w) {
		numEdges++;
		if (!domain.containsKey(source)) //If doesn't exist, create one first
			addNode(source);
		if (!domain.containsKey(target))
			addNode(target);
		return (domain.get(source)).connect(domain.get(target), w); // Add each node into each other's 'neighbors' map
	}

	//Cut off all neighbors of the node and then remove the node from the domain.
	//Cutting operates in the manner of deleting the node in the neighbor node's 'neighbors' map.
	//Time and space complexity is O(n) where n is the number of neighbors of the node
	//since there is a single loop that takes neighbors of the node
	//and number of the creations of the variable are the number of neighbors
	public boolean removeNode(E node) {
		final Set<E> list2put = getNeighbors((E) domain.get(node));
		Iterator it = list2put.iterator();

		while(it.hasNext()){
			Node temp = (Node)it.next();
			temp.neighbors.remove(domain.get(node)); //cut off all the relations from target side (to avoid java.util.ConcurrentModificationException)
			numEdges--;
		}
		domain.get(node).neighbors.clear();
		return domain.remove(node) != null;
	} // remove node. return false if node doesn't exist.

	//Cutting edge by deleting the node in the neighbor node's 'neighbors' map.
	//Time and Space complexity are O(1) since it does not have any loop and operates static operation
	public boolean removeEdge(E source, E target) {
		if(!isEdge(source, target)) return false; //return false where those two are not connected
		numEdges--;
		return (domain.get(source)).disConnect(domain.get(target));
	}

	//Check if source node's 'neighbors' map contains the target node.
	//Time and Space complexity are O(1) since it does not have any loop and operates static operation.
	public boolean isEdge(E source, E target) {
		return (domain.get(source)).neighbors.containsKey(domain.get(target));
	}

	//Check the value of the 'neighbors' map where the key is the target node.
	//Time and Space complexity are O(1) since it does not have any loop and operates static operation
	public double getWeight(E source, E target) {
		if(!isEdge(source, target))
			return -1; //return invalid output where those two are not connected
		return (double) (domain.get(source)).neighbors.get(domain.get(target));
	}

	//Find target node in the 'neighbors' map of the source node and modify the value
	//Time and Space complexity are O(1) since it does not have any loop and operates static operation
	public boolean setWeight(E source, E target, double w) {
		if(!isEdge(source, target)) return false; //return false where those two are not connected
		return (domain.get(source)).changeWeight(domain.get(target), w);
	} 
	
	//Return the size of the domain
	//Time and Space complexity are O(1) since it does not have any loop and operates static operation
	public int numNodes() {
		return domain.size();
	} // return the total number of nodes. should have O(1) time complexity.

	//Return the number of edges
	//Variable numEdges that counts the number of edges is modified where connect or disconnect nodes
	public int numEdges() {
		return numEdges;
	} // return the total number of neighbors. should have O(1) time complexity.

	public static void main(String[] args) {
		HW9d<Integer> hw9 = new HW9d<Integer>(); // Initialize your graph in any way you want.
		
	/* 	  System.out.println(hw9.addEdge(0, 1, 1.0));
		  System.out.println(hw9.addEdge(1, 2, 2.0));
		  System.out.println(hw9.addEdge(2, 3, 3.0));
		  System.out.println(hw9.addEdge(3, 4, 4.0));
		  System.out.println(hw9.addEdge(4, 5, 1.0));
		  System.out.println(hw9.addEdge(5, 6, 2.0));
		  System.out.println(hw9.addEdge(6, 7, 3.0));
		  System.out.println(hw9.addEdge(7, 8, 4.0));
		  System.out.println(hw9.addEdge(8, 9, 1.0));
		  System.out.println(hw9.addEdge(9, 10, 2.0)); */
		

 		System.out.println(hw9.addEdge(0, 1, 1.0));
		System.out.println(hw9.addEdge(1, 2, 2.0));
		System.out.println(hw9.addEdge(0, 2, 3.0));
		System.out.println(hw9.addEdge(2, 3, 4.0));
		System.out.println(hw9.addEdge(0, 4, 1.0));
		System.out.println(hw9.addEdge(2, 8, 2.0));
		System.out.println(hw9.addEdge(3, 8, 3.0));
		System.out.println(hw9.addEdge(7, 5, 4.0));
		System.out.println(hw9.addEdge(5, 6, 1.0));
		System.out.println(hw9.addEdge(1, 5, 2.0));
		System.out.println(hw9.addEdge(7, 6, 2.0));
		System.out.println(hw9.addEdge(4, 10, 2.0));
		System.out.println(hw9.addEdge(4, 9, 2.0));
		System.out.println(hw9.addEdge(10, 11, 2.0));
		System.out.println(hw9.addEdge(10, 12, 2.0));
		System.out.println(hw9.addEdge(9, 13, 2.0));
		System.out.println(hw9.addEdge(9, 8, 2.0));
		System.out.println(hw9.addEdge(2, 9, 2.0));

		System.out.println(hw9.getWeight(8, 3));

		System.out.println(hw9.removeNode(8));
		System.out.println(hw9.removeEdge(6, 7));


		System.out.println(hw9.getWeight(3, 8));
		System.out.println(hw9.numEdges());

		System.out.println(hw9.setWeight(10, 1, 4.0));
		System.out.println(hw9.setWeight(10, 11, 4.0));
		System.out.println(hw9.getWeight(10, 11));
		System.out.println(hw9.numNodes());

		Iterator iter = hw9.breadthFirstIterator();

		while (iter.hasNext()) {
			int init = (int) ((HW9d.Node) iter.next()).element;
			System.out.println(init);
		}
		System.out.println();
		Iterator iter2 = hw9.depthFirstIterator();

		while (iter2.hasNext()) {
			int init = (int) ((HW9d.Node) iter2.next()).element;
			System.out.println(init);
		}
	}

	class Node<E> {
		HashMap neighbors; //Map of the node, Key will be neighbor node and the value will be the weight between two
		E element;

		public E getElement(){return element;}
		public Node(E element) {
			neighbors = new HashMap<Node<E>, Double>();
			this.element = element;
		}

		public boolean connect(Node n, double weight) { //Creates edge
			if (n == null)
				return false;

			this.neighbors.put(n, weight); //Add each other on their 'neighbors' map
			n.neighbors.put(this, weight);
			return true;
		}

		public boolean disConnect(Node target) { //Removes edge
			if(!this.neighbors.containsKey(target)) return false; //check if neighbor
			this.neighbors.remove(target);//Remove each other on their 'neighnors' map
			target.neighbors.remove(this);
			return true;
		}

		public boolean changeWeight(Node target, double w) {
			this.neighbors.replace(target, w);
			return target.neighbors.replace(this, w) != null;
		}

	}

	class edge<K,V>{
		HashSet nodesInEdges;
		double weight;
		public edge(Node form, Node lat, double weight){
			nodesInEdges = new HashSet<Node>();
			nodesInEdges.add(form);
			nodesInEdges.add(lat);
			this.weight = weight;
		}

		public boolean scoping(Node f, Node l){
			return nodesInEdges.contains(f) && nodesInEdges.contains(l);
		}
		public double getWeight(Node f, Node l){
			if(scoping(f, l)) return weight;
			return -1;
		}
	}

}
