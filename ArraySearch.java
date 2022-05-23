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
                10, 2, 5, 3
        })));

        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExists(new int[] {
                10, 4, 9, 3
        })));

        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExists(new int[] {
                4, -7, 11, 4, 18
        })));

        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExists(new int[] {
                4, -7, 11, -14, 18
        })));

        System.out.println("=".repeat((50)));

        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExistsV1(new int[] {
                10, 2, 5, 3
        })));
        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExistsV1(new int[] {
                7, 1, 14, 11
        })));

        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExistsV1(new int[] {
                10, 2, 5, 3
        })));
        

        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExistsV1(new int[] {
                10, 4, 9, 3
        })));

        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExistsV1(new int[] {
                4, -7, 11, 4, 18
        })));

        System.out.println(String.format("Exists : %b", searchIfNWithDoubleExistsV1(new int[] {
                4, -7, 11, -14, 18
        })));
    }

    static boolean searchIfNWithDoubleExists(int[] nums) {
        var numMap = new HashMap<Integer, Integer>();
        Helper.printArray("Input", nums);
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i] * 2) || (nums[i] % 2 == 0 && numMap.containsKey(nums[i] / 2))) {
                return true;
            }
            numMap.put(nums[i], nums[i]);
        }
        return false;
    }

    static boolean searchIfNWithDoubleExistsV1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int buscar = arr[i] * 2;

            for (int j = 0; j < arr.length; j++) {
                if (i == j)
                    continue;
                if (buscar == arr[j])
                    return true;
            }
        }
        return false;
    }
}
