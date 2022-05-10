import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 7, 9, 1, 3, 8, 5 };
        int[] resultMax = twoSumMax(arr);
        System.out.println(String.format("Index [%d,%d] : [%d]", resultMax[0], resultMax[1], resultMax[2]));

        int[] resultTarget = twoSumTarget(arr,17);
        System.out.println(String.format("Index [%d,%d] : [%d]", resultTarget[0], resultTarget[1], resultTarget[2]));
    }

    static int[] twoSumMax(int[] arr) {
        int[] result = { 0, 0, 0 };
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] > result[2]) {
                    result[0] = i;
                    result[1] = j;
                    result[2] = arr[i] + arr[j];
                }
            }
        }
        return result;
    }
    static int[] twoSumTarget(int[] arr, int target) {
        int[] result = { 0, 0, 0 };
        for (int i = 0; i < arr.length - 1; i++) {
            // for (int j = i + 1; j < arr.length; j++) {
            //     if (arr[i] + arr[j] > result[2]) {
            //         result[0] = i;
            //         result[1] = j;
            //         result[2] = arr[i] + arr[j];
            //     }
            // }
        }
        return result;
    }
}
