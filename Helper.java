import javax.sql.rowset.spi.SyncFactory;

public class Helper {
    static void printArray(String name, int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i]);
            } else {
                System.out.print(String.format("%d,", nums[i]));
            }
        }
        System.out.println(String.format("] : %s", name));
    }
}
