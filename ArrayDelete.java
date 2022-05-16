public class ArrayDelete {
    public static void main(String[] args) {
        deleteElements(new int[] { 3, 2, 2, 3 }, 3);
        deleteElementsV1(new int[] { 3, 2, 2, 3 }, 2);
    }

    static int deleteElements(int[] nums, int val) {
        // Input: nums = [3,2,2,3], val = 3
        // Output: 2, nums = [2,2,_,_]
        Helper.printArray("Input", nums);
        int k = 0;
        int tp = 0;
        int size = nums.length - 1;
        for (int i = 0; i <= size; i++) {
            if (tp > size) {
                nums[i] = 0;
                continue;
            }
            if (nums[tp] == val) {
                if (tp == size) {
                    nums[i] = 0;
                } else {
                    var ok=false;
                    while(tp<size) {
                        if(nums[++tp]!=val) {
                            nums[i]=nums[tp];
                            k++;
                            ok=true;
                            break;
                        }
                    }
                    if(!ok) nums[i]=0;
                }
            } else {
                nums[i] = nums[tp];
                k++;
            }
            tp++;
        }
        Helper.printArray("Vanilla", nums);
        System.out.println(String.format("K = %d", k));
        return k;
    }

    static int deleteElementsV1(int[] nums, int val) {
        // Input: nums = [3,2,2,3], val = 3
        // Output: 2, nums = [2,2,_,_]
        Helper.printArray("Input", nums);
        int k = 0;
        int tp = 0;
        int size = nums.length - 1;
        for (int i = 0; i <= size; i++) {
           if(nums[i]==val){
               nums[tp++]=nums[i];
               k++;
           }
        }
        Helper.printArray("Vanilla", nums);
        System.out.println(String.format("K = %d", k));
        return k;
    }
}
