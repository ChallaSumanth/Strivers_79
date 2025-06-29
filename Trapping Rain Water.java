class Solution {
    public int trap(int[] height) {
        
        int maxWater = 0;
        for(int i = 0; i < height.length; i++)
        {
            int j = i;
            int maxLeft = 0, maxRight = 0;
            while(j >= 0)
            {
                if(maxLeft <= height[j])
                {
                    maxLeft = height[j];
                }
                j--;
            }

            j = i;

            while(j < height.length)
            {
                if(maxRight <= height[j])
                {
                    maxRight = height[j];
                }
                j++;
            }

            maxWater += Math.min(maxLeft, maxRight) - height[i];
        }

        return maxWater;
    }
}

--------------------------------------------------------------

class Solution {
    public int trap(int[] height) {
        
        int maxWater = 0;
        int len = height.length;
        int[] preMax = new int[len];
        int[] sufMax = new int[len];
        preMax[0] = height[0];
        sufMax[len - 1] = height[len - 1];
        for(int i = 1; i < height.length; i++)
        {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }

        for(int i = len - 2; i >= 0; i--)
        {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }

        for(int i = 0; i < len; i++)
        {
            maxWater += Math.min(preMax[i], sufMax[i]) - height[i];   
        }

        return maxWater;
    }
}

-----------------------------------------------------
class Solution {
    public int trap(int[] height) {
        
        int maxWater = 0;
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int maxLeft = 0, maxRight = 0;
        while(left <= right)
        {
            if(height[left] <= height[right])
            {
                if(maxLeft <= height[left])
                    maxLeft = height[left];
                else
                    maxWater += maxLeft - height[left];
                left++;
            }
            else
            {
                if(maxRight <= height[right])
                    maxRight = height[right];
                else
                    maxWater += maxRight - height[right];
                right--;
            }
        }
        return maxWater;
    }
}
