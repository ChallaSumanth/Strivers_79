class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;

        int low = 0;
        int high = len1;
        if(len1 > len2)
            return findMedianSortedArrays(nums2, nums1);
        while(low <= high)
        {
            int cut1 = (low + high) >> 1;

            int cut2 = ((len1 + len2) / 2) - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == len1 ? Integer.MAX_VALUE : nums1[cut1]; 
            int r2 = cut2 == len2 ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 > r2)
                high = cut1 - 1;
            else if(l2 > r1)
                low = cut1 + 1;

            else {
                if((len1 + len2) % 2 == 0)
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                else
                    return (double) Math.min(r1, r2);
            }
                
        }

        return 1;
    }

}