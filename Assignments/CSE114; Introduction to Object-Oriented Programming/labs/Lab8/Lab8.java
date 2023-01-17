public class Lab8 {


    public static boolean occur (int[] nums, int item) {
        boolean a;
        for (int i = 0; i <= nums.length; i++) {
            if (nums[i] == item) {
                a = true;
                break;
            } else {
                a = false;
            }
        }
        return a;
    }
    
    public static 


    public static void main(String args[]) {

        int[] nums = {1, 2, 2, 3, 2, 5, 3, 6};
        int item = 3;
        occur(nums, item);
    }


}