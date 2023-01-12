public class FindMin {

    public static int find(int[] ary, int n, int k){
        if(n == ary.length) return ary[k];
        if(ary[n] < ary[k]) k = n;
        return find(ary, n+1, k);
    }
    public static int find(int[] ary){
        return find(ary,0,0);
    }
    
    public static void main(String args[]){
        int[] ary = {2,1,6,-2,5,2,3,7,3,45,2,34,5};
        System.out.println(find(ary));
    }

}
