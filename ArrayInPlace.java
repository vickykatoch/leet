public class ArrayInPlace {
    public static void main(String[] args) {
        // Helper.printArray("Vanilla", replaceRightGreatest(null));
        // Helper.printArray("Vanilla", replaceRightGreatest(new int[] {}));
        // Helper.printArray("Vanilla", replaceRightGreatest(new int[] { 10 }));
        Helper.printArray("Vanilla", replaceRightGreatest(new int[] { 17, 18, 5, 4, 6, 1 }));
        Helper.printArray("V1", replaceRightGreatestV1(new int[] { 17, 18, 5, 4, 6, 1 }));
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
        for(int i=nums.length-1; i>=0; i--) 
            max= Math.max(nums[i],nums[i]=max);
        return nums; 
    }
}
