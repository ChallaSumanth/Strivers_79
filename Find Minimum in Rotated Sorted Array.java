class Solution {
    public int findMin(int[] nums) {
        
        int minEle = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;

        while(low <= high)
        {
            int mid = (low + high) >> 1;

            if(nums[low] <= nums[high])
            {
                minEle = Math.min(nums[low], minEle);
                break;
            }
            if(nums[low] <= nums[mid])
            {
                minEle = Math.min(nums[low], minEle);
                low = mid + 1;
            }
            else
            {
                minEle = Math.min(nums[mid], minEle);
                high = mid - 1;
            }
        }

        return minEle;
    }
}