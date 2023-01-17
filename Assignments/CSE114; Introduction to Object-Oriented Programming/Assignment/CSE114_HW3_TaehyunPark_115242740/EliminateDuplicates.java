//Taehyun Park taehyun.park.1@stonybrook.edu
public class EliminateDuplicates {

    public static String[] eliminateDuplicates(String str){
        String[] dupliOutput = new String[2];
        dupliOutput[0] = "";
        dupliOutput[1] = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i){
                dupliOutput[0] += str.charAt(i);
            }else {
                dupliOutput[1] += str.charAt(i);
            }
        }
        return dupliOutput;
    }

    public static void main (String args[]){

                String[] retString1 = eliminateDuplicates("abracadabra");
                System.out.println(retString1[0] + ", " + retString1[1]);
                
                String[] retString2 = eliminateDuplicates("Stony Brook University");
                System.out.println(retString2[0] + ", " + retString2[1]);
                
                String[] retString3 = eliminateDuplicates("This is a test sentence.");
                System.out.println(retString3[0] + ", " + retString3[1]);
                
                String[] retString4 = eliminateDuplicates("Loose Control");
                System.out.println(retString4[0] + ", " + retString4[1]);
                
                String[] retString5 = eliminateDuplicates("Taehyun Park");
                System.out.println(retString5[0] + ", " + retString5[1]);

    }
}