import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void twoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(nums, target);
        Assert.assertArrayEquals(new int[]{0, 1}, ints);

        nums = new int[]{3, 2, 4};
        target = 6;
        ints = twoSum.twoSum(nums, target);
        Assert.assertArrayEquals(new int[]{1, 2}, ints);

        nums = new int[]{3, 3};
        target = 6;
        ints = twoSum.twoSum(nums, target);
        Assert.assertArrayEquals(new int[]{0, 1}, ints);
    }
}