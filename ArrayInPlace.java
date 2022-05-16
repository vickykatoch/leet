public class ArrayInPlace {
    public static void main(String[] args) {
        // Helper.printArray("Vanilla", replaceRightGreatest(null));
        // Helper.printArray("Vanilla", replaceRightGreatest(new int[] {}));
        Helper.printArray("Vanilla", replaceRightGreatest(new int[] { 10 }));
        Helper.printArray("Vanilla", replaceRightGreatest(new int[] { 17, 18, 5, 4, 6, 1 }));
        Helper.printArray("V1", replaceRightGreatestV1(new int[] { 17, 18, 5, 4, 6, 1 }));
        System.out.println(String.format("In Place Dups : %d", removeInPlaceDuplicates(new int[] {
                0, 0, 1, 1, 1, 2, 2, 3, 3, 4
        })));

        System.out.println(String.format("In Place Dups : %d", removeInPlaceDuplicates(new int[] {
                1, 1, 2
        })));
        System.out.println(String.format("In Place Dups : %d", removeInPlaceDuplicates(new int[] {
                1
        })));

        Helper.printArray("In Place Zeros", moveInPlaceZeroesV1(new int[] { 0, 1, 0, 3, 12 }));

        Helper.printArray("In Place Zeros", moveInPlaceZeroesV2(new int[] { 0, 1, 0, 3, 12 }));
        Helper.printArray("In Place Zeros", moveInPlaceZeroesV2(new int[] { 0, 1 }));

        Helper.printArray("In Place Zeros", moveInPlaceZeroesV3(new int[] { 0, 1, 0, 3, 12 }));
        Helper.printArray("In Place Zeros", moveInPlaceZeroesV3(new int[] { 0, 1 }));
        Helper.printArray("In Place Zeros", moveInPlaceZeroesV3(new int[] { 2, 1 }));
        Helper.printArray("In Place Zeros", moveInPlaceZeroesV3(new int[] { 1 }));
        // Helper.printArray("In Place Zeros", moveInPlaceZeroes(new int[] { 0 }));

        // Helper.printArray("In Place Zeros", moveInPlaceZeroes(new int[] { 0, 0, 12,
        // 0, 0 }));
    }

    static int[] replaceRightGreatest(int[] nums) {
        Helper.printArray("Input", nums);
        int size = nums.length;
        var newArray = new int[size];
        newArray[size - 1] = -1;
        for (int i = size - 2; i >= 0; i--) {
            newArray[i] = Math.max(newArray[i + 1], nums[i + 1]);
        }
        return newArray;
    }

    static int[] replaceRightGreatestV1(int[] nums) {
        int max = -1;
        for (int i = nums.length - 1; i >= 0; i--)
            max = Math.max(nums[i], nums[i] = max);
        return nums;
    }

    static int removeInPlaceDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        Helper.printArray("In Place Remove", nums);
        return k;
    }

    static int[] moveInPlaceZeroesV1(int[] nums) {
        Helper.printArray("In Place move", nums);
        // 0, 1, 0, 3, 12
        int numZeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                numZeroes++;
        }
        int[] newCopy = new int[nums.length];
        for (int i = 0, k = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                newCopy[k++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newCopy[i];
        }

        return nums;
    }

    static int[] moveInPlaceZeroesV2(int[] nums) {
        Helper.printArray("In Place move", nums);
        int lastKnownNonZero = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] != 0) {
                nums[lastKnownNonZero++] = nums[i];
            }
        }
        for (int i = lastKnownNonZero; i < size; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    static int[] moveInPlaceZeroesV3(int[] nums) {
        // 0, 1, 0, 3, 12
        Helper.printArray("In Place move", nums);
        int lastKnownNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 ) {
                var isTrue = lastKnownNonZero == i;
                nums[lastKnownNonZero++] = nums[i];
                if (!isTrue)
                    nums[i] = 0;
            }
        }
        return nums;
    }
}
