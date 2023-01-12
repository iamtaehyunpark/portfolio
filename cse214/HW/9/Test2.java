import java.util.*;

/**
 * Name: Taehyun Park
 * SBUID: 115242740
 */

public class Test2 {

    /*
     * TODO: Implement Kruskal's algorithm on the graph c.
     */
    public static Connectable<Integer> getKruskalMST(Connectable<Integer> c) {
        Test<Integer> out = new Test<Integer>();
        Test graph = (Test) c;
        Collection<Test.Edge> edgesInList = graph.edges.values();
        Object[] edges = edgesInList.toArray();
        Arrays.sort(edges);

        Collection domain = graph.domain.values();

        HashMap<Test.Node, Test.Node> cycle = new HashMap<>();

        Iterator makingCycleTab = domain.iterator();
        while (makingCycleTab.hasNext()) {
            Test.Node addingNode = (Test.Node) makingCycleTab.next();
            cycle.put(addingNode, addingNode);
        }

        for (Object tempEdge : edges) {
            if (cycle.get(((Test.Edge) tempEdge).lat) == (cycle.get(((Test.Edge) tempEdge).form))) {
                continue;
            } else {
                out.addEdge((int) ((Test.Edge) tempEdge).form.element, (int) ((Test.Edge) tempEdge).lat.element, ((Test.Edge) tempEdge).weight);
                //cycle.replace(((Test.Edge) tempEdge).lat, cycle.get(((Test.Edge)tempEdge).form));
                final Test.Node fixedLat = cycle.get(((Test.Edge) tempEdge).lat);
                final Test.Node fixedForm =  cycle.get(((Test.Edge)tempEdge).form);
                for(Test.Node temp : cycle.keySet()){
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
    public static Connectable<Integer> getPrimMST(Connectable<Integer> c) {
        Test<Integer> out = new Test<Integer>();
        Test graph = (Test) c;


        Set<Test.Node> reached = new HashSet<>();
        Test.Node first = (Test.Node) graph.domain.values().iterator().next(); // designating starting node(will have the lowest element in hashset)
        reached.add(first);

        LinkedList<Test.Edge> edges = new LinkedList<>();
        while (reached.size() < graph.domain.size()) {
            Set neighborsOfScope = graph.getNeighbors(first);
            for (Object adding : neighborsOfScope) {
                if (!edges.contains(first.getEdge((Test.Node) adding)) && !reached.contains((Test.Node) adding)) {
                    edges.add(first.getEdge((Test.Node) adding));
                }

            }

            Test.Node next;
            while (edges.size() > 0) {
                if (edges.size() > 1)
                    Collections.sort(edges);
                Test.Edge tempEdge = edges.getFirst();


                if (tempEdge.form == first) next = tempEdge.lat;
                else if(tempEdge.lat == first) next = tempEdge.form;
                else {
                    first = tempEdge.form;
                    next = tempEdge.lat;
                }

                if (!reached.contains(next) ) {
                    out.addEdge((int) (first.element), (int) (next.element), ((Test.Edge) tempEdge).weight);
                    reached.add(next);
                    edges.removeFirst();
                    first = next;
                    break;
                } else {
                    edges.removeFirst();
                }
            }
        }
        return out;
    }


    public static void main(String[] args) {
        Test<Integer> test = new Test<Integer>(); // Initialize your graph in any way you want.
        /*test.addEdge(0, 2, 3.0);
        test.addEdge(0, 1, 1.0);
        test.addEdge(1, 2, 2.0);
        test.addEdge(2, 3, 4.0);
        Connectable<Integer> kruskal = Test2.getKruskalMST(test);
        assert (kruskal.isEdge(0, 1) && kruskal.getWeight(0, 1) == 1.0);
        assert (kruskal.isEdge(2, 1) && kruskal.getWeight(2, 1) == 2.0);
        assert (kruskal.isEdge(2, 3) && kruskal.getWeight(2, 3) == 4.0);
        assert (!kruskal.isEdge(0, 2));

        Connectable<Integer> prim = Test2.getPrimMST(test); // The two should be the same.
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
        
        Connectable<Integer> kruskal = Test2.getKruskalMST(test);
        assert (kruskal.isEdge(3, 7) && kruskal.getWeight(3, 7) == 1.0);
        assert (kruskal.isEdge(2, 8) && kruskal.getWeight(2, 8) == 6.0);
        assert (kruskal.isEdge(4, 0) && kruskal.getWeight(4, 0) == 8.0);
        assert (!kruskal.isEdge(0, 1));
        assert (!kruskal.isEdge(2, 3)); 


        Connectable<Integer> prim = Test2.getPrimMST(test); // The two should be the same. 
        assert (prim.isEdge(3, 7) && prim.getWeight(3, 7) == 1.0);
        assert (prim.isEdge(2, 8) && prim.getWeight(2, 8) == 6.0);
        assert (prim.isEdge(4, 0) && prim.getWeight(4, 0) == 8.0);
        assert (!prim.isEdge(0, 1));
        assert (!prim.isEdge(2, 3));
    }
}


