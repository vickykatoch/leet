import java.util.HashMap;

public class ArraySearch {
    public static void main(String[] args) {
        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExists(new int[] {
                10, 2, 5, 3
        })));
        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExists(new int[] {
                7, 1, 14, 11
        })));

        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExists(new int[] {
            10,2,5,3
        })));

        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExists(new int[] {
            10,4,9,3
        })));

        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExists(new int[] {
            4,-7,11,4,18
        })));
    }

    static boolean searchIfNWithDoubleExists(int[] nums) {
        var numMap = new HashMap<Integer, Integer>();
        Helper.printArray("Input", nums);
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                return true;
            }
            numMap.put(nums[i], nums[i] * 2);
            numMap.put(nums[i] * 2, nums[i]);
            if (nums[i] % 2 == 0) {
                numMap.put(nums[i] / 2, nums[i]);
            }
        }
        return false;
    }
}
