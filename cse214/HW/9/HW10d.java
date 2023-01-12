/**
 * Name: Taehyun Park
 * SBUID: 115242740
 * 
 */

public class HW10d {
	
	/*
	 * TODO: Implement Kruskal's algorithm on the graph c.
	 */
	public static Connectable<Integer> getKruskalMST(Connectable<Integer> c) {
		
		return null;
	}
	 
	/*
	 * TODO: Implement Prim's algorithm on the graph c.
	 */
	public static Connectable<Integer> getPrimMST(Connectable<Integer> c) {
		return null;
	}
	
	
	public static void main(String[] args) {
		HW9<Integer> hw9 = new HW9<Integer>(); // Initialize your graph in any way you want.
		hw9.addEdge(0, 1, 1.0);
		hw9.addEdge(1, 2, 2.0);
		hw9.addEdge(0, 2, 3.0);
		hw9.addEdge(2, 3, 4.0);
		Connectable<Integer> kruskal = HW10d.getKruskalMST(hw9);
		assert(kruskal.isEdge(0, 1) && kruskal.getWeight(0, 1) == 1.0);
		assert(kruskal.isEdge(2, 1) && kruskal.getWeight(0, 1) == 2.0);
		assert(kruskal.isEdge(2, 3) && kruskal.getWeight(0, 1) == 4.0);
		Connectable<Integer> prim = HW10d.getPrimMST(hw9); // The two should be the same.
		assert(prim.isEdge(0, 1) && prim.getWeight(0, 1) == 1.0);
		assert(prim.isEdge(2, 1) && prim.getWeight(0, 1) == 2.0);
		assert(prim.isEdge(2, 3) && prim.getWeight(0, 1) == 4.0);
	}
}
