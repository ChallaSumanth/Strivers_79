class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int left = 0, right = 0, idx = 0;
        boolean isStart = true;
        while(right < k - 1)
            right++;
        while(right < len)
        {
            getMaxele(ans, left, right, nums, idx);
            left++;
            right++;
            idx++;
        }
        return ans;
    }

    private void getMaxele(int[] ans, int left, int right, int[] nums, int idx)
    {
        int max = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++)
        {
            max = Math.max(max, nums[i]);
        }
        ans[idx] = max;
    }
}
---------------------------------------------
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int [] ans = new int[len - k + 1];
        int idx = 0;
        Deque<Integer> qu = new ArrayDeque<>();
        for(int i = 0; i < len; i++)
        {
            if(!qu.isEmpty() && qu.peek() == i - k)
                qu.poll();
            
            while(!qu.isEmpty() && nums[qu.peekLast()] <= nums[i])
                qu.pollLast();

            qu.offer(i);
            if(i >= k - 1)
                ans[idx++] = nums[qu.peek()];

        }
        return ans;
    }
}