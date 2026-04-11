package Arrays.BinarySearch;

public class BinarySearchProblems {

    public static void main(String[] args) {
    }

    private static int simpleIterativeSearch(int[] arr, int target) {

        if(arr == null || arr.length == 0) {
            return -1;
        }

        int size = arr.length, left = 0, right = size - 1;

        while(left <= right) {

            int mid = left + ((right - left)/2);

            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    } // T -> O(log n) S -> O(1)

    private static int recursiveSearch(int[] nums, int target, int left, int right) {
        if(left > right) {
            return -1;
        }

        int mid = (right + left) / 2;
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] > target) {
            return recursiveSearch(nums, target, left, mid - 1);
        } else {
            return recursiveSearch(nums, target, mid + 1, right);
        }
    } // T -> O(log n) S -> O(log n)

    /**
     * Given the array nums after the possible rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums.
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     */
    private static int findInRotated(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    } // T -> O(log n) S -> O(1)

    /**
     * Given a sorted array of non-negative distinct integers,
     * find the smallest missing non-negative element in it.
     * Input:  nums[] = [0, 1, 2, 6, 9, 11, 15]
     * Output: The smallest missing element is 3
     */
    private static int findSmallestMissing(int[] nums) {

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right)/2;

            if(nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    } // T -> O(log n) S -> O(1)

    /**
     * Given a sorted binary array, efficiently count the total number of 1’s in it.
     * Input:  nums[] = [0, 0, 0, 0, 1, 1, 1]
     * Output: The total number of 1’s present is 3
     */
    private static int numberOf1sInBinaryArray(int[] nums, int left, int right) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums[right] == 0) {
            return 0;
        }
        if(nums[left] == 1) {
            return right - left + 1;
        }
        int mid = (left + right)/2;

        return numberOf1sInBinaryArray(nums, left, mid) + numberOf1sInBinaryArray(nums, mid + 1, right);
    }

    /**
     * Given a sorted integer array, find the index of a given number’s first occurrence.
     * If the element is not present in the array, report that as well.
     */
    private static int findFirstOccurrence(int[] nums, int k) {

        int result = -1, len = nums.length, left = 0, right = len - 1;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if(nums[mid] == k) {
                result = mid;
                right = mid - 1;
            } else if(nums[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
