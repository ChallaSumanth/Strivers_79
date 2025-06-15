class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Set<List<Integer>> unique = new HashSet<>();
        for(int i = 0; i < len; i++)
        {
            Set<Integer> hs = new HashSet<>();
            for(int j = i + 1; j < len; j++)
            {
                int third = -(nums[i] + nums[j]);
                if(hs.contains(third))
                {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    unique.add(temp);
                }    
                hs.add(nums[j]);
            }
        }
        return new ArrayList<>(unique);
    }
}

---------------------------
//optimal

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < len; i++)
        {
            if(i != 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1;
            int k = len - 1;
            while(j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0)
                    j++;
                else if(sum > 0)
                    k--;
                else
                {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j - 1] == nums[j]) j++;
                    while(j < k && nums[k + 1] == nums[k]) k--;
                }

            }
        }
        return ans;
    }
}