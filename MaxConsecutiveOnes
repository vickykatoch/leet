
class MaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(findMaxConsectiveCount(new int[] { 1, 1, 0, 1, 1, 1 }));
        System.out.println(findMaxConsectiveCount(new int[] { 1, 1, 1, 1, 0, 1 }));
        System.out.println(findMaxConsectiveCountWhenSingleZeroFlippedBrute(new int[] { 1, 0, 1, 1, 0, 1 }));

        System.out.println(findMaxConsectiveCountWhenSingleZeroFlippedSlidingWindow(new int[] { 1, 0, 1, 1, 0 }));
        System.out.println(findMaxConsectiveCountWhenSingleZeroFlippedSlidingWindow(new int[] { 1, 0, 0, 1, 0, 1 }));
        System.out.println(findMaxConsectiveCountWhenSingleZeroFlippedSlidingWindow(new int[] { 1, 0, 0, 1, 0, 1, 0 }));

        System.out.println(findMaxConsectiveCountWhenSingleZeroFlippedSlidingWindow(new int[] {
                1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1
        }));

        System.out.println(findMaxConsectiveCountWhenSingleZeroFlippedSlidingWindowOpt1(new int[] { 1, 0, 1, 1, 0 }));
        System.out
                .println(findMaxConsectiveCountWhenSingleZeroFlippedSlidingWindowOpt1(new int[] { 1, 0, 0, 1, 0, 1 }));
        System.out.println(
                findMaxConsectiveCountWhenSingleZeroFlippedSlidingWindowOpt1(new int[] { 1, 0, 0, 1, 0, 1, 0 }));

        System.out.println(findMaxConsectiveCountWhenSingleZeroFlippedSlidingWindowOpt1(new int[] {
                1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1
        }));

        System.out.println(findMaxConsectiveCountWhenSingleZeroFlippedSlidingWindowOpt1(new int[] {
                1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1
        }));
    }

    static int findMaxConsectiveCount(int[] arr) {
        int ctr = 0;
        int maxSeq = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                ctr++;
            } else {
                maxSeq = Math.max(maxSeq, ctr);
                ctr = 0;
            }
        }
        return Math.max(maxSeq, ctr);
    }

    static int findMaxConsectiveCountWhenSingleZeroFlippedBrute(int[] nums) {
        int longestSeq = 0;
        for (int i = 0; i < nums.length; i++) {
            int numZeroes = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    numZeroes++;
                }
                if (numZeroes <= 1) {
                    longestSeq = Math.max(longestSeq, j - i + 1);
                }
            }
        }
        return longestSeq;
    }

    static int findMaxConsectiveCountWhenSingleZeroFlippedSlidingWindow(int[] nums) {
        int longestSeq = 0;
        int left = 0;
        int right = 0;
        int numZeroes = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                numZeroes++;
            }
            while (numZeroes == 2) {
                if (nums[left] == 0) {
                    numZeroes--;
                }
                left++;
            }
            longestSeq = Math.max(longestSeq, right - left + 1);
            right++;
        }
        return longestSeq;
    }

    static int findMaxConsectiveCountWhenSingleZeroFlippedSlidingWindowOpt1(int[] nums) {
        int longestSeq = 0;
        int right = 0, left = 0, seenZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                seenZero = 1;
                left = right;
                right = 0;
            } else {
                right++;
            }
            longestSeq = Math.max(longestSeq, right + left + seenZero);
        }
        return longestSeq;
    }
}
