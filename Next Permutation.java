class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int break_point = -1;
        for(int i = len - 2; i >= 0; i--)
        {
            if(nums[i] < nums[i + 1])
            {
                break_point = i;
                break;
            }
        }
        if(break_point == -1)
        {
            reverse(nums, 0, len - 1);
        }
        else
        {
            for(int i = len - 1; i >= 0; i--)
            {
                if(nums[i] > nums[break_point])
                {
                    int temp = nums[i];
                    nums[i] = nums[break_point];
                    nums[break_point] = temp;
                    reverse(nums, break_point + 1, len - 1);
                    break;
                }
            }
        }
    }
    private void reverse(int [] nums, int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

// TC : O(3N) SC : O(1)