import java.util.*;

/**
 * Name: Taehyun Park
 * SBUID: 115242740
 */

public class HW10 {

    /*
     * TODO: Implement Kruskal's algorithm on the graph c.
     */

     //Kruskal method will add edges into output tree one by one.
     //The smallest edge will be first added to the tree, and then moderate cycle tree to prevent cycle.
     //The time complexity will be O(n) where n is the number of edges in graph since the single for-loop tant takes edges exist
     //The space complexity will be O(n) where n is the number of edges since the biggest space in the method takes them
    public static Connectable<Integer> getKruskalMST(Connectable<Integer> c) {
        HW9<Integer> out = new HW9<Integer>();
        HW9 graph = (HW9) c;
        Collection<HW9.Edge> edgesInList = graph.edges.values();
        Object[] edges = edgesInList.toArray();
        Arrays.sort(edges);

        Collection domain = graph.domain.values();

        HashMap<HW9.Node, HW9.Node> cycle = new HashMap<>();

        Iterator makingCycleTab = domain.iterator();
        while (makingCycleTab.hasNext()) { //makes cycle table
            HW9.Node addingNode = (HW9.Node) makingCycleTab.next();
            cycle.put(addingNode, addingNode);
        }

        for (Object tempEdge : edges) { // while check all the edges
            if (cycle.get(((HW9.Edge) tempEdge).lat) == (cycle.get(((HW9.Edge) tempEdge).form))) { //if cycle table is checked , just continue
                continue;
            } else {
                out.addEdge((int) ((HW9.Edge) tempEdge).form.element, (int) ((HW9.Edge) tempEdge).lat.element, ((HW9.Edge) tempEdge).weight); //add to output
                //cycle.replace(((HW9.Edge) tempEdge).lat, cycle.get(((HW9.Edge)tempEdge).form));
                final HW9.Node fixedLat = cycle.get(((HW9.Edge) tempEdge).lat);
                final HW9.Node fixedForm =  cycle.get(((HW9.Edge)tempEdge).form);
                for(HW9.Node temp : cycle.keySet()){ //moderate cycle table
                    if(cycle.get(temp) == fixedLat)
                        cycle.replace(temp, fixedForm);
                }
            }
        }
        return out;
    }

    /*
     * TODO: Implement Prim's algorithm on the graph c.
     */
    //Prim method will make tree by adding all the neighbors and edge between it of certain node into the output.
    //The node that has the smallest weight among all the neighbors will be chosen and then again add all the neighbors and edges of chosen node.
    //The node already once chosen will not be chosen again to prevent cycle.
    //The time complexity will be O(n^2) where n is the number of Nodes in graph since the double while-loop that checks all the nodes in domain exist.
     //The space complexity will be O(n) where n is the number of nodes since the biggest space in the method takes them.
    public static Connectable<Integer> getPrimMST(Connectable<Integer> c) {
        HW9<Integer> out = new HW9<Integer>();
        HW9 graph = (HW9) c;


        Set<HW9.Node> reached = new HashSet<>();
        HW9.Node first = (HW9.Node) graph.domain.values().iterator().next(); // designating starting node(will have the lowest element in hashset)
        reached.add(first);

        LinkedList<HW9.Edge> edges = new LinkedList<>();
        while (reached.size() < graph.domain.size()) { //while all the nodes are reached
            Set neighborsOfScope = graph.getNeighbors(first);
            for (Object adding : neighborsOfScope) {  //add all the neighbors and edges between them into checking array
                if (!edges.contains(first.getEdge((HW9.Node) adding)) && !reached.contains((HW9.Node) adding)) { //if already exist, skip to add
                    edges.add(first.getEdge((HW9.Node) adding));
                }

            }

            HW9.Node next;
            while (edges.size() > 0) {
                if (edges.size() > 1)
                    Collections.sort(edges); //sort so that the smallest edge comes first
                HW9.Edge tempEdge = edges.getFirst();


                if (tempEdge.form == first) next = tempEdge.lat;
                else if(tempEdge.lat == first) next = tempEdge.form;
                else {
                    first = tempEdge.form;
                    next = tempEdge.lat;
                }

                if (!reached.contains(next) ) {
                    out.addEdge((int) (first.element), (int) (next.element), ((HW9.Edge) tempEdge).weight);
                    reached.add(next);
                    edges.removeFirst(); //remove in checking array
                    first = next; //change scoping node to browse its neighbors
                    break;
                } else {
                    edges.removeFirst(); //if cycle is spotted, remove that array
                }
            }
        }
        return out;
    }


    public static void main(String[] args) {
        HW9<Integer> test = new HW9<Integer>(); // Initialize your graph in any way you want.
        /*test.addEdge(0, 2, 3.0);
        test.addEdge(0, 1, 1.0);
        test.addEdge(1, 2, 2.0);
        test.addEdge(2, 3, 4.0);
        Connectable<Integer> kruskal = HW10.getKruskalMST(test);
        assert (kruskal.isEdge(0, 1) && kruskal.getWeight(0, 1) == 1.0);
        assert (kruskal.isEdge(2, 1) && kruskal.getWeight(2, 1) == 2.0);
        assert (kruskal.isEdge(2, 3) && kruskal.getWeight(2, 3) == 4.0);
        assert (!kruskal.isEdge(0, 2));

        Connectable<Integer> prim = HW10.getPrimMST(test); // The two should be the same.
        assert (prim.isEdge(0, 1) && prim.getWeight(0, 1) == 1.0);
        assert (prim.isEdge(2, 1) && prim.getWeight(2, 1) == 2.0);
        assert (prim.isEdge(2, 3) && prim.getWeight(2, 3) == 4.0);
        assert (!prim.isEdge(0, 2));
*/

		System.out.println(test.addEdge(0, 1, 4.0));
		System.out.println(test.addEdge(1, 2, 2.0));
		System.out.println(test.addEdge(0, 2, 3.0));
		System.out.println(test.addEdge(2, 3, 7.0));
		System.out.println(test.addEdge(0, 4, 8.0));
		System.out.println(test.addEdge(2, 8, 6.0));
		System.out.println(test.addEdge(3, 8, 3.0));
		System.out.println(test.addEdge(7, 3, 1.0));
		System.out.println(test.addEdge(3, 5, 2.0));
        
        Connectable<Integer> kruskal = HW10.getKruskalMST(test);
        assert (kruskal.isEdge(3, 7) && kruskal.getWeight(3, 7) == 1.0);
        assert (kruskal.isEdge(2, 8) && kruskal.getWeight(2, 8) == 6.0);
        assert (kruskal.isEdge(4, 0) && kruskal.getWeight(4, 0) == 8.0);
        assert (!kruskal.isEdge(0, 1));
        assert (!kruskal.isEdge(2, 3)); 


        Connectable<Integer> prim = HW10.getPrimMST(test); // The two should be the same. 
        assert (prim.isEdge(3, 7) && prim.getWeight(3, 7) == 1.0);
        assert (prim.isEdge(2, 8) && prim.getWeight(2, 8) == 6.0);
        assert (prim.isEdge(4, 0) && prim.getWeight(4, 0) == 8.0);
        assert (!prim.isEdge(0, 1));
        assert (!prim.isEdge(2, 3));
    }
}


