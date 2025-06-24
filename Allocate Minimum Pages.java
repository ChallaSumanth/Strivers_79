class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if(arr.length < k) return -1;
        int min_value = Integer.MIN_VALUE;
        int max_value = 0;
        for(int ele : arr)
        {
             min_value = Math.max(ele, min_value);
             max_value += ele;
        }
        if(k == 1) return max_value;
        int ans = Integer.MIN_VALUE;
        for(int i = min_value; i <= max_value; i++)
        {
            int countStudent = findPossibilty(arr, i);
            if(countStudent <= k)
                return i;
        }
        return min_value;
    }
    
    private static int findPossibilty(int[] arr, int pages)
    {
        int students = 1;
        long curPagesSum = 0;
        for(int bookpages : arr)
        {
            if(curPagesSum + bookpages > pages)
            {
               students++;
               curPagesSum = bookpages;
            }
            else
               curPagesSum += bookpages;
        }
        return students;
    }
}

-----------
optimal


//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if(arr.length < k) return -1;
        int min_value = Integer.MIN_VALUE;
        int max_value = 0;
        for(int ele : arr)
        {
             min_value = Math.max(ele, min_value);
             max_value += ele;
        }
        if(k == 1) return max_value;
        int ans = Integer.MIN_VALUE;
        int low = min_value;
        int high = max_value;
        while(low <= high)
        {
            int mid = (low + high) >> 1;
            int countStudent = findPossibilty(arr, mid);
            if(countStudent <= k)
            {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
    
    private static int findPossibilty(int[] arr, int pages)
    {
        int students = 1;
        long curPagesSum = 0;
        for(int bookpages : arr)
        {
            if(curPagesSum + bookpages > pages)
            {
               students++;
               curPagesSum = bookpages;
            }
            else
               curPagesSum += bookpages;
        }
        return students;
    }
}