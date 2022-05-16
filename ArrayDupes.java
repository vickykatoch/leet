public class ArrayDupes {
    public static void main(String[] args) {
        removeDupes(new int[] { 1, 1, 2 });
        removeDupes(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 });
    }

    static int removeDupes(int[] nums) {
        Helper.printArray("Input", nums);
        int k = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[j-1]) {
                nums[j++] = nums[i];
                k++;
            }
        }
        Helper.printArray("Vanilla", nums);
        System.out.println(String.format("K = %d", k));
        return k;
    }
}
