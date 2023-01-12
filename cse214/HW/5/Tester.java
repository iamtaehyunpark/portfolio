import java.util.*;

public class Tester{

    public static Queue<Integer> recursiveReverseQ(Queue<Integer> a) { // 5 points
		Queue<Integer> out = new LinkedList<Integer>();
        Queue<Integer> mod = new LinkedList<Integer>();
		out = reverseQueue(a,out, mod);
		return out;
	}
	public static Queue<Integer> reverseQueue(Queue<Integer> ori, Queue<Integer> out, Queue<Integer> mod){
		if(ori.size() == 1 && mod.size() == 0) {
            out.add(ori.remove());
			return out; //stop if everything moved to the output
		}  
		else if(ori.size() == 1) {
			out.add(ori.remove());  //put the last element into output
			return reverseQueue(mod,out,ori);  //restart the process
		}
		else{
			mod.add(ori.remove());
			return reverseQueue(ori, out, mod);  //looping until just one element left
		}
	}

    public static void main(String args[]){
        Queue<Integer> ary = new LinkedList<>();
        ary.add(1);
        ary.add(1);
        ary.add(3);
        ary.add(4);
        while(ary.element() != null) System.out.println(ary.remove());
    }
}