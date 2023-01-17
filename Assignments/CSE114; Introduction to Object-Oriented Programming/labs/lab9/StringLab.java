public class StringLab {


    public static int wordCount(String str) {
        String[] words = str.split(" ");
        return words.length;
    }

    public static double averageWordLength(String str){
        String[] strArr = str.split(" |[,]|[.]|[!]");
        double sum = 0;
                for(int i = 0; i < strArr.length; i++){
                    sum += strArr[i].length();
                }

                return sum/(strArr.length-count);
    }


    public static boolean wordSearch (String s, String word){
        String real = s.toLowerCase();
        String fake = word.toLowerCase();
        String[] words = real.split(" |[,]|[.]|[!]");
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(fake)){
                return true;
            }

        }
        return false;
    }

    public static void main(String args[]){

        int l = wordCount("IT is raining outside, and it looks like it will continue for a WHILE!");
        System.out.println(l);
        
        System.out.println(averageWordLength("It is raining outside, and it looks like it will continue for a WHILE!"));




        String s = "It is raining outside, and it looks like it will continue for a WHILE!";
            boolean aa = wordSearch(s, "looks");
            boolean bb = wordSearch(s, "rain");
            boolean cc = wordSearch(s, "While");
            if(aa) {
                System.out.print("true");
            } else{
                System.out.print("false");
            }

            if(bb) {
                System.out.print("true");
            } else{
                System.out.print("false");
            }

            if(cc) {
                System.out.print("true");
            } else{
                System.out.print("false");
            }


        }
}