Brute force 

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxEat = Integer.MIN_VALUE;
        for(int i = 0; i< piles.length; i++)
        {
            maxEat = Math.max(maxEat, piles[i]);
        }

        
        for(int i = 1; i <= maxEat; i++)
        {
            int totalHours = 0;
            for(int j = 0; j < piles.length; j++)
            {
                totalHours += Math.ceil((double)piles[j]/(double)i);
            }
            if(totalHours <= h)
                    return i;
        }
        return maxEat;
    }
}
----------------------------
Optimal
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxEat = Integer.MIN_VALUE;
        for(int i = 0; i< piles.length; i++)
        {
            maxEat = Math.max(maxEat, piles[i]);
        }
        
        int low = 1;
        int high = maxEat;
        int minEat = Integer.MAX_VALUE;
        while(low <= high)
        {
            int mid = (low + high) >> 1;
            int hours = calculatePossibilty(piles, mid);
            if(hours <= h)
            {
                minEat = mid;
                high = mid - 1;
            }
            else if(hours > h)
                low = mid + 1;
        }
        return minEat;
    }

    private int calculatePossibilty(int [] piles, int hours)
    {
        int totalHours = 0;
        for(int i = 0; i < piles.length; i++)
        {
            totalHours += Math.ceil((double)piles[i]/(double)hours);
        }
        return totalHours;
    }
}