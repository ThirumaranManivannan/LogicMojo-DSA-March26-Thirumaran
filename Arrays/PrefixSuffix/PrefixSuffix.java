package Arrays.PrefixSuffix;

public class PrefixSuffix {

    public static void main(String[] args) {

    }
    /**
     *  Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     */

    private static int[] arrayProduct(int[] arr) {

        int n = arr.length;
        int[] result = new int[n], prefix = new int[n], suffix = new int[n];
        prefix[0] = 1; suffix[n - 1] = 1;

        for(int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] * arr[ i - 1];
            suffix[n - i - 1] = suffix[n - i] * arr[ n - i - 1];
        }

        for(int i = 0; i < arr.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }

}
