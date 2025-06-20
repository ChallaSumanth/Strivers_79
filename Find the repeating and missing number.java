class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
       int len = nums.length;
       int [] hash = new int[len + 1];
        for(int i = 0; i < len; i++)
        {
            hash[nums[i]]++;
        }
        int rep = -1, mis = -1;
        for(int i = 1; i <= len; i++)
        {
            if(hash[i] == 2)
                rep = i;
            if(hash[i] == 0)
                mis = i;
            if(rep != -1 && mis != -1)
                break;
        }
        return new int[]{rep, mis};
    }
}