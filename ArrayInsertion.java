import java.util.ArrayList;

public class ArrayInsertion {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 0, 2, 3, 0, 4, 5, 0 };
        printArray(nums);
        duplicateZeros(nums);
        printArray(nums);
        duplicateZerosV2(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });        
        duplicateZerosV3(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });
        System.out.println("=".repeat(50));
        nums = new int[] { 0, 0, 0, 0, 0, 0, 0 };
        printArray(nums);
        duplicateZeros(nums);
        printArray(nums);
    }

    static void duplicateZeros(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0 && i < nums.length - 1) {
                for (int j = nums.length - 1; j > i; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[++i] = 0;
                i++;
            } else {
                i++;
            }
        }
    }

    static void duplicateZerosV2(int[] nums) {
        int size = nums.length;
        ArrayList<Integer> numArray = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numArray.add(nums[i]);
            if (nums[i] == 0) {
                numArray.add(0);
            }
        }
        for (int i = 0; i < size; i++) {
            nums[i] = numArray.get(i);
        }
        printArray(nums);
    }

    static void duplicateZerosV3(int[] nums) {
        // [1,0,2,3,0,4,5,0]
        // [1,0,0,2,3,0,0,4]
        int size = nums.length-1; // 8
        int possibleZeroes = 0;
        for (int i = 0; i < size - possibleZeroes; i++) {
            if (nums[i] == 0) {
                if (i == size - possibleZeroes) {
                    nums[i] = 0;
                    i--;
                    break;
                }
                possibleZeroes++;
            }
        }
        int last = size - possibleZeroes;
        for (int j = last; j >= 0; j--) {
            if (nums[j] == 0) {
                nums[j + possibleZeroes] = 0;
                possibleZeroes--;
                nums[j + possibleZeroes] = 0;
            } else {
                nums[j + possibleZeroes] = nums[j];
            }
        }
        printArray(nums);
    }

    static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i]);
            } else {
                System.out.print(String.format("%d,", nums[i]));
            }
        }
        System.out.println("]");
    }
}
