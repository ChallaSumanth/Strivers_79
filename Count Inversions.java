class Solution {
    
    private static int merge(int[] arr, int low, int mid, int high)
    {
        int left = low;
        int right = mid + 1;
        int count = 0;
        List<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high)
        {
            if(arr[left] <= arr[right])
            {
                temp.add(arr[left]);
                left++;
            }
            else
            {
                count += (mid - left + 1);
                temp.add(arr[right]);
                right++;
            }
        }
        
        while(left <= mid)
        {
            temp.add(arr[left]);
            left++;
        }
        
        while(right <= high)
        {
            temp.add(arr[right]);
            right++;
        }
        
        for(int i = low; i<= high; i++)
        {
            arr[i] = temp.get(i - low);
        }
        return count;
    }
    
    private static int mergeSort(int [] arr, int low, int high)
    {
        int count = 0;
        int mid = (low + high) / 2;
        if(low >= high) return count;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        return mergeSort(arr, 0, arr.length - 1);
    }
}