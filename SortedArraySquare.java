import java.util.*;
;
public class SortedArraySquare {
    public static void main(String[] args) {
        int[] input = {-4,-1,0,3,10};
        SortedArraySquare.printArray("Input ",input);
        SortedArraySquare.printArray("Vanilla ", SortedArraySquare.squareSortedVanilla(input));
        SortedArraySquare.printArray("Double Pointer ", SortedArraySquare.squareSortedDblPointer(input));
    } 

    public static int[] squareSortedVanilla(int[] nums) {
        int[] output=new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            output[i]=nums[i]*nums[i];
        }
        Arrays.sort(output);
        return output;
    }
    public static int[] squareSortedDblPointer(int[] nums) {
        int[] output=new int[nums.length];
        int left=0;
        int right=nums.length-1;

        for(int i=0;i<nums.length;i++) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                output[i] = nums[i]*nums[i];
                right++;
            } else {
                output[right] = nums[i]*nums[i];
                right--;
            }
        }
        // Arrays.sort(output);
        return output;
    }
    public static void printArray(String msg, int[] nums) {
        System.out.print(msg + " : [");
        for(int n: nums) {
            System.out.print(String.format("%d,", n));
        }
        System.out.println("]");
    }
}
