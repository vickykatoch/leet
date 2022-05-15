import java.util.ArrayList;

public class ArrayInsertion {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 0, 2, 3, 0, 4, 5, 0 };
        printArray("Input", nums);
        duplicateZeros(nums);
        duplicateZerosV2(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });
        duplicateZerosV3(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });
        nums = new int[] { 0, 0, 0, 0, 0, 0, 0 };
        printArray("Input", nums);
        duplicateZeros(nums);

        duplicateZerosV4(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });
        duplicateZerosV4(new int[] { 8, 4, 5, 0, 0, 0, 0, 7 });
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
        printArray("Vanilla", nums);
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
        printArray("V2", nums);
    }

    static void duplicateZerosV3(int[] nums) {
        // [1,0,2,3,0,4,5,0]
        // [1,0,0,2,3,0,0,4]
        int size = nums.length - 1; // 8
        int possibleDupZeroes = 0;
        for (int i = 0; i < size - possibleDupZeroes; i++) {
            if (nums[i] == 0) {
                if (i == size - possibleDupZeroes) {
                    nums[i] = 0;
                    i--;
                    break;
                }
                possibleDupZeroes++;
            }
        }
        int last = size - possibleDupZeroes;
        for (int j = last; j >= 0; j--) {
            if (nums[j] == 0) {
                nums[j + possibleDupZeroes] = 0;
                possibleDupZeroes--;
                nums[j + possibleDupZeroes] = 0;
            } else {
                nums[j + possibleDupZeroes] = nums[j];
            }
        }
        printArray("V3", nums);
    }

    static void duplicateZerosV4(int[] nums) {
        // [1,0,2,3,0,4,5,0]
        // [1,0,0,2,3,0,0,4,5,0]
        // [1,0,0,2,3,0,0,4]
        int size = nums.length - 1;
        int possDups = 0;
        // Find the # of zeros that can be duplicated
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                possDups++;
            }
            if (i >= (size - possDups)) {
                break;
            }
        }
        System.out.println(String.format("Possible 0s :%d", possDups));
        int maxIterate = size - possDups;

        for (int j = maxIterate; j >= 0; j--) {
            if (nums[j] == 0) {
                nums[j + possDups] = 0;
                possDups--;
                nums[j + possDups] = 0;
            } else {
                nums[j + possDups] = nums[j];
            }
        }

        printArray("V4", nums);
    }

    static void printArray(String name, int[] nums) {
        System.out.print(String.format("%s : [", name));
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
