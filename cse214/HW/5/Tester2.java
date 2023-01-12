import java.util.*;

public class Tester2{

    public static int[] recursiveSubsetSum(int[] ary) { // 2 points
		int[] out = new int[(int)(Math.pow(2, ary.length))];
		int[] times = new int[ary.length];

		out = store(ary, times, out, 0);
		
		return out;
	}
    public static int[] store(int[] ary, int[] times, int[] out, int index){
        out[index] = recurSumOfAll(ary, times, 0);
        if(recurSwitchTimes(times, 0) == -1) return out;
        
        return store(ary, times, out, index+1);
    }
	public static int recurSwitchTimes(int[] times, int timesIndex){
		if(timesIndex == times.length) return -1;
		times[timesIndex]++;
		if(times[timesIndex] > 1) {
            times[timesIndex] = 0;
			return recurSwitchTimes(times,timesIndex+1);
		}
		return times[timesIndex];
	}
	public static int recurSumOfAll(int[] ary, int[] times, int n){
        if(n == ary.length-1) return ary[n] * times[n]; //base case, stop if every index added
        int sum = ary[n] * times[n];
		return sum + recurSumOfAll(ary, times, n+1);
	}

    public static void main(String args[]){
    int[] ary = {1,2,3,4};
    int[] out = recursiveSubsetSum(ary);
    for(int i : out) System.out.println(i);
    }
} 