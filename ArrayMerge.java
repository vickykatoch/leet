import java.util.Arrays;

public class ArrayMerge {
    public static void main(String[] args) {
        System.out.println("=".repeat(50));
        mergeArray(new int[] { 1, 2, 3, 0, 0, 0 }, new int[] { 2, 5, 6 }, 3, 3);
        System.out.println("=".repeat(50));
        mergeArrayV1(new int[] { 1, 2, 3, 0, 0, 0 }, new int[] { 2, 5, 6 }, 3, 3);

        System.out.println("=".repeat(50));
        mergeArrayV1(new int[] { 1 }, new int[] {}, 1, 0);

        System.out.println("=".repeat(50));
        mergeArrayV1(new int[] { 0 }, new int[] { 2 }, 0, 1);

        System.out.println("=".repeat(50));
        mergeArrayV2(new int[] { 1, 2, 3, 0, 0, 0 }, new int[] { 2, 5, 6 }, 3, 3);
        System.out.println("=".repeat(50));
        mergeArrayV2(new int[] { 0 }, new int[] { 2 }, 0, 1);
    }

    static void mergeArray(int[] nums1, int[] nums2, int m, int n) {
        Helper.printArray("Input", nums1);
        Helper.printArray("Input", nums2);
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        Helper.printArray("Vanilla", nums1);
    }

    static void mergeArrayV1(int[] nums1, int[] nums2, int m, int n) {
        Helper.printArray("Input", nums1);
        Helper.printArray("Input", nums2);
        int lastIdx = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (i < n) {
                if (nums1[i] > nums2[lastIdx]) {
                    int temp = nums2[lastIdx];
                    nums2[lastIdx] = nums1[i];
                    nums1[i] = temp;
                }
            } else {
                if (n <= lastIdx)
                    break;
                nums1[i] = nums2[lastIdx];
                lastIdx++;
            }
        }
        Helper.printArray("V1", nums1);
    }

    static void mergeArrayV2(int[] nums1, int[] nums2, int m, int n) {
        Helper.printArray("Input", nums1);
        Helper.printArray("Input", nums2);
        int size = m + n;
        int[] newCopy = new int[m];
        for (int i = 0; i < m; i++) {
            newCopy[i] = nums1[i];
        }
        int p1 = 0, p2 = 0;
        for (int p = 0; p < nums1.length; p++) {
            if (p1 < m) {

            }
        }
        Helper.printArray("V2", nums1);
    }
}
