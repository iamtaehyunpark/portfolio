public class Collatz {

    static long[] ary = new long[1];

    public static void admin(long n){
        ary[0] = n;
        check(n);
    }


    public static void check(long now) {
        if (now < ary[0]) {
            System.out.printf("%d is in conjecture\f",ary[0]);
            admin(ary[0]+1);
        } else {
            if (now%2 == 0) {
                evenFunc(now);
            } else{
                oddFunc(now);
            }
        }
    }

    public static void evenFunc(long now){
        check(now/2);
    }
    public static void oddFunc(long now){
        check(3*now+1);
    }





    public static void main (String[] args) {
        try {
            admin(Long.parseLong(args[0]));
        } catch (StackOverflowError error2) {
            String[] str = new String[1];
            str[0] = Long.toString(ary[0]+1);
            main(str);
        }
    }
}