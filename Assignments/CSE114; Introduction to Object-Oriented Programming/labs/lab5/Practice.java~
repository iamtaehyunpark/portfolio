

public class Practice {

    public static int add2 (int x,int y) {
	return x + y;
    }

    public static int add4 (int x,int y,int z,int w) {
	int add4Sum = add2(x, y) + add2(z, w);
	    
	return add4Sum ;
    }

    public static String addString (String k,String i,String j) {
	return k + i + j;
    }
    
    public static String add4addString (int x,int y,int z,int w,String k,String i,String j) {
	int add4Sum = add4(x, y, z, w);
	String addStringSum = addString(k, i, j);
	return add4Sum + addStringSum;
    }

    public static String addStringAdd4 (String k,String i,String j,int x,int y,int z,int w) {
	String addStringSum = addString(k, i, j);
	int add4Sum = x + y + z + w;
        return addStringSum + add4Sum;
    }
    
    public static void main (String[] args){
	
	int sum = add4(1, 2, 3, 4);
	String sum7 = add4addString(1, 2, 3, 4, "Apple", "Orange", "Kiwi");
	String sum7_2 = addStringAdd4("Apple", "Orange", "Kiwi", 1, 2, 3, 4);

	System.out.println(sum);
	System.out.println(sum7);
	System.out.println(sum7_2);
    }
}
