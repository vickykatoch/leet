import java.util.Arrays;

public class Misc {
    public static void main(String[] args) {
        System.out.println(String.format("Height Anamoly: %d", findHeightAnamoly(new int[] {
                1, 1, 4, 2, 1, 3
        })));
        System.out.println(String.format("Height Anamoly: %d", findHeightAnamoly(new int[] {
                5, 1, 2, 3, 4
        })));
        System.out.println(String.format("Height Anamoly: %d", findHeightAnamoly(new int[] {
                5
        })));
        System.out.println(String.format("Height Anamoly: %d", findHeightAnamoly(new int[] {
                1, 2, 3, 4, 5
        })));

        System.out.println(String.format("Height Anamoly: %d", maxConsectiveOnes(new int[] {
                1, 0, 1, 1, 0
        }, 1)));

        System.out.println(String.format("Max Consective Ones: %d", maxConsectiveOnes(new int[] {
                1, 0, 1, 1, 0, 1
        }, 1)));
        System.out.println(String.format("Max Consective Ones: %d", maxConsectiveOnes(new int[] {
                1
        }, 1)));
    }

    static int findHeightAnamoly(int[] heights) {
        Helper.printArray("Input", heights);
        // 1, 1, 4, 2, 1, 3
        // 1, 1, 1, 2, 3, 4
        int k = 0;
        var copy = heights.clone();
        Arrays.sort(copy);
        for (int i = 0; i < copy.length; i++)
            if (copy[i] != heights[i])
                k++;
        return k;
    }

    static int maxConsectiveOnes(int[] nums, int n) {
        // 1,0,1,1,0
        Helper.printArray("Input", nums);
        int left = 0, right = 0;
        for (; right < nums.length; right++) {
            if (nums[right] == 0) {
                n--;
            }
            if (n < 0 && nums[left++]==0) {
                n++;
            }
        }
        return right - left;
    }
}