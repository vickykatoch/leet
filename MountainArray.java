public class MountainArray {
    public static void main(String[] args) {
        System.out.println(String.format("OK = %b", isValidMountain(new int[] { 2, 1 })));
        System.out.println(String.format("OK = %b", isValidMountain(new int[] { 3, 5, 5 })));
        System.out.println(String.format("OK = %b", isValidMountain(new int[] { 0, 3, 2, 1 })));

        System.out.println("=".repeat((50)));

        System.out.println(String.format("OK = %b", isValidMountainV1(new int[] { 2, 1 })));
        System.out.println(String.format("OK = %b", isValidMountainV1(new int[] { 3, 5, 5 })));
        System.out.println(String.format("OK = %b", isValidMountainV1(new int[] { 0, 3, 2, 1 })));
        System.out.println(String.format("OK = %b", isValidMountainV1(new int[] { 2 })));
        System.out.println(String.format("OK = %b", isValidMountainV1(new int[] { 0,1,2,3,4,5,6,7,8,9 })));
    }

    static boolean isValidMountain(int[] nums) {
        Helper.printArray("Input", nums);
        var increasingOrder = false;
        var decreasingOrder = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            } else if (nums[i - 1] < nums[i]) {
                if (decreasingOrder)
                    return false;
                increasingOrder = true;
            } else {
                if (!increasingOrder)
                    return false;
                decreasingOrder = true;
            }
        }
        return increasingOrder && decreasingOrder;
    }

    static boolean isValidMountainV1(int[] nums) {
        if(nums.length<3) return false;
        int i = 0;
        for (; i < nums.length-1; i++) {
            if (nums[i] >= nums[i + 1])
                break;
        }
        if (i == 0 || i == nums.length-1)
            return false;
        int j = i;
        for (; j < nums.length - 1; j++) {
            if (nums[j] <= nums[j + 1])
                return false;
        }

        return j == nums.length - 1;
    }
}
