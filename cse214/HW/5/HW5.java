/**
 * Homework 5: Due Oct. 27th @ 23:59 Korea time.
 * Name: Taehyun Park
 * SBUID: 11524270
 * 
 * You are to solve a collection of individual recursion puzzles. For each puzzle, you must implement
 * both a recursive and an iterative version. You are free to write helper methods that will do the
 * actual recursion. Not using a recursion in a recursive version will result in a zero score.
 * For each puzzle, clearly describe what your base and recursive cases are in the header comment.
 * Also provide a description of your approach in a single paragraph.
 * 
 * GENERAL INSTRUCTIONS (failure to follow these instructions will result in a deduction of points):
 * Your final submission should be your own work.
 * Do not import any unauthorized packages. 
 * Do not use any Java data structures unless told to do so.
 * Do not change the class or method names.
 * Submit a single HW5.java file with no package structure.
 * 50% off for late submissions, up to 24 hours.
 * Detailed instructions are given per puzzle.
 * 
 * RUBRIC
 * Correctness (70 points): See the individual method head for individual point allocation. 
 * Comments (30 points): 5 points for each puzzle. This should include your base and recursive 
 *                       case descriptions, as well as the description of your overall approach.
 *                       Place this information in the comment block right before the implementation
 *                       of each puzzle.
 */
import java.util.*;

import javax.lang.model.element.Element;
import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;

public class HW5 {

	/*
	 * 1. Enumerate all possible combinations letters in the given phone number digits. Use numCodes for the corresponding mnemonic.
	 * 'n' is a numeric string containing a sequence of digits, each between 2 and 9, inclusive.
	 * E.g., n = "45" --> your answer should be: {"GJ", "GK", "GL", "HK", "HK", "HL", "IJ", "IK", "IL"} 
	 * (not necessarily in that order) This is because you have to produce all possible combinations of
	 * characters that belong to the digits 4 (GHI) and 5 (JKL), respectively.
	 * For the iterative version, you are free to use any data structures mentioned in class.
	 */

	 /*
	  * Pick one from one String and pick another with the other String.
	  make possible sets between only two strings at first
	and treat the output of it as another new single string that is needed to be merged with the rest Strings.
	  */
 final String[] numCodes = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	
	//base case is where first String reaches its end and recursion if there are more cases left
	public String[] recursiveMnemonics(String n) { // 12 points
		String[][] allChosenNumCodes = new String[n.length()][];  //Creating 2d array that has every single characters needed to make combinations 
		for(int j= 0; j<n.length();j++){    
			allChosenNumCodes[j] = numCodes[n.charAt(j)-48].split("");
		}

		return recurModifySize(allChosenNumCodes);
	}
    public String[] recurOperatingWithTwo(String[] ary1, String[] ary2, String[] out, int counter1, int counter2){ 
        if(counter1 == ary1.length) return out;
        
        if(counter2<ary2.length){
        String addOut = "";
        addOut += ary1[counter1];
        addOut += ary2[counter2];   //merging two characters into a String
        out[ary2.length*counter1+counter2] = addOut;  //add into output
        counter2++;
        return recurOperatingWithTwo(ary1, ary2, out, counter1, counter2);  //retry until pointer get to the last of ary2
        } else{
            counter1++;
            return recurOperatingWithTwo(ary1, ary2, out, counter1, 0); //clear index of ary2 and increase ary1 index
        }
    }
    public String[] recurModifySize(String[][] ori){   //if need to merge more than two Strings
        String[] out = new String[(ori[ori.length-2].length)*(ori[ori.length-1].length)]; //maximum number of combination
        if(ori.length>2) {   //if more than two, decreasing last String by merging right before one
            String[] temp = recurOperatingWithTwo(ori[ori.length-2],ori[ori.length-1],out,0,0);  
            String[][] temp2 = new String[ori.length-1][]; //making new one whose last two Strings are merged
            for (int i = 0; i < ori.length-2; i++) {
                temp2[i] = Arrays.copyOf(ori[i], ori[i].length);
            }
            temp2[temp2.length-1] = temp;
            ori = temp2;
            return recurModifySize(ori);  //retry until only left two Strings
        } else if(ori.length == 1) return ori[0]; //if one, just return
        else{
            return recurOperatingWithTwo(ori[0],ori[1],out,0,0); //base case, stop after merging every String
        }
    }

	
	public String[] iterativeMnemonics(String n) { // 2 points

		String[][] allChosenNumCodes = new String[n.length()][];  //Creating 2d array that has every single characters needed to make combinations 
		for(int j= 0; j<n.length();j++){    
			allChosenNumCodes[j] = numCodes[n.charAt(j)-48].split("");
		}
        

		return iterModifySize(allChosenNumCodes);
	}
    public String[] operatingWithTwo(String[] ary1, String[] ary2){  //operating with only two strings

        int counter =0;    //counting index to put the output
        int numPossibleComb = ary1.length*ary2.length;    //output array size
		String[] out = new String[numPossibleComb]; //expected output

        String addOut = "";

        for(int i = 0; i< ary1.length; i++){
            addOut += ary1[i];
            for(int j = 0; j<ary2.length; j++){
            addOut += ary2[j];   //merging two characters into a String
            out[counter] = addOut;  // put it into output array
            addOut ="";  
            addOut += ary1[i];  //retry after replacing only the last character
            counter++;
            }
            addOut ="";  //clear for the next attempt
        }
       
        return out;
    }
    public String[] iterModifySize(String[][] ori){   //if need to merge more than two Strings
        while(ori.length>2){  //if more than two, decreasing last String by merging right before one
            String[] temp = operatingWithTwo(ori[ori.length-2],ori[ori.length-1]);  
            String[][] temp2 = new String[ori.length-1][]; //making new one whose last two Strings are merged
            for (int i = 0; i < ori.length-2; i++) {
               temp2[i] = Arrays.copyOf(ori[i], ori[i].length);
               }
            temp2[temp2.length-1] = temp;
            ori = temp2;
            }

        if(ori.length == 2) return operatingWithTwo(ori[0],ori[1]);
        return ori[0];
    }

	/*
	 * 2. Print all subset sums of a given array. A value of 0 is always part of the answer.
	 * (i.e., when NO elements are added)
	 * For example, when the input is {1, 2, 3}, the result should be the array 
	 * {0, 1, 2, 3, 3, 4, 5, 6} (singletons and duplicates should also be present)
	 * Do not use any data structures for both cases.
	 */


	/*
	 * My functions will be like 'output array before sum[i] = ary[i] * binary Array[i]'
	 * every index of array has corresponding binary number, and multiplication of those two will be cover all the possible cases.
	 * binary array will be modified while all the possible cases of binary number combinations are once multiplied to the array
	 * 
	 * [a / b / c / d]
	 * [1 / 0 / 0 / 1]
	 */
	// base case is where binary array is maximum that cannot increase any more, recursion if possible to make changes in binary array
    public int[] recursiveSubsetSum(int[] ary) { // 12 points
		int[] out = new int[(int)(Math.pow(2, ary.length))];
		int[] times = new int[ary.length];

		out = store(ary, times, out, 0);
		
		return out;
	}
    public int[] store(int[] ary, int[] times, int[] out, int index){
        out[index] = recurSumOfAll(ary, times, 0);
        if(recurSwitchTimes(times, 0) == -1) return out; //base case, stop if all the cases stored
        
        return store(ary, times, out, index+1);
    }
	public int recurSwitchTimes(int[] times, int timesIndex){
		if(timesIndex == times.length) return -1;
		times[timesIndex]++;
		if(times[timesIndex] > 1) {
            times[timesIndex] = 0;
			return recurSwitchTimes(times,timesIndex+1);
		}
		return times[timesIndex];
	}
	public int recurSumOfAll(int[] ary, int[] times, int n){
        if(n == ary.length-1) return ary[n] * times[n]; //base case, stop if every index added
        int sum = ary[n] * times[n];
		return sum + recurSumOfAll(ary, times, n+1);
	}
	
    public int[] iterativeSubsetSum(int[] ary) { // 2 points
		int[] out = new int[(int)(Math.pow(2, ary.length))]; //deciding output size; size = all the possible number of cases
		int counter = 0;
		int[] times = new int[ary.length]; 

		while(true){ //run all the cases
			out[counter] = sumOfAll(ary, times);
			if(switchTimes(times,0) == -1) break; 
			counter++;
		}
		return out;
	}
	public int switchTimes(int[] times, int n){  //Times array will be consist of binary numbers.
		times[n]++;
            while(n < times.length-1){  //implementation of binary structure
                if(times[n] >1) {
                    times[n]=0;
                    times[n+1]++;
                    n++;
                    continue;
                }
                n++;
            }
            if(times[times.length-1] > 1) return -1;
		return 0;
	}
	public int sumOfAll(int[] ary, int[] times){ //
        int[] temp = new int[ary.length];
		for(int i =0;i<ary.length;i++){
			temp[i] = ary[i]*times[i];
		}
		int sum =0;
		for(int i:temp) sum += i;
		return sum;
	}
	
	/*
	 * 3. Skip every n-th element in the LinkedList (n > 1).
	 * For example, in a list 1-2-3-4-5-6 with n=3, the output is 1-2-4-5.
	 * Use only a LinkedList, and no other data structures.
	 */

	 /*
	  * delete all the n th index element by counting the length between n th index
	  */
	  //base cas is when n th pointer reaches linkedlist size, and recursion if index needed to be checked whether it n th is left
	public LinkedList<Integer> recursiveSkipNth(LinkedList<Integer> l, int n) { // 10 points
		skipCounting(l, n, 0);
		return l;
	}
	public LinkedList<Integer> skipCounting(LinkedList<Integer> l, int n, int count){
		count++; //count current index(-1)
		if(count == l.size()) return l; //if reaches end, end recursion, base case
		else if(count%(n-1) ==0){ //if index is nth, delete
			l.remove(count);
		}
		return skipCounting(l, n, count);
	}
	
    public LinkedList<Integer> iterativeSkipNth(LinkedList<Integer> l, int n) { // 1 points
		for(int i = 1; (n-1)*i < l.size();i++){
            l.remove((n-1)*i);
        }
        return l;
	}
	
	/*
	 * 4. Sort a given integer Stack in descending order.
	 * For example, if the initial stack is: <TOP> 3-4-1-2-9 <BOTTOM>, the result should be
	 * <TOP> 9-4-3-2-1 <BOTTOM>.
	 * Use only a Stack, and no other data structures.
	 */

	 /*
	  * Similar to the Hanoi Tower problem, if element to be poped at next is smaller than the one already put into output array,
	  move the nodes into temp stack until the top of the stack is smaller than it
	  */
	  //base case is where there's nothing left to be poped in the given stack
	  //recursion if given stack and temp are not fully moved to output stack
    public Stack<Integer> recursiveSortStack(Stack<Integer> s) { // 12 points
		Stack<Integer> out = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		sortingStack(s,out,temp);

		return out;
	}
	public Stack<Integer> sortingStack(Stack<Integer> s, Stack<Integer> out, Stack<Integer> temp){
		if(s.empty()&&temp.empty()) return out;//base case, stop where out is full
		
		//all the possible conditions; never put on the stack of the larger number than itself.
        if (out.empty()){
            out.push(s.pop());
        } else if(s.empty()) out.push(temp.pop());
        else if(!temp.empty()){
			if(s.peek() >= out.peek() && s.peek()<=temp.peek()) out.push(s.pop());
			else if(s.peek() >= out.peek() && s.peek()>=temp.peek()) out.push(temp.pop());
			else if(s.peek() <= out.peek()) temp.push(out.pop());
		}else {
			if(s.peek() >= out.peek()) out.push(s.pop());
			else if(s.peek() <= out.peek()) temp.push(out.pop());
		}

		return sortingStack(s, out, temp);
	}


	public Stack<Integer> iterativeSortStack(Stack<Integer> s) { // 2 points
		Stack<Integer> temp = new Stack<>();
		Stack<Integer> out = new Stack<>();

        out.push(s.pop());
		while(!s.empty()){   //looping while every element in s to get out
			if(s.peek() < out.peek()) { 
				while(!out.empty() && s.peek()<out.peek()) temp.push(out.pop());  //store all in temp stack
				out.push(s.pop());   //push small integer at the bottom of output
				while(!temp.empty()) out.push(temp.pop());  //re-put all the integers to the output
			}
			else out.push(s.pop());  //just put on the top of output stack if large
		}
		return out;
	}
	
	/*
	 * 5. Even-odd sum. Return the sums of all even and odd numbers, respectively, in a given array.
	 * For example, when the array is {4, 2, 1, 5, 6}, it should return {12, 6} (in that order).
	 * Do not use any data structures.
	 */

	 /*
	  * sum even index odd index separately
	  */
	  //base case is where there's nothing left to sum up, recursion until last element in returned
	public int[] recursiveEvenOddSums(int[] a) { // 10 points
		int[] out = {recurEvenSum(a,0), recurOddSum(a,0)};
		return out;
	}
	public int recurEvenSum(int[] a,int n){
		if(n == a.length) return 0;  //set the base case
		int out = 0;
		if(a[n] %2 != 0);  //if odd, add 0 to the output
		else out = a[n]; //if even, add 0 to the output
		n++;  //call the next index of a
		return out + recurEvenSum(a, n); //recursively
	}
	public int recurOddSum(int[] a,int n){
		if(n == a.length) return 0;
		int out = 0;
		if(a[n] %2 == 0);
		else out = a[n];
		n++;
		return out + recurOddSum(a, n++);
	}
	
	
	public int[] iterativeEvenOddSums(int[] a) { // 1 point
		int[] out = new int[2];
		for(int i : a) {
			if(i % 2 == 0) out[0] += i;
			else out[1] += i;
		}
		return out;
	}
	
	/*
	 * 6. Reverse the order of elements in a given queue.
	 * For example, if the queue has the following elements [A, B, C, D], the result should
	 * be [D, C, B, A], where the last element is the front of the queue.
	 * The contents of the given queue should not change.
	 * Use only a queue, and no other data structures.
	 */

	 /*
	  * store one node of given queue into temp queue, and making partially reversed queue with just part of given queue
	  retrying it until all the nodes in the given queue moved to output queue
	  */
	  //base case is where given queue is empty, recursion if output is not fully filled with the all the Element of given queue
	public Queue<Integer> recursiveReverseQ(Queue<Integer> a) { // 5 points
		Queue<Integer> out = new LinkedList<Integer>();
        Queue<Integer> mod = new LinkedList<Integer>();
		out = reverseQueue(a,out, mod);
		return out;
	}
	public Queue<Integer> reverseQueue(Queue<Integer> ori, Queue<Integer> out, Queue<Integer> mod){
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
			return reverseQueue(ori, out, mod);  //recursion until just one element left
		}
	}
	
	
	public Queue<Integer> iterativeReverseQ(Queue<Integer> a) { // 1 point
		int[] temp = new int[a.size()];
		for(int i = 0;i<temp.length;i++) temp[i] = a.remove(); //put all the elements into array
		for(int i = temp.length-1;i>-1;i--) a.add(temp[i]);  //reversely put the elements to the Queue

		return a;
	}
	
	public static void main(String[] args) {
		HW5 ok = new HW5();
		int[] o = {};
		int[] ary = ok.recursiveSubsetSum(o);
		for(int i : ary) System.out.println(i);

	}
}