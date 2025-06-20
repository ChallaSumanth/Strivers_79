class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int prePrd = 1;
        int sufPrd = 1;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < len ;i++)
        {
            if(prePrd == 0)
                prePrd = 1;
            if(sufPrd == 0)
                sufPrd = 1;  

            prePrd *= nums[i];
            sufPrd *= nums[len - i - 1];
   
            ans = Math.max(ans, Math.max(prePrd, sufPrd));
        }
        return ans;
    }
}