class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] ans = new int[len1];
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = len2 - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && st.peek() <= nums2[i])
                st.pop();
            
            if(st.isEmpty())
                map.put(nums2[i], -1);
            else
                map.put(nums2[i], st.peek());
            
            st.push(nums2[i]);
        }

        for(int i = 0; i < len1; i++)
            ans[i] = map.get(nums1[i]);
        return ans;
    }
}