class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int len = stalls.length;
        Arrays.sort(stalls);
        int maxPossibleDist = stalls[len - 1] - stalls[0];
        for(int i = 1; i <= maxPossibleDist; i++)
        {
            if(!isPossible(stalls, i, k))
                return i - 1;
        }
        
        return maxPossibleDist;
    }
    private static boolean isPossible(int[] stalls, int dist, int k)
    {
        int countCows = 1;
        int dis = stalls[0];
        for(int i = 1; i < stalls.length; i++)
        {
            if(stalls[i] - dis >= dist)
            {
                countCows++;
                dis = stalls[i];
            }
           // System.out.println("count ="+countCows);
            if(countCows >= k)
                return true;
        }
        return false;
    }
}
-------------------------------

optimal
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int len = stalls.length;
        Arrays.sort(stalls);
        int maxPossibleDist = stalls[len - 1] - stalls[0];
        int low = 1;
        int high = maxPossibleDist;
        int ans = maxPossibleDist;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(!isPossible(stalls, mid, k))
            {
                ans = mid - 1;
                high = mid - 1;
            }
            else
                low = mid + 1;
                
        }
        
        return ans;
    }
    private static boolean isPossible(int[] stalls, int dist, int k)
    {
        int countCows = 1;
        int dis = stalls[0];
        for(int i = 1; i < stalls.length; i++)
        {
            if(stalls[i] - dis >= dist)
            {
                countCows++;
                dis = stalls[i];
            }
           // System.out.println("count ="+countCows);
            if(countCows >= k)
                return true;
        }
        return false;
    }
}