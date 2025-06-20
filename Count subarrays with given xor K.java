class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
      int len = nums.length;
      int xor = 0;
      int count = 0;
      Map<Integer, Integer> freq = new HashMap<>();
      freq.put(0, 1);
      for(int i = 0; i < len; i++)
      {
            xor ^= nums[i];

            int x = xor ^ k;
            if(freq.containsKey(x))
            {
                count += freq.get(x);
            }
            if(freq.containsKey(xor))
                freq.put(xor, freq.get(xor) + 1);
            else
                freq.put(xor, 1);
      }
      return count;
    }
}