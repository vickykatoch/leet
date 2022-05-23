public class ArraySortByParity {
    public static void main(String[] args) {
        Helper.printArray("V1", sortArrayByParity(new int[] { 3, 1, 2, 4 }));
        Helper.printArray("V1", sortArrayByParity(new int[] { 3, 1 }));
        Helper.printArray("V1", sortArrayByParity(new int[] { 3, 1, 2 }));
        Helper.printArray("V1", sortArrayByParity(new int[] { 2 }));
        Helper.printArray("V1", sortArrayByParity(new int[] {}));
        Helper.printArray("V1", sortArrayByParity(new int[] { 0 }));

        System.out.println(String.format("Remove Element: %d", removeElement(new int[] {
                3, 2, 2, 3
        }, 3)));
        System.out.println(String.format("Remove Element: %d", removeElement(new int[] {
                3, 2, 2, 3
        }, 2)));
        System.out.println(String.format("Remove Element: %d", removeElement(new int[] {
                3, 2
        }, 3)));

        System.out.println(String.format("Remove Element: %d", removeElement(new int[] {

        }, 3)));
        System.out.println(String.format("Remove Element: %d", removeElement(new int[] {
                3
        }, 3)));
    }

    static int[] sortArrayByParity(int[] nums) {
        Helper.printArray("Input", nums);
        // 3, 1, 2, 4
        int evenCtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[evenCtr];
                nums[evenCtr++] = temp;
            }
        }
        return nums;
    }

    static int removeElement(int[] nums, int val) {
        Helper.printArray("Input", nums);
        // 3,2,2,3
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        Helper.printArray("Removed Value", nums);
        return k;
    }
}
